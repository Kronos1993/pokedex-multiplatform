package com.kronos.mutliplatform.pokedex.features.pokemon.detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.LoadingDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.ScrollableTabView
import com.kronos.mutliplatform.pokedex.core.ui.components.TabItem
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.toPokemonColor
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages.PokemonDetailTab
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.female
import pokedex.shared.generated.resources.female_shiny
import pokedex.shared.generated.resources.front
import pokedex.shared.generated.resources.front_shiny
import pokedex.shared.generated.resources.home
import pokedex.shared.generated.resources.home_shiny
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter
import pokedex.shared.generated.resources.pokemon_detail_tab_evolution
import pokedex.shared.generated.resources.pokemon_detail_tab_games
import pokedex.shared.generated.resources.pokemon_detail_tab_info
import pokedex.shared.generated.resources.pokemon_detail_tab_moves
import pokedex.shared.generated.resources.pokemon_detail_tab_stats

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemon: String,
    navHost: NavHostController,
    isDarkTheme: Boolean,
    currentLang: String,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<PokemonDetailScreenViewModel>()
    val pokemonInfo by viewModel.pokemon.collectAsStateWithLifecycle()
    val pokemonSpritesUrl by viewModel.pokemonSpritesUrl.collectAsStateWithLifecycle()
    val pokemonOtherFormsUrl by viewModel.pokemonOtherFormsUrl.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val listState = rememberLazyGridState()

    val stringSpriteHome = stringResource(Res.string.home)
    val stringSpriteHomeShiny = stringResource(Res.string.home_shiny)
    val stringSpriteFront = stringResource(Res.string.front)
    val stringSpriteFemale = stringResource(Res.string.female)
    val stringSpriteFrontShiny = stringResource(Res.string.front_shiny)
    val stringSpriteFemaleShiny = stringResource(Res.string.female_shiny)

    LaunchedEffect(Unit) {
        viewModel.initStrings(
            stringSpriteHome = stringSpriteHome,
            stringSpriteHomeShiny = stringSpriteHomeShiny,
            stringSpriteFront = stringSpriteFront,
            stringSpriteFemale = stringSpriteFemale,
            stringSpriteFrontShiny = stringSpriteFrontShiny,
            stringSpriteFemaleShiny = stringSpriteFemaleShiny
        )
        viewModel.loadPokemonInfo()
    }

    val typeName = remember(pokemonInfo.types) {
        pokemonInfo.types.firstOrNull()?.name
    }

    val targetColor = typeName?.toPokemonColor() ?: MaterialTheme.colorScheme.surfaceVariant

    val dominantColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "dominantColorAnimation"
    )

    val tabs = listOf(
        TabItem(
            stringResource(Res.string.pokemon_detail_tab_info),
            Icons.Pokeball,
            Icons.Pokeball,
            index = 1
        ) {
            PokemonDetailTab(
                pokemon = pokemonInfo,
                pokemonSprites = pokemonSpritesUrl,
                pokemonOtherForms = pokemonOtherFormsUrl,
                dominantColor = dominantColor,
                isDarkTheme = isDarkTheme,
                currentLang = currentLang,
                listState = listState,
                gridColumns = when (deviceScreenConfiguration) {
                    DeviceScreenConfiguration.MOBILE_PORTRAIT -> {
                        1
                    }

                    DeviceScreenConfiguration.MOBILE_LANDSCAPE,
                    DeviceScreenConfiguration.TABLET_PORTRAIT -> {
                        2
                    }

                    DeviceScreenConfiguration.TABLET_LANDSCAPE,
                    DeviceScreenConfiguration.DESKTOP -> {
                        3
                    }
                },
                onTypeClick = {
                },
                onEggGroupClick = {
                },
                onAbilityClick = {
                },
                onSpriteClick = {},
                onOtherFormsClick = {
                    viewModel.setCurrentPokemon(it)
                    navHost.navigate("${Destinations.POKEMON_DETAIL.name}/${it.name}")
                },
            )
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
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = pokemon.replaceFirstChar { it.uppercase() }.replace("-", " "),
                    navIconButton = {
                        IconButton(
                            icon = Icons.AutoMirrored.Filled.ArrowBack,
                            onClick = {
                                scope.launch {
                                    navHost.popBackStack()
                                }
                            },
                            type = ButtonType.TEXT,
                            iconColor = dominantColor,
                            size = ComponentSize.LARGE
                        )
                    },
                    actions = listOf(),
                    appBarColors = TopAppBarDefaults.topAppBarColors(
                        containerColor = dominantColor.copy(alpha = .25f),
                        titleContentColor = dominantColor,
                        navigationIconContentColor = dominantColor,
                        actionIconContentColor = dominantColor,
                    ),
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
            if (!viewModel.loading) {
                ScrollableTabView(
                    tabs = tabs,
                    paddingValues = paddingValues
                )
            }

            LoadingDialog(
                Res.string.loading_dialog_title,
                Res.string.loading_dialog_text,
                showDialog = viewModel.loading
            )
        }
    }
}