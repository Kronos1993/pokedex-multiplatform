package com.kronos.mutliplatform.pokedex.features.items.list

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
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
import com.kronos.mutliplatform.pokedex.features.items.list.content.ItemsContent
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.prettyName
import com.kronos.mutliplatform.pokedex.screen_config.DeviceScreenConfiguration
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokedex_list
import pokedex.shared.generated.resources.loading_dialog_text
import pokedex.shared.generated.resources.loading_dialog_title
import pokedex.shared.generated.resources.menu_items
import pokedex.shared.generated.resources.menu_pokemon_search_placeholder
import pokedex.shared.generated.resources.refresh_list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    itemCategory: String? = null,
    navHost: NavHostController,
    isDarkTheme: Boolean,
    deviceScreenConfiguration: DeviceScreenConfiguration,
) {
    val viewModel = koinViewModel<ItemListScreenViewModel>()

    val items by viewModel.items.collectAsStateWithLifecycle()
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val errorMessage by viewModel.message.collectAsStateWithLifecycle()
    val isLastPage by viewModel.lastPage.collectAsStateWithLifecycle()
    val isSearching by viewModel.isSearching.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val listState = rememberLazyGridState()

    val itemsTitle = stringResource(Res.string.menu_items)

    val screenTitle = remember(itemCategory) {
        itemCategory?.takeIf { it.isNotEmpty() }?.prettyName() ?: itemsTitle
    }

    val gridColumns = remember(deviceScreenConfiguration) {
        when (deviceScreenConfiguration) {
            DeviceScreenConfiguration.MOBILE_PORTRAIT -> 2
            DeviceScreenConfiguration.MOBILE_LANDSCAPE,
            DeviceScreenConfiguration.TABLET_PORTRAIT -> 4
            DeviceScreenConfiguration.TABLET_LANDSCAPE,
            DeviceScreenConfiguration.DESKTOP -> 6
        }
    }

    LaunchedEffect(itemCategory) {
        viewModel.loadItems(itemCategory)
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

    LaunchedEffect(listState, isLastPage, isLoading, items) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleItemIndex ->
                val totalItems = listState.layoutInfo.totalItemsCount
                if (lastVisibleItemIndex != null &&
                    lastVisibleItemIndex >= totalItems - 3 &&
                    !isLastPage &&
                    !isLoading &&
                    items.isNotEmpty()
                ) {
                    viewModel.loadItems(itemCategory)
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
                onRefresh = { viewModel.refreshItems(itemCategory,true) }
            ) {
                val rootModifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(color = Color.Transparent)
                    .consumeWindowInsets(WindowInsets.navigationBars)

                if (items.isEmpty()) {
                    EmptyList(
                        title = stringResource(Res.string.empty_pokedex_list),
                        subtitle = stringResource(Res.string.refresh_list),
                        showRetryButton = true,
                        onRetryClick = {
                            viewModel.refreshItems(itemCategory,true)
                        },
                        modifier = rootModifier
                    )
                } else {
                    ItemsContent(
                        gridColumns = gridColumns,
                        listState = listState,
                        itemList = items,
                        onClick = { item ->
                            navHost.navigate("${Destinations.ITEM_DETAIL.name}/${item.name}")
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