package com.kronos.mutliplatform.pokedex.components.icon.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Games.GameUsum: ImageVector
    get() {
        if (_gameUsum != null) {
            return _gameUsum!!
        }
        _gameUsum = Builder(
            name = "GameUsum",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFCC5500))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000044))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFFFFAA00)),
                strokeLineWidth = 2f
            ) {
                moveTo(12f, 24f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFFFFCC44)),
                strokeLineWidth = 1.5f
            ) {
                moveTo(12f, 24f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFFEE88))) {
                moveTo(12f, 24f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFFDD00)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(12f, 14f)
                lineToRelative(4f, 8f)
                lineToRelative(-4f, -4f)
                lineToRelative(-4f, 4f)
                close()
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFF4444FF)),
                strokeLineWidth = 2f
            ) {
                moveTo(36f, 24f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFF6666FF)),
                strokeLineWidth = 1.5f
            ) {
                moveTo(36f, 24f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
            path(fill = SolidColor(Color(0xFFAAAAFF))) {
                moveTo(36f, 24f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFF8888FF)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(36f, 14f)
                lineToRelative(4f, 8f)
                lineToRelative(-4f, -4f)
                lineToRelative(-4f, 4f)
                close()
            }
        }
            .build()
        return _gameUsum!!
    }

private var _gameUsum: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameUsum, contentDescription = null)
    }
}
