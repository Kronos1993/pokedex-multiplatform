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

val Icons.AppIcon: ImageVector
    get() {
        if (_appIcon != null) {
            return _appIcon!!
        }
        _appIcon = Builder(
            name = "AppIcon", 
            defaultWidth = 108.dp, 
            defaultHeight = 108.dp, 
            viewportWidth = 108f, 
            viewportHeight = 108f
        ).apply {
            path(fill = SolidColor(Color(0xFF082B5B))) {
                moveTo(54f, 54f)
                moveToRelative(-54f, 0f)
                arcToRelative(54f, 54f, 0f, isMoreThanHalf = true, isPositiveArc = true, 108f, 0f)
                arcToRelative(54f, 54f, 0f, isMoreThanHalf = true, isPositiveArc = true, -108f, 0f)
            }
            path(fill = SolidColor(Color(0xFFD9D9D9))) {
                moveTo(54f, 54f)
                moveToRelative(-51f, 0f)
                arcToRelative(51f, 51f, 0f, isMoreThanHalf = true, isPositiveArc = true, 102f, 0f)
                arcToRelative(51f, 51f, 0f, isMoreThanHalf = true, isPositiveArc = true, -102f, 0f)
            }
            path(fill = SolidColor(Color(0xFF0B3F78))) {
                moveTo(54f, 54f)
                moveToRelative(-48f, 0f)
                arcToRelative(48f, 48f, 0f, isMoreThanHalf = true, isPositiveArc = true, 96f, 0f)
                arcToRelative(48f, 48f, 0f, isMoreThanHalf = true, isPositiveArc = true, -96f, 0f)
            }
            path(fill = SolidColor(Color(0xFF8ED8FF))) {
                moveTo(0f, 51f)
                horizontalLineToRelative(108f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-108f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD0D0D0))) {
                moveTo(54f, 54f)
                moveToRelative(-25f, 0f)
                arcToRelative(25f, 25f, 0f, isMoreThanHalf = true, isPositiveArc = true, 50f, 0f)
                arcToRelative(25f, 25f, 0f, isMoreThanHalf = true, isPositiveArc = true, -50f, 0f)
            }
            path(fill = SolidColor(Color(0xFF082B5B))) {
                moveTo(54f, 54f)
                moveToRelative(-21f, 0f)
                arcToRelative(21f, 21f, 0f, isMoreThanHalf = true, isPositiveArc = true, 42f, 0f)
                arcToRelative(21f, 21f, 0f, isMoreThanHalf = true, isPositiveArc = true, -42f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFF003C))) {
                moveTo(35f, 54f)
                arcTo(19f, 19f, 0f, isMoreThanHalf = false, isPositiveArc = true, 73f, 54f)
                lineTo(63f, 54f)
                arcTo(9f, 9f, 0f, isMoreThanHalf = false, isPositiveArc = false, 45f, 54f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(35f, 54f)
                arcTo(19f, 19f, 0f, isMoreThanHalf = false, isPositiveArc = false, 73f, 54f)
                lineTo(63f, 54f)
                arcTo(9f, 9f, 0f, isMoreThanHalf = false, isPositiveArc = true, 45f, 54f)
                close()
            }
            path(fill = SolidColor(Color(0xFF082B5B))) {
                moveTo(54f, 54f)
                moveToRelative(-9f, 0f)
                arcToRelative(9f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = true, 18f, 0f)
                arcToRelative(9f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = true, -18f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF5F5F5))) {
                moveTo(54f, 54f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
        }
        .build()
        return _appIcon!!
    }

private var _appIcon: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.AppIcon, contentDescription = null)
    }
}
