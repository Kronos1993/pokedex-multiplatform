package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Icons.NoEgg: ImageVector
    get() {
        if (_noEgg != null) {
            return _noEgg!!
        }
        _noEgg = Builder(
            name = "NoEgg", 
            defaultWidth = 135.dp, 
            defaultHeight = 135.dp, 
            viewportWidth = 135f, 
            viewportHeight = 135f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFA))) {
                moveTo(115.67f, 81.17f)
                curveToRelative(0f, 26.6f, -21.56f, 48.17f, -48.17f, 48.17f)
                curveToRelative(-26.6f, 0f, -48.17f, -21.57f, -48.17f, -48.17f)
                curveToRelative(0f, -26.6f, 21.56f, -75.5f, 48.17f, -75.5f)
                curveTo(94.1f, 5.67f, 115.67f, 54.56f, 115.67f, 81.17f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9F9E4))) {
                moveTo(67.5f, 5.67f)
                verticalLineToRelative(123.67f)
                curveToRelative(26.6f, 0f, 48.17f, -21.57f, 48.17f, -48.17f)
                curveTo(115.67f, 54.56f, 94.1f, 5.67f, 67.5f, 5.67f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(37.65f, 108.49f)
                curveToRelative(4.45f, 4.86f, 9.34f, 7.24f, 6.74f, 9.62f)
                curveToRelative(-2.6f, 2.38f, -8.32f, 0.37f, -12.76f, -4.49f)
                curveToRelative(-4.44f, -4.86f, -5.94f, -10.73f, -3.33f, -13.11f)
                curveTo(30.9f, 98.14f, 33.21f, 103.63f, 37.65f, 108.49f)
                close()
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(97.35f, 108.49f)
                curveToRelative(-4.45f, 4.86f, -9.34f, 7.24f, -6.74f, 9.62f)
                curveToRelative(2.6f, 2.38f, 8.32f, 0.37f, 12.76f, -4.49f)
                curveToRelative(4.44f, -4.86f, 5.94f, -10.73f, 3.33f, -13.11f)
                curveTo(104.1f, 98.14f, 101.79f, 103.63f, 97.35f, 108.49f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 130.83f)
                curveToRelative(-27.39f, 0f, -49.67f, -22.28f, -49.67f, -49.67f)
                curveToRelative(0f, -13.94f, 5.61f, -32.96f, 14.3f, -48.46f)
                curveTo(42.45f, 14.3f, 55.01f, 4.17f, 67.5f, 4.17f)
                curveToRelative(12.49f, 0f, 25.05f, 10.14f, 35.37f, 28.54f)
                curveToRelative(8.69f, 15.5f, 14.3f, 34.52f, 14.3f, 48.46f)
                curveTo(117.17f, 108.55f, 94.89f, 130.83f, 67.5f, 130.83f)
                close()
                moveTo(67.5f, 7.17f)
                curveToRelative(-6.58f, 0f, -19.58f, 3.51f, -32.75f, 27.01f)
                curveToRelative(-8.45f, 15.08f, -13.92f, 33.53f, -13.92f, 46.99f)
                curveToRelative(0f, 25.73f, 20.94f, 46.67f, 46.67f, 46.67f)
                curveToRelative(25.73f, 0f, 46.67f, -20.93f, 46.67f, -46.67f)
                curveToRelative(0f, -13.47f, -5.46f, -31.91f, -13.92f, -46.99f)
                curveTo(87.08f, 10.68f, 74.08f, 7.17f, 67.5f, 7.17f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(95.79f, 93.64f)
                curveToRelative(-6.27f, 13.57f, -19.07f, 21.02f, -28.59f, 16.62f)
                reflectiveCurveToRelative(-5.1f, -12.39f, 1.17f, -25.97f)
                curveToRelative(6.27f, -13.57f, 12f, -27.59f, 21.52f, -23.19f)
                curveTo(99.42f, 65.5f, 102.06f, 80.06f, 95.79f, 93.64f)
                close()
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(89.9f, 61.1f)
                curveToRelative(-9.52f, -4.4f, -15.26f, 9.62f, -21.52f, 23.19f)
                curveToRelative(-0.3f, 0.64f, -0.59f, 1.26f, -0.87f, 1.88f)
                verticalLineToRelative(24.21f)
                curveToRelative(9.49f, 4.11f, 22.09f, -3.31f, 28.29f, -16.74f)
                curveTo(102.06f, 80.06f, 99.42f, 65.5f, 89.9f, 61.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(39.8f, 42.71f)
                moveToRelative(-3.06f, 0f)
                arcToRelative(3.06f, 3.06f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6.12f, 0f)
                arcToRelative(3.06f, 3.06f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6.12f, 0f)
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(50.85f, 28.08f)
                moveToRelative(-1.2f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.39f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2.39f, 0f)
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(44.59f, 60.28f)
                moveToRelative(-1.73f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.46f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.46f, 0f)
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(71.56f, 117.38f)
                moveToRelative(-1.73f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.46f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.46f, 0f)
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(63.42f, 115.65f)
                moveToRelative(-1.73f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.46f, 0f)
                arcToRelative(1.73f, 1.73f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.46f, 0f)
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(88.05f, 34.14f)
                moveToRelative(-3.54f, 0f)
                arcToRelative(3.54f, 3.54f, 0f, isMoreThanHalf = true, isPositiveArc = true, 7.07f, 0f)
                arcToRelative(3.54f, 3.54f, 0f, isMoreThanHalf = true, isPositiveArc = true, -7.07f, 0f)
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(98.08f, 49.23f)
                moveToRelative(-3.46f, 0f)
                arcToRelative(3.46f, 3.46f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6.92f, 0f)
                arcToRelative(3.46f, 3.46f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6.92f, 0f)
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(48.83f, 95.61f)
                moveToRelative(-3.46f, 0f)
                arcToRelative(3.46f, 3.46f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6.92f, 0f)
                arcToRelative(3.46f, 3.46f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6.92f, 0f)
            }
            path(fill = SolidColor(Color(0xFF7BC67B))) {
                moveTo(71.23f, 44.86f)
                curveToRelative(0f, 8.11f, 3.5f, 14.68f, -4.61f, 14.68f)
                reflectiveCurveToRelative(-14.68f, -6.57f, -14.68f, -14.68f)
                reflectiveCurveToRelative(6.57f, -14.69f, 14.68f, -14.69f)
                reflectiveCurveTo(71.23f, 36.75f, 71.23f, 44.86f)
                close()
            }
            path(fill = SolidColor(Color(0xFF54AF79))) {
                moveTo(67.5f, 59.51f)
                curveToRelative(6.95f, -0.48f, 3.72f, -6.85f, 3.72f, -14.65f)
                reflectiveCurveToRelative(3.23f, -14.17f, -3.72f, -14.65f)
                verticalLineTo(59.51f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.9f, stroke = SolidColor(Color(0xFFE53935)), strokeAlpha = 0.9f, strokeLineWidth = 10f, strokeLineCap = Round) {
                moveTo(12f, 12f)
                lineTo(123f, 123f)
            }
        }
        .build()
        return _noEgg!!
    }

private var _noEgg: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.NoEgg, contentDescription = null)
    }
}
