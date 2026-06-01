package com.kronos.mutliplatform.pokedex

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kronos.mutliplatform.pokedex.components.icon.DrawerPokemonTypes
import com.kronos.mutliplatform.pokedex.components.icon.Info
import com.kronos.mutliplatform.pokedex.components.icon.PokedexSvg
import com.kronos.mutliplatform.pokedex.components.icon.Settings
import com.kronos.mutliplatform.pokedex.components.icon.TmDisk
import com.kronos.mutliplatform.pokedex.core.preferences.PreferenceViewModel
import com.kronos.mutliplatform.pokedex.core.ui.ConfigureSystemBars
import com.kronos.mutliplatform.pokedex.core.ui.components.ConfirmDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.NavigationItem
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.features.about.AboutScreen
import com.kronos.mutliplatform.pokedex.features.move.detail.MoveDetailScreen
import com.kronos.mutliplatform.pokedex.features.move.list.MoveListScreen
import com.kronos.mutliplatform.pokedex.features.pokedex.PokedexScreen
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.PokemonDetailScreen
import com.kronos.mutliplatform.pokedex.features.pokemon.list.PokemonListScreen
import com.kronos.mutliplatform.pokedex.features.setting.SettingsScreen
import com.kronos.mutliplatform.pokedex.features.types.detail.TypeDetailScreen
import com.kronos.mutliplatform.pokedex.features.types.list.TypeListScreen
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.default_lang_key
import pokedex.shared.generated.resources.exit_dialog_body
import pokedex.shared.generated.resources.exit_dialog_no
import pokedex.shared.generated.resources.exit_dialog_title
import pokedex.shared.generated.resources.exit_dialog_yes
import pokedex.shared.generated.resources.lang_preference_default_value
import pokedex.shared.generated.resources.menu_about
import pokedex.shared.generated.resources.menu_exit
import pokedex.shared.generated.resources.menu_moves
import pokedex.shared.generated.resources.menu_pokedex
import pokedex.shared.generated.resources.menu_settings
import pokedex.shared.generated.resources.menu_types
import pokedex.shared.generated.resources.theme_preference_default_value
import pokedex.shared.generated.resources.theme_preference_key

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val viewModel = koinViewModel<PreferenceViewModel>()
    val appViewModel = koinViewModel<AppViewModel>()

    val showExitDialog by appViewModel.showExitDialog.collectAsStateWithLifecycle()

    val ready by viewModel.isReady.collectAsStateWithLifecycle()
    val themePreferenceKey = stringResource(Res.string.theme_preference_key)
    val themePreferenceDefault = stringResource(Res.string.theme_preference_default_value)
    val langPreferenceKey = stringResource(Res.string.default_lang_key)
    val langPreferenceDefault = stringResource(Res.string.lang_preference_default_value)

    val isDarkTheme by viewModel.preferenceThemeFlow.collectAsStateWithLifecycle()
    val currentLang by viewModel.preferenceLangFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getPreferenceTheme(
            themePreferenceKey,
            themePreferenceDefault
        )

        viewModel.loadPreferences(
            langKey = langPreferenceKey,
            langDefault = langPreferenceDefault,
            themeKey = themePreferenceKey,
            themeDefault = themePreferenceDefault,
        )
    }

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val deviceScreenConfiguration =
        DeviceScreenConfiguration.fromWindowSizeClass(windowSizeClass)

    ConfigureSystemBars(
        darkTheme = isDarkTheme == stringResource(Res.string.theme_preference_default_value)
    )

    Scaffold() {
        AppTheme(
            darkTheme = isDarkTheme == stringResource(Res.string.theme_preference_default_value)
        ) {
            if (ready) {
                NavHost(
                    navController = navController,
                    startDestination = Destinations.POKEDEX.name
                ) {
                    composable(route = Destinations.POKEDEX.name) {
                        PokedexScreen(
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(
                        route = "${Destinations.POKEMON_LIST}/{pokedexName}",
                        arguments = listOf(navArgument("pokedexName") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val savedStateHandle = backStackEntry.savedStateHandle
                        val pokedex = savedStateHandle.get<String>("pokedexName") ?: ""
                        PokemonListScreen(
                            navController,
                            pokedex,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(
                        route = "${Destinations.POKEMON_DETAIL}/{pokemon}",
                        arguments = listOf(navArgument("pokemon") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val savedStateHandle = backStackEntry.savedStateHandle
                        val pokemon = savedStateHandle.get<String>("pokemon") ?: ""
                        PokemonDetailScreen(
                            pokemon = pokemon,
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            currentLang = currentLang,
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(route = Destinations.MOVES.name) {
                        MoveListScreen(
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(
                        route = "${Destinations.MOVE_DETAIL}/{move}",
                        arguments = listOf(navArgument("move") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val savedStateHandle = backStackEntry.savedStateHandle
                        val move = savedStateHandle.get<String>("move") ?: ""
                        MoveDetailScreen(
                            move = move,
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            currentLang = currentLang,
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(route = Destinations.TYPES.name) {
                        TypeListScreen(
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(
                        route = "${Destinations.TYPES_DETAIL}/{type}",
                        arguments = listOf(navArgument("type") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val savedStateHandle = backStackEntry.savedStateHandle
                        val type = savedStateHandle.get<String>("type") ?: ""
                        TypeDetailScreen(
                            type = type,
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            currentLang = currentLang,
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }

                    composable(
                        route = Destinations.SETTINGS.name,
                    ) { backStackEntry ->
                        SettingsScreen(
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            currentLang = currentLang,
                            deviceScreenConfiguration = deviceScreenConfiguration,
                            onLanguageChange = {
                                viewModel.updateAppLanguage(it)
                            }
                        )
                    }

                    composable(
                        route = Destinations.ABOUT.name,
                    ) { backStackEntry ->
                        AboutScreen(
                            navController,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }
                }
            }

            ConfirmDialog(
                title = stringResource(Res.string.exit_dialog_title),
                body = stringResource(Res.string.exit_dialog_body),
                confirmText = stringResource(Res.string.exit_dialog_yes),
                onConfirm = {
                    appViewModel.closeApp()
                },
                cancelText = stringResource(Res.string.exit_dialog_no),
                onCancel = { appViewModel.showExitDialog(false) },
                showDialog = showExitDialog
            )

        }
    }
}

@Composable
fun rememberNavDestinations(
    navController: NavHostController,
    isDesktop: Boolean = false,
    onExitClicked: () -> Unit = {}
): List<NavigationItem> {

    // Obtenemos los strings en el ámbito Composable actual
    val pokedexTitle = stringResource(Res.string.menu_pokedex)
    val movesTitle = stringResource(Res.string.menu_moves)
    val typesTitle = stringResource(Res.string.menu_types)
    val settingsTitle = stringResource(Res.string.menu_settings)
    val aboutTitle = stringResource(Res.string.menu_about)
    val exitTitle = stringResource(Res.string.menu_exit)
    val closeIconTint = MaterialTheme.colorScheme.onSurface

    return remember(navController, isDesktop, onExitClicked) {
        buildList {
            val defaultClick: (Int, NavigationItem) -> Unit = { _, navItem ->
                navController.navigate(navItem.destination.name) {
                    launchSingleTop = true
                }
            }

            add(
                NavigationItem(
                    title = pokedexTitle,
                    destination = Destinations.POKEDEX,
                    selectedIcon = Icons.PokedexSvg,
                    unselectedIcon = Icons.PokedexSvg,
                    onClick = defaultClick
                )
            )

            add(
                NavigationItem(
                    title = movesTitle,
                    destination = Destinations.MOVES,
                    selectedIcon = Icons.TmDisk,
                    unselectedIcon = Icons.TmDisk,
                    onClick = defaultClick
                )
            )

            add(
                NavigationItem(
                    title = typesTitle,
                    destination = Destinations.TYPES,
                    selectedIcon = Icons.DrawerPokemonTypes,
                    unselectedIcon = Icons.DrawerPokemonTypes,
                    onClick = defaultClick
                )
            )

            add(
                NavigationItem(
                    title = settingsTitle,
                    destination = Destinations.SETTINGS,
                    selectedIcon = Icons.Settings,
                    unselectedIcon = Icons.Settings,
                    isPrimary = false,
                    onClick = defaultClick
                )
            )

            add(
                NavigationItem(
                    title = aboutTitle,
                    destination = Destinations.ABOUT,
                    selectedIcon = Icons.Info,
                    unselectedIcon = Icons.Info,
                    isPrimary = false,
                    onClick = defaultClick
                )
            )

            if (isDesktop) {
                add(
                    NavigationItem(
                        title = exitTitle,
                        destination = Destinations.EXIT,
                        selectedIcon = Icons.Filled.Close,
                        unselectedIcon = Icons.Outlined.Close,
                        iconTint = closeIconTint,
                        isPrimary = false,
                        onClick = { _, _ -> onExitClicked() }
                    )
                )
            }
        }
    }
}

