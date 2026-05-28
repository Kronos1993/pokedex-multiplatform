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

val Icons.Scale: ImageVector
    get() {
        if (_scale != null) {
            return _scale!!
        }
        _scale = Builder(
            name = "Scale", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFFACABB1))) {
                moveTo(411.57f, 0f)
                curveToRelative(-0.3f, -0f, -0.55f, -0f, -0.8f, 0f)
                lineTo(256f, 0.01f)
                lineTo(101.97f, 0.02f)
                curveToRelative(-0.76f, -0.03f, -1.48f, -0.03f, -2.32f, 0f)
                curveTo(44.69f, 0.66f, 0f, 45.87f, 0f, 100.85f)
                verticalLineToRelative(310.3f)
                curveTo(0f, 466.76f, 45.24f, 512f, 100.85f, 512f)
                horizontalLineTo(256f)
                horizontalLineToRelative(155.15f)
                curveTo(466.76f, 512f, 512f, 466.76f, 512f, 411.15f)
                verticalLineTo(100.85f)
                curveTo(512f, 45.44f, 466.99f, 0.26f, 411.57f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD8143A))) {
                moveTo(256f, 186.18f)
                curveToRelative(-12.85f, 0f, -23.27f, 10.42f, -23.27f, 23.27f)
                verticalLineToRelative(23.27f)
                verticalLineTo(256f)
                curveToRelative(0f, 12.85f, 10.42f, 23.27f, 23.27f, 23.27f)
                reflectiveCurveToRelative(23.27f, -10.42f, 23.27f, -23.27f)
                verticalLineToRelative(-23.27f)
                verticalLineToRelative(-23.27f)
                curveTo(279.27f, 196.6f, 268.85f, 186.18f, 256f, 186.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDEDEE0))) {
                moveTo(407.2f, 195.29f)
                curveTo(382.26f, 133.21f, 322.91f, 93.09f, 256f, 93.09f)
                reflectiveCurveToRelative(-126.26f, 40.11f, -151.2f, 102.2f)
                curveToRelative(-3.48f, 8.65f, -1.46f, 18.54f, 5.14f, 25.14f)
                lineToRelative(52.03f, 52.03f)
                curveToRelative(4.36f, 4.36f, 10.28f, 6.82f, 16.45f, 6.82f)
                horizontalLineTo(256f)
                curveToRelative(-12.85f, 0f, -23.27f, -10.42f, -23.27f, -23.27f)
                verticalLineToRelative(-23.27f)
                verticalLineToRelative(-23.27f)
                curveToRelative(0f, -12.85f, 10.42f, -23.27f, 23.27f, -23.27f)
                reflectiveCurveToRelative(23.27f, 10.42f, 23.27f, 23.27f)
                verticalLineToRelative(23.27f)
                verticalLineTo(256f)
                curveToRelative(0f, 12.85f, -10.42f, 23.27f, -23.27f, 23.27f)
                horizontalLineToRelative(77.58f)
                curveToRelative(6.17f, 0f, 12.09f, -2.45f, 16.45f, -6.82f)
                lineToRelative(52.03f, -52.03f)
                curveTo(408.66f, 213.83f, 410.68f, 203.94f, 407.2f, 195.29f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD6D5D8))) {
                moveTo(104.8f, 195.29f)
                curveToRelative(-3.48f, 8.65f, -1.46f, 18.54f, 5.14f, 25.14f)
                lineToRelative(52.03f, 52.03f)
                curveToRelative(4.36f, 4.36f, 10.28f, 6.82f, 16.45f, 6.82f)
                horizontalLineTo(256f)
                curveToRelative(-12.85f, 0f, -23.27f, -10.42f, -23.27f, -23.27f)
                verticalLineToRelative(-23.27f)
                verticalLineToRelative(-23.27f)
                curveToRelative(0f, -12.85f, 10.42f, -23.27f, 23.27f, -23.27f)
                verticalLineTo(93.09f)
                curveTo(189.09f, 93.09f, 129.74f, 133.21f, 104.8f, 195.29f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB8002B))) {
                moveTo(232.73f, 209.46f)
                verticalLineToRelative(23.27f)
                verticalLineTo(256f)
                curveToRelative(0f, 12.85f, 10.42f, 23.27f, 23.27f, 23.27f)
                verticalLineToRelative(-93.09f)
                curveTo(243.15f, 186.18f, 232.73f, 196.6f, 232.73f, 209.46f)
                close()
            }
            path(fill = SolidColor(Color(0xFF898890))) {
                moveTo(178.42f, 279.27f)
                curveToRelative(-6.17f, 0f, -12.09f, -2.45f, -16.45f, -6.82f)
                lineToRelative(-52.04f, -52.03f)
                curveToRelative(-6.59f, -6.59f, -8.62f, -16.49f, -5.14f, -25.14f)
                curveTo(129.74f, 133.21f, 189.09f, 93.09f, 256f, 93.09f)
                verticalLineTo(0.01f)
                lineTo(101.97f, 0.02f)
                curveToRelative(-0.76f, -0.03f, -1.48f, -0.03f, -2.32f, 0f)
                curveTo(44.69f, 0.66f, 0f, 45.87f, 0f, 100.85f)
                verticalLineToRelative(310.3f)
                curveTo(0f, 466.76f, 45.24f, 512f, 100.85f, 512f)
                horizontalLineTo(256f)
                verticalLineTo(279.27f)
                horizontalLineTo(178.42f)
                close()
            }
        }
        .build()
        return _scale!!
    }

private var _scale: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Scale, contentDescription = null)
    }
}
