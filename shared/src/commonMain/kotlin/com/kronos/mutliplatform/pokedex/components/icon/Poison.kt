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

val PokemonTypes.Poison: ImageVector
    get() {
        if (_poison != null) {
            return _poison!!
        }
        _poison = Builder(
            name = "Poison", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF9354CB))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(159.37f, 123.2f)
                moveToRelative(-16.8f, 0f)
                arcToRelative(16.8f, 16.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 33.6f, 0f)
                arcToRelative(16.8f, 16.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -33.6f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(102.45f, 86.6f)
                moveToRelative(-28.2f, 0f)
                arcToRelative(28.2f, 28.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 56.4f, 0f)
                arcToRelative(28.2f, 28.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -56.4f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(197.45f, 191.55f)
                curveToRelative(2.36f, -1.5f, 3.12f, -3.08f, 3.28f, -4.91f)
                curveToRelative(0.05f, -0.38f, 0.08f, -0.77f, 0.08f, -1.18f)
                curveToRelative(0f, -0.27f, -0.03f, -0.52f, -0.06f, -0.76f)
                curveToRelative(-0.16f, -2.7f, -1.26f, -4.54f, -8.23f, -6.81f)
                curveToRelative(-1.21f, -0.39f, -2.54f, -0.78f, -3.97f, -1.17f)
                curveToRelative(-7.9f, -2.37f, -15.56f, -3.78f, -24.24f, -4.53f)
                curveToRelative(-3.43f, -0.44f, -6.99f, -0.84f, -10.63f, -1.18f)
                curveToRelative(-1.71f, -0.52f, -2.31f, -1.28f, -2.72f, -2.44f)
                curveToRelative(-0.55f, -2.95f, -1.65f, -5.7f, -3.19f, -8.15f)
                curveToRelative(-3.79f, -6.49f, -9.84f, -10.25f, -17.82f, -10.82f)
                curveToRelative(-0.49f, -0.04f, -0.98f, -0.07f, -1.48f, -0.08f)
                curveToRelative(-0.04f, 0f, -0.08f, 0f, -0.12f, 0f)
                curveToRelative(-0.03f, 0f, -0.05f, 0f, -0.08f, 0f)
                curveToRelative(-0.09f, 0f, -0.18f, 0f, -0.27f, 0f)
                curveToRelative(-0.27f, 0f, -0.53f, 0.01f, -0.8f, 0.02f)
                curveToRelative(-9.24f, 0.17f, -16.18f, 4.64f, -19.99f, 12.7f)
                curveToRelative(-0.62f, 1.22f, -1.15f, 2.49f, -1.55f, 3.82f)
                curveToRelative(-0.93f, 2.47f, -1.59f, 3.97f, -3.63f, 4.86f)
                curveToRelative(-4.92f, 0.42f, -9.65f, 0.95f, -14.1f, 1.57f)
                curveToRelative(-4.28f, 0.46f, -8.51f, 1.21f, -12.7f, 2.17f)
                curveToRelative(-5.5f, 1.14f, -10.17f, 2.43f, -13.73f, 3.8f)
                curveToRelative(-0.53f, 0.19f, -1.04f, 0.4f, -1.54f, 0.63f)
                curveToRelative(-4.26f, 1.9f, -4.63f, 3.67f, -4.66f, 5.88f)
                curveToRelative(-0.02f, 0.26f, -0.05f, 0.52f, -0.04f, 0.8f)
                curveToRelative(0f, 0.16f, 0.03f, 0.31f, 0.04f, 0.47f)
                curveToRelative(0.06f, 2.53f, 0.72f, 4.56f, 5.71f, 6.64f)
                curveToRelative(0.94f, 0.41f, 1.93f, 0.76f, 2.94f, 1.08f)
                curveToRelative(1.65f, 0.55f, 3.48f, 1.08f, 5.48f, 1.59f)
                curveToRelative(8.46f, 2.29f, 17.02f, 3.57f, 25.62f, 4.37f)
                curveToRelative(10.22f, 1.13f, 21.52f, 1.79f, 32.87f, 1.8f)
                curveToRelative(0f, 0f, 0f, 0f, 0.01f, 0f)
                curveToRelative(0f, 0f, 0f, 0f, 0f, 0f)
                curveToRelative(0.03f, 0f, 0.06f, 0f, 0.09f, 0f)
                curveToRelative(10.47f, 0f, 20.99f, -0.59f, 30.65f, -1.59f)
                curveToRelative(10.15f, -0.84f, 20.2f, -2.3f, 30.08f, -5.18f)
                curveToRelative(0.46f, -0.13f, 0.91f, -0.26f, 1.35f, -0.39f)
                curveToRelative(0.09f, -0.03f, 0.17f, -0.05f, 0.26f, -0.08f)
                curveToRelative(2.29f, -0.71f, 4.79f, -1.49f, 6.76f, -2.73f)
                curveToRelative(0.08f, -0.05f, 0.16f, -0.1f, 0.25f, -0.15f)
                curveToRelative(0.02f, -0.02f, 0.05f, -0.03f, 0.07f, -0.05f)
                close()
            }
        }
        .build()
        return _poison!!
    }

private var _poison: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Poison, contentDescription = null)
    }
}
