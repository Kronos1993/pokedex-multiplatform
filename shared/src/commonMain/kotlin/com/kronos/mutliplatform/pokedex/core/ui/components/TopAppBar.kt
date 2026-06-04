package com.kronos.mutliplatform.pokedex.core.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.core.ui.components.button.Button
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.core.ui.components.menu.AppBarAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    title: String?,
    navIconButton: @Composable () -> Unit,
    actions: List<AppBarAction>,
    searchEnabled: Boolean = false,
    isSearching: Boolean = false,
    searchPlaceholder: String = "",
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    onSearchToggle: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    appBarColors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
    ),
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(isSearching) {
        if (isSearching) {
            focusRequester.requestFocus()
        }
    }

    TopAppBar(
        title = {
            if (isSearching) {

                TextInputView(
                    type = TextInputType.OUTLINED,
                    fontColor = MaterialTheme.colorScheme.onPrimary,
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    onSearchQueryChange("")
                                },
                                icon = Icons.Default.Close,
                                iconColor = MaterialTheme.colorScheme.onPrimary,
                                size = ComponentSize.LARGE
                            )
                        }
                    },
                    placeholder = {
                        BodyText(
                            searchPlaceholder,
                            textColor = MaterialTheme.colorScheme.onPrimary,
                            size = ComponentSize.LARGE
                        )
                    },
                    colors = TextFieldDefaults.colors(

                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,

                        cursorColor = MaterialTheme.colorScheme.onPrimary,

                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,

                        focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),

                        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),

                        focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                    )
                )

            } else {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (!title.isNullOrEmpty()) {
                        Text(
                            title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

            }
        },
        navigationIcon = navIconButton,
        actions = {
            if (searchEnabled) {
                if (isSearching){
                    IconButton(
                        icon = Icons.Filled.Close,
                        iconColor = MaterialTheme.colorScheme.onPrimary,
                        onClick = {
                            onSearchToggle()
                        },
                        size = ComponentSize.LARGE
                    )
                }else{
                    IconButton(
                        icon = Icons.Filled.Search,
                        iconColor = MaterialTheme.colorScheme.onPrimary,
                        onClick = {
                            onSearchToggle()
                        },
                        size = ComponentSize.LARGE
                    )
                }
            }
            actions.forEach { action ->
                when (action) {
                    is AppBarAction.Icon -> {
                        IconButton(
                            onClick = action.onClick,
                            iconColor = action.tint,
                            icon = action.icon,
                            size = ComponentSize.LARGE
                        )
                    }

                    is AppBarAction.Menu -> {
                        IconButton(
                            onClick = { expanded = !expanded },
                            iconColor = MaterialTheme.colorScheme.onPrimary,
                            icon = Icons.Filled.MoreVert,
                            size = ComponentSize.LARGE
                        )

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            action.items.forEach { menuItem ->
                                DropdownMenuItem(
                                    onClick = {
                                        menuItem.onClick()
                                        expanded = false
                                    },
                                    text = { Text(menuItem.label) },
                                    leadingIcon = {
                                        if (menuItem.icon != null) {
                                            Icon(
                                                imageVector = menuItem.icon,
                                                tint = menuItem.tint,
                                                contentDescription = menuItem.label,
                                                modifier = Modifier.padding(end = 8.dp)
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }

                    is AppBarAction.IconText -> {
                        Button(
                            text = action.text,
                            iconPosition = action.iconPosition,
                            icon = action.icon,
                            onClick = action.onClick,
                            size = action.size,
                            type = action.type,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior,
        colors = appBarColors,
        modifier = modifier
    )
}