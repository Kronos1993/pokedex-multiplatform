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

val Games.GameBlack2White2: ImageVector
    get() {
        if (_gameBlack2White2 != null) {
            return _gameBlack2White2!!
        }
        _gameBlack2White2 = Builder(
            name = "GameBlack2White2", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF111111))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDDDDDD))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2244AA)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(4f, 8f)
                quadTo(10f, 6f, 14f, 12f)
                quadTo(16f, 18f, 12f, 24f)
                quadTo(8f, 28f, 4f, 24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1133AA)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(4f, 26f)
                quadTo(10f, 24f, 14f, 30f)
                quadTo(12f, 36f, 6f, 36f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88AAFF)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(44f, 8f)
                quadTo(38f, 6f, 34f, 12f)
                quadTo(32f, 18f, 36f, 24f)
                quadTo(40f, 28f, 44f, 24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAACCFF)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(44f, 26f)
                quadTo(38f, 24f, 34f, 30f)
                quadTo(36f, 36f, 42f, 36f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88CCFF)), stroke = SolidColor(Color(0xFFAADDFF)), strokeLineWidth = 0.8f) {
                moveTo(24f, 8f)
                lineToRelative(4f, 8f)
                lineToRelative(-4f, 4f)
                lineToRelative(-4f, -4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF66AAFF)), stroke = SolidColor(Color(0xFFAADDFF)), strokeLineWidth = 0.8f) {
                moveTo(24f, 20f)
                lineToRelative(4f, 8f)
                lineToRelative(-4f, 8f)
                lineToRelative(-4f, -8f)
                close()
            }
        }
        .build()
        return _gameBlack2White2!!
    }

private var _gameBlack2White2: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameBlack2White2, contentDescription = null)
    }
}
