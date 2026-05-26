package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val PokemonTypes.Dragon: ImageVector
    get() {
        if (_dragon != null) {
            return _dragon!!
        }
        _dragon = Builder(
            name = "Dragon", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF576FBC))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(170.93f, 124.41f)
                curveToRelative(0.8f, 15.21f, -5.05f, 28.07f, -14.96f, 38.95f)
                curveToRelative(-4.86f, 5.34f, -7.13f, 10.82f, -7.01f, 17.85f)
                curveToRelative(0.07f, 4.3f, -0.64f, 8.63f, -1.21f, 12.91f)
                curveToRelative(-1.48f, 11.17f, -7.97f, 16.55f, -19.79f, 16.53f)
                curveToRelative(-11.81f, -0.02f, -18.2f, -5.38f, -19.75f, -16.59f)
                curveToRelative(-0.18f, -1.32f, -0.43f, -2.65f, -0.42f, -3.97f)
                curveToRelative(0.07f, -12.31f, -3.37f, -22.68f, -11.93f, -32.43f)
                curveToRelative(-14.25f, -16.22f, -14.56f, -45.3f, -2.66f, -60.49f)
                curveToRelative(5.82f, -7.42f, 4.65f, -17.14f, 7.55f, -25.58f)
                curveToRelative(2.37f, -6.9f, 4.02f, -14.05f, 6.07f, -21.06f)
                curveToRelative(0.48f, -1.65f, 1.51f, -3.06f, 3.48f, -3f)
                curveToRelative(2.02f, 0.06f, 2.71f, 1.6f, 3.11f, 3.3f)
                curveToRelative(1.8f, 7.77f, 4.05f, 15.47f, 5.23f, 23.33f)
                curveToRelative(0.95f, 6.31f, 4.94f, 5.95f, 9.39f, 5.97f)
                curveToRelative(4.5f, 0.02f, 8.42f, 0.25f, 9.35f, -6.03f)
                curveToRelative(1.11f, -7.53f, 3.32f, -14.9f, 5.03f, -22.34f)
                curveToRelative(0.45f, -1.96f, 0.74f, -4.19f, 3.34f, -4.19f)
                curveToRelative(2.43f, 0f, 3.15f, 1.99f, 3.71f, 4f)
                curveToRelative(1.88f, 6.72f, 3.88f, 13.4f, 5.7f, 20.14f)
                curveToRelative(3.01f, 11.13f, 4.22f, 22.74f, 11.59f, 32.51f)
                curveToRelative(4.31f, 5.71f, 3.98f, 13.22f, 4.18f, 20.21f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(194.2f, 95.93f)
                curveToRelative(16.78f, 17.37f, 18.87f, 64.53f, -8.22f, 85.49f)
                curveToRelative(-5.83f, -6.35f, -8.44f, -14.77f, -13.52f, -21.58f)
                curveToRelative(-0.65f, -0.87f, -0.74f, -2.88f, -0.18f, -3.82f)
                curveToRelative(5.41f, -9f, 4.95f, -20.46f, 12.96f, -28.54f)
                curveToRelative(7.84f, -7.92f, 9.39f, -18.61f, 8.97f, -31.55f)
                close()
            }
            path(fill = SolidColor(Color(0xFF576FBC))) {
                moveTo(141.47f, 153.95f)
                curveToRelative(6.61f, -10.7f, 12.32f, -19.93f, 18.62f, -30.12f)
                curveToRelative(5.76f, 18.39f, -0.34f, 28.8f, -18.62f, 30.12f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(61.68f, 95.93f)
                curveToRelative(-16.78f, 17.37f, -18.87f, 64.53f, 8.22f, 85.49f)
                curveToRelative(5.83f, -6.35f, 8.44f, -14.77f, 13.52f, -21.58f)
                curveToRelative(0.65f, -0.87f, 0.74f, -2.88f, 0.18f, -3.82f)
                curveToRelative(-5.41f, -9f, -4.95f, -20.46f, -12.96f, -28.54f)
                curveToRelative(-7.84f, -7.92f, -9.39f, -18.61f, -8.97f, -31.55f)
                close()
            }
            path(fill = SolidColor(Color(0xFF576FBC))) {
                moveTo(115.46f, 153.95f)
                curveToRelative(-6.61f, -10.7f, -12.32f, -19.93f, -18.62f, -30.12f)
                curveToRelative(-5.76f, 18.39f, 0.34f, 28.8f, 18.62f, 30.12f)
                close()
            }
        }
        .build()
        return _dragon!!
    }

private var _dragon: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = PokemonTypes.Dragon, contentDescription = null)
    }
}
