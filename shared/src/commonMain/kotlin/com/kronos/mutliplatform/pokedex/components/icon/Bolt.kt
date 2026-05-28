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

val Icons.Bolt: ImageVector
    get() {
        if (_bolt != null) {
            return _bolt!!
        }
        _bolt = Builder(
            name = "Bolt", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFB655))) {
                moveTo(463.41f, 199.92f)
                curveToRelative(-3.76f, -8.36f, -12.06f, -13.74f, -21.23f, -13.74f)
                horizontalLineTo(301.32f)
                lineToRelative(39.31f, -157.26f)
                curveToRelative(2.6f, -10.4f, -2.23f, -21.22f, -11.71f, -26.23f)
                curveToRelative(-9.47f, -5f, -21.14f, -2.89f, -28.26f, 5.12f)
                lineTo(256f, 58.06f)
                lineTo(52.43f, 287.08f)
                curveToRelative(-6.09f, 6.85f, -7.59f, 16.64f, -3.84f, 25f)
                reflectiveCurveToRelative(12.06f, 13.74f, 21.23f, 13.74f)
                horizontalLineToRelative(140.86f)
                lineToRelative(-39.31f, 157.26f)
                curveToRelative(-2.6f, 10.4f, 2.23f, 21.22f, 11.71f, 26.23f)
                curveToRelative(3.44f, 1.82f, 7.16f, 2.69f, 10.86f, 2.69f)
                curveToRelative(6.49f, 0f, 12.87f, -2.71f, 17.4f, -7.81f)
                lineToRelative(44.67f, -50.25f)
                lineToRelative(203.57f, -229.02f)
                curveTo(465.67f, 218.07f, 467.17f, 208.28f, 463.41f, 199.92f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB655))) {
                moveTo(69.82f, 325.82f)
                horizontalLineToRelative(140.86f)
                lineToRelative(-39.31f, 157.26f)
                curveToRelative(-2.6f, 10.4f, 2.23f, 21.22f, 11.71f, 26.23f)
                curveToRelative(3.44f, 1.82f, 7.16f, 2.69f, 10.86f, 2.69f)
                curveToRelative(6.49f, 0f, 12.87f, -2.71f, 17.4f, -7.81f)
                lineToRelative(44.67f, -50.25f)
                verticalLineTo(58.06f)
                lineTo(52.43f, 287.08f)
                curveToRelative(-6.09f, 6.85f, -7.59f, 16.64f, -3.84f, 25f)
                curveTo(52.34f, 320.44f, 60.65f, 325.82f, 69.82f, 325.82f)
                close()
            }
        }
        .build()
        return _bolt!!
    }

private var _bolt: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Bolt, contentDescription = null)
    }
}
