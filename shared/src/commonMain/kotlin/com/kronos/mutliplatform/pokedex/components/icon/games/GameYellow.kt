package com.kronos.mutliplatform.pokedex.components.icon.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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

val Games.GameYellow: ImageVector
    get() {
        if (_gameYellow != null) {
            return _gameYellow!!
        }
        _gameYellow = Builder(
            name = "GameYellow",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFD700))) {
                moveTo(6f, 0f)
                lineTo(42f, 0f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 48f, 6f)
                lineTo(48f, 42f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 42f, 48f)
                lineTo(6f, 48f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 42f)
                lineTo(0f, 6f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFD700)),
                stroke = SolidColor(Color(0xFF222222)),
                strokeLineWidth = 1f
            ) {
                moveTo(8f, 20f)
                lineToRelative(5f, -14f)
                lineToRelative(5f, 14f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFD700)),
                stroke = SolidColor(Color(0xFF222222)),
                strokeLineWidth = 1f
            ) {
                moveTo(30f, 20f)
                lineToRelative(5f, -14f)
                lineToRelative(5f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(10f, 20f)
                lineToRelative(3f, -11f)
                lineToRelative(3f, 11f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(32f, 20f)
                lineToRelative(3f, -11f)
                lineToRelative(3f, 11f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFD700)),
                stroke = SolidColor(Color(0xFF222222)),
                strokeLineWidth = 1.5f
            ) {
                moveTo(24f, 30f)
                moveToRelative(-14f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, 28f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, -28f, 0f)
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(19f, 27f)
                moveToRelative(-2.5f, 0f)
                arcToRelative(2.5f, 2.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 5f, 0f)
                arcToRelative(2.5f, 2.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -5f, 0f)
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(29f, 27f)
                moveToRelative(-2.5f, 0f)
                arcToRelative(2.5f, 2.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 5f, 0f)
                arcToRelative(2.5f, 2.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -5f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(19.8f, 26.2f)
                moveToRelative(-0.8f, 0f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.6f, 0f)
                arcToRelative(
                    0.8f,
                    0.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -1.6f,
                    0f
                )
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(29.8f, 26.2f)
                moveToRelative(-0.8f, 0f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.6f, 0f)
                arcToRelative(
                    0.8f,
                    0.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -1.6f,
                    0f
                )
            }
            path(fill = SolidColor(Color(0xFFFF6666)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(14f, 31f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFF6666)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(34f, 31f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFF222222)),
                strokeLineWidth = 1.5f,
                strokeLineCap = Round
            ) {
                moveTo(20f, 33f)
                quadTo(24f, 37f, 28f, 33f)
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(22.8f, 30f)
                arcToRelative(
                    1.2f,
                    0.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    2.4f,
                    0f
                )
                arcToRelative(
                    1.2f,
                    0.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -2.4f,
                    0f
                )
                close()
            }
        }
            .build()
        return _gameYellow!!
    }

private var _gameYellow: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameYellow, contentDescription = null)
    }
}
