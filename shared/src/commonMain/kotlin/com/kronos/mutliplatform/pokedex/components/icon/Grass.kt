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

val PokemonTypes.Grass: ImageVector
    get() {
        if (_grass != null) {
            return _grass!!
        }
        _grass = Builder(
            name = "Grass", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF439837))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(194.3f, 86.12f)
                curveToRelative(2.2f, -2.13f, 1.76f, 4.2f, 1.52f, 6.15f)
                curveToRelative(-4.07f, 32.61f, -8.97f, 65.08f, -16.15f, 97.16f)
                curveToRelative(-1.92f, 8.61f, -3.33f, 9.71f, -12.1f, 9.84f)
                curveToRelative(-9.68f, 0.14f, -19.35f, 0.06f, -28.95f, 0.04f)
                curveToRelative(-1.7f, 0f, -2.85f, -1.73f, -2.2f, -3.3f)
                curveToRelative(15.94f, -38.11f, 37.34f, -90.03f, 57.88f, -109.89f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(121.47f, 180.64f)
                curveToRelative(-0.83f, -23.74f, 2.05f, -37.16f, 5.01f, -68.66f)
                curveToRelative(0.12f, -1.32f, 0.59f, -2.57f, 1.15f, -3.77f)
                curveToRelative(3.53f, -7.48f, 17.34f, -36.24f, 25.36f, -46.17f)
                curveToRelative(1.68f, -2.08f, 5.01f, -0.95f, 5.18f, 1.71f)
                curveToRelative(0.11f, 1.78f, 0.04f, 3.44f, -0.03f, 5.22f)
                curveToRelative(-0.89f, 20.31f, -3.29f, 40.49f, -6.19f, 60.6f)
                curveToRelative(-0.56f, 3.86f, -2.22f, 7.68f, -3.97f, 11.23f)
                curveToRelative(-5.73f, 11.62f, 1.08f, -2.28f, -17.76f, 34.57f)
                curveToRelative(-1.19f, 2.34f, -2.12f, 5.3f, -4.33f, 6.98f)
                curveToRelative(-1.8f, 1.37f, -4.34f, 0.55f, -4.42f, -1.7f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(116.82f, 86.12f)
                curveToRelative(2.2f, -2.13f, 1.76f, 4.2f, 1.52f, 6.15f)
                curveToRelative(-4.07f, 32.61f, -8.97f, 65.08f, -16.15f, 97.16f)
                curveToRelative(-1.92f, 8.61f, -3.33f, 9.71f, -12.1f, 9.84f)
                curveToRelative(-9.68f, 0.14f, -19.35f, 0.06f, -28.95f, 0.04f)
                curveToRelative(-1.7f, 0f, -2.85f, -1.73f, -2.2f, -3.3f)
                curveToRelative(15.94f, -38.11f, 37.34f, -90.03f, 57.88f, -109.89f)
                close()
            }
        }
        .build()
        return _grass!!
    }

private var _grass: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Grass, contentDescription = null)
    }
}
