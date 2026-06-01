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

val Icons.Sword: ImageVector
    get() {
        if (_sword != null) {
            return _sword!!
        }
        _sword = Builder(
            name = "Sword", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 511.69f, 
            viewportHeight = 511.69f
        ).apply {
            path(fill = SolidColor(Color(0xFFAFB5CB))) {
                moveTo(205.91f, 255.85f)
                lineToRelative(-53.35f, 53.35f)
                curveToRelative(2.79f, 11.94f, 8.72f, 23.04f, 17.74f, 32.19f)
                curveToRelative(9.18f, 8.98f, 19.99f, 15.06f, 31.74f, 18.19f)
                lineToRelative(53.8f, -53.79f)
                lineTo(205.91f, 255.85f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAFB5CB))) {
                moveTo(430.39f, 31.37f)
                lineToRelative(-174.55f, 174.55f)
                lineToRelative(49.94f, 49.94f)
                lineToRelative(174.55f, -174.55f)
                lineToRelative(31.36f, -81.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBD8366))) {
                moveTo(57.46f, 479.21f)
                lineToRelative(-24.96f, -24.96f)
                lineToRelative(109.2f, -109.21f)
                lineToRelative(24.96f, 24.97f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD69C77))) {
                moveTo(36.5f, 508.18f)
                lineToRelative(-32.98f, -32.98f)
                curveToRelative(-4.69f, -4.69f, -4.69f, -12.28f, 0f, -16.96f)
                lineToRelative(8.02f, -8.02f)
                curveToRelative(4.68f, -4.68f, 12.27f, -4.68f, 16.95f, 0f)
                lineToRelative(32.98f, 32.99f)
                curveToRelative(4.69f, 4.68f, 4.69f, 12.27f, 0f, 16.95f)
                lineToRelative(-8.02f, 8.02f)
                curveTo(48.77f, 512.86f, 41.17f, 512.86f, 36.5f, 508.18f)
            }
            path(fill = SolidColor(Color(0xFFD69C77))) {
                moveTo(145.66f, 366.67f)
                curveToRelative(-0.16f, -0.16f, -0.33f, -0.33f, -0.49f, -0.49f)
                curveToRelative(-14.56f, -14.75f, -24.28f, -33.47f, -28.05f, -53.37f)
                curveToRelative(-2.14f, -11.26f, 6.42f, -21.67f, 17.87f, -21.3f)
                curveToRelative(8.2f, 0.26f, 15.25f, 6.14f, 16.67f, 14.21f)
                curveToRelative(2.35f, 13.29f, 8.74f, 25.63f, 18.64f, 35.66f)
                curveToRelative(10.54f, 10.31f, 23.17f, 17.06f, 36.99f, 19.59f)
                curveToRelative(8.08f, 1.47f, 13.84f, 8.68f, 13.99f, 16.89f)
                verticalLineToRelative(0.04f)
                curveToRelative(0.21f, 10.93f, -9.53f, 19.76f, -20.3f, 17.78f)
                curveTo(180.22f, 391.87f, 160.79f, 381.8f, 145.66f, 366.67f)
            }
            path(fill = SolidColor(Color(0xFFC7CFE3))) {
                moveTo(282.17f, 238.35f)
                curveToRelative(-2.26f, 0f, -4.52f, -0.87f, -6.24f, -2.59f)
                curveToRelative(-3.45f, -3.45f, -3.45f, -9.03f, 0f, -12.48f)
                lineTo(435.07f, 64.14f)
                curveToRelative(3.44f, -3.44f, 9.03f, -3.44f, 12.48f, 0f)
                curveToRelative(3.44f, 3.45f, 3.44f, 9.04f, 0f, 12.48f)
                lineTo(288.41f, 235.76f)
                curveTo(286.69f, 237.48f, 284.43f, 238.35f, 282.17f, 238.35f)
            }
            path(fill = SolidColor(Color(0xFFBD8366))) {
                moveTo(454.23f, 479.21f)
                lineToRelative(24.96f, -24.96f)
                lineToRelative(-109.36f, -109.36f)
                lineToRelative(-24.96f, 24.96f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD69C77))) {
                moveTo(475.19f, 508.18f)
                lineToRelative(32.98f, -32.98f)
                curveToRelative(4.69f, -4.69f, 4.69f, -12.28f, 0f, -16.96f)
                lineToRelative(-8.02f, -8.02f)
                curveToRelative(-4.68f, -4.68f, -12.27f, -4.68f, -16.95f, 0f)
                lineToRelative(-32.98f, 32.99f)
                curveToRelative(-4.69f, 4.68f, -4.69f, 12.27f, 0f, 16.95f)
                lineToRelative(8.02f, 8.02f)
                curveTo(462.92f, 512.86f, 470.52f, 512.86f, 475.19f, 508.18f)
            }
            path(fill = SolidColor(Color(0xFFD69C77))) {
                moveTo(366.02f, 366.67f)
                curveToRelative(0.16f, -0.16f, 0.33f, -0.33f, 0.49f, -0.49f)
                curveToRelative(14.56f, -14.75f, 24.28f, -33.47f, 28.05f, -53.37f)
                curveToRelative(2.14f, -11.26f, -6.42f, -21.67f, -17.87f, -21.3f)
                curveToRelative(-8.2f, 0.26f, -15.25f, 6.14f, -16.67f, 14.21f)
                curveToRelative(-2.35f, 13.29f, -8.74f, 25.63f, -18.64f, 35.66f)
                curveToRelative(-10.54f, 10.31f, -23.17f, 17.06f, -36.99f, 19.59f)
                curveToRelative(-8.08f, 1.47f, -13.84f, 8.68f, -13.99f, 16.89f)
                verticalLineToRelative(0.04f)
                curveToRelative(-0.21f, 10.93f, 9.53f, 19.76f, 20.3f, 17.78f)
                curveTo(331.46f, 391.87f, 350.9f, 381.8f, 366.02f, 366.67f)
            }
            path(fill = SolidColor(Color(0xFFC7CFE3))) {
                moveTo(341.38f, 341.38f)
                curveToRelative(-9.18f, 8.98f, -19.99f, 15.06f, -31.74f, 18.2f)
                lineTo(31.36f, 81.31f)
                lineTo(0f, 0f)
                lineToRelative(81.3f, 31.36f)
                lineToRelative(277.82f, 277.83f)
                curveTo(356.34f, 321.13f, 350.4f, 332.24f, 341.38f, 341.38f)
            }
            path(fill = SolidColor(Color(0xFFAFB5CB))) {
                moveTo(308.96f, 317.8f)
                curveToRelative(-2.26f, 0f, -4.52f, -0.87f, -6.24f, -2.59f)
                lineTo(64.14f, 76.62f)
                curveToRelative(-3.45f, -3.44f, -3.45f, -9.03f, 0f, -12.48f)
                curveToRelative(3.44f, -3.44f, 9.03f, -3.44f, 12.48f, 0f)
                lineToRelative(238.58f, 238.59f)
                curveToRelative(3.45f, 3.45f, 3.45f, 9.03f, 0f, 12.48f)
                curveTo(313.48f, 316.93f, 311.22f, 317.8f, 308.96f, 317.8f)
            }
        }
        .build()
        return _sword!!
    }

private var _sword: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Sword, contentDescription = null)
    }
}
