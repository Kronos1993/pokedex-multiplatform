package com.kronos.mutliplatform.pokedex.core.ui.components.menu

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.IconPosition
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType

sealed class AppBarAction {
    data class Menu(val items: List<MenuItem>) : AppBarAction()
    data class Icon(
        val icon: ImageVector,
        val tint: Color = Color.White,
        val contentDescription: String?,
        val onClick: () -> Unit,
    ) : AppBarAction()

    data class IconText(
        val icon: ImageVector,
        val text: String,
        val iconPosition: IconPosition,
        val size: ComponentSize,
        val type: ButtonType,
        val tint: Color = Color.White,
        val contentDescription: String?,
        val onClick: () -> Unit,
    ) : AppBarAction()
}

data class MenuItem(
    val label: String,
    val icon: ImageVector? = null,
    val tint: Color = Color.White,
    val onClick: () -> Unit
)