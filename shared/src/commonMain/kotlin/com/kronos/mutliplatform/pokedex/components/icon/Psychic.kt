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

val PokemonTypes.Psychic: ImageVector
    get() {
        if (_psychic != null) {
            return _psychic!!
        }
        _psychic = Builder(
            name = "Psychic", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFE96C8C))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(197.45f, 99.74f)
                curveToRelative(0.29f, 5.25f, -2.01f, 9.75f, -4.39f, 14.13f)
                curveToRelative(-5f, 9.21f, -4.92f, 18.19f, -0.37f, 27.66f)
                curveToRelative(10.23f, 21.3f, 3.62f, 33.41f, -19.59f, 35.57f)
                curveToRelative(-11.16f, 1.04f, -19.22f, 5.65f, -25.41f, 15.11f)
                curveToRelative(-11.71f, 17.9f, -27.71f, 17.77f, -39.56f, -0.25f)
                curveToRelative(-5.98f, -9.09f, -13.76f, -13.73f, -24.55f, -14.79f)
                curveToRelative(-24.07f, -2.36f, -30.54f, -13.99f, -20.14f, -35.92f)
                curveToRelative(4.32f, -9.12f, 4.22f, -17.7f, -0.14f, -26.79f)
                curveToRelative(-10.21f, -21.31f, -3.62f, -33.41f, 19.59f, -35.57f)
                curveToRelative(11.15f, -1.04f, 19.23f, -5.65f, 25.41f, -15.11f)
                curveToRelative(11.49f, -17.58f, 27.83f, -17.94f, 38.95f, -0.54f)
                curveToRelative(7.09f, 11.09f, 16.73f, 15.07f, 29.13f, 16.03f)
                curveToRelative(13.9f, 1.08f, 21.17f, 8.75f, 21.06f, 20.48f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE96C8D))) {
                moveTo(174.57f, 154.66f)
                curveToRelative(-20.78f, 1.82f, -35.45f, 9.96f, -46.37f, 26.9f)
                curveToRelative(-11.55f, -16.67f, -26f, -25.21f, -45.7f, -26.81f)
                curveToRelative(6.99f, -17.87f, 8.75f, -34.96f, -0.85f, -53f)
                curveToRelative(19.9f, -2.33f, 34.97f, -10.36f, 46.4f, -26.96f)
                curveToRelative(11.3f, 16.3f, 25.74f, 24.84f, 45.44f, 26.44f)
                curveToRelative(-6.94f, 17.88f, -8.77f, 34.96f, 1.08f, 53.42f)
                close()
            }
        }
        .build()
        return _psychic!!
    }

private var _psychic: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Psychic, contentDescription = null)
    }
}
