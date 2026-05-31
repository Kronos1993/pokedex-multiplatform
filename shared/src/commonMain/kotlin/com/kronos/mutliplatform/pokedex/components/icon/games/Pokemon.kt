package com.kronos.mutliplatform.pokedex.components.icon.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Games.Pokemon: ImageVector
    get() {
        if (_pokemon != null) {
            return _pokemon!!
        }
        _pokemon = Builder(
            name = "Pokemon",
            defaultWidth = 2500.dp,
            defaultHeight = 917.dp,
            viewportWidth = 269.5f,
            viewportHeight = 98.8f
        ).apply {
            path(
                fill = linearGradient(
                    0f to Color(0xFF0070B6),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(13.3f, 53.52f),
                    end = Offset(3.28f, 34.86f)
                )
            ) {
                moveTo(0f, 36.6f)
                lineToRelative(12f, 20.3f)
                lineToRelative(4.8f, -4.6f)
                lineTo(3.7f, 32.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0071B9))) {
                moveTo(178.6f, 20.6f)
                lineToRelative(-0.5f, 2.7f)
                lineToRelative(5.7f, -1.9f)
                lineToRelative(-0.7f, -3.3f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF0070B6),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(135.48f, 15.39f),
                    end = Offset(148.19f, 1.76f)
                )
            ) {
                moveTo(145f, 2.3f)
                lineToRelative(-18.5f, 21.2f)
                lineToRelative(5.4f, -1.5f)
                lineToRelative(17.6f, -22f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(244.1f, 31.3f)
                lineToRelative(4.5f, -2.4f)
                lineToRelative(-1.3f, 11.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(215.8f, 38.6f)
                lineToRelative(4.1f, 0.9f)
                lineTo(225f, 37f)
                lineToRelative(-4.5f, -1.7f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF0070B6),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(80f, 38.1f),
                    end = Offset(78.49f, 25.36f)
                )
            ) {
                moveTo(76.6f, 26.6f)
                lineToRelative(0.6f, 13.1f)
                lineToRelative(5.7f, -2.2f)
                lineToRelative(-1.7f, -13.4f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF125D9E),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(218.9f, 35.65f),
                    end = Offset(218.29f, 24.15f)
                )
            ) {
                moveTo(220.2f, 22.6f)
                lineToRelative(-4.5f, 2.5f)
                lineToRelative(0.1f, 13.5f)
                lineToRelative(4.6f, -2.3f)
                lineToRelative(1.4f, -6.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF312370))) {
                moveTo(219.6f, 39.5f)
                lineToRelative(-5f, 44.4f)
                lineToRelative(8f, -1.6f)
                lineToRelative(1.5f, -45.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF21386E))) {
                moveTo(229.3f, 86f)
                lineToRelative(0.2f, 6f)
                lineToRelative(15.3f, 4.9f)
                lineToRelative(4.6f, -2.4f)
                lineToRelative(-15.1f, -11.7f)
                lineToRelative(-15.2f, -1.3f)
                lineToRelative(-4.5f, 2.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF21386E))) {
                moveTo(172.5f, 75.4f)
                lineToRelative(3.7f, -2f)
                lineToRelative(2.5f, 4.4f)
                lineToRelative(3.5f, -1.9f)
                lineToRelative(0.7f, 5.8f)
                lineToRelative(22.3f, 4f)
                lineToRelative(4.4f, -2.5f)
                lineToRelative(-30.7f, -18.7f)
                lineToRelative(-21.8f, 3.7f)
                lineToRelative(-4.2f, 4.1f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF125D9E),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(176.46f, 19.08f),
                    end = Offset(163.12f, 40.3f)
                )
            ) {
                moveTo(165.4f, 20.8f)
                lineToRelative(-4.5f, 2.5f)
                lineToRelative(-8f, 49f)
                lineToRelative(4.5f, -2.4f)
                lineToRelative(7.7f, -27.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(129.8f, 27.4f)
                lineToRelative(-3.6f, 1.9f)
                lineToRelative(0.3f, 1.2f)
                lineToRelative(8.5f, -5.4f)
                lineToRelative(-3.7f, -4f)
                lineToRelative(-4.8f, 2.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF21386E))) {
                moveTo(139.5f, 85.3f)
                lineToRelative(-36.3f, -18f)
                lineToRelative(4.5f, -3.5f)
                lineToRelative(36.3f, 19f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(106.6f, 18.3f)
                lineToRelative(-5.5f, 10.4f)
                lineToRelative(5.8f, -1.7f)
                lineToRelative(4.2f, -11.2f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF105FA1),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(58.37f, 53.12f),
                    end = Offset(67.47f, 71.02f)
                )
            ) {
                moveTo(56.6f, 61.4f)
                lineTo(52f, 64.6f)
                reflectiveCurveToRelative(1f, 5.2f, 2.3f, 8.8f)
                curveToRelative(1.3f, 3.6f, 4.3f, 6.5f, 4.3f, 6.5f)
                curveToRelative(2f, 1.9f, 4.3f, 3.3f, 7f, 4.1f)
                curveToRelative(5.1f, 1.5f, 10.9f, 0.5f, 15.9f, -2.7f)
                curveToRelative(1.3f, -0.8f, 3.1f, -2.1f, 4.2f, -3.2f)
                curveToRelative(-4.9f, 3f, -29.1f, -16.7f, -29.1f, -16.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(81.5f, 38.7f)
                lineToRelative(4.2f, 46.7f)
                lineToRelative(17.4f, -2.5f)
                lineToRelative(4.6f, -2.4f)
                lineToRelative(-21.5f, -44.6f)
                lineToRelative(-4.4f, 1.5f)
                lineToRelative(-4.6f, 2.3f)
                close()
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF105FA1),
                    1f to Color(0xFF1D2C5E),
                    start = Offset(24.04f, 47.02f),
                    end = Offset(34.57f, 71.43f)
                )
            ) {
                moveTo(16.5f, 54.9f)
                lineToRelative(19.4f, 43.9f)
                lineToRelative(18.4f, -5.9f)
                lineToRelative(4.5f, -3f)
                lineToRelative(-38.2f, -40f)
                lineToRelative(-4.8f, 2.9f)
                lineToRelative(-3.8f, 4.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(208.4f, 75.6f)
                lineToRelative(0.3f, 2.2f)
                curveToRelative(1.6f, -0.2f, 3.2f, -0.4f, 4.7f, -0.9f)
                curveToRelative(1.7f, -0.6f, 5.3f, -2.2f, 6.6f, -3.4f)
                curveToRelative(-0.6f, 0.2f, -9f, 2.4f, -11.6f, 2.1f)
            }
            path(fill = SolidColor(Color(0xFF1D2C5E))) {
                moveTo(143.3f, 64.4f)
                lineToRelative(0.7f, 3.5f)
                curveToRelative(3.7f, -0.6f, 6.9f, -1.9f, 10.1f, -3.8f)
                curveToRelative(2f, -1.2f, 4.1f, -2.9f, 4.8f, -3.4f)
                curveToRelative(-0.5f, 0.3f, -15.6f, 3.7f, -15.6f, 3.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFCB05))) {
                moveTo(40.95f, 94.61f)
                lineTo(39.55f, 91.41f)
                lineToRelative(-18.4f, -41f)
                lineToRelative(-0.4f, -0.8f)
                lineToRelative(-0.8f, 0.4f)
                lineToRelative(-0.6f, 0.3f)
                lineToRelative(-3.3f, 1.6f)
                curveToRelative(-0.5f, -0.8f, -1.3f, -2.2f, -1.8f, -3.1f)
                lineTo(6.85f, 36.31f)
                lineToRelative(-1.9f, -3.3f)
                lineToRelative(3.2f, -2f)
                curveToRelative(3f, -1.9f, 6.4f, -3.7f, 10.2f, -5.3f)
                curveToRelative(7.4f, -3.1f, 14.9f, -4.8f, 21.8f, -4.8f)
                curveToRelative(2.3f, 0f, 4.5f, 0.2f, 6.5f, 0.5f)
                curveToRelative(3.4f, 0.4f, 6.6f, 1.5f, 9.2f, 3.3f)
                curveToRelative(3.9f, 2.2f, 7f, 5.6f, 8.7f, 9.6f)
                curveToRelative(1.4f, 3.3f, 1.7f, 7.2f, 0.8f, 11.2f)
                lineToRelative(-0.5f, 2.4f)
                lineToRelative(2f, -1.4f)
                curveToRelative(1.3f, -1f, 2.7f, -1.8f, 4.2f, -2.4f)
                curveToRelative(2.6f, -1.1f, 5.3f, -1.7f, 8f, -1.7f)
                curveToRelative(2.6f, 0f, 5f, 0.5f, 7.2f, 1.5f)
                lineToRelative(1.4f, 0.6f)
                lineToRelative(-0.1f, -1.6f)
                lineToRelative(-0.6f, -6.7f)
                lineToRelative(-0.1f, -1.1f)
                lineToRelative(-1f, 0.3f)
                lineToRelative(-3.1f, 0.8f)
                lineToRelative(-0.5f, -11.4f)
                lineToRelative(22.8f, -7.3f)
                lineToRelative(-0.2f, 8.9f)
                lineToRelative(1.7f, 0.4f)
                lineToRelative(5f, -9.5f)
                lineToRelative(14.9f, 13.2f)
                lineToRelative(0.6f, 0.6f)
                lineToRelative(0.6f, -0.6f)
                curveToRelative(2f, -1.9f, 4.5f, -3.5f, 7.2f, -4.6f)
                lineToRelative(1.1f, -0.5f)
                lineToRelative(-0.8f, -1f)
                lineToRelative(-2.7f, -3.3f)
                lineTo(149.55f, 1.41f)
                lineToRelative(9f, 13.4f)
                lineToRelative(-13.7f, 7.4f)
                lineToRelative(-3f, 1.6f)
                lineToRelative(3.5f, 0.1f)
                curveToRelative(6.5f, 0.1f, 12.3f, 2.9f, 16.2f, 7.7f)
                lineToRelative(1.4f, 1.8f)
                lineToRelative(0.9f, 1.1f)
                lineToRelative(-1.5f, 1.6f)
                lineToRelative(-1f, 1.1f)
                lineToRelative(-3.4f, 3.7f)
                lineToRelative(-0.6f, 0.7f)
                lineToRelative(0.7f, 0.6f)
                lineToRelative(3.2f, 2.9f)
                lineToRelative(1.2f, 1.1f)
                lineToRelative(0.3f, -1.6f)
                lineToRelative(1.2f, -7.6f)
                lineToRelative(0.3f, -2f)
                lineToRelative(0.3f, -2f)
                lineToRelative(1.8f, -11.3f)
                horizontalLineToRelative(17f)
                lineToRelative(0.1f, -0.8f)
                lineToRelative(0.3f, -1.9f)
                lineTo(198.55f, 19.01f)
                lineToRelative(3.6f, 22.6f)
                lineToRelative(0.2f, 1.5f)
                lineToRelative(1.2f, -0.9f)
                curveToRelative(1.5f, -1.1f, 3.1f, -1.9f, 4.8f, -2.6f)
                curveToRelative(2.3f, -0.9f, 4.6f, -1.3f, 7f, -1.3f)
                curveToRelative(2.8f, 0f, 5.5f, 0.6f, 7.8f, 1.9f)
                curveToRelative(0.1f, 0f, 0.1f, 0.1f, 0.3f, 0.2f)
                lineToRelative(1.1f, 0.4f)
                lineToRelative(0.1f, -1.2f)
                lineToRelative(0.3f, -2.5f)
                lineToRelative(0.1f, -0.8f)
                lineToRelative(-0.8f, -0.2f)
                lineToRelative(-3f, -0.7f)
                lineToRelative(-0.1f, -11.8f)
                lineToRelative(22.9f, 5f)
                lineToRelative(1.7f, 8.5f)
                horizontalLineToRelative(1.8f)
                lineToRelative(1.8f, -7.3f)
                lineToRelative(19.1f, 4.6f)
                lineTo(248.85f, 93.31f)
                lineToRelative(-13.9f, -4.4f)
                lineToRelative(-0.1f, -5.4f)
                verticalLineToRelative(-0.8f)
                lineToRelative(-0.8f, -0.1f)
                lineToRelative(-13.9f, -2f)
                lineToRelative(0.8f, -7.1f)
                lineToRelative(0.2f, -1.7f)
                lineToRelative(-1.5f, 0.8f)
                curveToRelative(-0.7f, 0.4f, -1.4f, 0.7f, -2.1f, 0.9f)
                curveToRelative(-2.3f, 0.9f, -4.6f, 1.3f, -6.9f, 1.3f)
                curveToRelative(-0.7f, 0f, -1.3f, 0f, -2f, -0.1f)
                lineToRelative(-1.2f, -0.1f)
                lineToRelative(0.2f, 1.2f)
                lineToRelative(1f, 6.2f)
                lineToRelative(-20.3f, -3.6f)
                lineToRelative(-1.1f, -9.2f)
                lineToRelative(-0.3f, -3f)
                lineToRelative(-1.4f, 2.6f)
                lineToRelative(-2.3f, 4.5f)
                lineToRelative(-4.3f, -7.9f)
                lineToRelative(-1.3f, -2.4f)
                lineToRelative(-0.4f, 2.7f)
                lineToRelative(-0.9f, 6.1f)
                lineToRelative(-17.8f, -2.8f)
                lineToRelative(1.4f, -8.4f)
                lineToRelative(0.3f, -1.9f)
                lineToRelative(-1.7f, 1f)
                curveToRelative(-2.9f, 1.7f, -6.3f, 3.1f, -10.2f, 4f)
                curveToRelative(-1.4f, 0.3f, -2.8f, 0.6f, -4.3f, 0.7f)
                lineToRelative(-0.8f, 0.1f)
                lineTo(143.25f, 81.31f)
                lineToRelative(-35f, -17.3f)
                lineToRelative(-1.3f, -0.6f)
                verticalLineToRelative(16.3f)
                lineToRelative(-15.7f, 2.3f)
                lineToRelative(-0.7f, -7.1f)
                lineToRelative(-0.2f, -1.9f)
                lineToRelative(-1.4f, 1.3f)
                curveToRelative(-2.1f, 2f, -4.4f, 3.6f, -6.9f, 4.7f)
                curveToRelative(-2.6f, 1.1f, -5.3f, 1.7f, -7.9f, 1.7f)
                curveToRelative(-2.7f, 0f, -5.2f, -0.6f, -7.5f, -1.6f)
                curveToRelative(-4.2f, -2f, -7.3f, -5.7f, -8.6f, -10.4f)
                curveToRelative(-0.6f, -2.2f, -0.8f, -4.5f, -0.5f, -6.9f)
                lineToRelative(0.3f, -2.5f)
                lineToRelative(-1.8f, 1.8f)
                curveToRelative(-1.3f, 1.2f, -2.7f, 2.4f, -4.2f, 3.5f)
                lineToRelative(-0.5f, 0.4f)
                lineToRelative(0.2f, 0.6f)
                lineToRelative(5.3f, 20.2f)
                lineToRelative(0.9f, 3.6f)
                lineToRelative(-3.5f, 1.1f)
                lineToRelative(-9.9f, 3.2f)
                lineToRelative(-3.4f, 0.9f)
                close()
                moveTo(45.35f, 40.31f)
                curveToRelative(-0.5f, 0f, -1f, 0f, -1.6f, 0.1f)
                lineToRelative(-0.7f, 0.1f)
                lineToRelative(-1f, 0.2f)
                lineToRelative(0.3f, 1f)
                lineToRelative(0.2f, 0.6f)
                lineToRelative(2.8f, 9.3f)
                lineToRelative(0.3f, 0.9f)
                lineToRelative(0.4f, 1.3f)
                lineToRelative(1f, -0.9f)
                lineToRelative(0.7f, -0.6f)
                curveToRelative(2.8f, -2.5f, 3.7f, -5f, 3.1f, -8.2f)
                curveToRelative(-0.4f, -1.9f, -1.8f, -2.8f, -2.7f, -3.2f)
                curveToRelative(-0.6f, -0.4f, -1.7f, -0.6f, -2.8f, -0.6f)
                close()
                moveTo(121.55f, 40.61f)
                lineToRelative(-1.8f, 1.7f)
                lineToRelative(-4.7f, 4.5f)
                lineToRelative(-1f, 1f)
                lineToRelative(1.3f, 0.5f)
                lineToRelative(5f, 1.9f)
                lineToRelative(1.5f, 0.6f)
                lineToRelative(-0.3f, -1.6f)
                curveToRelative(-0.4f, -2.1f, -0.5f, -4.2f, -0.3f, -6.2f)
                lineToRelative(0.3f, -2.4f)
                close()
                moveTo(141.95f, 35.41f)
                curveToRelative(-1.9f, 0f, -3.8f, 0.8f, -5.1f, 2.3f)
                curveToRelative(-2f, 2.2f, -2.4f, 5.5f, -1f, 8.1f)
                lineToRelative(0.4f, 0.7f)
                lineToRelative(0.6f, 1.1f)
                lineToRelative(0.9f, -1f)
                lineToRelative(0.6f, -0.6f)
                lineToRelative(6.9f, -7.8f)
                lineToRelative(0.5f, -0.6f)
                lineToRelative(0.9f, -1f)
                lineToRelative(-1.2f, -0.5f)
                lineToRelative(-0.8f, -0.3f)
                curveToRelative(-1f, -0.2f, -1.8f, -0.4f, -2.7f, -0.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(152.4f, 47f)
                lineToRelative(-0.2f, 0.2f)
                curveToRelative(0.1f, 0f, 0.2f, -0.1f, 0.2f, -0.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(158.4f, 41.6f)
                lineToRelative(3.4f, -3.7f)
                lineToRelative(-1.2f, 1.2f)
                verticalLineTo(39f)
                lineToRelative(-1f, 1.1f)
                lineToRelative(-3.4f, 3.6f)
                lineToRelative(3.2f, 2.9f)
                lineToRelative(0.6f, -3.6f)
                lineToRelative(1.6f, 1.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(158.4f, 41.6f)
                lineToRelative(3.2f, 2.8f)
                lineToRelative(1.2f, -7.6f)
                lineToRelative(-1f, 1.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(115.7f, 47.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(134.7f, 50.7f)
                curveToRelative(0.3f, 0.3f, 0f, 0.1f, 0.3f, 0.3f)
                lineToRelative(2.1f, -1.5f)
                curveToRelative(-0.3f, -0.2f, -0.6f, -0.5f, -0.9f, -0.7f)
                curveToRelative(-3f, -2.8f, -2.2f, -9f, -0.3f, -12.4f)
                curveToRelative(-5.2f, 4.2f, -4.9f, 10.6f, -1.2f, 14.3f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(160f, 54.2f)
                curveToRelative(-3.5f, 2.9f, -7.4f, 4.7f, -12.6f, 6f)
                curveToRelative(-1.1f, 0.3f, -2.3f, 0.5f, -3.3f, 0.5f)
                curveToRelative(-8.3f, 0.8f, -15.2f, -3f, -17.8f, -9.1f)
                curveToRelative(-0.3f, -0.7f, -0.6f, -1.5f, -0.8f, -2.3f)
                curveToRelative(-1.2f, -5.2f, -0.2f, -9.8f, 2.4f, -13.5f)
                curveToRelative(0.3f, -0.4f, 0.5f, -0.7f, 0.8f, -1f)
                curveToRelative(-0.1f, 0.1f, -0.3f, 0.2f, -0.4f, 0.3f)
                curveToRelative(-1f, 0.9f, -1.9f, 1.8f, -2.6f, 2.9f)
                curveToRelative(-2.6f, 3.6f, -3.6f, 8.3f, -2.4f, 13.5f)
                curveToRelative(0.2f, 0.8f, 0.4f, 1.6f, 0.8f, 2.3f)
                curveToRelative(2.6f, 6.2f, 9.6f, 10f, 17.8f, 9.2f)
                curveToRelative(1.1f, -0.1f, 2.2f, -0.3f, 3.4f, -0.6f)
                curveToRelative(5.2f, -1.3f, 9.2f, -3.1f, 12.6f, -6f)
                curveToRelative(0.8f, -0.7f, 1.7f, -1.5f, 2.5f, -2.3f)
                lineToRelative(-0.1f, -0.1f)
                curveToRelative(-0.2f, 0.1f, -0.3f, 0.1f, -0.3f, 0.2f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(101.7f, 38.5f)
                lineToRelative(9.2f, -13f)
                lineToRelative(-0.4f, -0.3f)
                lineToRelative(-8.9f, 12.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(162.8f, 36.8f)
                lineToRelative(-1.2f, 7.6f)
                lineTo(160f, 43f)
                lineToRelative(-0.6f, 3.6f)
                lineToRelative(-3.2f, -2.9f)
                lineToRelative(3.4f, -3.6f)
                lineToRelative(1f, -1.1f)
                verticalLineToRelative(0.1f)
                lineToRelative(1.2f, -1.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(151.4f, 15.4f)
                lineToRelative(3.2f, -1.4f)
                lineToRelative(-5.9f, -7.6f)
                lineToRelative(-1.9f, 2.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(61.8f, 34.2f)
                curveToRelative(-15f, -18.2f, -41.9f, -8.4f, -51.5f, 0.1f)
                lineToRelative(0.4f, 0.7f)
                curveToRelative(2.2f, -1.3f, 4.6f, -2.4f, 7f, -3.5f)
                curveToRelative(9.6f, -4.1f, 18.8f, -5.3f, 26.1f, -4f)
                curveToRelative(2.6f, 0.3f, 5.3f, 1.1f, 7.7f, 2.7f)
                curveToRelative(3.3f, 1.9f, 5.8f, 4.5f, 7.3f, 7.9f)
                curveToRelative(2.6f, 6f, 0.3f, 14f, -5.8f, 20.6f)
                curveToRelative(7.7f, -7.1f, 13f, -13.9f, 8.8f, -24.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(92.3f, 55.4f)
                curveToRelative(-0.1f, -0.3f, -0.1f, -0.7f, -0.2f, -1f)
                curveToRelative(-0.8f, -3f, -2.6f, -5.4f, -5f, -7f)
                curveToRelative(-3.8f, -2.6f, -9.2f, -3.1f, -14.5f, -0.9f)
                curveToRelative(-2.8f, 1.2f, -5.2f, 3.1f, -7.2f, 5.3f)
                curveToRelative(1.5f, -1.3f, 3.2f, -2.3f, 5f, -3.1f)
                curveToRelative(5.3f, -2.3f, 10.7f, -1.7f, 14.5f, 0.9f)
                curveToRelative(2.4f, 1.6f, 4.2f, 4f, 5f, 7f)
                curveToRelative(0.1f, 0.3f, 0.2f, 0.7f, 0.2f, 1f)
                curveToRelative(0.2f, 1.2f, 0.3f, 2.3f, 0.3f, 3.5f)
                curveToRelative(-0.1f, 3.5f, -1.4f, 7f, -3.5f, 10f)
                curveToRelative(-0.3f, 0.5f, -0.7f, 0.9f, -1.1f, 1.4f)
                curveToRelative(1.2f, -1.1f, 2.3f, -2.2f, 3.2f, -3.5f)
                curveToRelative(2.2f, -3f, 3.4f, -6.5f, 3.6f, -10f)
                curveToRelative(0f, -1.2f, -0.1f, -2.4f, -0.3f, -3.6f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(77.6f, 51f)
                reflectiveCurveToRelative(2.2f, -2.2f, 2.1f, -2.2f)
                curveToRelative(-2.7f, -0.1f, -3.9f, 2.5f, -4f, 2.7f)
                curveToRelative(0.6f, -0.3f, 1.2f, -0.4f, 1.9f, -0.5f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(82.7f, 54.1f)
                curveToRelative(0.1f, 0.4f, 0.2f, 0.7f, 0.2f, 1.1f)
                curveToRelative(0f, 0.6f, -0.1f, 1.1f, -0.4f, 1.6f)
                curveToRelative(0.4f, -0.2f, 3.6f, -1.8f, 2.4f, -5f)
                curveToRelative(0.1f, 0.2f, -2.3f, 2.3f, -2.2f, 2.3f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(70.3f, 56f)
                curveToRelative(0f, -1.3f, 2.3f, -4.6f, 3f, -5.7f)
                curveToRelative(-3.6f, 2.3f, -5.2f, 5.4f, -5.2f, 7.8f)
                curveToRelative(0f, 4.2f, 3.7f, 7.6f, 8.1f, 7.6f)
                curveToRelative(2.1f, 0f, 5.9f, -1.1f, 8.4f, -5.1f)
                curveToRelative(-1.3f, 0.9f, -4.6f, 2.9f, -6.4f, 2.9f)
                curveToRelative(-4.4f, 0f, -7.9f, -3.3f, -7.9f, -7.5f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(101.2f, 59.8f)
                lineToRelative(0.1f, 16.9f)
                lineToRelative(2.7f, 0.2f)
                lineToRelative(-0.6f, -19.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(85.8f, 27.5f)
                verticalLineTo(29f)
                lineToRelative(12.8f, -3.8f)
                lineToRelative(0.9f, 16.3f)
                lineToRelative(2.2f, -3f)
                lineToRelative(-0.5f, -16.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(124.3f, 33.3f)
                lineToRelative(-11.9f, -11f)
                lineToRelative(-1.5f, 3.2f)
                lineToRelative(10.6f, 9.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(122.5f, 53.8f)
                lineToRelative(-14.1f, -4.7f)
                lineToRelative(-2f, 2.2f)
                lineToRelative(14f, 5.6f)
                curveToRelative(1.6f, 3f, 4f, 5.6f, 7f, 7.4f)
                curveToRelative(2.9f, 1.8f, 6.3f, 2.9f, 9.8f, 3.2f)
                verticalLineToRelative(6.9f)
                lineToRelative(2.2f, 1.1f)
                lineToRelative(0.7f, -10.4f)
                lineToRelative(-17.6f, -11.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(145.1f, 51.9f)
                curveToRelative(3.5f, -0.8f, 5.4f, -2.6f, 7.2f, -4.6f)
                curveToRelative(-1.3f, 1.1f, -7.7f, 2.5f, -8.8f, 2.8f)
                lineToRelative(-2.1f, 2.3f)
                curveToRelative(0.9f, 0f, 2.5f, -0.2f, 3.7f, -0.5f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(138.8f, 27.9f)
                curveToRelative(-6.4f, 0.8f, -9.7f, 6.2f, -10.2f, 6.8f)
                curveToRelative(2.4f, -2f, 5.3f, -3.5f, 8.6f, -4.2f)
                curveToRelative(7.9f, -1.9f, 14.8f, 0.5f, 19.1f, 5.8f)
                lineToRelative(2.7f, -2.2f)
                curveToRelative(-4.3f, -5.2f, -12.3f, -8.1f, -20.2f, -6.2f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(160.2f, 54f)
                curveToRelative(0.8f, -0.6f, 2.1f, -1.3f, 2.9f, -2.1f)
                lineToRelative(-8.5f, -7.6f)
                curveToRelative(-0.7f, 0.8f, -1.2f, 2.1f, -2f, 2.7f)
                lineToRelative(7.6f, 7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(203.9f, 74.4f)
                curveToRelative(-8.9f, -7.4f, -8.4f, -23.1f, -4f, -28.1f)
                lineTo(196f, 21.6f)
                lineToRelative(-8.6f, 1.1f)
                lineToRelative(-0.4f, 2.2f)
                horizontalLineToRelative(6.5f)
                lineToRelative(3.5f, 22.4f)
                curveToRelative(-4.4f, 5f, -6.5f, 11.7f, -5.1f, 17.9f)
                curveToRelative(1.1f, 4.8f, 4.1f, 8.6f, 8.3f, 10.8f)
                curveToRelative(0.4f, 0.2f, 0.9f, 0.4f, 1.3f, 0.6f)
                lineToRelative(0.1f, 0.3f)
                lineToRelative(2.6f, 0.4f)
                curveToRelative(-0.1f, 0.1f, 0.2f, -2.7f, -0.3f, -2.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(169.6f, 25.2f)
                lineToRelative(-0.4f, 2.2f)
                horizontalLineToRelative(9.8f)
                lineToRelative(2.9f, 15.9f)
                lineToRelative(2.2f, -2.2f)
                lineToRelative(-2.3f, -16.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(186.4f, 56f)
                lineToRelative(-3.2f, 8.2f)
                lineToRelative(0.8f, 2.2f)
                lineToRelative(4.5f, -12.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(177f, 50.9f)
                lineToRelative(-2.2f, 2.2f)
                lineToRelative(-2.4f, 14.8f)
                lineToRelative(2.3f, 0.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(221.1f, 46.1f)
                curveToRelative(1.3f, 0.9f, 2.4f, 2.1f, 3.2f, 3.5f)
                curveToRelative(0.7f, 1.1f, 1.1f, 2.2f, 1.5f, 3.6f)
                curveToRelative(1.1f, 4.5f, -0.2f, 9.3f, -3f, 13.1f)
                curveToRelative(-0.3f, 0.4f, -0.6f, 0.8f, -0.9f, 1.1f)
                curveToRelative(1.1f, -1f, 15.1f, -11.3f, 1.5f, -24.8f)
                curveToRelative(-15f, -4.9f, -20.7f, 4.8f, -21.2f, 5.5f)
                curveToRelative(1.6f, -1.3f, 3.4f, -2.5f, 5.4f, -3.2f)
                curveToRelative(5f, -2f, 10f, -1.3f, 13.5f, 1.2f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(213.6f, 47.1f)
                curveToRelative(0f, 0.1f, 2.2f, -2.2f, 2.2f, -2.2f)
                curveToRelative(-2.7f, 0.1f, -4f, 1.4f, -3.8f, 2f)
                curveToRelative(-0.2f, 0.2f, -0.3f, 0.5f, -0.4f, 0.7f)
                curveToRelative(0.5f, -0.3f, 1.6f, -0.5f, 2f, -0.5f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(218.6f, 50.5f)
                curveToRelative(0.1f, 0.4f, 0.1f, 0.7f, 0.1f, 1.1f)
                curveToRelative(0f, 0.5f, -0.2f, 1f, -0.4f, 1.4f)
                curveToRelative(0.4f, -0.2f, 3.6f, -1.2f, 2.4f, -4.8f)
                curveToRelative(0.1f, 0.2f, -2.2f, 2.3f, -2.1f, 2.3f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(211.5f, 61.8f)
                curveToRelative(3f, 0.1f, 6.4f, -1.7f, 8.8f, -5f)
                curveToRelative(-6.1f, 1.3f, -12.6f, -9f, -12f, -10f)
                curveToRelative(-2.3f, 1.7f, -4.4f, 4.9f, -4.5f, 7.2f)
                curveToRelative(-0.2f, 4.2f, 3.3f, 7.6f, 7.7f, 7.8f)
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(245.2f, 88.5f)
                lineToRelative(1.4f, 0.9f)
                lineToRelative(17.6f, -52.8f)
                lineToRelative(-13.2f, -3f)
                lineToRelative(-0.1f, 3.1f)
                lineToRelative(10.6f, 2.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(224.3f, 27.9f)
                lineToRelative(0.1f, 3f)
                lineToRelative(14f, 2.8f)
                lineToRelative(5.4f, 25.6f)
                lineToRelative(2.2f, -2.2f)
                lineToRelative(-5.2f, -25.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(235.1f, 57.1f)
                lineToRelative(-3.9f, 21.8f)
                lineToRelative(2.2f, 0.7f)
                lineToRelative(3.9f, -24.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(53.4f, 86.9f)
                lineToRelative(-6.5f, -23.8f)
                lineToRelative(-2.4f, 1.7f)
                lineToRelative(6.1f, 22.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC7A008))) {
                moveTo(51.7f, 51.2f)
                curveToRelative(-1.5f, 1.6f, -4.9f, 4.7f, -6.8f, 5.9f)
                lineToRelative(-1.2f, -3.7f)
                lineToRelative(-2.5f, -8.2f)
                lineToRelative(-1.6f, -5.5f)
                lineToRelative(-1.6f, 2f)
                lineToRelative(1.6f, 5.5f)
                lineToRelative(2.5f, 8.1f)
                lineToRelative(1.2f, 3.7f)
                curveToRelative(2.7f, -1.5f, 6.5f, -4.7f, 8.4f, -7.8f)
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(144.5f, 37.1f)
                curveToRelative(-2.1f, -0.8f, -5f, -0.6f, -6.6f, 1.2f)
                curveToRelative(-0.4f, 0.4f, -1.1f, 1.4f, -1.3f, 1.9f)
                curveToRelative(1.5f, -1.2f, 4.3f, -1.5f, 6f, -0.8f)
                lineToRelative(1.9f, -2.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D7F68))) {
                moveTo(49.9f, 44.5f)
                curveToRelative(-0.2f, -1.2f, -1.4f, -2.2f, -2f, -2.5f)
                curveToRelative(-1f, -0.5f, -2.9f, -0.6f, -4.2f, -0.3f)
                curveToRelative(0.2f, 0.8f, 0.5f, 1.8f, 0.6f, 2.2f)
                curveToRelative(0.5f, 0.1f, 1.4f, 0.2f, 1.9f, 0.4f)
                curveToRelative(0.6f, 0.3f, 1.6f, 0.9f, 1.8f, 2.2f)
                curveToRelative(0.3f, 1.6f, 0.2f, 3.2f, -0.5f, 4.4f)
                curveToRelative(1.9f, -1.8f, 2.8f, -3.8f, 2.4f, -6.4f)
            }
            path(fill = SolidColor(Color(0xFF3C5AA6))) {
                moveTo(53.15f, 44.41f)
                curveToRelative(-0.9f, -4.8f, -7.2f, -7.5f, -13.5f, -4.1f)
                lineToRelative(1.6f, 5.5f)
                lineToRelative(2.5f, 8.2f)
                lineToRelative(1.2f, 3.7f)
                curveToRelative(4.7f, -2.9f, 9.4f, -6.6f, 8.2f, -13.3f)
                close()
                moveTo(46.95f, 51.91f)
                curveToRelative(-0.7f, -2.2f, -2.2f, -7f, -2.2f, -7f)
                reflectiveCurveToRelative(-0.3f, -1f, -0.7f, -2.2f)
                curveToRelative(1.3f, -0.2f, 2.6f, -0.1f, 3.6f, 0.4f)
                curveToRelative(0.6f, 0.3f, 1.6f, 0.9f, 1.8f, 2.2f)
                curveToRelative(0.6f, 2.6f, -0.3f, 4.6f, -2.5f, 6.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3567B0))) {
                moveTo(147.75f, 36.81f)
                curveToRelative(-3.5f, -3.2f, -8.9f, -3f, -12.1f, 0.5f)
                curveToRelative(-3.2f, 3.5f, -3f, 8.9f, 0.5f, 12.1f)
                curveToRelative(0.3f, 0.3f, 0.6f, 0.5f, 0.9f, 0.7f)
                lineTo(148.35f, 37.31f)
                curveToRelative(-0.2f, -0.1f, -0.4f, -0.3f, -0.6f, -0.5f)
                close()
                moveTo(137.15f, 45.81f)
                curveToRelative(-1.1f, -2f, -0.9f, -4.6f, 0.8f, -6.4f)
                curveToRelative(1.6f, -1.7f, 4f, -2.2f, 6.1f, -1.4f)
                lineToRelative(-6.9f, 7.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1E2D5F))) {
                moveTo(162.8f, 35.4f)
                lineToRelative(-6.2f, 6f)
                lineToRelative(5.9f, 5.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3466AF))) {
                moveTo(220.7f, 48.3f)
                curveToRelative(0.1f, 0.4f, 0.1f, 0.8f, 0.1f, 1.2f)
                curveToRelative(-0.1f, 2.4f, -2.3f, 4.2f, -5f, 4.1f)
                curveToRelative(-2.7f, -0.1f, -4.8f, -2.1f, -4.7f, -4.5f)
                curveToRelative(0.1f, -2.2f, 2.1f, -4f, 4.5f, -4.1f)
                curveToRelative(-0.5f, -0.1f, -1f, -0.2f, -1.5f, -0.2f)
                curveToRelative(-4.5f, -0.2f, -8.1f, 3f, -8.3f, 6.9f)
                curveToRelative(-0.2f, 4.2f, 3.2f, 7.7f, 7.6f, 7.8f)
                curveToRelative(4.5f, 0.2f, 8.1f, -3f, 8.3f, -7.2f)
                curveToRelative(0.3f, -1.4f, -0.2f, -2.8f, -1f, -4f)
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF3C5AA6),
                    0.93f to Color(0xFF2B73B9),
                    1f to Color(0xFF2A75BB),
                    start = Offset(70.26f, 56.08f),
                    end = Offset(86.18f, 56.08f)
                )
            ) {
                moveTo(85.1f, 53.1f)
                curveToRelative(0f, 2.4f, -2.2f, 4.3f, -4.8f, 4.3f)
                curveToRelative(-2.7f, 0f, -4.8f, -1.9f, -4.8f, -4.3f)
                curveToRelative(0f, -2.2f, 1.9f, -4.1f, 4.4f, -4.3f)
                curveToRelative(-0.5f, -0.1f, -1f, -0.1f, -1.5f, -0.1f)
                curveToRelative(-4.5f, 0f, -8f, 3.3f, -8f, 7.3f)
                curveToRelative(0f, 4.2f, 3.5f, 7.5f, 7.9f, 7.5f)
                curveToRelative(4.5f, 0f, 8f, -3.3f, 8f, -7.5f)
                curveToRelative(0f, -1.5f, -0.5f, -2.8f, -1.3f, -4f)
                curveToRelative(0f, 0.3f, 0.1f, 0.7f, 0.1f, 1.1f)
            }
            path(
                fill = linearGradient(
                    0f to Color(0xFF3C5AA6),
                    0.93f to Color(0xFF2B73B9),
                    1f to Color(0xFF2A75BB),
                    start = Offset(3.73f, 47.88f),
                    end = Offset(269.47f, 47.88f)
                )
            ) {
                moveTo(248.55f, 28.91f)
                lineToRelative(-2f, 8.2f)
                lineToRelative(-1.8f, -9.1f)
                lineToRelative(-24.6f, -5.4f)
                lineToRelative(0.2f, 13.7f)
                lineToRelative(3.7f, 0.8f)
                lineToRelative(-0.3f, 2.5f)
                reflectiveCurveToRelative(-0.1f, 0f, -0.1f, -0.1f)
                curveToRelative(-4.6f, -2.4f, -10.3f, -2.7f, -15.6f, -0.6f)
                curveToRelative(-1.8f, 0.7f, -3.5f, 1.6f, -5f, 2.7f)
                lineToRelative(-3.7f, -23.4f)
                horizontalLineToRelative(-16.3f)
                lineToRelative(-0.4f, 2.7f)
                horizontalLineToRelative(-17.2f)
                lineToRelative(-2f, 12f)
                lineToRelative(-1.4f, -1.8f)
                curveToRelative(-4.2f, -5.1f, -10.2f, -7.9f, -16.9f, -8.1f)
                lineToRelative(14.6f, -7.8f)
                lineTo(149.55f, 0.01f)
                lineToRelative(-18.4f, 21.2f)
                lineToRelative(3.2f, 3.9f)
                curveToRelative(-2.9f, 1.2f, -5.4f, 2.8f, -7.5f, 4.8f)
                lineToRelative(-15.8f, -14f)
                lineToRelative(-5.5f, 10.5f)
                lineToRelative(0.2f, -10.2f)
                lineToRelative(-24.7f, 7.9f)
                lineToRelative(0.7f, 13.2f)
                lineToRelative(4.2f, -1.1f)
                lineToRelative(0.6f, 6.7f)
                curveToRelative(-4.8f, -2.2f, -10.6f, -2.1f, -15.9f, 0.2f)
                curveToRelative(-1.6f, 0.7f, -3.1f, 1.5f, -4.4f, 2.5f)
                curveToRelative(0.9f, -4.1f, 0.7f, -8.1f, -0.9f, -11.7f)
                curveToRelative(-1.8f, -4.2f, -5.1f, -7.8f, -9f, -10f)
                curveToRelative(-2.8f, -1.9f, -6.1f, -3f, -9.6f, -3.4f)
                curveToRelative(-8.5f, -1.5f, -18.8f, 0f, -28.9f, 4.3f)
                curveToRelative(-3.7f, 1.6f, -7.2f, 3.4f, -10.3f, 5.4f)
                lineToRelative(-3.9f, 2.5f)
                lineToRelative(2.4f, 4f)
                lineTo(13.45f, 49.31f)
                lineToRelative(2.3f, 3.8f)
                lineToRelative(4f, -2f)
                lineToRelative(0.6f, -0.3f)
                lineToRelative(18.4f, 41f)
                lineToRelative(1.8f, 3.9f)
                lineToRelative(4.1f, -1.3f)
                lineToRelative(9.9f, -3.2f)
                lineToRelative(4.4f, -1.4f)
                lineToRelative(-1.1f, -4.4f)
                lineTo(52.55f, 65.21f)
                curveToRelative(1.5f, -1.1f, 2.9f, -2.3f, 4.2f, -3.6f)
                curveToRelative(-0.3f, 2.4f, -0.1f, 4.9f, 0.5f, 7.2f)
                curveToRelative(1.4f, 4.9f, 4.6f, 8.8f, 9.1f, 10.9f)
                curveToRelative(4.8f, 2.3f, 10.7f, 2.3f, 16.1f, 0f)
                curveToRelative(2.7f, -1.2f, 5.2f, -2.8f, 7.2f, -4.9f)
                lineToRelative(0.7f, 8.1f)
                lineToRelative(17.4f, -2.6f)
                lineTo(107.75f, 64.71f)
                lineToRelative(36.3f, 18f)
                lineTo(144.05f, 65.41f)
                curveToRelative(1.5f, -0.1f, 2.9f, -0.4f, 4.4f, -0.7f)
                curveToRelative(4f, -1f, 7.4f, -2.3f, 10.5f, -4.1f)
                lineToRelative(-1.5f, 9.3f)
                lineToRelative(19.6f, 3.1f)
                lineToRelative(1.1f, -7.1f)
                lineToRelative(5.1f, 9.5f)
                lineToRelative(3.1f, -6f)
                lineToRelative(1.1f, 9.9f)
                lineToRelative(22.2f, 3.9f)
                lineToRelative(-1.2f, -7.5f)
                curveToRelative(3f, 0.3f, 6.2f, -0.1f, 9.3f, -1.2f)
                curveToRelative(0.7f, -0.3f, 1.5f, -0.6f, 2.1f, -1f)
                lineToRelative(-0.9f, 8f)
                lineToRelative(14.8f, 2.1f)
                lineToRelative(0.1f, 6.1f)
                lineToRelative(15.4f, 4.8f)
                lineToRelative(20.1f, -60.5f)
                lineToRelative(-20.8f, -5.1f)
                close()
                moveTo(161.75f, 37.91f)
                lineToRelative(1f, -1.1f)
                lineToRelative(-1.2f, 7.6f)
                lineToRelative(-3.2f, -2.9f)
                lineToRelative(3.4f, -3.6f)
                close()
                moveTo(148.75f, 6.71f)
                lineToRelative(5.4f, 7.3f)
                lineToRelative(-15.4f, 7.6f)
                lineToRelative(-1.1f, -1.6f)
                curveToRelative(0f, 0.1f, 11.1f, -13.3f, 11.1f, -13.3f)
                close()
                moveTo(46.85f, 63.11f)
                lineToRelative(6.1f, 23.6f)
                lineToRelative(-9.9f, 3.2f)
                lineTo(22.65f, 44.31f)
                curveToRelative(-1.1f, 0.6f, -3.2f, 1.6f, -5f, 2.5f)
                lineTo(10.25f, 34.31f)
                curveToRelative(2.9f, -1.9f, 6.2f, -3.5f, 9.6f, -5f)
                curveToRelative(9.6f, -4.1f, 18.8f, -5.3f, 26.1f, -4f)
                curveToRelative(2.6f, 0.3f, 5.3f, 1.1f, 7.7f, 2.7f)
                curveToRelative(3.3f, 1.9f, 5.8f, 4.5f, 7.3f, 7.9f)
                curveToRelative(3.6f, 8.2f, -2.3f, 20f, -14.1f, 27.2f)
                close()
                moveTo(92.55f, 58.91f)
                curveToRelative(-0.1f, 3.5f, -1.4f, 7f, -3.6f, 10f)
                curveToRelative(-2.1f, 2.9f, -4.9f, 5.2f, -8.3f, 6.7f)
                curveToRelative(-8.6f, 3.7f, -17.2f, 0f, -19.5f, -8.2f)
                curveToRelative(-2.2f, -7.9f, 3f, -17.3f, 11.3f, -20.9f)
                curveToRelative(5.3f, -2.3f, 10.7f, -1.7f, 14.5f, 0.9f)
                curveToRelative(2.4f, 1.6f, 4.2f, 4f, 5f, 7f)
                curveToRelative(0.1f, 0.3f, 0.2f, 0.7f, 0.2f, 1f)
                curveToRelative(0.4f, 1.2f, 0.4f, 2.4f, 0.4f, 3.5f)
                close()
                moveTo(139.45f, 75.61f)
                lineToRelative(-36.1f, -18f)
                lineToRelative(0.1f, 18.9f)
                lineToRelative(-9.3f, 1.3f)
                lineToRelative(-0.7f, -7.8f)
                curveToRelative(2.9f, -4.9f, 3.9f, -10.8f, 2.4f, -16.1f)
                curveToRelative(-0.8f, -2.9f, -2.3f, -5.5f, -4.4f, -7.5f)
                lineToRelative(-1.3f, -15.9f)
                lineToRelative(-4.2f, 1.1f)
                lineToRelative(-0.2f, -4f)
                lineToRelative(15f, -4.5f)
                lineToRelative(0.9f, 15.4f)
                lineToRelative(11f, -15.5f)
                lineTo(123.55f, 33.31f)
                lineToRelative(-15.1f, 15.9f)
                lineToRelative(14.2f, 5.6f)
                curveToRelative(1.6f, 3f, 4f, 5.5f, 7f, 7.4f)
                curveToRelative(2.9f, 1.8f, 6.3f, 2.9f, 9.8f, 3.2f)
                verticalLineToRelative(10.2f)
                close()
                moveTo(120.75f, 49.41f)
                lineToRelative(-5f, -1.9f)
                lineToRelative(4.7f, -4.5f)
                curveToRelative(-0.3f, 2.1f, -0.2f, 4.2f, 0.3f, 6.4f)
                close()
                moveTo(159.95f, 54.21f)
                curveToRelative(-3.5f, 2.9f, -7.4f, 4.7f, -12.6f, 6f)
                curveToRelative(-1.1f, 0.3f, -2.3f, 0.5f, -3.3f, 0.5f)
                curveToRelative(-8.3f, 0.8f, -15.2f, -3f, -17.8f, -9.1f)
                curveToRelative(-0.3f, -0.7f, -0.6f, -1.5f, -0.8f, -2.3f)
                curveToRelative(-1.2f, -5.2f, -0.2f, -9.8f, 2.4f, -13.5f)
                curveToRelative(0.7f, -1.1f, 1.6f, -2f, 2.6f, -2.9f)
                curveToRelative(2.4f, -2.2f, 5.5f, -3.7f, 9f, -4.6f)
                curveToRelative(7.9f, -1.9f, 14.8f, 0.5f, 19.1f, 5.7f)
                lineToRelative(-15f, 16f)
                curveToRelative(1f, 0.2f, 2.6f, -0.1f, 3.8f, -0.4f)
                curveToRelative(3.6f, -0.9f, 5.6f, -2.8f, 7.3f, -4.8f)
                lineToRelative(6f, 5.4f)
                lineToRelative(1.8f, 1.6f)
                curveToRelative(-0.8f, 0.9f, -1.6f, 1.7f, -2.5f, 2.4f)
                close()
                moveTo(191.85f, 75.51f)
                lineTo(188.55f, 53.91f)
                lineToRelative(-4.6f, 11.9f)
                lineToRelative(-6.9f, -14.9f)
                horizontalLineToRelative(-0.1f)
                lineToRelative(-2.7f, 17.3f)
                lineToRelative(-11.5f, -2f)
                lineToRelative(1.6f, -9.6f)
                curveToRelative(0.4f, -0.4f, 0.9f, -0.8f, 1.3f, -1.3f)
                lineToRelative(3.7f, -3.8f)
                lineToRelative(-3.6f, -3.3f)
                lineToRelative(3.9f, -23f)
                horizontalLineToRelative(11.6f)
                lineToRelative(2.9f, 15.9f)
                lineToRelative(3.3f, -18.4f)
                horizontalLineToRelative(8.3f)
                lineToRelative(3.5f, 22.4f)
                curveToRelative(-4.4f, 5f, -6.5f, 11.7f, -5.1f, 17.9f)
                curveToRelative(1.1f, 4.8f, 4.1f, 8.6f, 8.3f, 10.9f)
                curveToRelative(0.4f, 0.2f, 0.9f, 0.4f, 1.3f, 0.6f)
                lineToRelative(0.4f, 2.9f)
                lineToRelative(-12.3f, -1.9f)
                close()
                moveTo(220.55f, 68.41f)
                curveToRelative(-1.3f, 0.9f, -2.7f, 1.7f, -4.2f, 2.2f)
                curveToRelative(-3f, 1.1f, -5.9f, 1.4f, -8.6f, 0.8f)
                curveToRelative(-1.8f, -0.4f, -3.5f, -1.1f, -5f, -2.1f)
                curveToRelative(-2.3f, -1.7f, -4f, -4.1f, -4.8f, -7.2f)
                curveToRelative(-0.9f, -3.7f, -0.1f, -7.7f, 1.9f, -11.2f)
                curveToRelative(1f, -1.7f, 2.3f, -3.3f, 3.8f, -4.7f)
                curveToRelative(1.7f, -1.5f, 3.7f, -2.8f, 5.8f, -3.6f)
                curveToRelative(5.1f, -1.9f, 10.1f, -1.2f, 13.6f, 1.3f)
                curveToRelative(1.3f, 0.9f, 2.4f, 2.1f, 3.2f, 3.5f)
                curveToRelative(0.6f, 1.1f, 1.1f, 2.3f, 1.4f, 3.6f)
                curveToRelative(1.1f, 4.5f, -0.2f, 9.3f, -3f, 13.1f)
                curveToRelative(-0.9f, 1.7f, -2.4f, 3.1f, -4.1f, 4.3f)
                close()
                moveTo(246.55f, 88.81f)
                lineToRelative(-8.5f, -2.5f)
                lineToRelative(-0.7f, -31.4f)
                lineToRelative(-4.3f, 24.2f)
                lineToRelative(-9.3f, -1.5f)
                lineToRelative(0.7f, -7f)
                curveToRelative(6.1f, -5.1f, 9.3f, -13.2f, 7.5f, -20.6f)
                curveToRelative(-0.8f, -3.2f, -2.4f, -6.1f, -4.8f, -8.2f)
                lineToRelative(0.8f, -8.2f)
                lineToRelative(-3.5f, -0.9f)
                lineToRelative(0.1f, -4.4f)
                lineToRelative(16f, 3.2f)
                lineToRelative(5.4f, 25.5f)
                lineToRelative(5.5f, -22.9f)
                lineToRelative(12.2f, 2.7f)
                lineToRelative(-17.1f, 52f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(258f, 85.3f)
                horizontalLineToRelative(0.4f)
                curveToRelative(0.5f, 0f, 0.9f, -0.2f, 0.9f, -0.7f)
                curveToRelative(0f, -0.3f, -0.3f, -0.7f, -0.9f, -0.7f)
                horizontalLineToRelative(-0.4f)
                verticalLineToRelative(1.4f)
                close()
                moveTo(258f, 87.4f)
                horizontalLineToRelative(-0.6f)
                verticalLineToRelative(-3.8f)
                curveToRelative(0.3f, -0.1f, 0.6f, -0.1f, 1.1f, -0.1f)
                curveToRelative(0.6f, 0f, 1f, 0.1f, 1.2f, 0.3f)
                curveToRelative(0.2f, 0.2f, 0.4f, 0.4f, 0.4f, 0.8f)
                curveToRelative(0f, 0.5f, -0.3f, 0.8f, -0.7f, 0.9f)
                curveToRelative(0.3f, 0.1f, 0.6f, 0.4f, 0.6f, 0.9f)
                curveToRelative(0.1f, 0.6f, 0.2f, 0.8f, 0.2f, 0.9f)
                horizontalLineToRelative(-0.6f)
                curveToRelative(-0.1f, -0.1f, -0.2f, -0.5f, -0.3f, -1f)
                curveToRelative(-0.1f, -0.5f, -0.3f, -0.7f, -0.8f, -0.7f)
                horizontalLineToRelative(-0.5f)
                verticalLineToRelative(1.8f)
                close()
                moveTo(258.7f, 82.5f)
                curveToRelative(-1.5f, 0f, -2.7f, 1.3f, -2.7f, 2.9f)
                curveToRelative(0f, 1.6f, 1.2f, 2.9f, 2.8f, 2.9f)
                curveToRelative(1.5f, 0f, 2.7f, -1.3f, 2.7f, -2.9f)
                curveToRelative(-0.1f, -1.6f, -1.3f, -2.9f, -2.8f, -2.9f)
                close()
                moveTo(258.7f, 82f)
                curveToRelative(1.9f, 0f, 3.3f, 1.5f, 3.3f, 3.4f)
                reflectiveCurveToRelative(-1.5f, 3.4f, -3.4f, 3.4f)
                reflectiveCurveToRelative(-3.4f, -1.5f, -3.4f, -3.4f)
                curveToRelative(0.1f, -1.9f, 1.6f, -3.4f, 3.5f, -3.4f)
                close()
            }
        }
            .build()
        return _pokemon!!
    }

private var _pokemon: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.Pokemon, contentDescription = null)
    }
}
