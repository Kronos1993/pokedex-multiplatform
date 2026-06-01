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

val Icons.Shield: ImageVector
    get() {
        if (_shield != null) {
            return _shield!!
        }
        _shield = Builder(
            name = "Shield", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 128f, 
            viewportHeight = 128f
        ).apply {
            path(fill = SolidColor(Color(0xFFB0BEC5))) {
                moveTo(16.77f, 19.75f)
                curveToRelative(-1f, 0f, -1.7f, 0.8f, -1.7f, 1.8f)
                verticalLineToRelative(0.1f)
                curveToRelative(-1.5f, 25.91f, 3.03f, 59.27f, 24.01f, 83.52f)
                curveToRelative(12.1f, 14.7f, 23.91f, 18.53f, 24.51f, 18.73f)
                curveToRelative(0f, 0f, 0.28f, 0.09f, 0.54f, 0.09f)
                reflectiveCurveToRelative(0.57f, -0.1f, 0.57f, -0.1f)
                curveToRelative(0.5f, -0.2f, 12.48f, -4.02f, 24.49f, -18.72f)
                curveToRelative(19.91f, -24.21f, 24.01f, -58.82f, 24.01f, -83.52f)
                verticalLineToRelative(-0.1f)
                curveToRelative(0f, -1f, -0.8f, -1.8f, -1.7f, -1.8f)
                curveToRelative(-0.3f, 0f, -29.11f, -1f, -46.01f, -15.3f)
                curveToRelative(-0.7f, -0.6f, -1.7f, -0.6f, -2.4f, 0f)
                curveToRelative(-17.11f, 14.2f, -46.02f, 15.2f, -46.32f, 15.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF84B0C1))) {
                moveTo(111.49f, 19.75f)
                curveToRelative(-0.3f, 0f, -29.11f, -1f, -46.01f, -15.3f)
                curveToRelative(-0.4f, -0.35f, -0.83f, -0.45f, -1.24f, -0.45f)
                horizontalLineToRelative(-0.11f)
                verticalLineToRelative(120f)
                curveToRelative(0.27f, -0.01f, 0.62f, -0.11f, 0.62f, -0.12f)
                curveToRelative(0.6f, -0.25f, 12.44f, -4f, 24.44f, -18.7f)
                curveToRelative(19.91f, -24.21f, 24.01f, -58.82f, 24.01f, -83.52f)
                verticalLineToRelative(-0.1f)
                curveToRelative(0f, -1.01f, -0.8f, -1.81f, -1.71f, -1.81f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(26.33f, 28.31f)
                curveToRelative(-0.82f, 0f, -1.02f, 1.02f, -1.02f, 1.74f)
                verticalLineToRelative(0.1f)
                curveToRelative(0f, 19.72f, 3.06f, 47.4f, 19f, 66.71f)
                curveToRelative(9.6f, 11.75f, 19f, 14.81f, 19.41f, 14.91f)
                lineToRelative(0.41f, 0.1f)
                lineToRelative(0.41f, -0.1f)
                curveToRelative(0.41f, -0.1f, 9.81f, -3.17f, 19.41f, -14.91f)
                curveToRelative(15.94f, -19.31f, 19f, -46.89f, 19f, -66.71f)
                verticalLineToRelative(-0.1f)
                curveToRelative(0f, -0.82f, -0.41f, -1.43f, -1.23f, -1.43f)
                horizontalLineToRelative(0.1f)
                curveToRelative(-0.2f, 0f, -23.19f, -0.82f, -36.67f, -12.16f)
                curveToRelative(-1.19f, -0.98f, -1.94f, -0.2f, -1.94f, -0.2f)
                curveTo(49.63f, 27.6f, 26.64f, 28.31f, 26.33f, 28.31f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC9E3E6))) {
                moveTo(29.18f, 30.07f)
                curveToRelative(-0.76f, 0f, -0.94f, 0.96f, -0.94f, 1.64f)
                verticalLineToRelative(0.1f)
                curveToRelative(0f, 18.57f, 2.83f, 44.65f, 17.57f, 62.84f)
                curveToRelative(8.88f, 11.07f, 17.57f, 13.95f, 17.95f, 14.05f)
                lineToRelative(0.38f, 0.1f)
                lineToRelative(0.38f, -0.1f)
                curveToRelative(0.38f, -0.1f, 9.07f, -2.98f, 17.95f, -14.05f)
                curveToRelative(14.73f, -18.19f, 17.57f, -44.17f, 17.57f, -62.84f)
                verticalLineToRelative(-0.1f)
                curveToRelative(0f, -0.77f, -0.38f, -1.35f, -1.13f, -1.35f)
                horizontalLineTo(99f)
                curveToRelative(-0.19f, 0f, -21.44f, -0.77f, -33.91f, -11.45f)
                curveToRelative(-0.94f, -0.95f, -1.79f, -0.19f, -1.79f, -0.19f)
                curveTo(50.72f, 29.4f, 29.47f, 30.07f, 29.18f, 30.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB0BEC5))) {
                moveTo(98.89f, 30.36f)
                horizontalLineToRelative(0.09f)
                curveToRelative(-0.19f, 0f, -21.44f, -0.77f, -33.91f, -11.45f)
                curveToRelative(-0.34f, -0.34f, -0.66f, -0.46f, -0.94f, -0.47f)
                verticalLineToRelative(90.35f)
                lineToRelative(0.38f, -0.1f)
                curveToRelative(0.38f, -0.1f, 9.07f, -2.98f, 17.95f, -14.05f)
                curveToRelative(14.73f, -18.19f, 17.57f, -44.17f, 17.57f, -62.84f)
                verticalLineToRelative(-0.1f)
                curveToRelative(-0.01f, -0.76f, -0.38f, -1.34f, -1.14f, -1.34f)
                close()
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(70.63f, 14.44f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(82.21f, 19.67f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(95.01f, 23.21f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(108.15f, 25.14f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(108.57f, 36.94f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(107.02f, 50.76f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(64.08f, 118.11f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(75.4f, 112.71f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(85.74f, 102.71f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(93.81f, 91.27f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(99.67f, 79f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF37474F))) {
                moveTo(104.27f, 64.65f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(70.15f, 13.8f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(81.73f, 19.03f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(94.53f, 22.57f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(107.66f, 24.5f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(108.09f, 36.3f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(106.53f, 50.12f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(63.6f, 117.47f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(74.92f, 112.07f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(85.26f, 102.07f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(93.33f, 90.63f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(99.19f, 78.36f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFB9E4EA))) {
                moveTo(103.79f, 64.01f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(57.97f, 14.44f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(46.39f, 19.67f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(33.59f, 23.21f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(20.45f, 25.14f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(20.02f, 36.94f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(21.58f, 50.76f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(53.19f, 112.71f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(42.86f, 102.71f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(34.79f, 91.27f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(28.92f, 79f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFF2F7889))) {
                moveTo(24.33f, 64.65f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(57.54f, 13.8f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(45.95f, 19.03f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(33.16f, 22.57f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(20.02f, 24.5f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(19.59f, 36.3f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(21.15f, 50.12f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(52.76f, 112.07f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(42.42f, 102.07f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(34.36f, 90.63f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(28.49f, 78.36f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(23.89f, 64.01f)
                moveToRelative(-1.93f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.86f, 0f)
                arcToRelative(1.93f, 1.93f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.86f, 0f)
            }
        }
        .build()
        return _shield!!
    }

private var _shield: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Shield, contentDescription = null)
    }
}
