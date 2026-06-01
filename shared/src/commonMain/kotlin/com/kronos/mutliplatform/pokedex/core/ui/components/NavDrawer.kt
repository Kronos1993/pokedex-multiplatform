package com.kronos.mutliplatform.pokedex.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import kotlinx.coroutines.launch

enum class Destinations {
    POKEDEX,
    POKEMON_LIST,
    POKEMON_DETAIL,
    MOVES,
    MOVE_DETAIL,
    TYPES,
    TYPES_DETAIL,
    SETTINGS,
    ABOUT,
    EXIT
}

data class NavigationItem(
    val title: String,
    val destination: Destinations,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTint: Color = Color.Unspecified,
    val isPrimary: Boolean = true,
    val isSelected: Boolean = false,
    var badgeCount: Int? = null,
    val onClick: (Int, NavigationItem) -> Unit
)

private val drawerHeaderGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFFCC0000),
        Color(0xFFE53935),
        Color(0xFFEF5350),
    ),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)

@Composable
fun NavDrawer(
    navigationItems: List<NavigationItem>,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    gesturesEnabled: Boolean = true,
    scrimColor: Color = DrawerDefaults.scrimColor,
    drawerHeader: @Composable () -> Unit = { DrawerPlaceholderHeader() },
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                drawerHeader()

                Spacer(modifier = Modifier.padding(5.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    navigationItems.forEachIndexed { index, item ->
                        if (index > 0 && navigationItems[index - 1].isPrimary && !item.isPrimary) {
                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 8.dp),
                                thickness = 1.dp,
                                color = MaterialTheme.colorScheme.outlineVariant // Color estándar de la guía de diseño
                            )
                        }

                        NavigationDrawerItem(
                            label = { Text(text = item.title) },
                            selected = index == selectedIndex,
                            onClick = {
                                if (index != selectedIndex) {
                                    item.onClick(index, item)
                                }
                                scope.launch { drawerState.close() }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedIndex) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title,
                                    tint = item.iconTint,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            badge = {
                                item.badgeCount?.takeIf { it > 0 }?.let { count ->
                                    LabelText(
                                        text = if (count > 99) "99+" else count.toString(),
                                        textColor = Color.White,
                                        size = ComponentSize.SMALL,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .background(
                                                MaterialTheme.colorScheme.error,
                                                shape = RoundedCornerShape(50.dp)
                                            )
                                            .padding(horizontal = 6.dp, vertical = 4.dp)
                                    )
                                }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(
                                    alpha = 0.2f
                                ),
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                            ),
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        },
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
        scrimColor = scrimColor,
        content = content
    )
}

@Composable
fun DrawerHeader(
    avatarUrl: String?,
    name: String,
    subtitle: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = drawerHeaderGradient)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (!avatarUrl.isNullOrEmpty()) {
                AvatarView(
                    avatarUrl = avatarUrl,
                    placeholder = name,
                    onAvatarClicked = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column {
                TitleText(
                    text = name,
                    textColor = Color.White,
                    size = ComponentSize.MEDIUM
                )
                Spacer(modifier = Modifier.height(5.dp))
                BodyText(
                    text = subtitle,
                    textColor = Color.White.copy(alpha = 0.85f),
                    maxLines = 5,
                    textOverflow = TextOverflow.Ellipsis,
                    size = ComponentSize.MEDIUM
                )
            }
        }
    }
}

@Composable
fun DrawerHeader(
    icon: ImageVector?,
    name: String,
    subtitle: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = drawerHeaderGradient)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    modifier = Modifier.size(64.dp),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column {
                TitleText(
                    text = name,
                    textColor = Color.White,
                    size = ComponentSize.MEDIUM
                )
                Spacer(modifier = Modifier.height(5.dp))
                BodyText(
                    text = subtitle,
                    textColor = Color.White.copy(alpha = 0.85f),
                    maxLines = 5,
                    textOverflow = TextOverflow.Ellipsis,
                    size = ComponentSize.MEDIUM
                )
            }
        }
    }
}

@Composable
fun DrawerPlaceholderHeader(title: String = "Welcome!") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(brush = drawerHeaderGradient),
        contentAlignment = Alignment.Center
    ) {
        TitleText(text = title, textColor = Color.White, size = ComponentSize.MEDIUM)
    }
}

@Composable
fun AvatarView(
    avatarUrl: String,
    placeholder: String,
    size: Dp = 64.dp,
    cornerRadius: Dp = 32.dp,
    onAvatarClicked: () -> Unit
) {
    if (avatarUrl.isNotEmpty()) {
        val imageRequest = ImageRequest.Builder(LocalPlatformContext.current)
            .data(avatarUrl)
            .memoryCachePolicy(CachePolicy.DISABLED)
            .diskCachePolicy(CachePolicy.DISABLED)
            .build()

        AsyncImage(
            model = imageRequest,
            contentDescription = "Avatar",
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color.Gray)
                .clickable { onAvatarClicked() },
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color.Gray)
                .clickable { onAvatarClicked() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = placeholder.take(1).uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
fun NavDrawerPreview() {
    val items = listOf(
        NavigationItem(
            title = "Pokédex",
            destination = Destinations.POKEDEX,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            isPrimary = true,
            isSelected = true,
            onClick = { _, _ -> }
        ),
        NavigationItem(
            title = "Pokémon List",
            destination = Destinations.POKEMON_LIST,
            selectedIcon = Icons.AutoMirrored.Filled.List,
            unselectedIcon = Icons.AutoMirrored.Outlined.List,
            isPrimary = true,
            onClick = { _, _ -> }
        ),
        NavigationItem(
            title = "Moves",
            destination = Destinations.MOVES,
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            isPrimary = true,
            badgeCount = 3,
            onClick = { _, _ -> }
        ),
        NavigationItem(
            title = "Settings",
            destination = Destinations.SETTINGS,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            isPrimary = false,
            onClick = { _, _ -> }
        ),
        NavigationItem(
            title = "About",
            destination = Destinations.ABOUT,
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            isPrimary = false,
            onClick = { _, _ -> }
        ),
    )

    AppTheme {
        NavDrawer(
            navigationItems = items,
            selectedIndex = 0,
            drawerState = rememberDrawerState(DrawerValue.Open),
            drawerHeader = {
                DrawerHeader(
                    icon = Icons.Filled.CatchingPokemon,
                    name = "Pokédex",
                    subtitle = "Gotta catch 'em all"
                )
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                )
            }
        )
    }
}

@Preview
@Composable
fun DrawerHeaderAvatarPreview() {
    AppTheme {
        DrawerHeader(
            avatarUrl = "",
            name = "Ash Ketchum",
            subtitle = "Pallet Town Trainer"
        )
    }
}

@Preview
@Composable
fun DrawerPlaceholderHeaderPreview() {
    AppTheme {
        DrawerPlaceholderHeader(title = "Welcome!")
    }
}