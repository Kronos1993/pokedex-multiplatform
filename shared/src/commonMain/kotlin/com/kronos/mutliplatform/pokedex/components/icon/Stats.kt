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

val Icons.Stats: ImageVector
    get() {
        if (_stats != null) {
            return _stats!!
        }
        _stats = Builder(
            name = "Stats", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFFE21B1B))) {
                moveTo(256f, 0f)
                curveTo(114.62f, 0f, 0f, 114.62f, 0f, 256f)
                reflectiveCurveToRelative(114.62f, 256f, 256f, 256f)
                curveToRelative(141.32f, 0f, 255.9f, -114.51f, 255.99f, -255.82f)
                horizontalLineTo(256f)
                verticalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC9C9C9))) {
                moveTo(437.11f, 75.07f)
                lineTo(256f, 256.18f)
                horizontalLineToRelative(255.99f)
                curveToRelative(0f, -0.06f, 0.01f, -0.12f, 0.01f, -0.18f)
                curveTo(512f, 185.35f, 483.38f, 121.39f, 437.11f, 75.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC9C9C9))) {
                moveTo(256f, 0f)
                verticalLineToRelative(256.18f)
                lineTo(437.11f, 75.07f)
                curveTo(390.78f, 28.7f, 326.74f, 0f, 256f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAAAA))) {
                moveTo(437.11f, 436.74f)
                lineTo(256f, 255.62f)
                horizontalLineToRelative(255.99f)
                curveToRelative(0f, 0.06f, 0.01f, 0.12f, 0.01f, 0.18f)
                curveTo(512f, 326.46f, 483.38f, 390.42f, 437.11f, 436.74f)
                close()
            }
            path(fill = SolidColor(Color(0xFF939393))) {
                moveTo(256f, 511.81f)
                verticalLineTo(255.62f)
                lineToRelative(181.11f, 181.11f)
                curveTo(390.78f, 483.12f, 326.74f, 511.81f, 256f, 511.81f)
                close()
            }
        }
        .build()
        return _stats!!
    }

private var _stats: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Stats, contentDescription = null)
    }
}
