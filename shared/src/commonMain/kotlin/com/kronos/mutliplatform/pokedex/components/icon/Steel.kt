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

val PokemonTypes.Steel: ImageVector
    get() {
        if (_steel != null) {
            return _steel!!
        }
        _steel = Builder(
            name = "Steel", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF74B0CB))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(117.24f, 93.22f)
                curveToRelative(2.6f, 13.41f, 4.78f, 24.66f, 7.26f, 37.43f)
                curveToRelative(-22.73f, 6.49f, -44.68f, 12.75f, -69.68f, 19.88f)
                curveToRelative(9.84f, -30.35f, 18.66f, -57.52f, 27.59f, -85.05f)
                horizontalLineToRelative(89.4f)
                curveToRelative(0.95f, 2.01f, 2.13f, 4.49f, 3.84f, 8.09f)
                curveToRelative(-19.64f, 6.61f, -38.27f, 12.88f, -58.41f, 19.65f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(200.8f, 150.53f)
                curveToRelative(-14.91f, 10.77f, -28.49f, 20.58f, -44.8f, 32.36f)
                curveToRelative(-7.75f, -27.52f, -14.82f, -52.63f, -22.38f, -79.5f)
                curveToRelative(16.5f, -5.26f, 30.78f, -9.82f, 46.8f, -14.93f)
                curveToRelative(6.96f, 21.21f, 13.5f, 41.12f, 20.38f, 62.07f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(143.47f, 191.59f)
                curveToRelative(-5.22f, 3.98f, -10.06f, 7.68f, -15.77f, 12.03f)
                curveToRelative(-19.71f, -14.37f, -38.84f, -28.32f, -61.19f, -44.61f)
                curveToRelative(22.17f, -6.41f, 40.89f, -11.82f, 61.12f, -17.66f)
                curveToRelative(5.46f, 17.32f, 10.48f, 33.22f, 15.85f, 50.24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF77B2CB))) {
                moveTo(97.05f, 80.81f)
                moveToRelative(-7.64f, 0f)
                arcToRelative(7.64f, 7.64f, 0f, isMoreThanHalf = true, isPositiveArc = true, 15.28f, 0f)
                arcToRelative(7.64f, 7.64f, 0f, isMoreThanHalf = true, isPositiveArc = true, -15.28f, 0f)
            }
            path(fill = SolidColor(Color(0xFF77B2CB))) {
                moveTo(161.67f, 116.95f)
                moveToRelative(-10.41f, 0f)
                arcToRelative(10.41f, 10.41f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20.82f, 0f)
                arcToRelative(10.41f, 10.41f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20.82f, 0f)
            }
        }
        .build()
        return _steel!!
    }

private var _steel: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Steel, contentDescription = null)
    }
}
