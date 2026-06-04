package com.kronos.mutliplatform.pokedex.features.move.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kronos.mutliplatform.pokedex.AppViewModel
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.components.icon.AppIcon
import com.kronos.mutliplatform.pokedex.core.PlatformType
import com.kronos.mutliplatform.pokedex.core.ui.components.AppTopAppBar
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.Destinations
import com.kronos.mutliplatform.pokedex.core.ui.components.DrawerHeader
import com.kronos.mutliplatform.pokedex.core.ui.components.LoadingDialog
import com.kronos.mutliplatform.pokedex.core.ui.components.NavDrawer
import com.kronos.mutliplatform.pokedex.core.ui.components.PullToRefreshContainer
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.features.move.list.content.MovesContent
import com.kronos.mutliplatform.pokedex.rememberNavDestinations
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.app_name
import pokedex.shared.generated.resources.empty_move_list
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title
import pokedex.shared.generated.resources.menu_moves
import pokedex.shared.generated.resources.menu_pokemon_search_placeholder
import pokedex.shared.generated.resources.refresh_list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoveListScreen(
    navHost: NavHostController,
    isDarkTheme: Boolean,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<MoveListScreenViewModel>()
    val appViewModel = koinViewModel<AppViewModel>()

    val moves by viewModel.moves.collectAsStateWithLifecycle()
    val appVersion by viewModel.appVersion.collectAsStateWithLifecycle()
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.message.collectAsStateWithLifecycle()
    val isLastPage by viewModel.lastPage.collectAsStateWithLifecycle()
    val isSearching by viewModel.isSearching.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val listState = rememberLazyGridState()

    val navDestinations = rememberNavDestinations(
        navController = navHost,
        isDesktop = viewModel.platform.platformType == PlatformType.DESKTOP,
        onExitClicked = {
            appViewModel.showExitDialog(true)
        }
    )

    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedItem = remember(currentRoute, navDestinations) {
        navDestinations.indexOfFirst { it.destination.name == currentRoute }.coerceAtLeast(0)
    }

    val gridColumns = remember(deviceScreenConfiguration) {
        when (deviceScreenConfiguration) {
            DeviceScreenConfiguration.MOBILE_PORTRAIT -> 2
            DeviceScreenConfiguration.MOBILE_LANDSCAPE,
            DeviceScreenConfiguration.TABLET_PORTRAIT -> 3

            DeviceScreenConfiguration.TABLET_LANDSCAPE,
            DeviceScreenConfiguration.DESKTOP -> 4
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getAppVersion()
        viewModel.loadMoves()
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

    LaunchedEffect(listState, isLastPage, isLoading, moves) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleItemIndex ->
                val totalItems = listState.layoutInfo.totalItemsCount
                if (lastVisibleItemIndex != null &&
                    lastVisibleItemIndex >= totalItems - 3 &&
                    !isLastPage &&
                    !isLoading &&
                    moves.isNotEmpty()
                ) {
                    viewModel.loadMoves()
                }
            }
    }


    NavDrawer(
        navigationItems = navDestinations,
        selectedIndex = selectedItem,
        drawerState = drawerState,
        drawerHeader = {
            DrawerHeader(
                icon = Icons.AppIcon,
                name = stringResource(Res.string.app_name),
                subtitle = appVersion
            )
        },
        scrimColor = if (viewModel.platform.platformType == PlatformType.DESKTOP) {
            Color.Transparent
        } else {
            DrawerDefaults.scrimColor
        },
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Scaffold(
            topBar = {
                AppTopAppBar(
                    title = stringResource(Res.string.menu_moves),
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
                isRefreshing = isLoading,
                onRefresh = { viewModel.loadMoves(true) }
            ) {

                val rootModifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(color = Color.Transparent)
                    .consumeWindowInsets(WindowInsets.navigationBars)

                if (moves.isEmpty()) {
                    EmptyList(
                        title = stringResource(Res.string.empty_move_list),
                        subtitle = stringResource(Res.string.refresh_list),
                        showRetryButton = true,
                        onRetryClick = {
                            viewModel.loadMoves(true)
                        },
                        modifier = rootModifier
                    )
                } else {
                    MovesContent(
                        gridColumns = gridColumns,
                        listState = listState,
                        moves = moves,
                        onClick = {
                            navHost.navigate("${Destinations.MOVE_DETAIL.name}/${it.name}")
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