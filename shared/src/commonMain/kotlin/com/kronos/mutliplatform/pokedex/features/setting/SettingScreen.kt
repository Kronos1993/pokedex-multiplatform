package com.kronos.mutliplatform.pokedex.features.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Palette
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
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kronos.mutliplatform.pokedex.core.preferences.PreferenceViewModel
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.SettingRadioOptions
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.default_lang_key
import pokedex.shared.generated.resources.lang_preference_default_value
import pokedex.shared.generated.resources.menu_settings
import pokedex.shared.generated.resources.preference_app_theme_entries
import pokedex.shared.generated.resources.preference_app_theme_values
import pokedex.shared.generated.resources.preference_lang_entries
import pokedex.shared.generated.resources.preference_lang_subtitle
import pokedex.shared.generated.resources.preference_lang_title
import pokedex.shared.generated.resources.preference_lang_values
import pokedex.shared.generated.resources.preference_theme_subtitle
import pokedex.shared.generated.resources.preference_theme_title
import pokedex.shared.generated.resources.theme_preference_default_value
import pokedex.shared.generated.resources.theme_preference_key

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navHost: NavHostController,
    isDarkTheme: Boolean,
    deviceScreenConfiguration: DeviceScreenConfiguration,
    currentLang: String,
    onLanguageChange: (String) -> Unit
) {
    val viewModel = koinViewModel<PreferenceViewModel>()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Claves y valores predeterminados desde recursos
    val langPreferenceKey = stringResource(Res.string.default_lang_key)
    val langPreferenceDefault = stringResource(Res.string.lang_preference_default_value)
    val themePreferenceKey = stringResource(Res.string.theme_preference_key)
    val themePreferenceDefault = stringResource(Res.string.theme_preference_default_value)

    // Obtener preferencias al iniciar
    LaunchedEffect(Unit) {
        viewModel.loadPreferences(
            langKey = langPreferenceKey,
            langDefault = langPreferenceDefault,
            themeKey = themePreferenceKey,
            themeDefault = themePreferenceDefault,
        )
    }

    // Estados locales para las opciones seleccionadas
    val selectedLang by viewModel.preferenceLangFlow.collectAsStateWithLifecycle()
    val selectedTheme by viewModel.preferenceThemeFlow.collectAsStateWithLifecycle()


    // Listas de opciones desde recursos

    val langOptions = stringResource(Res.string.preference_lang_entries)
        .split(",")
        .mapIndexed { index, entry ->
            Pair(
                entry.trim(),
                stringResource(Res.string.preference_lang_values).split(",")[index].trim()
            )
        }


    val themeOptions = stringResource(Res.string.preference_app_theme_entries)
        .split(",")
        .mapIndexed { index, entry ->
            Pair(
                entry.trim(),
                stringResource(Res.string.preference_app_theme_values).split(",")[index].trim()
            )
        }

    LaunchedEffect(viewModel.message) {
        if (viewModel.message.orEmpty().containsKey("error")) {
            scope.launch {
                snackbarHostState.showSnackbar(
                    message = viewModel.message.orEmpty()["error"].orEmpty(),
                    duration = SnackbarDuration.Short
                )
                viewModel.message?.clear()
            }
        }
    }

    // UI
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = stringResource(Res.string.menu_settings),
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
                    actions = listOf(),
                )
            },
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    Snackbar(
                        snackbarData = data,
                        containerColor = MaterialTheme.colorScheme.error, // Fondo del Snackbar
                        contentColor = MaterialTheme.colorScheme.onError // Color del texto
                    )
                }
            },
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                key(currentLang) {
                    SettingRadioOptions(
                        title = stringResource(Res.string.preference_lang_title),
                        subtitle = stringResource(Res.string.preference_lang_subtitle),
                        iconTint = Color.Unspecified,
                        icon = Icons.Filled.Language,
                        iconDesc = stringResource(Res.string.preference_lang_subtitle),
                        options = langOptions,
                        selectedOption = selectedLang,
                        onOptionSelected = {
                            scope.launch {
                                viewModel.preferenceRepository.setPreference(langPreferenceKey, it)
                            }
                            viewModel.setPreferenceLang(it)
                            onLanguageChange(it)
                        }
                    )

                    SettingRadioOptions(
                        title = stringResource(Res.string.preference_theme_title),
                        subtitle = stringResource(Res.string.preference_theme_subtitle),
                        iconTint = Color.Unspecified,
                        icon = Icons.Filled.Palette,
                        iconDesc = stringResource(Res.string.preference_theme_subtitle),
                        options = themeOptions,
                        selectedOption = selectedTheme,
                        onOptionSelected = {
                            scope.launch {
                                viewModel.preferenceRepository.setPreference(themePreferenceKey, it)
                            }
                            viewModel.setPreferenceTheme(it)
                        }
                    )
                }
            }
        }
    }
}
