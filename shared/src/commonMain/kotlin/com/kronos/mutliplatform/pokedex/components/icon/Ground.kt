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

val PokemonTypes.Ground: ImageVector
    get() {
        if (_ground != null) {
            return _ground!!
        }
        _ground = Builder(
            name = "Ground", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFA4733C))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(126.23f, 184.84f)
                curveToRelative(-2.52f, -0.77f, -6.4f, -1.66f, -10.06f, -3.12f)
                curveToRelative(-16.93f, -6.77f, -33.8f, -13.68f, -50.68f, -20.59f)
                curveToRelative(-1.52f, -0.62f, -2.94f, -1.54f, -4.37f, -2.37f)
                curveToRelative(-7.42f, -4.3f, -7.7f, -9.21f, -0.2f, -12.86f)
                curveToRelative(20.58f, -10.01f, 41.94f, -18.12f, 63.61f, -25.43f)
                curveToRelative(2.66f, -0.9f, 5.15f, -0.6f, 7.77f, 0.29f)
                curveToRelative(21.03f, 7.14f, 41.73f, 15.08f, 61.78f, 24.65f)
                curveToRelative(0.9f, 0.43f, 1.91f, 0.68f, 2.71f, 1.23f)
                curveToRelative(4.81f, 3.35f, 4.98f, 8.12f, -0.08f, 11.12f)
                curveToRelative(-4.54f, 2.69f, -9.52f, 4.66f, -14.4f, 6.73f)
                curveToRelative(-16.16f, 6.86f, -32.34f, 13.7f, -49f, 19.3f)
                curveToRelative(-1.91f, 0.64f, -3.72f, 1.37f, -7.09f, 1.04f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(127.56f, 209.93f)
                curveToRelative(-4.2f, 0f, -16.12f, -4.16f, -23.83f, -7.01f)
                curveToRelative(-14.62f, -5.41f, -29.03f, -11.48f, -43.23f, -17.96f)
                curveToRelative(-0.67f, -0.3f, -3.56f, -1.99f, -5.19f, -2.94f)
                curveToRelative(-5.04f, -2.9f, -5.41f, -3.74f, -2.57f, -9.25f)
                curveToRelative(1.9f, -3.68f, 2.7f, -3.31f, 7.75f, -0.99f)
                curveToRelative(16.01f, 7.32f, 32.38f, 13.67f, 48.71f, 20.15f)
                reflectiveCurveToRelative(21.09f, 6.87f, 37.52f, 0.04f)
                curveToRelative(15.91f, -6.61f, 31.68f, -13.54f, 47.8f, -19.73f)
                curveToRelative(4.87f, -1.87f, 6.88f, -3.86f, 9.14f, 1.33f)
                curveToRelative(1.81f, 4.15f, 3.83f, 5.53f, -3.76f, 8.84f)
                curveToRelative(-16.74f, 7.31f, -33.07f, 15.45f, -50.36f, 21.36f)
                curveToRelative(-7.2f, 2.46f, -17.23f, 6.15f, -21.98f, 6.15f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(93.59f, 71.19f)
                quadToRelative(0f, 14.24f, -14.1f, 14.23f)
                curveToRelative(-1.33f, 0f, -2.65f, 0.02f, -3.98f, -0.02f)
                curveToRelative(-8.78f, -0.28f, -9.26f, -0.78f, -9.52f, -9.97f)
                quadToRelative(-0.51f, -18.04f, 17.68f, -17.63f)
                curveToRelative(9.44f, 0.22f, 9.76f, 0.54f, 9.92f, 10.4f)
                curveToRelative(0.02f, 0.99f, 0f, 1.99f, 0f, 2.98f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(185.3f, 87.72f)
                curveToRelative(-0.14f, 10.17f, -0.34f, 10.34f, -11.99f, 10.25f)
                curveToRelative(-10f, -0.08f, -10.24f, -0.37f, -10.14f, -12.06f)
                curveToRelative(0.09f, -10.18f, 0.35f, -10.41f, 11.95f, -10.24f)
                curveToRelative(10.14f, 0.15f, 10.34f, 0.38f, 10.18f, 12.05f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(119.38f, 99.54f)
                curveToRelative(0.04f, 8.09f, -1.04f, 9.17f, -9.13f, 9.18f)
                curveToRelative(-8.19f, 0f, -9.46f, -1.21f, -9.42f, -8.99f)
                curveToRelative(0.04f, -7.6f, 0.99f, -8.41f, 9.78f, -8.36f)
                curveToRelative(8.16f, 0.05f, 8.74f, 0.59f, 8.78f, 8.16f)
                close()
            }
        }
        .build()
        return _ground!!
    }

private var _ground: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Ground, contentDescription = null)
    }
}
