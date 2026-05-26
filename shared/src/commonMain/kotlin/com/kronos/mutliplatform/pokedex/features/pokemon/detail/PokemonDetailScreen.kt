package com.kronos.mutliplatform.pokedex.features.pokemon.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kronos.mutliplatform.pokedex.components.icon.EvolutionChains
import com.kronos.mutliplatform.pokedex.components.icon.GameBoy
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.components.icon.PokemonLocation
import com.kronos.mutliplatform.pokedex.components.icon.Stats
import com.kronos.mutliplatform.pokedex.components.icon.TmDisk
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.ScrollableTabView
import com.kronos.mutliplatform.pokedex.core.ui.components.TabItem
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter
import pokedex.shared.generated.resources.pokemon_detail_tab_evolution
import pokedex.shared.generated.resources.pokemon_detail_tab_games
import pokedex.shared.generated.resources.pokemon_detail_tab_info
import pokedex.shared.generated.resources.pokemon_detail_tab_moves
import pokedex.shared.generated.resources.pokemon_detail_tab_stats

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemon:String,
    navHost: NavHostController,
    isDarkTheme: Boolean,
    currentLang: String,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<PokemonDetailScreenViewModel>()
    val pokemonInfo by viewModel.pokemon.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val tabs = listOf(
        TabItem(
            stringResource(Res.string.pokemon_detail_tab_info),
            Icons.Pokeball,
            Icons.Pokeball,
            index = 1
        ) {
            //todo add screen
        },

        TabItem(
            stringResource(Res.string.pokemon_detail_tab_encounter),
            Icons.PokemonLocation,
            Icons.PokemonLocation,
            index = 2
        ) {
            //todo add screen
        },

        TabItem(
            stringResource(Res.string.pokemon_detail_tab_evolution),
            Icons.EvolutionChains,
            Icons.EvolutionChains,
            index = 3
        ) {
            //todo add screen
        },

        TabItem(
            stringResource(Res.string.pokemon_detail_tab_stats),
            Icons.Stats,
            Icons.Stats,
            index = 4
        ) {
            //todo add screen
        },

        TabItem(
            stringResource(Res.string.pokemon_detail_tab_moves),
            Icons.TmDisk,
            Icons.TmDisk,
            index = 5
        ) {
            //todo add screen
        },

        TabItem(
            stringResource(Res.string.pokemon_detail_tab_games),
            Icons.GameBoy,
            Icons.GameBoy,
            index = 6
        ) {
            //todo add screen
        },
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onPrimary,
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = pokemon.replaceFirstChar { it.uppercase() },
                    navIconButton = {
                        IconButton(
                            icon = Icons.AutoMirrored.Filled.ArrowBack,
                            onClick = {
                                scope.launch {
                                    navHost.popBackStack()
                                }
                            },
                            type = ButtonType.TEXT,
                            iconColor = Color.White,
                            size = ComponentSize.LARGE
                        )
                    },
                    actions = listOf()
                )
            },
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
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
            ScrollableTabView(
                tabs = tabs,
                paddingValues = paddingValues
            )
        }
    }
}