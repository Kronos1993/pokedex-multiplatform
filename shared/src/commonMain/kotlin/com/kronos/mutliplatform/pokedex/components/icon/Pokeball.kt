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

val Icons.Pokeball: ImageVector
    get() {
        if (_pokeball != null) {
            return _pokeball!!
        }
        _pokeball = Builder(
            name = "Pokeball", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 511.98f, 
            viewportHeight = 511.98f
        ).apply {
            path(fill = SolidColor(Color(0xFFED5564))) {
                moveTo(491.86f, 156.35f)
                curveToRelative(-12.89f, -30.48f, -31.34f, -57.87f, -54.84f, -81.37f)
                curveToRelative(-23.52f, -23.5f, -50.9f, -41.96f, -81.37f, -54.85f)
                curveToRelative(-31.56f, -13.35f, -65.09f, -20.13f, -99.65f, -20.13f)
                curveToRelative(-34.55f, 0f, -68.08f, 6.77f, -99.64f, 20.13f)
                curveToRelative(-30.48f, 12.89f, -57.87f, 31.35f, -81.37f, 54.85f)
                curveToRelative(-23.5f, 23.51f, -41.96f, 50.89f, -54.85f, 81.37f)
                curveTo(6.77f, 187.91f, 0f, 221.44f, 0f, 255.99f)
                curveToRelative(0f, 34.56f, 6.77f, 68.09f, 20.13f, 99.65f)
                curveToRelative(12.89f, 30.47f, 31.35f, 57.86f, 54.85f, 81.36f)
                curveToRelative(23.51f, 23.52f, 50.89f, 41.97f, 81.37f, 54.86f)
                curveToRelative(31.56f, 13.34f, 65.09f, 20.13f, 99.64f, 20.13f)
                curveToRelative(34.56f, 0f, 68.09f, -6.78f, 99.65f, -20.13f)
                curveToRelative(30.47f, -12.89f, 57.86f, -31.34f, 81.37f, -54.86f)
                curveToRelative(23.5f, -23.5f, 41.95f, -50.89f, 54.84f, -81.36f)
                curveToRelative(13.34f, -31.56f, 20.13f, -65.09f, 20.13f, -99.65f)
                curveTo(511.98f, 221.44f, 505.2f, 187.91f, 491.86f, 156.35f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE6E9ED))) {
                moveTo(0.1f, 263.18f)
                curveToRelative(0.88f, 32.01f, 7.59f, 63.09f, 20.02f, 92.46f)
                curveToRelative(12.89f, 30.47f, 31.35f, 57.86f, 54.85f, 81.36f)
                curveToRelative(23.51f, 23.52f, 50.89f, 41.97f, 81.37f, 54.86f)
                curveToRelative(31.56f, 13.34f, 65.09f, 20.13f, 99.64f, 20.13f)
                curveToRelative(34.56f, 0f, 68.09f, -6.78f, 99.65f, -20.13f)
                curveToRelative(30.47f, -12.89f, 57.86f, -31.34f, 81.37f, -54.86f)
                curveToRelative(23.5f, -23.5f, 41.95f, -50.89f, 54.84f, -81.36f)
                curveToRelative(12.44f, -29.37f, 19.16f, -60.45f, 20.03f, -92.46f)
                horizontalLineTo(0.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF434A54))) {
                moveTo(510.77f, 281.21f)
                curveToRelative(0.81f, -8.34f, 1.22f, -16.75f, 1.22f, -25.22f)
                curveToRelative(0f, -9.52f, -0.52f, -18.95f, -1.53f, -28.29f)
                curveToRelative(-12.72f, 1.96f, -30.98f, 4.52f, -54f, 7.05f)
                curveToRelative(-43.69f, 4.82f, -113.9f, 10.57f, -200.46f, 10.57f)
                curveToRelative(-86.55f, 0f, -156.78f, -5.75f, -200.46f, -10.57f)
                curveToRelative(-23.02f, -2.54f, -41.28f, -5.09f, -54f, -7.05f)
                curveTo(0.52f, 237.04f, 0f, 246.48f, 0f, 255.99f)
                curveToRelative(0f, 8.47f, 0.41f, 16.88f, 1.22f, 25.22f)
                curveToRelative(41.53f, 6.25f, 133.03f, 17.44f, 254.77f, 17.44f)
                reflectiveCurveTo(469.23f, 287.46f, 510.77f, 281.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE6E9ED))) {
                moveTo(309.33f, 266.66f)
                curveToRelative(0f, 29.46f, -23.89f, 53.33f, -53.34f, 53.33f)
                curveToRelative(-29.45f, 0f, -53.33f, -23.88f, -53.33f, -53.33f)
                curveToRelative(0f, -29.45f, 23.88f, -53.33f, 53.33f, -53.33f)
                curveTo(285.44f, 213.33f, 309.33f, 237.2f, 309.33f, 266.66f)
                close()
            }
            path(fill = SolidColor(Color(0xFF434A54))) {
                moveTo(255.99f, 170.66f)
                curveToRelative(-52.94f, 0f, -96f, 43.07f, -96f, 96f)
                reflectiveCurveToRelative(43.06f, 95.99f, 96f, 95.99f)
                reflectiveCurveToRelative(96f, -43.06f, 96f, -95.99f)
                curveTo(351.99f, 213.73f, 308.93f, 170.66f, 255.99f, 170.66f)
                close()
                moveTo(255.99f, 309.33f)
                curveToRelative(-23.52f, 0f, -42.66f, -19.16f, -42.66f, -42.68f)
                curveToRelative(0f, -23.52f, 19.14f, -42.66f, 42.66f, -42.66f)
                curveToRelative(23.53f, 0f, 42.65f, 19.14f, 42.65f, 42.66f)
                curveTo(298.65f, 290.18f, 279.52f, 309.33f, 255.99f, 309.33f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.2f, strokeAlpha = 0.2f) {
                moveTo(491.86f, 156.35f)
                curveToRelative(-12.89f, -30.48f, -31.34f, -57.87f, -54.84f, -81.37f)
                curveToRelative(-23.52f, -23.5f, -50.9f, -41.96f, -81.37f, -54.85f)
                curveToRelative(-31.56f, -13.35f, -65.09f, -20.13f, -99.65f, -20.13f)
                curveToRelative(-3.57f, 0f, -7.13f, 0.08f, -10.66f, 0.22f)
                curveToRelative(30.79f, 1.25f, 60.66f, 7.93f, 88.97f, 19.91f)
                curveToRelative(30.5f, 12.89f, 57.87f, 31.35f, 81.37f, 54.85f)
                curveToRelative(23.5f, 23.51f, 41.97f, 50.89f, 54.86f, 81.37f)
                curveToRelative(13.36f, 31.56f, 20.11f, 65.09f, 20.11f, 99.65f)
                curveToRelative(0f, 34.56f, -6.75f, 68.09f, -20.11f, 99.65f)
                curveToRelative(-12.89f, 30.47f, -31.36f, 57.86f, -54.86f, 81.36f)
                curveToRelative(-23.5f, 23.52f, -50.87f, 41.97f, -81.37f, 54.86f)
                curveToRelative(-28.31f, 11.97f, -58.19f, 18.66f, -88.97f, 19.91f)
                curveToRelative(3.54f, 0.14f, 7.09f, 0.22f, 10.66f, 0.22f)
                curveToRelative(34.56f, 0f, 68.09f, -6.78f, 99.65f, -20.13f)
                curveToRelative(30.47f, -12.89f, 57.86f, -31.34f, 81.37f, -54.86f)
                curveToRelative(23.5f, -23.5f, 41.95f, -50.89f, 54.84f, -81.36f)
                curveToRelative(13.34f, -31.56f, 20.13f, -65.09f, 20.13f, -99.65f)
                curveTo(511.98f, 221.44f, 505.2f, 187.91f, 491.86f, 156.35f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.1f, strokeAlpha = 0.1f) {
                moveTo(20.13f, 355.64f)
                curveToRelative(12.89f, 30.47f, 31.35f, 57.86f, 54.85f, 81.36f)
                curveToRelative(23.51f, 23.52f, 50.89f, 41.97f, 81.37f, 54.86f)
                curveToRelative(31.56f, 13.34f, 65.09f, 20.13f, 99.64f, 20.13f)
                curveToRelative(3.57f, 0f, 7.13f, -0.08f, 10.66f, -0.22f)
                curveToRelative(-30.79f, -1.25f, -60.67f, -7.94f, -88.98f, -19.91f)
                curveToRelative(-30.48f, -12.89f, -57.86f, -31.34f, -81.36f, -54.86f)
                curveToRelative(-23.51f, -23.5f, -41.96f, -50.89f, -54.86f, -81.36f)
                curveToRelative(-13.35f, -31.56f, -20.12f, -65.09f, -20.12f, -99.65f)
                curveToRelative(0f, -34.55f, 6.76f, -68.08f, 20.12f, -99.65f)
                curveTo(54.35f, 125.86f, 72.8f, 98.48f, 96.31f, 74.98f)
                curveToRelative(23.51f, -23.51f, 50.88f, -41.97f, 81.36f, -54.86f)
                curveToRelative(28.31f, -11.98f, 58.19f, -18.66f, 88.98f, -19.91f)
                curveToRelative(-3.54f, -0.14f, -7.09f, -0.22f, -10.66f, -0.22f)
                curveToRelative(-34.55f, 0f, -68.08f, 6.77f, -99.64f, 20.13f)
                curveToRelative(-30.48f, 12.89f, -57.87f, 31.35f, -81.37f, 54.86f)
                curveToRelative(-23.5f, 23.5f, -41.96f, 50.88f, -54.85f, 81.36f)
                curveTo(6.77f, 187.91f, 0f, 221.44f, 0f, 255.99f)
                curveTo(0f, 290.55f, 6.77f, 324.08f, 20.13f, 355.64f)
                close()
            }
        }
        .build()
        return _pokeball!!
    }

private var _pokeball: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Pokeball, contentDescription = null)
    }
}
