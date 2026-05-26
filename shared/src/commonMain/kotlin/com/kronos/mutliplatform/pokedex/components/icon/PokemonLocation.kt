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

val Icons.PokemonLocation: ImageVector
    get() {
        if (_pokemonLocation != null) {
            return _pokemonLocation!!
        }
        _pokemonLocation = Builder(
            name = "PokemonLocation", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 511.98f, 
            viewportHeight = 511.98f
        ).apply {
            path(fill = SolidColor(Color(0xFFED5564))) {
                moveTo(423.05f, 111.9f)
                curveToRelative(-9.16f, -21.51f, -22.2f, -40.92f, -38.79f, -57.7f)
                curveToRelative(-16.7f, -16.89f, -36.08f, -30.19f, -57.59f, -39.51f)
                curveTo(304.19f, 4.94f, 280.42f, 0f, 255.99f, 0f)
                curveToRelative(-24.42f, 0f, -48.2f, 4.94f, -70.67f, 14.69f)
                curveToRelative(-21.51f, 9.33f, -40.89f, 22.63f, -57.59f, 39.51f)
                curveToRelative(-16.59f, 16.78f, -29.65f, 36.19f, -38.8f, 57.7f)
                curveToRelative(-9.46f, 22.23f, -14.27f, 45.59f, -14.27f, 69.42f)
                curveToRelative(0f, 51.94f, 25.67f, 90.33f, 58.17f, 138.92f)
                curveToRelative(27.62f, 41.29f, 61.99f, 92.68f, 91.18f, 168.81f)
                curveToRelative(3.13f, 8.58f, 13.34f, 22.94f, 31.98f, 22.94f)
                curveToRelative(18.55f, 0f, 28.78f, -13.47f, 31.9f, -21.44f)
                lineToRelative(0.05f, -0.11f)
                curveToRelative(29.3f, -77.01f, 63.79f, -128.81f, 91.51f, -170.42f)
                curveToRelative(32.33f, -48.56f, 57.87f, -86.9f, 57.87f, -138.7f)
                curveTo(437.33f, 157.49f, 432.51f, 134.14f, 423.05f, 111.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE6E9ED))) {
                moveTo(74.66f, 181.4f)
                curveToRelative(0.02f, 51.9f, 25.69f, 90.26f, 58.17f, 138.84f)
                curveToRelative(27.62f, 41.29f, 61.99f, 92.68f, 91.18f, 168.81f)
                curveToRelative(3.13f, 8.58f, 13.34f, 22.94f, 31.98f, 22.94f)
                curveToRelative(18.55f, 0f, 28.78f, -13.47f, 31.9f, -21.44f)
                lineToRelative(0.05f, -0.11f)
                curveToRelative(29.3f, -77.01f, 63.79f, -128.81f, 91.51f, -170.42f)
                curveToRelative(32.31f, -48.53f, 57.84f, -86.87f, 57.87f, -138.62f)
                lineTo(74.66f, 181.4f)
                lineTo(74.66f, 181.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF434A54))) {
                moveTo(74.66f, 181.32f)
                curveToRelative(0f, 3.63f, 0.14f, 7.17f, 0.38f, 10.67f)
                horizontalLineToRelative(361.89f)
                curveToRelative(0.23f, -3.5f, 0.39f, -7.05f, 0.39f, -10.67f)
                curveToRelative(0f, -3.56f, -0.13f, -7.13f, -0.34f, -10.66f)
                horizontalLineTo(74.99f)
                curveTo(74.78f, 174.2f, 74.66f, 177.76f, 74.66f, 181.32f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0D468))) {
                moveTo(319.99f, 181.32f)
                curveToRelative(0f, 35.34f, -28.66f, 64f, -64f, 64f)
                curveToRelative(-35.34f, 0f, -64f, -28.66f, -64f, -64f)
                reflectiveCurveToRelative(28.66f, -64f, 64f, -64f)
                curveTo(291.33f, 117.32f, 319.99f, 145.98f, 319.99f, 181.32f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.2f, strokeAlpha = 0.2f) {
                moveTo(255.99f, 117.32f)
                curveToRelative(-5.52f, 0f, -10.88f, 0.7f, -16f, 2.02f)
                curveToRelative(27.6f, 7.11f, 48f, 32.17f, 48f, 61.98f)
                curveToRelative(0f, 29.83f, -20.4f, 54.89f, -48f, 61.98f)
                curveToRelative(5.12f, 1.31f, 10.48f, 2.02f, 16f, 2.02f)
                curveToRelative(35.34f, 0f, 64f, -28.66f, 64f, -64f)
                reflectiveCurveTo(291.33f, 117.32f, 255.99f, 117.32f)
                close()
            }
            path(fill = SolidColor(Color(0xFF434A54))) {
                moveTo(255.99f, 255.99f)
                curveToRelative(-41.17f, 0f, -74.66f, -33.5f, -74.66f, -74.67f)
                curveToRelative(0f, -41.17f, 33.49f, -74.65f, 74.66f, -74.65f)
                curveToRelative(41.17f, 0f, 74.65f, 33.48f, 74.65f, 74.65f)
                reflectiveCurveTo(297.16f, 255.99f, 255.99f, 255.99f)
                close()
                moveTo(255.99f, 128f)
                curveToRelative(-29.41f, 0f, -53.33f, 23.92f, -53.33f, 53.33f)
                reflectiveCurveToRelative(23.93f, 53.34f, 53.33f, 53.34f)
                curveToRelative(29.4f, 0f, 53.34f, -23.94f, 53.34f, -53.34f)
                reflectiveCurveTo(285.39f, 128f, 255.99f, 128f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCCD1D9))) {
                moveTo(255.99f, 373.32f)
                curveToRelative(-5.89f, 0f, -10.66f, 4.78f, -10.66f, 10.67f)
                verticalLineTo(510.25f)
                curveToRelative(3.19f, 1.09f, 6.73f, 1.73f, 10.66f, 1.73f)
                curveToRelative(3.92f, 0f, 7.48f, -0.61f, 10.66f, -1.64f)
                verticalLineTo(383.99f)
                curveTo(266.65f, 378.1f, 261.88f, 373.32f, 255.99f, 373.32f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.2f, strokeAlpha = 0.2f) {
                moveTo(423.05f, 111.9f)
                curveToRelative(-9.16f, -21.51f, -22.2f, -40.92f, -38.79f, -57.7f)
                curveToRelative(-16.7f, -16.89f, -36.08f, -30.19f, -57.59f, -39.51f)
                curveTo(304.19f, 4.94f, 280.42f, 0f, 255.99f, 0f)
                curveToRelative(-3.57f, 0f, -7.13f, 0.13f, -10.66f, 0.33f)
                curveToRelative(20.68f, 1.23f, 40.82f, 6.03f, 60.01f, 14.36f)
                curveToRelative(21.5f, 9.33f, 40.87f, 22.63f, 57.59f, 39.51f)
                curveToRelative(16.59f, 16.78f, 29.64f, 36.19f, 38.8f, 57.7f)
                curveToRelative(9.47f, 22.23f, 14.27f, 45.59f, 14.27f, 69.42f)
                curveToRelative(0f, 51.79f, -25.53f, 90.14f, -57.87f, 138.7f)
                curveToRelative(-27.72f, 41.61f, -62.2f, 93.4f, -91.5f, 170.42f)
                lineToRelative(-0.04f, 0.11f)
                curveToRelative(-2.45f, 6.25f, -9.3f, 15.91f, -21.09f, 19.75f)
                curveToRelative(3.15f, 1.06f, 6.65f, 1.69f, 10.52f, 1.69f)
                curveToRelative(18.55f, 0f, 28.78f, -13.47f, 31.9f, -21.44f)
                lineToRelative(0.05f, -0.11f)
                curveToRelative(29.3f, -77.01f, 63.79f, -128.81f, 91.51f, -170.42f)
                curveToRelative(32.33f, -48.56f, 57.87f, -86.9f, 57.87f, -138.7f)
                curveTo(437.33f, 157.49f, 432.51f, 134.14f, 423.05f, 111.9f)
                close()
            }
        }
        .build()
        return _pokemonLocation!!
    }

private var _pokemonLocation: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonLocation, contentDescription = null)
    }
}
