package com.kronos.mutliplatform.pokedex.features.pokemon.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.LoadingDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.PullToRefreshContainer
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.prettyName
import com.kronos.mutliplatform.pokedex.features.pokemon.list.content.PokemonsContent
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokedex_list
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title
import pokedex.shared.generated.resources.menu_pokemon_search_placeholder
import pokedex.shared.generated.resources.refresh_list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    navHost: NavHostController,
    pokedex: String,
    isDarkTheme: Boolean,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<PokemonListScreenViewModel>()

    val pokemonList by viewModel.pokemons.collectAsStateWithLifecycle()
    var pokedexName by remember { mutableStateOf(pokedex) }
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.message.collectAsStateWithLifecycle()
    val isSearching by viewModel.isSearching.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val listState = rememberLazyGridState()

    val screenTitle = remember(pokedexName) {
        pokedexName.prettyName()
    }

    val gridColumns = remember(deviceScreenConfiguration) {
        when (deviceScreenConfiguration) {
            DeviceScreenConfiguration.MOBILE_PORTRAIT -> 1
            DeviceScreenConfiguration.MOBILE_LANDSCAPE,
            DeviceScreenConfiguration.TABLET_PORTRAIT -> 2
            DeviceScreenConfiguration.TABLET_LANDSCAPE,
            DeviceScreenConfiguration.DESKTOP -> 3
        }
    }

    LaunchedEffect(pokedex) {
        viewModel.loadPokemons(pokedex)
        pokedexName = pokedex.removePrefix("updated-")
            .removePrefix("extended-")
            .removePrefix("original-")
            .removePrefix("letsgo-")
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let { error ->
            if (error.containsKey("error")) {
                snackbarHostState.showSnackbar(
                    message = error["error"].orEmpty(),
                    duration = SnackbarDuration.Short
                )
                viewModel.clearMessage("error")
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = screenTitle.replaceFirstChar { it.uppercase() },
                    isSearching = isSearching,
                    searchQuery = searchQuery,
                    searchPlaceholder = stringResource(Res.string.menu_pokemon_search_placeholder),
                    searchEnabled = true,
                    onSearchQueryChange = {
                        viewModel.updateSearchQuery(it)
                    },
                    onSearchToggle = {
                        val isSearching = !isSearching

                        if (!isSearching) {
                            viewModel.updateSearchQuery("")
                        }
                        viewModel.isSearching(isSearching)
                    },
                    navIconButton = {
                        IconButton(
                            icon = Icons.AutoMirrored.Filled.ArrowBack,
                            onClick = {
                                scope.launch {
                                    viewModel.isSearching(false)
                                    navHost.popBackStack()
                                }
                            },
                            type = ButtonType.TEXT,
                            iconColor = MaterialTheme.colorScheme.onPrimary,
                            size = ComponentSize.LARGE
                        )
                    },
                    actions = listOf()
                )
            },
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    Snackbar(
                        snackbarData = data,
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                }
            }
        ) {
            PullToRefreshContainer(
                innerPadding = it,
                isRefreshing = isLoading,
                onRefresh = { viewModel.refreshPokemons(pokedex) }
            ) {
                val rootModifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(color = Color.Transparent)
                    .consumeWindowInsets(WindowInsets.navigationBars)

                if (pokemonList.isEmpty()) {
                    EmptyList(
                        title = stringResource(Res.string.empty_pokedex_list),
                        subtitle = stringResource(Res.string.refresh_list),
                        showRetryButton = true,
                        onRetryClick = {
                            viewModel.refreshPokemons(pokedex)
                        },
                        modifier = rootModifier
                    )
                } else {
                    PokemonsContent(
                        gridColumns = gridColumns,
                        listState = listState,
                        pokemonList = pokemonList,
                        onClick = { pokemon ->
                            navHost.navigate("${Destinations.POKEMON_DETAIL.name}/${pokemon.pokemonId}")
                        },
                        modifier = rootModifier
                    )
                }
            }


            // Diálogo de carga
            LoadingDialog(
                Res.string.loading_dialog_title,
                Res.string.loading_dialog_text,
                showDialog = isLoading
            )

        }
    }
}