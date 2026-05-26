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

val PokemonTypes.Fighting: ImageVector
    get() {
        if (_fighting != null) {
            return _fighting!!
        }
        _fighting = Builder(
            name = "Fighting", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFE49021))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(187.37f, 155.46f)
                curveToRelative(0.55f, 0.18f, 0.95f, 0.71f, 1.01f, 1.29f)
                curveToRelative(1.74f, 16.71f, -0.12f, 19.56f, -15.05f, 25.28f)
                curveToRelative(-18.32f, 7.01f, -37.09f, 12.47f, -56.28f, 16.61f)
                curveToRelative(-6.49f, 1.4f, -12.82f, 1.23f, -18.55f, -1.56f)
                curveToRelative(-9.55f, -4.66f, -18.43f, -10.58f, -26.79f, -17.18f)
                curveToRelative(-2.9f, -2.29f, -4.35f, -5.25f, -4.45f, -8.92f)
                curveToRelative(-0.16f, -5.96f, 0.32f, -11.94f, 0f, -17.9f)
                curveToRelative(-0.29f, -5.3f, 1.7f, -8.26f, 7.01f, -8.25f)
                curveToRelative(13.98f, 0.02f, 27.96f, 0f, 41.94f, 0.07f)
                curveToRelative(2.73f, 0.01f, 5.69f, 0.39f, 6.17f, 3.76f)
                curveToRelative(0.85f, 6.07f, 5.16f, 6f, 9.64f, 6f)
                curveToRelative(14.98f, -0.02f, 29.96f, -0.02f, 44.94f, 0.04f)
                curveToRelative(3.34f, 0.01f, 6.74f, -0.4f, 10.4f, 0.77f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(66.79f, 97f)
                curveToRelative(0f, -7.65f, -0.17f, -15.31f, 0.05f, -22.96f)
                curveToRelative(0.23f, -8.25f, 1.29f, -9.16f, 9.29f, -9.49f)
                curveToRelative(12.35f, -0.52f, 13.55f, 0.62f, 13.57f, 13.24f)
                curveToRelative(0.03f, 14.31f, 0.11f, 28.62f, -0.05f, 42.92f)
                curveToRelative(-0.1f, 8.6f, -2.14f, 10.41f, -10.71f, 10.59f)
                curveToRelative(-9.27f, 0.18f, -11.82f, -1.83f, -12.08f, -10.34f)
                curveToRelative(-0.24f, -7.98f, -0.05f, -15.97f, -0.05f, -23.96f)
                curveToRelative(0f, 0f, -0.01f, 0f, -0.02f, 0f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(162.9f, 146.55f)
                curveToRelative(-6.65f, 0f, -13.31f, -0.04f, -19.96f, 0.01f)
                curveToRelative(-6.12f, 0.05f, -9.28f, -2.95f, -9.44f, -9.04f)
                curveToRelative(-0.09f, -3.32f, -0.23f, -6.66f, 0f, -9.97f)
                curveToRelative(0.36f, -5.39f, 3.15f, -8.73f, 8.81f, -8.76f)
                curveToRelative(13.64f, -0.08f, 27.28f, 0.01f, 40.91f, -0.04f)
                curveToRelative(4.22f, -0.02f, 5.58f, 2.08f, 6.03f, 6.1f)
                curveToRelative(2.32f, 20.72f, 1.48f, 21.77f, -19.36f, 21.77f)
                curveToRelative(-2.33f, 0f, -4.66f, 0f, -6.99f, 0f)
                curveToRelative(0f, -0.02f, 0f, -0.05f, 0f, -0.07f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(122.79f, 98.15f)
                curveToRelative(0f, 7.98f, 0.25f, 15.96f, -0.07f, 23.93f)
                curveToRelative(-0.3f, 7.37f, -2.74f, 9.14f, -11.13f, 9.21f)
                curveToRelative(-8.7f, 0.07f, -11.35f, -1.5f, -11.5f, -8.78f)
                curveToRelative(-0.36f, -16.61f, -0.09f, -33.23f, -0.15f, -49.85f)
                curveToRelative(-0.02f, -5.98f, 3.01f, -8.41f, 8.72f, -8.11f)
                curveToRelative(1.33f, 0.07f, 2.66f, -0.04f, 3.99f, 0f)
                curveToRelative(8.85f, 0.21f, 9.91f, 1.08f, 10.13f, 9.67f)
                curveToRelative(0.2f, 7.97f, 0.04f, 15.95f, 0.04f, 23.93f)
                curveToRelative(0f, 0f, -0.02f, 0f, -0.03f, 0f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(189.2f, 87.77f)
                curveToRelative(0f, 5.64f, 0f, 11.27f, 0f, 16.91f)
                curveToRelative(0f, 4.05f, -1.9f, 6.18f, -6.11f, 5.93f)
                curveToRelative(-0.66f, -0.04f, -1.33f, 0f, -1.99f, 0.03f)
                quadToRelative(-14.85f, 0.61f, -14.86f, -14.08f)
                curveToRelative(0f, -7.3f, -0.1f, -14.6f, 0.04f, -21.89f)
                curveToRelative(0.17f, -9.07f, 1.26f, -10.04f, 10.57f, -10.2f)
                curveToRelative(1.66f, -0.03f, 3.32f, 0.07f, 4.97f, 0.05f)
                curveToRelative(4.94f, -0.05f, 7.33f, 2.49f, 7.37f, 7.32f)
                curveToRelative(0.04f, 5.31f, 0f, 10.61f, 0f, 15.92f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(156.1f, 88.09f)
                curveToRelative(0f, 5.33f, -0.1f, 10.66f, 0.03f, 15.99f)
                curveToRelative(0.12f, 4.68f, -2.05f, 6.48f, -6.64f, 6.51f)
                curveToRelative(-19.31f, 0.12f, -16.06f, 0.62f, -16.34f, -14.77f)
                curveToRelative(-0.14f, -7.66f, 0.11f, -15.33f, 0.03f, -22.99f)
                curveToRelative(-0.06f, -5.9f, 2.76f, -8.56f, 8.59f, -8.29f)
                curveToRelative(2.33f, 0.11f, 4.66f, 0.06f, 6.99f, 0.05f)
                curveToRelative(5.03f, -0.01f, 7.23f, 2.72f, 7.26f, 7.5f)
                curveToRelative(0.03f, 5.33f, 0f, 10.66f, 0f, 15.99f)
                horizontalLineToRelative(0.06f)
                close()
            }
        }
        .build()
        return _fighting!!
    }

private var _fighting: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Fighting, contentDescription = null)
    }
}
