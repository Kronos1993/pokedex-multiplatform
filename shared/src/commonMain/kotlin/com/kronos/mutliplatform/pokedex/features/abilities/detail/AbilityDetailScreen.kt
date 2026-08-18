package com.kronos.mutliplatform.pokedex.features.abilities.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.LoadingDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.PullToRefreshContainer
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.features.abilities.detail.content.AbilityInfoScreen
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbilityDetailScreen(
    ability: String,
    navHost: NavHostController,
    isDarkTheme: Boolean,
    currentLang: String,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<AbilityDetailScreenViewModel>()
    val abilityInfo by viewModel.abilityInfo.collectAsStateWithLifecycle()
    val pokemons by viewModel.pokemons.collectAsStateWithLifecycle()
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.message.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(ability) {
        viewModel.loadAbilityInfo(ability)
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

    val screenTitle = remember(abilityInfo, currentLang) {
        abilityInfo.getName(currentLang)
            .replaceFirstChar { it.uppercase() }
            .replace("-", " ")
    }

    val pokemonItemsPerRow = remember(deviceScreenConfiguration) {
        when (deviceScreenConfiguration) {
            DeviceScreenConfiguration.MOBILE_PORTRAIT -> 2
            DeviceScreenConfiguration.MOBILE_LANDSCAPE,
            DeviceScreenConfiguration.TABLET_PORTRAIT -> 3
            DeviceScreenConfiguration.TABLET_LANDSCAPE,
            DeviceScreenConfiguration.DESKTOP -> 4
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = screenTitle,
                    navIconButton = {
                        IconButton(
                            icon = Icons.AutoMirrored.Filled.ArrowBack,
                            onClick = {
                                scope.launch {
                                    navHost.popBackStack()
                                }
                            },
                            type = ButtonType.TEXT,
                            iconColor = MaterialTheme.colorScheme.onPrimary,
                            size = ComponentSize.LARGE
                        )
                    },
                    onRefresh = { viewModel.refreshMove(ability) },
                    isRefreshing = isLoading,
                    actions = listOf(),
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
        ) { paddingValues ->

            PullToRefreshContainer(
                innerPadding = paddingValues,
                isRefreshing = isLoading,
                onRefresh = { viewModel.refreshMove(ability) }
            ) {
                val rootModifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(color = Color.Transparent)
                    .consumeWindowInsets(WindowInsets.navigationBars)

                AbilityInfoScreen(
                    abilityInfo = abilityInfo,
                    lang = currentLang,
                    pokemonList = pokemons,
                    pokemonItemsPerRow = pokemonItemsPerRow,
                    onPokemonClick = {
                        navHost.navigate("${Destinations.POKEMON_DETAIL.name}/${it.pokemonId}")
                    },
                    modifier = rootModifier,
                )
            }

            LoadingDialog(
                Res.string.loading_dialog_title,
                Res.string.loading_dialog_text,
                showDialog = isLoading
            )
        }
    }
}