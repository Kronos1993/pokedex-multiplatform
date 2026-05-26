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

val PokemonTypes.Bug: ImageVector
    get() {
        if (_bug != null) {
            return _bug!!
        }
        _bug = Builder(
            name = "Bug", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF9F9F28))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(57.84f, 144.71f)
                curveToRelative(-0.01f, -17.4f, 1.6f, -28.85f, 6.39f, -39.68f)
                curveToRelative(3.81f, -8.63f, 8.14f, -10.12f, 15.18f, -4.54f)
                curveToRelative(9.56f, 7.57f, 20.13f, 12.71f, 32f, 15.35f)
                curveToRelative(6.4f, 1.43f, 8.85f, 5.18f, 6.73f, 11.74f)
                curveToRelative(-7.23f, 22.39f, -14.49f, 44.78f, -21.4f, 67.27f)
                curveToRelative(-2.38f, 7.73f, -5.96f, 7.47f, -11.48f, 3.27f)
                curveToRelative(-19.56f, -14.89f, -27.26f, -35.22f, -27.42f, -53.41f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(198.18f, 140.28f)
                curveToRelative(-0.2f, 22.43f, -7.79f, 41.62f, -25.21f, 56.25f)
                curveToRelative(-8.51f, 7.14f, -11.15f, 6.33f, -14.39f, -3.8f)
                curveToRelative(-6.75f, -21.15f, -13.17f, -42.41f, -20.18f, -63.48f)
                curveToRelative(-2.61f, -7.83f, -0.79f, -11.92f, 7.38f, -13.71f)
                curveToRelative(11.17f, -2.45f, 21.18f, -7.45f, 30.21f, -14.58f)
                curveToRelative(7.71f, -6.09f, 11.86f, -4.82f, 15.86f, 4.29f)
                curveToRelative(4.91f, 11.17f, 6.33f, 22.98f, 6.33f, 35.02f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(127.91f, 105.03f)
                curveToRelative(-15.42f, 0.42f, -28.7f, -4.76f, -40.56f, -14.1f)
                curveToRelative(-6.17f, -4.85f, -7.07f, -9.34f, -1.07f, -15.53f)
                curveToRelative(23.76f, -24.54f, 59.04f, -24.66f, 83.13f, -0.34f)
                curveToRelative(6.45f, 6.51f, 5.42f, 11.16f, -1.15f, 16.22f)
                curveToRelative(-11.96f, 9.2f, -25.27f, 14.31f, -40.34f, 13.75f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(128.4f, 179.08f)
                curveToRelative(4.03f, -0.22f, 7.65f, -0.37f, 11.27f, -0.64f)
                curveToRelative(4.75f, -0.35f, 6.18f, 2.6f, 7.01f, 6.54f)
                curveToRelative(0.84f, 3.97f, -0.53f, 6.29f, -4.39f, 7.43f)
                curveToRelative(-9.41f, 2.78f, -18.79f, 2.72f, -28.22f, 0.13f)
                curveToRelative(-4.4f, -1.21f, -5.59f, -3.84f, -4.63f, -8.17f)
                curveToRelative(0.94f, -4.23f, 3.05f, -6.32f, 7.53f, -5.92f)
                curveToRelative(3.94f, 0.35f, 7.89f, 0.44f, 11.44f, 0.63f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(127.89f, 170.73f)
                curveToRelative(-4.86f, -0.9f, -12.01f, 1.45f, -11.66f, -7f)
                curveToRelative(0.31f, -7.45f, 5.28f, -9.23f, 12.43f, -9.21f)
                curveToRelative(7.21f, 0.02f, 11.05f, 3f, 11.1f, 9.52f)
                curveToRelative(0.07f, 8.37f, -7.16f, 5.71f, -11.86f, 6.69f)
                close()
            }
        }
        .build()
        return _bug!!
    }

private var _bug: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Bug, contentDescription = null)
    }
}
