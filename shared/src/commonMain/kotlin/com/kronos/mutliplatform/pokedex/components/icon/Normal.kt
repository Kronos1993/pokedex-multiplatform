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

val PokemonTypes.Normal: ImageVector
    get() {
        if (_normal != null) {
            return _normal!!
        }
        _normal = Builder(
            name = "Normal", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF828282))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(129.76f, 204.09f)
                curveToRelative(-52.17f, 0.13f, -86.62f, -49.01f, -69.05f, -96.43f)
                curveToRelative(1.58f, -4.26f, 2.06f, -8.18f, 0.3f, -12.54f)
                curveToRelative(-4.35f, -10.76f, -2.11f, -20.35f, 6.4f, -28.13f)
                curveToRelative(8.6f, -7.86f, 18.65f, -8.56f, 28.73f, -3.56f)
                curveToRelative(4.11f, 2.04f, 7.65f, 1.76f, 11.48f, 0.67f)
                curveToRelative(13.45f, -3.84f, 26.89f, -3.86f, 40.31f, -0.09f)
                curveToRelative(5.01f, 1.41f, 9.29f, 0.9f, 14.31f, -1.24f)
                curveToRelative(9.79f, -4.16f, 19.59f, -3.35f, 27.74f, 4.64f)
                curveToRelative(8.34f, 8.17f, 9.92f, 17.82f, 5.48f, 28.33f)
                curveToRelative(-1.7f, 4.02f, -1.86f, 7.6f, -0.29f, 11.52f)
                curveToRelative(13.45f, 33.52f, -1.47f, 71.64f, -33.35f, 88.74f)
                curveToRelative(-10.47f, 5.62f, -21.72f, 8.21f, -32.05f, 8.08f)
                close()
            }
            path(fill = SolidColor(Color(0xFF828282))) {
                moveTo(77.28f, 133.16f)
                curveToRelative(-1.34f, -26.26f, 21.93f, -51.19f, 50.24f, -51.09f)
                curveToRelative(28.36f, 0.09f, 50.55f, 22.02f, 51.35f, 50.13f)
                curveToRelative(0.68f, 24.05f, -19.28f, 50.72f, -50.39f, 51.16f)
                curveToRelative(-27.94f, 0.4f, -51.07f, -22.27f, -51.2f, -50.2f)
                close()
            }
        }
        .build()
        return _normal!!
    }

private var _normal: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Normal, contentDescription = null)
    }
}
