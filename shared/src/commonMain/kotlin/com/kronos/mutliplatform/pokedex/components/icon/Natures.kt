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

val Icons.Natures: ImageVector
    get() {
        if (_natures != null) {
            return _natures!!
        }
        _natures = Builder(
            name = "Natures", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFF76CC5B))) {
                moveTo(90.74f, 421.26f)
                curveToRelative(145.94f, 145.95f, 485.68f, -115.38f, 410.55f, -410.55f)
                curveTo(206.12f, -64.42f, -55.21f, 275.32f, 90.74f, 421.26f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.2f, strokeAlpha = 0.2f) {
                moveTo(90.74f, 374.98f)
                curveToRelative(-23.11f, -23.11f, -36f, -51.09f, -40.17f, -81.51f)
                curveToRelative(-6.04f, 48.06f, 5.7f, 93.33f, 40.17f, 127.79f)
                curveTo(226.37f, 556.89f, 529.37f, 340.78f, 511.22f, 72.64f)
                curveTo(494.63f, 318.48f, 218.46f, 502.7f, 90.74f, 374.98f)
                close()
            }
            path(fill = SolidColor(Color(0xFF599944))) {
                moveTo(399.17f, 206.68f)
                lineToRelative(-64.02f, -13.47f)
                lineToRelative(62.69f, -62.69f)
                curveToRelative(4.52f, -4.52f, 4.52f, -11.85f, 0f, -16.36f)
                reflectiveCurveToRelative(-11.85f, -4.52f, -16.36f, 0f)
                lineToRelative(-62.69f, 62.69f)
                lineToRelative(-13.47f, -64.02f)
                curveToRelative(-1.32f, -6.25f, -7.45f, -10.26f, -13.7f, -8.94f)
                curveToRelative(-6.26f, 1.32f, -10.26f, 7.45f, -8.94f, 13.7f)
                lineToRelative(16.57f, 78.8f)
                lineToRelative(-58.59f, 58.59f)
                lineToRelative(-13.47f, -64.02f)
                curveToRelative(-1.32f, -6.26f, -7.45f, -10.26f, -13.7f, -8.94f)
                curveToRelative(-6.25f, 1.32f, -10.26f, 7.45f, -8.94f, 13.7f)
                lineToRelative(16.57f, 78.8f)
                lineToRelative(-58.59f, 58.59f)
                lineToRelative(-13.47f, -64.02f)
                curveToRelative(-1.32f, -6.25f, -7.45f, -10.26f, -13.7f, -8.94f)
                curveToRelative(-6.26f, 1.32f, -10.26f, 7.45f, -8.94f, 13.7f)
                lineToRelative(16.57f, 78.79f)
                lineTo(3.39f, 492.25f)
                curveToRelative(-4.52f, 4.52f, -4.52f, 11.85f, 0f, 16.36f)
                curveToRelative(2.26f, 2.26f, 5.22f, 3.39f, 8.18f, 3.39f)
                reflectiveCurveToRelative(5.92f, -1.13f, 8.18f, -3.39f)
                lineToRelative(139.6f, -139.6f)
                lineToRelative(78.8f, 16.57f)
                curveToRelative(0.8f, 0.17f, 1.61f, 0.25f, 2.39f, 0.25f)
                curveToRelative(5.36f, 0f, 10.17f, -3.74f, 11.31f, -9.19f)
                curveToRelative(1.32f, -6.25f, -2.69f, -12.39f, -8.94f, -13.7f)
                lineToRelative(-64.02f, -13.47f)
                lineToRelative(58.59f, -58.59f)
                lineToRelative(78.8f, 16.57f)
                curveToRelative(0.8f, 0.17f, 1.61f, 0.25f, 2.39f, 0.25f)
                curveToRelative(5.36f, 0f, 10.16f, -3.74f, 11.31f, -9.19f)
                curveToRelative(1.32f, -6.25f, -2.69f, -12.39f, -8.94f, -13.7f)
                lineToRelative(-64.02f, -13.47f)
                lineToRelative(58.59f, -58.59f)
                lineToRelative(78.8f, 16.58f)
                curveToRelative(0.8f, 0.17f, 1.61f, 0.25f, 2.39f, 0.25f)
                curveToRelative(5.36f, 0f, 10.17f, -3.74f, 11.31f, -9.19f)
                curveTo(409.43f, 214.13f, 405.43f, 207.99f, 399.17f, 206.68f)
                close()
            }
        }
        .build()
        return _natures!!
    }

private var _natures: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Natures, contentDescription = null)
    }
}
