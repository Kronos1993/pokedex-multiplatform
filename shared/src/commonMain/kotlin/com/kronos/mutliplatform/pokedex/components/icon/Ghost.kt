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

val PokemonTypes.Ghost: ImageVector
    get() {
        if (_ghost != null) {
            return _ghost!!
        }
        _ghost = Builder(
            name = "Ghost", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF6F4570))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(181.32f, 129.18f)
                curveToRelative(17.5f, -2.25f, 26.94f, 4.31f, 29.63f, 19.92f)
                curveToRelative(0.35f, 2.02f, 0.89f, 4.09f, -0.95f, 5.51f)
                curveToRelative(-1.82f, 1.4f, -3.97f, 0.9f, -5.49f, -0.53f)
                curveToRelative(-3.43f, -3.21f, -6.15f, -2.85f, -9.23f, 0.65f)
                curveToRelative(-11.43f, 13.03f, -11.49f, 12.97f, -25.61f, 3.67f)
                curveToRelative(-7.23f, 9.3f, -13.4f, 19.53f, -22.16f, 27.76f)
                curveToRelative(-15.24f, 14.32f, -23.93f, 14.36f, -39.14f, -0.12f)
                curveToRelative(-8.5f, -8.1f, -14.85f, -17.81f, -21.86f, -27.6f)
                curveToRelative(-1.34f, 0.61f, -2.63f, 0.92f, -3.57f, 1.67f)
                curveToRelative(-11.08f, 8.95f, -12.51f, 8.86f, -20.73f, -3.02f)
                curveToRelative(-3.01f, -4.34f, -5.61f, -7.7f, -10.89f, -2.9f)
                curveToRelative(-1.55f, 1.41f, -3.7f, 1.79f, -5.46f, 0.27f)
                curveToRelative(-1.77f, -1.53f, -1.11f, -3.56f, -0.73f, -5.56f)
                curveToRelative(2.91f, -15.53f, 11.6f, -21.56f, 29.88f, -19.95f)
                curveToRelative(-1.56f, -21.61f, 3.65f, -40.79f, 21.04f, -55.13f)
                curveToRelative(10.2f, -8.4f, 21.88f, -12.33f, 35.08f, -11.62f)
                curveToRelative(30.09f, 1.6f, 48.84f, 26.36f, 50.2f, 66.98f)
                close()
            }
            path(fill = SolidColor(Color(0xFF785279))) {
                moveTo(97.2f, 100.05f)
                curveToRelative(-0.05f, -3.76f, 0.1f, -7.72f, 4.2f, -9.25f)
                curveToRelative(4.1f, -1.54f, 6.94f, 1.39f, 9.36f, 4.16f)
                curveToRelative(5.03f, 5.76f, 7.53f, 12.61f, 6.59f, 20.2f)
                curveToRelative(-0.85f, 6.86f, -5.98f, 8.61f, -11.33f, 4.15f)
                curveToRelative(-5.97f, -4.98f, -8.66f, -11.56f, -8.82f, -19.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFF785279))) {
                moveTo(158.77f, 100.6f)
                curveToRelative(-0.26f, 7.31f, -2.96f, 13.47f, -8.42f, 18.46f)
                curveToRelative(-2.1f, 1.92f, -4.32f, 3.3f, -7.12f, 2.5f)
                curveToRelative(-3.33f, -0.96f, -4.53f, -3.86f, -4.71f, -6.94f)
                curveToRelative(-0.42f, -7.24f, 1.69f, -13.82f, 6.43f, -19.33f)
                curveToRelative(2.59f, -3.02f, 5.62f, -6.37f, 10.14f, -4.27f)
                curveToRelative(3.89f, 1.81f, 3.8f, 5.86f, 3.69f, 9.59f)
                close()
            }
        }
        .build()
        return _ghost!!
    }

private var _ghost: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Ghost, contentDescription = null)
    }
}
