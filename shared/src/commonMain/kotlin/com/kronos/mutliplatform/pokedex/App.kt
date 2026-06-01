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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
import com.kronos.mutliplatform.pokedex.features.move.detail.MoveDetailScreen
import com.kronos.mutliplatform.pokedex.features.move.list.MoveListScreen
import com.kronos.mutliplatform.pokedex.features.pokedex.PokedexScreen
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.PokemonDetailScreen
import com.kronos.mutliplatform.pokedex.features.pokemon.list.PokemonListScreen
import com.kronos.mutliplatform.pokedex.features.setting.SettingsScreen
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

    viewModel.getPreferenceTheme(
        stringResource(Res.string.theme_preference_key),
        stringResource(Res.string.theme_preference_default_value)
    )
    val isDarkTheme by viewModel.preferenceThemeFlow.collectAsStateWithLifecycle()
    val currentLang by viewModel.preferenceLangFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
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

                    composable(route = Destinations.MOVES.name) {
                        MoveListScreen(
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


                    /*composable(
                        route = Destinations.ABOUT.name,
                    ) { backStackEntry ->
                        viewModelEvents.getUnreadEvents()
                        AboutScreen(
                            navController,
                            4,
                            unreadEventsCount,
                            isDarkTheme == stringResource(Res.string.theme_preference_default_value),
                            deviceScreenConfiguration = deviceScreenConfiguration,
                        )
                    }
                    */

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
fun getNavDestinations(
    navController: NavHostController,
    isDesktop: Boolean = false,
    onExitClicked: () -> Unit = {}
) = buildList {

    add(
        NavigationItem(
            title = stringResource(Res.string.menu_pokedex),
            destination = Destinations.POKEDEX,
            selectedIcon = Icons.PokedexSvg,
            unselectedIcon = Icons.PokedexSvg,
            onClick = { pos, navItem ->
                navController.navigate(navItem.destination.name)
            }
        )
    )

    add(
        NavigationItem(
            title = stringResource(Res.string.menu_moves),
            destination = Destinations.MOVES,
            selectedIcon = Icons.TmDisk,
            unselectedIcon = Icons.TmDisk,
            onClick = { pos, navItem ->
                navController.navigate(navItem.destination.name)
            }
        )
    )

    add(
        NavigationItem(
            title = stringResource(Res.string.menu_settings),
            destination = Destinations.SETTINGS,
            selectedIcon = Icons.Settings,
            unselectedIcon = Icons.Settings,
            isPrimary = false,
            onClick = { pos, navItem ->
                navController.navigate(navItem.destination.name)
            }
        )
    )

    add(
        NavigationItem(
            title = stringResource(Res.string.menu_about),
            destination = Destinations.ABOUT,
            selectedIcon = Icons.Info,
            unselectedIcon = Icons.Info,
            isPrimary = false,
            onClick = { pos, navItem ->
                navController.navigate(navItem.destination.name)
            }
        )
    )

    if (isDesktop) {
        add(
            NavigationItem(
                title = stringResource(Res.string.menu_exit),
                destination = Destinations.EXIT, // Cambia esto si tienes un Destinations.EXIT
                selectedIcon = Icons.Filled.Close,
                unselectedIcon = Icons.Outlined.Close,
                iconTint = MaterialTheme.colorScheme.onSurface,
                isPrimary = false,
                onClick = { pos, navItem ->
                    onExitClicked()
                }
            )
        )
    }
}
