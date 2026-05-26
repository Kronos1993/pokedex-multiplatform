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

val PokemonTypes.Dark: ImageVector
    get() {
        if (_dark != null) {
            return _dark!!
        }
        _dark = Builder(
            name = "Dark", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF4F4747))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(74.46f, 84.24f)
                curveToRelative(7.49f, 7.56f, 17.75f, 14.95f, 27.04f, 16.93f)
                curveToRelative(-1.38f, 2.84f, -1.88f, 5.07f, -2.37f, 8.23f)
                curveToRelative(-2.78f, 17.82f, -1.19f, 34.63f, 12.15f, 48.3f)
                curveToRelative(10.06f, 10.31f, 23.45f, 10.28f, 33.51f, -0.09f)
                curveToRelative(13.29f, -13.71f, 14.91f, -30.51f, 12.01f, -48.33f)
                curveToRelative(-0.43f, -2.62f, -1.93f, -9.15f, -1.88f, -9.24f)
                curveToRelative(0.1f, -0.18f, 0f, -0.08f, 1f, -0.38f)
                curveToRelative(6.48f, -1.51f, 18.62f, -7.99f, 26.05f, -15.5f)
                curveToRelative(15.36f, 11.88f, 23.65f, 36.91f, 14.18f, 56.85f)
                curveToRelative(-12.94f, 27.24f, -43.16f, 51.76f, -81.43f, 43.96f)
                curveToRelative(-29.15f, -5.94f, -49.04f, -24.49f, -57.95f, -53.21f)
                curveToRelative(-4.14f, -13.33f, 1.67f, -35.98f, 17.7f, -47.52f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(139.92f, 124.38f)
                curveToRelative(-0.27f, 5.3f, -0.79f, 12.61f, -6.05f, 18.45f)
                curveToRelative(-4.12f, 4.57f, -7.96f, 4.83f, -11.66f, -0.03f)
                curveToRelative(-7.43f, -9.75f, -7.46f, -20.89f, -4.48f, -32.19f)
                curveToRelative(1.96f, -7.42f, 2.86f, -7.9f, 10.26f, -7.9f)
                curveToRelative(7.41f, 0f, 7.97f, 0.58f, 10.38f, 7.85f)
                curveToRelative(1.28f, 3.88f, 1.58f, 7.78f, 1.56f, 13.83f)
                close()
            }
        }
        .build()
        return _dark!!
    }

private var _dark: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Dark, contentDescription = null)
    }
}
