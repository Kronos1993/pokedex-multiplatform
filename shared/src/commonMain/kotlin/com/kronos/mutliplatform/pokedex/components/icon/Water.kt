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

val PokemonTypes.Water: ImageVector
    get() {
        if (_water != null) {
            return _water!!
        }
        _water = Builder(
            name = "Water", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF3099E1))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(128.35f, 206.24f)
                curveToRelative(-34.24f, 0.13f, -56.14f, -32.39f, -43.8f, -64.78f)
                curveToRelative(4.18f, -10.98f, 10.78f, -20.6f, 16.8f, -30.49f)
                curveToRelative(9.43f, -15.5f, 15.71f, -32.11f, 19.91f, -49.63f)
                curveToRelative(0.54f, -2.25f, 0.94f, -4.58f, 1.88f, -6.66f)
                curveToRelative(0.93f, -2.07f, 2.13f, -4.29f, 5.02f, -4.17f)
                curveToRelative(2.83f, 0.12f, 3.84f, 2.41f, 4.87f, 4.44f)
                curveToRelative(0.74f, 1.45f, 1.09f, 3.12f, 1.41f, 4.73f)
                curveToRelative(4.46f, 22.12f, 13.91f, 42.06f, 26.04f, 60.93f)
                curveToRelative(7.77f, 12.08f, 14.46f, 24.58f, 14.13f, 39.75f)
                curveToRelative(-0.57f, 26.48f, -19.82f, 45.79f, -46.27f, 45.89f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3A9DE2))) {
                moveTo(129.16f, 193.51f)
                curveToRelative(-13.8f, -1.05f, -25.57f, -4.53f, -32.92f, -16.53f)
                curveToRelative(-1.35f, -2.2f, -3.13f, -5.02f, -1.71f, -7.44f)
                curveToRelative(1.88f, -3.21f, 4.73f, -0.71f, 7.03f, 0.08f)
                curveToRelative(17.88f, 6.19f, 35.7f, 6.17f, 53.52f, -0.27f)
                curveToRelative(2.06f, -0.75f, 4.33f, -2.73f, 6.36f, -0.43f)
                curveToRelative(1.92f, 2.18f, 0.05f, 4.41f, -0.92f, 6.39f)
                curveToRelative(-6.52f, 13.39f, -18.86f, 16.49f, -31.35f, 18.19f)
                close()
            }
        }
        .build()
        return _water!!
    }

private var _water: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Water, contentDescription = null)
    }
}
