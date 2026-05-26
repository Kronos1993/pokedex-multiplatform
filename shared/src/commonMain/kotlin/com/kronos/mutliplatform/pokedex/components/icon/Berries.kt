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

val Icons.Berries: ImageVector
    get() {
        if (_berries != null) {
            return _berries!!
        }
        _berries = Builder(
            name = "Berries", 
            defaultWidth = 135.dp, 
            defaultHeight = 135.dp, 
            viewportWidth = 135f, 
            viewportHeight = 135f
        ).apply {
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(67.5f, 113.58f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(67.5f, 97.2f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(82.26f, 103.04f, 75.57f, 97.2f, 67.5f, 97.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(67.5f, 97.2f)
                curveToRelative(9.05f, 0f, 16.38f, 7.34f, 16.38f, 16.39f)
                curveToRelative(0f, 9.05f, -7.33f, 16.38f, -16.38f, 16.38f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(83.81f, 112.11f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.38f, -7.34f, 16.38f, -16.38f)
                curveTo(83.88f, 113.09f, 83.85f, 112.6f, 83.81f, 112.11f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 131.47f)
                curveToRelative(-9.86f, 0f, -17.89f, -8.02f, -17.89f, -17.88f)
                curveToRelative(0f, -9.86f, 8.02f, -17.89f, 17.89f, -17.89f)
                curveToRelative(9.86f, 0f, 17.88f, 8.02f, 17.88f, 17.89f)
                curveTo(85.38f, 123.44f, 77.36f, 131.47f, 67.5f, 131.47f)
                close()
                moveTo(67.5f, 98.7f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.89f)
                curveToRelative(0f, 8.21f, 6.68f, 14.88f, 14.89f, 14.88f)
                curveToRelative(8.21f, 0f, 14.88f, -6.68f, 14.88f, -14.88f)
                curveTo(82.38f, 105.38f, 75.71f, 98.7f, 67.5f, 98.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(51.12f, 115.08f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.89f, 17.89f, -17.89f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.89f)
                curveTo(52.62f, 114.41f, 51.94f, 115.08f, 51.12f, 115.08f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(55.84f, 115.19f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.16f, 13.16f, -13.16f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.16f)
                curveTo(57.34f, 114.52f, 56.67f, 115.19f, 55.84f, 115.19f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(57.29f, 119.21f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.28f, -0.44f, -0.66f, -0.44f, -1.06f)
                curveToRelative(0f, -0.39f, 0.16f, -0.78f, 0.44f, -1.06f)
                curveToRelative(0.56f, -0.56f, 1.56f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.67f, 0.44f, 1.06f)
                curveToRelative(0f, 0.39f, -0.16f, 0.78f, -0.44f, 1.06f)
                curveTo(58.07f, 119.05f, 57.68f, 119.21f, 57.29f, 119.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(51.12f, 89.21f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(51.12f, 72.83f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                curveToRelative(8.07f, 0f, 14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(65.88f, 78.67f, 59.19f, 72.83f, 51.12f, 72.83f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(51.12f, 72.83f)
                curveToRelative(9.05f, 0f, 16.39f, 7.34f, 16.39f, 16.38f)
                curveToRelative(0f, 9.05f, -7.34f, 16.39f, -16.39f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(67.43f, 87.74f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.39f, -7.34f, 16.39f, -16.39f)
                curveTo(67.5f, 88.71f, 67.47f, 88.22f, 67.43f, 87.74f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(51.12f, 107.09f)
                curveToRelative(-9.86f, 0f, -17.88f, -8.02f, -17.88f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(9.86f, 0f, 17.89f, 8.02f, 17.89f, 17.88f)
                curveTo(69f, 99.07f, 60.98f, 107.09f, 51.12f, 107.09f)
                close()
                moveTo(51.12f, 74.33f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.88f, 14.89f)
                curveToRelative(8.21f, 0f, 14.89f, -6.68f, 14.89f, -14.89f)
                curveTo(66f, 81f, 59.32f, 74.33f, 51.12f, 74.33f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(34.73f, 90.71f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveTo(36.23f, 90.04f, 35.56f, 90.71f, 34.73f, 90.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(39.45f, 90.82f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.16f, 13.16f, -13.16f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.16f)
                curveTo(40.95f, 90.14f, 40.28f, 90.82f, 39.45f, 90.82f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(40.9f, 94.84f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.05f, -0.44f)
                curveToRelative(-0.28f, -0.28f, -0.45f, -0.67f, -0.45f, -1.06f)
                reflectiveCurveToRelative(0.17f, -0.78f, 0.45f, -1.06f)
                curveToRelative(0.55f, -0.56f, 1.56f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.43f, 0.67f, 0.43f, 1.06f)
                reflectiveCurveToRelative(-0.15f, 0.78f, -0.43f, 1.06f)
                curveTo(41.69f, 94.68f, 41.3f, 94.84f, 40.9f, 94.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(83.89f, 89.21f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(83.88f, 72.83f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(98.65f, 78.67f, 91.95f, 72.83f, 83.88f, 72.83f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(83.88f, 72.83f)
                curveToRelative(9.05f, 0f, 16.39f, 7.34f, 16.39f, 16.38f)
                curveToRelative(0f, 9.05f, -7.34f, 16.39f, -16.39f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(100.19f, 87.74f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.39f, -7.34f, 16.39f, -16.39f)
                curveTo(100.27f, 88.71f, 100.24f, 88.22f, 100.19f, 87.74f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(83.88f, 107.09f)
                curveToRelative(-9.86f, 0f, -17.88f, -8.02f, -17.88f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(9.86f, 0f, 17.89f, 8.02f, 17.89f, 17.88f)
                curveTo(101.77f, 99.07f, 93.75f, 107.09f, 83.88f, 107.09f)
                close()
                moveTo(83.88f, 74.33f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.88f, 14.89f)
                curveToRelative(8.21f, 0f, 14.89f, -6.68f, 14.89f, -14.89f)
                curveTo(98.77f, 81f, 92.09f, 74.33f, 83.88f, 74.33f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 90.71f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveTo(69f, 90.04f, 68.33f, 90.71f, 67.5f, 90.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(72.22f, 90.82f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.16f, 13.16f, -13.16f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.16f)
                curveTo(73.72f, 90.14f, 73.05f, 90.82f, 72.22f, 90.82f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(73.67f, 94.84f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.28f, -0.44f, -0.67f, -0.44f, -1.06f)
                reflectiveCurveToRelative(0.16f, -0.78f, 0.44f, -1.06f)
                curveToRelative(0.56f, -0.56f, 1.57f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.67f, 0.44f, 1.06f)
                reflectiveCurveToRelative(-0.16f, 0.78f, -0.44f, 1.06f)
                curveTo(74.45f, 94.68f, 74.07f, 94.84f, 73.67f, 94.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(51.12f, 51.57f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(51.12f, 35.18f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                curveToRelative(8.07f, 0f, 14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(65.88f, 41.02f, 59.19f, 35.18f, 51.12f, 35.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(51.12f, 35.18f)
                curveToRelative(9.05f, 0f, 16.39f, 7.34f, 16.39f, 16.38f)
                curveToRelative(0f, 9.05f, -7.34f, 16.39f, -16.39f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(67.43f, 50.1f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.39f, -7.34f, 16.39f, -16.39f)
                curveTo(67.5f, 51.07f, 67.47f, 50.58f, 67.43f, 50.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(51.12f, 69.45f)
                curveToRelative(-9.86f, 0f, -17.88f, -8.02f, -17.88f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(9.86f, 0f, 17.89f, 8.02f, 17.89f, 17.88f)
                curveTo(69f, 61.43f, 60.98f, 69.45f, 51.12f, 69.45f)
                close()
                moveTo(51.12f, 36.68f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.88f, 14.89f)
                curveToRelative(8.21f, 0f, 14.89f, -6.68f, 14.89f, -14.89f)
                curveTo(66f, 43.36f, 59.32f, 36.68f, 51.12f, 36.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(34.73f, 53.07f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveTo(36.23f, 52.4f, 35.56f, 53.07f, 34.73f, 53.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(39.45f, 53.17f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.16f, 13.16f, -13.16f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.16f)
                curveTo(40.95f, 52.5f, 40.28f, 53.17f, 39.45f, 53.17f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(40.91f, 57.2f)
                curveToRelative(-0.4f, 0f, -0.79f, -0.16f, -1.07f, -0.44f)
                curveToRelative(-0.27f, -0.28f, -0.43f, -0.67f, -0.43f, -1.06f)
                curveToRelative(0f, -0.4f, 0.15f, -0.78f, 0.43f, -1.06f)
                curveToRelative(0.57f, -0.56f, 1.57f, -0.56f, 2.13f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.66f, 0.44f, 1.06f)
                curveToRelative(0f, 0.39f, -0.16f, 0.78f, -0.45f, 1.06f)
                curveTo(41.69f, 57.04f, 41.3f, 57.2f, 40.91f, 57.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(83.89f, 51.57f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(83.88f, 35.18f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(98.65f, 41.02f, 91.95f, 35.18f, 83.88f, 35.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(83.88f, 35.18f)
                curveToRelative(9.05f, 0f, 16.39f, 7.34f, 16.39f, 16.38f)
                curveToRelative(0f, 9.05f, -7.34f, 16.39f, -16.39f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(100.19f, 50.1f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.39f, -7.34f, 16.39f, -16.39f)
                curveTo(100.27f, 51.07f, 100.24f, 50.58f, 100.19f, 50.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(83.88f, 69.45f)
                curveToRelative(-9.86f, 0f, -17.88f, -8.02f, -17.88f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(9.86f, 0f, 17.89f, 8.02f, 17.89f, 17.88f)
                curveTo(101.77f, 61.43f, 93.75f, 69.45f, 83.88f, 69.45f)
                close()
                moveTo(83.88f, 36.68f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.88f, 14.89f)
                curveToRelative(8.21f, 0f, 14.89f, -6.68f, 14.89f, -14.89f)
                curveTo(98.77f, 43.36f, 92.09f, 36.68f, 83.88f, 36.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 53.07f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.88f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.88f, 6.68f, -14.88f, 14.88f)
                curveTo(69f, 52.4f, 68.33f, 53.07f, 67.5f, 53.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(72.22f, 53.17f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.16f, 13.16f, -13.16f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.16f)
                curveTo(73.72f, 52.5f, 73.05f, 53.17f, 72.22f, 53.17f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(73.67f, 57.2f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.28f, -0.44f, -0.67f, -0.44f, -1.06f)
                curveToRelative(0f, -0.4f, 0.16f, -0.78f, 0.44f, -1.06f)
                curveToRelative(0.56f, -0.56f, 1.57f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.66f, 0.44f, 1.06f)
                curveToRelative(0f, 0.39f, -0.16f, 0.78f, -0.44f, 1.06f)
                curveTo(74.46f, 57.04f, 74.07f, 57.2f, 73.67f, 57.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(34.73f, 66.06f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(34.73f, 49.68f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(49.49f, 55.52f, 42.8f, 49.68f, 34.73f, 49.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(34.73f, 49.68f)
                curveToRelative(9.05f, 0f, 16.38f, 7.33f, 16.38f, 16.38f)
                reflectiveCurveToRelative(-7.33f, 16.39f, -16.38f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(51.04f, 64.59f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.38f, -7.34f, 16.38f, -16.39f)
                curveTo(51.12f, 65.57f, 51.08f, 65.08f, 51.04f, 64.59f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(34.73f, 83.95f)
                curveToRelative(-9.86f, 0f, -17.89f, -8.02f, -17.89f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(9.86f, 0f, 17.88f, 8.02f, 17.88f, 17.88f)
                curveTo(52.62f, 75.93f, 44.59f, 83.95f, 34.73f, 83.95f)
                close()
                moveTo(34.73f, 51.18f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.89f, 14.89f)
                curveToRelative(8.21f, 0f, 14.88f, -6.68f, 14.88f, -14.89f)
                curveTo(49.62f, 57.86f, 42.94f, 51.18f, 34.73f, 51.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(18.35f, 67.56f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveTo(19.85f, 66.89f, 19.18f, 67.56f, 18.35f, 67.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(23.07f, 67.67f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.17f, 13.17f, -13.17f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.61f, 0f, -10.17f, 4.56f, -10.17f, 10.17f)
                curveTo(24.57f, 67f, 23.9f, 67.67f, 23.07f, 67.67f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(24.52f, 71.7f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.29f, -0.44f, -0.67f, -0.44f, -1.06f)
                curveToRelative(0f, -0.4f, 0.16f, -0.79f, 0.44f, -1.07f)
                curveToRelative(0.56f, -0.55f, 1.56f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.67f, 0.44f, 1.07f)
                curveToRelative(0f, 0.39f, -0.16f, 0.77f, -0.44f, 1.06f)
                curveTo(25.3f, 71.54f, 24.92f, 71.7f, 24.52f, 71.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(67.5f, 66.06f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(67.5f, 49.68f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(82.26f, 55.52f, 75.57f, 49.68f, 67.5f, 49.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(67.5f, 49.68f)
                curveToRelative(9.05f, 0f, 16.38f, 7.33f, 16.38f, 16.38f)
                reflectiveCurveTo(76.55f, 82.45f, 67.5f, 82.45f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(83.81f, 64.59f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.38f, -7.34f, 16.38f, -16.39f)
                curveTo(83.88f, 65.57f, 83.85f, 65.08f, 83.81f, 64.59f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 83.95f)
                curveToRelative(-9.86f, 0f, -17.89f, -8.02f, -17.89f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(9.86f, 0f, 17.88f, 8.02f, 17.88f, 17.88f)
                curveTo(85.38f, 75.93f, 77.36f, 83.95f, 67.5f, 83.95f)
                close()
                moveTo(67.5f, 51.18f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.89f, 14.89f)
                curveToRelative(8.21f, 0f, 14.88f, -6.68f, 14.88f, -14.89f)
                curveTo(82.38f, 57.86f, 75.71f, 51.18f, 67.5f, 51.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(51.12f, 67.56f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveTo(52.62f, 66.89f, 51.94f, 67.56f, 51.12f, 67.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(55.84f, 67.67f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.17f, 13.16f, -13.17f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.6f, 0f, -10.16f, 4.56f, -10.16f, 10.17f)
                curveTo(57.34f, 67f, 56.67f, 67.67f, 55.84f, 67.67f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(57.29f, 71.7f)
                curveToRelative(-0.39f, 0f, -0.78f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.28f, -0.44f, -0.67f, -0.44f, -1.06f)
                curveToRelative(0f, -0.4f, 0.16f, -0.79f, 0.44f, -1.07f)
                curveToRelative(0.56f, -0.55f, 1.56f, -0.55f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.67f, 0.44f, 1.07f)
                curveToRelative(0f, 0.39f, -0.16f, 0.77f, -0.44f, 1.06f)
                curveTo(58.07f, 71.54f, 57.68f, 71.7f, 57.29f, 71.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(100.27f, 66.06f)
                moveToRelative(-16.38f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32.77f, 0f)
                arcToRelative(16.38f, 16.38f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32.77f, 0f)
            }
            path(fill = SolidColor(Color(0xFFF93585))) {
                moveTo(100.27f, 49.68f)
                curveToRelative(-8.07f, 0f, -14.76f, 5.84f, -16.12f, 13.52f)
                curveToRelative(1.36f, 7.68f, 8.05f, 13.52f, 16.12f, 13.52f)
                reflectiveCurveToRelative(14.76f, -5.84f, 16.12f, -13.52f)
                curveTo(115.03f, 55.52f, 108.34f, 49.68f, 100.27f, 49.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE02B7E))) {
                moveTo(100.27f, 49.68f)
                curveToRelative(9.05f, 0f, 16.38f, 7.33f, 16.38f, 16.38f)
                reflectiveCurveToRelative(-7.33f, 16.39f, -16.38f, 16.39f)
            }
            path(fill = SolidColor(Color(0xFFC90D6B))) {
                moveTo(116.58f, 64.59f)
                curveToRelative(-0.05f, -0.47f, -0.11f, -0.93f, -0.19f, -1.39f)
                curveToRelative(-1.36f, 7.68f, -8.05f, 13.52f, -16.12f, 13.52f)
                verticalLineToRelative(5.73f)
                curveToRelative(9.05f, 0f, 16.38f, -7.34f, 16.38f, -16.39f)
                curveTo(116.65f, 65.57f, 116.62f, 65.08f, 116.58f, 64.59f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(100.27f, 83.95f)
                curveToRelative(-9.86f, 0f, -17.89f, -8.02f, -17.89f, -17.89f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(9.86f, 0f, 17.88f, 8.02f, 17.88f, 17.88f)
                curveTo(118.15f, 75.93f, 110.13f, 83.95f, 100.27f, 83.95f)
                close()
                moveTo(100.27f, 51.18f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveToRelative(0f, 8.21f, 6.68f, 14.89f, 14.89f, 14.89f)
                curveToRelative(8.21f, 0f, 14.88f, -6.68f, 14.88f, -14.89f)
                curveTo(115.15f, 57.86f, 108.47f, 51.18f, 100.27f, 51.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(83.88f, 67.56f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -9.86f, 8.02f, -17.88f, 17.89f, -17.88f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-8.21f, 0f, -14.89f, 6.68f, -14.89f, 14.88f)
                curveTo(85.38f, 66.89f, 84.71f, 67.56f, 83.88f, 67.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(88.6f, 67.67f)
                curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                curveToRelative(0f, -7.26f, 5.91f, -13.17f, 13.17f, -13.17f)
                curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
                curveToRelative(-5.61f, 0f, -10.17f, 4.56f, -10.17f, 10.17f)
                curveTo(90.1f, 67f, 89.43f, 67.67f, 88.6f, 67.67f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFE6EB))) {
                moveTo(90.06f, 71.7f)
                curveToRelative(-0.4f, 0f, -0.79f, -0.16f, -1.06f, -0.44f)
                curveToRelative(-0.28f, -0.29f, -0.44f, -0.67f, -0.44f, -1.06f)
                curveToRelative(0f, -0.4f, 0.16f, -0.79f, 0.44f, -1.07f)
                curveToRelative(0.55f, -0.55f, 1.55f, -0.56f, 2.12f, 0f)
                curveToRelative(0.28f, 0.28f, 0.44f, 0.67f, 0.44f, 1.07f)
                curveToRelative(0f, 0.39f, -0.16f, 0.77f, -0.44f, 1.06f)
                curveTo(90.84f, 71.54f, 90.45f, 71.7f, 90.06f, 71.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF18AA67))) {
                moveTo(79.33f, 29.9f)
                curveToRelative(0f, 10.04f, -4.61f, 12.91f, -11.83f, 18.79f)
                curveToRelative(-7.22f, -5.88f, -11.84f, -8.76f, -11.84f, -18.79f)
                curveToRelative(0f, -10.03f, 4.61f, -18.99f, 11.84f, -24.86f)
                curveTo(74.72f, 10.91f, 79.33f, 19.86f, 79.33f, 29.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFF65E529))) {
                moveTo(67.5f, 5.03f)
                lineToRelative(0f, 43.65f)
                curveToRelative(-7.22f, -5.88f, -11.84f, -8.76f, -11.84f, -18.79f)
                curveTo(55.67f, 19.86f, 60.28f, 10.91f, 67.5f, 5.03f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(67.5f, 50.19f)
                curveToRelative(-0.34f, 0f, -0.67f, -0.11f, -0.95f, -0.34f)
                curveToRelative(-0.55f, -0.45f, -1.09f, -0.88f, -1.61f, -1.3f)
                curveToRelative(-6.26f, -5.03f, -10.78f, -8.67f, -10.78f, -18.65f)
                curveToRelative(0f, -10.13f, 4.52f, -19.62f, 12.39f, -26.03f)
                curveToRelative(0.55f, -0.45f, 1.34f, -0.45f, 1.89f, 0f)
                curveToRelative(7.87f, 6.41f, 12.39f, 15.9f, 12.39f, 26.02f)
                curveToRelative(0f, 9.98f, -4.52f, 13.62f, -10.77f, 18.65f)
                curveToRelative(-0.52f, 0.42f, -1.06f, 0.85f, -1.61f, 1.3f)
                curveTo(68.18f, 50.07f, 67.84f, 50.19f, 67.5f, 50.19f)
                close()
                moveTo(67.5f, 7f)
                curveToRelative(-6.58f, 5.81f, -10.34f, 14.08f, -10.34f, 22.9f)
                curveToRelative(0f, 8.55f, 3.43f, 11.31f, 9.66f, 16.32f)
                curveToRelative(0.22f, 0.18f, 0.45f, 0.36f, 0.68f, 0.54f)
                curveToRelative(0.23f, -0.19f, 0.46f, -0.37f, 0.68f, -0.55f)
                curveToRelative(6.22f, -5.01f, 9.65f, -7.77f, 9.65f, -16.31f)
                curveTo(77.83f, 21.09f, 74.08f, 12.81f, 67.5f, 7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF18AA67))) {
                moveTo(84.72f, 45.38f)
                curveToRelative(-5.46f, 5.46f, -9.53f, 4.51f, -16.65f, 3.79f)
                curveToRelative(-0.73f, -7.13f, -1.68f, -11.2f, 3.78f, -16.66f)
                curveToRelative(5.45f, -5.46f, 12.84f, -7.82f, 19.96f, -7.08f)
                curveTo(92.53f, 32.54f, 90.18f, 39.92f, 84.72f, 45.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFF65E529))) {
                moveTo(91.81f, 25.42f)
                lineToRelative(-23.74f, 23.74f)
                curveToRelative(-0.73f, -7.13f, -1.68f, -11.2f, 3.78f, -16.66f)
                curveTo(77.3f, 27.05f, 84.68f, 24.69f, 91.81f, 25.42f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(74.88f, 51.23f)
                curveToRelative(-1.66f, 0f, -3.38f, -0.19f, -5.37f, -0.4f)
                lineToRelative(-1.59f, -0.17f)
                curveToRelative(-0.71f, -0.07f, -1.27f, -0.63f, -1.34f, -1.34f)
                lineToRelative(-0.17f, -1.58f)
                curveToRelative(-0.68f, -6.24f, -1.17f, -10.75f, 4.38f, -16.3f)
                curveToRelative(4.93f, -4.93f, 11.5f, -7.65f, 18.48f, -7.65f)
                curveToRelative(0.89f, 0f, 1.8f, 0.05f, 2.69f, 0.14f)
                curveToRelative(0.71f, 0.07f, 1.27f, 0.63f, 1.34f, 1.34f)
                curveToRelative(0.81f, 7.87f, -1.93f, 15.59f, -7.52f, 21.17f)
                curveTo(82.38f, 49.84f, 79.22f, 51.23f, 74.88f, 51.23f)
                close()
                moveTo(69.43f, 47.8f)
                lineToRelative(0.4f, 0.04f)
                curveToRelative(1.9f, 0.21f, 3.55f, 0.38f, 5.05f, 0.38f)
                curveToRelative(3.01f, 0f, 5.53f, -0.65f, 8.78f, -3.91f)
                curveToRelative(4.65f, -4.65f, 7.07f, -10.97f, 6.75f, -17.5f)
                curveToRelative(-6.59f, -0.32f, -12.87f, 2.11f, -17.5f, 6.75f)
                curveToRelative(-4.53f, 4.53f, -4.17f, 7.84f, -3.52f, 13.85f)
                lineTo(69.43f, 47.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF18AA67))) {
                moveTo(50.28f, 45.38f)
                curveToRelative(5.46f, 5.46f, 9.53f, 4.51f, 16.65f, 3.79f)
                curveToRelative(0.73f, -7.13f, 1.68f, -11.2f, -3.78f, -16.66f)
                curveToRelative(-5.46f, -5.46f, -12.84f, -7.82f, -19.96f, -7.08f)
                curveTo(42.47f, 32.54f, 44.82f, 39.92f, 50.28f, 45.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFF65E529))) {
                moveTo(43.19f, 25.42f)
                lineToRelative(23.74f, 23.74f)
                curveToRelative(0.73f, -7.13f, 1.68f, -11.2f, -3.78f, -16.66f)
                curveTo(57.7f, 27.05f, 50.32f, 24.69f, 43.19f, 25.42f)
                close()
            }
            path(fill = SolidColor(Color(0xFF33363A))) {
                moveTo(60.12f, 51.23f)
                curveTo(60.12f, 51.23f, 60.12f, 51.23f, 60.12f, 51.23f)
                curveToRelative(-4.34f, 0f, -7.5f, -1.39f, -10.9f, -4.79f)
                curveToRelative(-5.58f, -5.58f, -8.32f, -13.3f, -7.52f, -21.17f)
                curveToRelative(0.07f, -0.71f, 0.63f, -1.27f, 1.34f, -1.34f)
                curveToRelative(0.89f, -0.09f, 1.79f, -0.14f, 2.69f, -0.14f)
                curveToRelative(6.99f, 0f, 13.55f, 2.72f, 18.49f, 7.65f)
                curveToRelative(5.55f, 5.55f, 5.06f, 10.06f, 4.38f, 16.3f)
                lineToRelative(-0.17f, 1.58f)
                curveToRelative(-0.07f, 0.71f, -0.63f, 1.27f, -1.34f, 1.34f)
                lineToRelative(-1.59f, 0.17f)
                curveTo(63.51f, 51.04f, 61.79f, 51.23f, 60.12f, 51.23f)
                close()
                moveTo(44.59f, 26.82f)
                curveToRelative(-0.32f, 6.53f, 2.1f, 12.85f, 6.75f, 17.5f)
                curveToRelative(3.25f, 3.25f, 5.77f, 3.91f, 8.78f, 3.91f)
                curveToRelative(1.5f, 0f, 3.15f, -0.18f, 5.05f, -0.38f)
                lineToRelative(0.4f, -0.04f)
                lineToRelative(0.04f, -0.38f)
                curveToRelative(0.65f, -6.01f, 1.01f, -9.32f, -3.52f, -13.85f)
                curveTo(57.46f, 28.93f, 51.19f, 26.49f, 44.59f, 26.82f)
                close()
            }
        }
        .build()
        return _berries!!
    }

private var _berries: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Berries, contentDescription = null)
    }
}
