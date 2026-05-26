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

val PokemonTypes.Electric: ImageVector
    get() {
        if (_electric != null) {
            return _electric!!
        }
        _electric = Builder(
            name = "Electric", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFDFBC28))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(112.94f, 205.87f)
                curveToRelative(-4.35f, -1.07f, -3.09f, -4.21f, -2.41f, -6.43f)
                curveToRelative(3.08f, -10.15f, 6.21f, -20.3f, 9.82f, -30.28f)
                curveToRelative(2.33f, -6.45f, 1.96f, -10.95f, -4.46f, -15.2f)
                curveToRelative(-10.8f, -7.15f, -20.8f, -15.48f, -31.36f, -23f)
                curveToRelative(-6.61f, -4.71f, -7.92f, -10.03f, -3.8f, -17.02f)
                curveToRelative(11.64f, -19.74f, 23.22f, -39.49f, 36.68f, -58.1f)
                curveToRelative(5.15f, -7.12f, 10.27f, -8.11f, 17.65f, -3.53f)
                curveToRelative(11.82f, 7.34f, 23.91f, 14.25f, 36.04f, 21.07f)
                curveToRelative(7.09f, 3.99f, 7.59f, 8.15f, 2.06f, 14.06f)
                curveToRelative(-8.19f, 8.74f, -15.62f, 18.2f, -24.02f, 26.73f)
                curveToRelative(-5.23f, 5.31f, -4.13f, 8.76f, 0.94f, 12.93f)
                curveToRelative(6.41f, 5.28f, 12.52f, 10.94f, 18.74f, 16.46f)
                curveToRelative(3.68f, 3.27f, 4.04f, 6.56f, 0.24f, 10.13f)
                curveToRelative(-17.7f, 16.64f, -35.35f, 33.33f, -53.04f, 49.98f)
                curveToRelative(-0.94f, 0.89f, -2.12f, 1.53f, -3.08f, 2.21f)
                close()
            }
        }
        .build()
        return _electric!!
    }

private var _electric: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Electric, contentDescription = null)
    }
}
