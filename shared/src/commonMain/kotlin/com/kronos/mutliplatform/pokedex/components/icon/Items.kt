package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Icons.Items: ImageVector
    get() {
        if (_items != null) {
            return _items!!
        }
        _items = Builder(
            name = "Items", 
            defaultWidth = 512.dp, 
            defaultHeight = 512.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFF00D7DF))) {
                moveTo(146.29f, 364.61f)
                horizontalLineToRelative(365.71f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-365.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00D7DF))) {
                moveTo(146.29f, 220.54f)
                horizontalLineToRelative(365.71f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-365.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00D7DF))) {
                moveTo(146.29f, 72.04f)
                horizontalLineToRelative(365.71f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-365.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(257.11f, 364.61f)
                horizontalLineToRelative(254.89f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-254.89f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(257.11f, 220.54f)
                horizontalLineToRelative(254.89f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-254.89f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(257.11f, 72.04f)
                horizontalLineToRelative(254.89f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-254.89f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(0f, 366.82f)
                horizontalLineToRelative(73.14f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-73.14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(0f, 220.54f)
                horizontalLineToRelative(73.14f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-73.14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A1A7))) {
                moveTo(0f, 72.04f)
                horizontalLineToRelative(73.14f)
                verticalLineToRelative(73.14f)
                horizontalLineToRelative(-73.14f)
                close()
            }
        }
        .build()
        return _items!!
    }

private var _items: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Items, contentDescription = null)
    }
}
