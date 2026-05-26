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

val PokemonTypes.Fairy: ImageVector
    get() {
        if (_fairy != null) {
            return _fairy!!
        }
        _fairy = Builder(
            name = "Fairy", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFE18CE1))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(168.54f, 132.61f)
                curveToRelative(3.77f, 6.74f, 7.72f, 12.55f, 9.17f, 19.5f)
                curveToRelative(2.22f, 10.62f, -1.21f, 14.8f, -11.95f, 15.74f)
                curveToRelative(-7.15f, 0.63f, -10.23f, 0.58f, -23.99f, -6.3f)
                curveToRelative(-0.72f, 12.68f, 10.42f, 26.54f, 7.56f, 40.13f)
                curveToRelative(-0.3f, 1.42f, -2.11f, 1.88f, -3.1f, 0.81f)
                curveToRelative(-10.72f, -11.57f, -11.42f, -26.96f, -18.23f, -40.53f)
                curveToRelative(-6.59f, 13.45f, -7.73f, 28.65f, -17.98f, 40.71f)
                curveToRelative(-0.94f, 1.1f, -2.77f, 0.71f, -3.11f, -0.7f)
                curveToRelative(-3.31f, -13.62f, 7.93f, -26.82f, 7.68f, -39.39f)
                curveToRelative(-4.82f, 3.96f, -16f, 5.77f, -22.74f, 5.34f)
                curveToRelative(-12.59f, -0.8f, -15.97f, -5f, -13.2f, -17.17f)
                curveToRelative(1.5f, -6.62f, 5.97f, -11.71f, 8.57f, -18.3f)
                curveToRelative(-7.97f, -5.14f, -16.04f, -9.4f, -21.66f, -17.39f)
                curveToRelative(-10.4f, -14.76f, -10.88f, -31.08f, -9.17f, -47.77f)
                curveToRelative(0.67f, -6.56f, 6.56f, -8.82f, 12.68f, -9f)
                curveToRelative(22.43f, -0.65f, 42.31f, 4.56f, 55.63f, 24.61f)
                quadToRelative(0.69f, 1.04f, 3.11f, 5.35f)
                quadToRelative(2.46f, -3.75f, 3.18f, -4.86f)
                curveToRelative(13.12f, -20.16f, 32.89f, -25.76f, 55.37f, -25.1f)
                curveToRelative(9.84f, 0.29f, 13.27f, 4.35f, 13.86f, 14.36f)
                curveToRelative(0.99f, 16.72f, -1.38f, 32.29f, -12.39f, 45.93f)
                curveToRelative(-5.05f, 6.25f, -12.22f, 8.98f, -19.28f, 14.02f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE291E2))) {
                moveTo(128.01f, 97.38f)
                curveToRelative(3.43f, 10.49f, 11.99f, 18.83f, 23.75f, 18.89f)
                curveToRelative(-4.1f, 10.72f, -12.19f, 14.1f, -21.2f, 14.91f)
                curveToRelative(-10.89f, 0.98f, -20.09f, -2.8f, -26.74f, -14.02f)
                curveToRelative(11.02f, -1.56f, 20.04f, -8.95f, 24.18f, -19.79f)
                close()
            }
        }
        .build()
        return _fairy!!
    }

private var _fairy: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Fairy, contentDescription = null)
    }
}
