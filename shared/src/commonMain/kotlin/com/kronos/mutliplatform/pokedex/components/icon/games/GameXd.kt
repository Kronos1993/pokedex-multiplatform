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

val Games.GameXd: ImageVector
    get() {
        if (_gameXd != null) {
            return _gameXd!!
        }
        _gameXd = Builder(
            name = "GameXd",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF110022))) {
                moveTo(4f, 0f)
                lineTo(44f, 0f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 48f, 4f)
                lineTo(48f, 44f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 44f, 48f)
                lineTo(4f, 48f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 44f)
                lineTo(0f, 4f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF220044)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(24f, 4f)
                quadTo(36f, 10f, 40f, 24f)
                quadTo(36f, 38f, 24f, 44f)
                quadTo(12f, 38f, 8f, 24f)
                quadTo(12f, 10f, 24f, 4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6600AA)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(16f, 10f)
                quadTo(10f, 8f, 8f, 14f)
                quadTo(6f, 20f, 12f, 22f)
                quadTo(10f, 18f, 14f, 16f)
                quadTo(14f, 22f, 18f, 22f)
                quadTo(16f, 18f, 18f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6600AA)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(32f, 10f)
                quadTo(38f, 8f, 40f, 14f)
                quadTo(42f, 20f, 36f, 22f)
                quadTo(38f, 18f, 34f, 16f)
                quadTo(34f, 22f, 30f, 22f)
                quadTo(32f, 18f, 30f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAA00FF)), fillAlpha = 0.4f, strokeAlpha = 0.4f) {
                moveTo(24f, 36f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color(0xFFCC44FF)), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(24f, 36f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEECCFF))) {
                moveTo(24f, 36f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
        }
            .build()
        return _gameXd!!
    }

private var _gameXd: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameXd, contentDescription = null)
    }
}
