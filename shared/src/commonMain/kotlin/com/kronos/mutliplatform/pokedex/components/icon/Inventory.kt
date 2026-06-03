package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Icons.Inventory: ImageVector
    get() {
        if (_inventory != null) {
            return _inventory!!
        }
        _inventory = Builder(
            name = "Inventory", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 24f, 
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black), fillAlpha = 0.16f) {
                moveTo(21f, 7f)
                verticalLineToRelative(11.6f)
                curveToRelative(0f, 1.33f, -1.07f, 2.4f, -2.4f, 2.4f)
                horizontalLineTo(5.4f)
                curveTo(4.07f, 21f, 3f, 19.93f, 3f, 18.6f)
                verticalLineTo(7f)
            }
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color.Black), strokeLineWidth = 1.5f, strokeLineCap = Round) {
                moveTo(21f, 7f)
                verticalLineToRelative(11.6f)
                curveToRelative(0f, 1.33f, -1.07f, 2.4f, -2.4f, 2.4f)
                horizontalLineTo(5.4f)
                curveTo(4.07f, 21f, 3f, 19.93f, 3f, 18.6f)
                verticalLineTo(7f)
            }
            path(fill = SolidColor(Color(0xFFE53935)), stroke = SolidColor(Color.Black), strokeLineWidth = 1.5f) {
                moveTo(21.4f, 3f)
                horizontalLineTo(2.6f)
                arcTo(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 4.6f)
                verticalLineToRelative(0.8f)
                arcTo(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.6f, 7f)
                horizontalLineToRelative(18.8f)
                arcTo(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 23f, 5.4f)
                verticalLineToRelative(-0.8f)
                arcTo(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 21.4f, 3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color.Black), strokeLineWidth = 1.5f, strokeLineCap = Round) {
                moveTo(8f, 11f)
                horizontalLineToRelative(8f)
            }
        }
        .build()
        return _inventory!!
    }

private var _inventory: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Inventory, contentDescription = null)
    }
}
