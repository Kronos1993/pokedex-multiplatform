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

val PokemonTypes.Flying: ImageVector
    get() {
        if (_flying != null) {
            return _flying!!
        }
        _flying = Builder(
            name = "Flying", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF74AAD0))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(151.78f, 148.43f)
                curveToRelative(-15.72f, 18.66f, -36.72f, 18.54f, -56.82f, 20.49f)
                curveToRelative(-0.88f, 0.09f, -1.72f, 0.46f, -2.36f, 1.09f)
                curveToRelative(-10.27f, 10.09f, -15.84f, 24.13f, -28f, 33.64f)
                curveToRelative(-0.55f, 0.43f, -1.39f, 0.2f, -1.63f, -0.45f)
                curveToRelative(-2.25f, -6.09f, -1.57f, -11.4f, -0.81f, -16.39f)
                curveToRelative(4.26f, -28.02f, 11.13f, -55.4f, 21.88f, -81.66f)
                curveToRelative(5.83f, -14.23f, 15.13f, -24.51f, 31.59f, -27.2f)
                curveToRelative(24.36f, -3.98f, 47.33f, -13.03f, 70.58f, -20.97f)
                curveToRelative(2.96f, -1.01f, 6.05f, -1.96f, 9.13f, -0.76f)
                curveToRelative(0.97f, 0.38f, 1.74f, 1.18f, 2.02f, 2.18f)
                curveToRelative(0.91f, 3.25f, -0.92f, 5.89f, -2.54f, 8.68f)
                curveToRelative(-13.5f, 23.36f, -34.25f, 37.51f, -58.92f, 46.81f)
                curveToRelative(-3.54f, 1.33f, -7.9f, 2.81f, -10.91f, 5.61f)
                curveToRelative(-0.32f, 0.3f, -0.08f, 0.86f, 0.35f, 0.88f)
                curveToRelative(17.48f, 0.74f, 32.76f, -5.7f, 48.82f, -9.24f)
                curveToRelative(0.55f, -0.12f, 1.04f, 0.45f, 0.84f, 0.98f)
                curveToRelative(-7.05f, 17.94f, -23.79f, 26.99f, -39.9f, 32.15f)
                curveToRelative(-6.3f, 2.02f, -9.35f, 2.46f, -20.33f, 3.46f)
                curveToRelative(-0.37f, 0.03f, -0.41f, 0.49f, -0.11f, 0.57f)
                curveToRelative(15.87f, 4f, 21.78f, -0.55f, 36.34f, -1.55f)
                curveToRelative(0.83f, -0.06f, 1.3f, 1.02f, 0.77f, 1.66f)
                close()
            }
        }
        .build()
        return _flying!!
    }

private var _flying: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Flying, contentDescription = null)
    }
}
