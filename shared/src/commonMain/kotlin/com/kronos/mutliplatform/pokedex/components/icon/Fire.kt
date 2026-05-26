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

val PokemonTypes.Fire: ImageVector
    get() {
        if (_fire != null) {
            return _fire!!
        }
        _fire = Builder(
            name = "Fire", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFE4613E))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(101.14f, 196.71f)
                curveToRelative(-18.04f, -4.97f, -32.15f, -33.23f, -26.12f, -56.44f)
                curveToRelative(2.47f, -9.5f, 6.73f, -18.04f, 13.15f, -25.42f)
                curveToRelative(5.67f, -6.52f, 11.56f, -12.86f, 17.44f, -19.19f)
                curveToRelative(16.45f, -17.72f, 16.84f, -21.84f, 3.67f, -40.92f)
                curveToRelative(16.66f, -6.33f, 35.79f, 6.81f, 36.26f, 24.87f)
                curveToRelative(0.23f, 8.92f, -3.12f, 16.84f, -6.55f, 24.78f)
                curveToRelative(-2.86f, 6.61f, -3.94f, 13.22f, 1.46f, 21.46f)
                curveToRelative(0.78f, -7.78f, 0.25f, -13.98f, 5.16f, -19.12f)
                curveToRelative(5.44f, -5.7f, 9.99f, -7.61f, 18.26f, -5.74f)
                curveToRelative(-8f, 6.58f, -6.97f, 10.9f, 6.52f, 29.92f)
                curveToRelative(12.34f, 17.41f, 15.7f, 32.35f, 6.6f, 48.54f)
                curveToRelative(-9.75f, 17.35f, -30.86f, 27.88f, -50.31f, 24.97f)
                curveToRelative(1.32f, -2.15f, 5f, -3.89f, 7.7f, -5.48f)
                curveToRelative(12.95f, -7.61f, 14.91f, -19.54f, 4.94f, -30.71f)
                curveToRelative(-3.31f, -3.71f, -7.06f, -7.04f, -10.68f, -10.47f)
                curveToRelative(-14.71f, -13.95f, -16.33f, -16.83f, -20.12f, -36.25f)
                curveToRelative(-20.01f, 10.96f, -23.87f, 46.75f, -7.38f, 75.23f)
                close()
            }
        }
        .build()
        return _fire!!
    }

private var _fire: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Fire, contentDescription = null)
    }
}
