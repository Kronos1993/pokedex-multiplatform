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

val PokemonTypes.Ice: ImageVector
    get() {
        if (_ice != null) {
            return _ice!!
        }
        _ice = Builder(
            name = "Ice", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFF47C8C8))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFBFDFD))) {
                moveTo(110.36f, 60.61f)
                curveToRelative(6.05f, -5.88f, 11.4f, -11.09f, 17.77f, -17.29f)
                curveToRelative(5.97f, 6.13f, 11.17f, 11.47f, 17.14f, 17.59f)
                curveToRelative(-4.92f, 5.79f, -9.31f, 10.96f, -14.74f, 17.36f)
                curveToRelative(12.8f, 7.44f, 26.4f, 16.32f, 40.07f, 24.27f)
                verticalLineToRelative(-23.26f)
                horizontalLineToRelative(24.01f)
                curveToRelative(0f, 7.81f, 0.09f, 16.68f, 0.09f, 25.33f)
                curveToRelative(-21.7f, 0f, -5.65f, 0.26f, -22.24f, 0.26f)
                curveToRelative(0f, 15.36f, 0.44f, 31.53f, 0.44f, 47.51f)
                horizontalLineToRelative(21.79f)
                verticalLineToRelative(24.18f)
                horizontalLineToRelative(-23.94f)
                verticalLineToRelative(-21.88f)
                curveToRelative(-13.22f, 7.56f, -27.06f, 15.34f, -40.38f, 22.95f)
                curveToRelative(5.13f, 5.9f, 9.4f, 10.79f, 14.9f, 17.11f)
                curveToRelative(-5.37f, 5.66f, -10.66f, 11.23f, -17.36f, 18.29f)
                curveToRelative(-5.96f, -6.39f, -11.21f, -12.02f, -17.12f, -18.36f)
                curveToRelative(4.98f, -5.7f, 9.44f, -10.8f, 14.84f, -16.97f)
                curveToRelative(-13.25f, -7.61f, -27f, -15.35f, -40.37f, -23.03f)
                verticalLineToRelative(22.22f)
                horizontalLineToRelative(-24.05f)
                verticalLineToRelative(-24.46f)
                horizontalLineToRelative(22.03f)
                curveToRelative(0f, -15.56f, -0.08f, -32.89f, -0.08f, -48.86f)
                lineToRelative(-22.05f, -0.08f)
                verticalLineToRelative(-24.22f)
                horizontalLineToRelative(24.22f)
                curveToRelative(0f, 21.72f, 0f, 2.88f, 0f, 21.24f)
                curveToRelative(13.09f, -7.41f, 26.69f, -14.32f, 40.16f, -21.95f)
                curveToRelative(-5.03f, -5.96f, -9.38f, -11.12f, -15.15f, -17.95f)
                close()
            }
            path(fill = SolidColor(Color(0xFF64CFCF))) {
                moveTo(96.46f, 140.79f)
                verticalLineToRelative(-32.06f)
                curveToRelative(12.55f, -7.16f, 12.55f, -6.81f, 27.27f, -15.03f)
                lineToRelative(6.03f, 7.93f)
                curveToRelative(-22.64f, 12.82f, 0.71f, -0.29f, -22.64f, 12.82f)
                verticalLineToRelative(26.34f)
                horizontalLineToRelative(-10.66f)
                close()
            }
        }
        .build()
        return _ice!!
    }

private var _ice: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Ice, contentDescription = null)
    }
}
