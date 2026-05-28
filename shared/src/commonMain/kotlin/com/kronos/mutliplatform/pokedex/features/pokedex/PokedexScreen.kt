package com.kronos.mutliplatform.pokedex.features.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.components.icon.AppIcon
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.ConfirmDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.DrawerHeader
import com.kronos.mutliplatform.pokedex.core.ui.components.LoadingDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.NavDrawer
import com.kronos.mutliplatform.pokedex.core.ui.components.PullToRefreshContainer
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.core.util.BackPressHandlerEffect
import com.kronos.mutliplatform.pokedex.features.pokedex.content.PokedexContent
import com.kronos.mutliplatform.pokedex.getNavDestinations
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.app_name
import pokedex.shared.generated.resources.empty_pokedex_list
import pokedex.shared.generated.resources.exit_dialog_body
import pokedex.shared.generated.resources.exit_dialog_no
import pokedex.shared.generated.resources.exit_dialog_title
import pokedex.shared.generated.resources.exit_dialog_yes
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title
import pokedex.shared.generated.resources.menu_pokedex
import pokedex.shared.generated.resources.refresh_list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(
    navHost: NavHostController,
    isDarkTheme: Boolean,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<PokedexScreenViewModel>()

    val pokedexList by viewModel.pokedex.collectAsStateWithLifecycle()
    val appVersion by viewModel.appVersion.collectAsStateWithLifecycle()
    var showExitDialog by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItem by remember { mutableIntStateOf(0) }
    val listState = rememberLazyGridState()


    LaunchedEffect(Unit){
        viewModel.loadPokedex()
        viewModel.getAppVersion()
    }

    BackPressHandlerEffect(
        enabled = navHost.currentBackStackEntry?.destination?.route == Destinations.POKEDEX.name
    ) {
        showExitDialog = true
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        NavDrawer(
            navigationItems = getNavDestinations(
                navHost,),
            selectedIndex = selectedItem,
            drawerState = drawerState,
            drawerHeader = {
                DrawerHeader(
                    icon = Icons.AppIcon,
                    name = stringResource(Res.string.app_name),
                    subtitle = appVersion
                )
            }
        ) {
            Scaffold(
                topBar = {
                    AppTopAppBar(
                        title = stringResource(Res.string.menu_pokedex),
                        navIconButton = {
                            IconButton(
                                icon = Icons.Filled.Menu,
                                onClick = {
                                    scope.launch { drawerState.open() }
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
                    isRefreshing = viewModel.loading,
                    onRefresh = { viewModel.loadPokedex(true) }
                ) {

                    val rootModifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                        .background(color = Color.Transparent)
                        .consumeWindowInsets(WindowInsets.navigationBars)

                    LaunchedEffect(listState) {
                        snapshotFlow {
                            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                        }.collect { lastVisibleItemIndex ->
                            val totalItems = listState.layoutInfo.totalItemsCount
                            if (lastVisibleItemIndex != null &&
                                lastVisibleItemIndex >= totalItems - 3 &&
                                !viewModel.lastPage.value &&
                                pokedexList.isNotEmpty()
                            ) {
                                viewModel.loadPokedex()
                            }
                        }
                    }

                    if (pokedexList.isEmpty()) {
                        EmptyList(
                            title = stringResource(Res.string.empty_pokedex_list),
                            subtitle = stringResource(Res.string.refresh_list),
                            showRetryButton = true,
                            onRetryClick = {
                                viewModel.loadPokedex(true)
                            },
                            modifier = rootModifier
                        )
                    } else {
                        PokedexContent(
                            gridColumns = when (deviceScreenConfiguration) {
                                DeviceScreenConfiguration.MOBILE_PORTRAIT -> {
                                    2
                                }

                                DeviceScreenConfiguration.MOBILE_LANDSCAPE,
                                DeviceScreenConfiguration.TABLET_PORTRAIT -> {
                                    3
                                }

                                DeviceScreenConfiguration.TABLET_LANDSCAPE,
                                DeviceScreenConfiguration.DESKTOP -> {
                                    4
                                }
                            },
                            listState = listState,
                            pokedexList = pokedexList,
                            onClick = {
                                viewModel.appCache._currentPokedex.value = it
                                navHost.navigate("${Destinations.POKEMON_LIST.name}/${it.name}")
                            },
                            modifier = rootModifier
                        )
                    }
                }

                // Diálogo de carga
                LoadingDialog(
                    Res.string.loading_dialog_title,
                    Res.string.loading_dialog_text,
                    showDialog = viewModel.loading
                )

                ConfirmDialog(
                    title = stringResource(Res.string.exit_dialog_title),
                    body = stringResource(Res.string.exit_dialog_body),
                    confirmText = stringResource(Res.string.exit_dialog_yes),
                    onConfirm = {

                        viewModel.closeApp()
                        showExitDialog = false
                    },
                    cancelText = stringResource(Res.string.exit_dialog_no),
                    onCancel = { showExitDialog = false },
                    showDialog = showExitDialog
                )

                // Mostrar Snackbar en caso de error
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
        }
    }
}