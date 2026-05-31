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

val Games.GameBlackWhite: ImageVector
    get() {
        if (_gameBlackWhite != null) {
            return _gameBlackWhite!!
        }
        _gameBlackWhite = Builder(
            name = "GameBlackWhite", 
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
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color.LightGray), stroke = SolidColor(Color(0xFFAAAAAA)), strokeLineWidth = 0.8f) {
                moveTo(28f, 8f)
                quadTo(36f, 6f, 42f, 12f)
                quadTo(46f, 18f, 42f, 26f)
                quadTo(38f, 30f, 32f, 28f)
                quadTo(26f, 24f, 28f, 16f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(30f, 10f)
                quadTo(36f, 9f, 40f, 14f)
                quadTo(43f, 19f, 40f, 24f)
                quadTo(37f, 27f, 32f, 25f)
                quadTo(28f, 22f, 30f, 16f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333333)), stroke = SolidColor(Color(0xFF555555)), strokeLineWidth = 0.8f) {
                moveTo(20f, 8f)
                quadTo(12f, 6f, 6f, 12f)
                quadTo(2f, 18f, 6f, 26f)
                quadTo(10f, 30f, 16f, 28f)
                quadTo(22f, 24f, 20f, 16f)
                close()
            }
            path(fill = SolidColor(Color.DarkGray), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(18f, 10f)
                quadTo(12f, 9f, 8f, 14f)
                quadTo(5f, 19f, 8f, 24f)
                quadTo(11f, 27f, 16f, 25f)
                quadTo(20f, 22f, 18f, 16f)
                close()
            }
            path(fill = SolidColor(Color.Gray), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(23f, 0f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(48f)
                horizontalLineToRelative(-2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF666666))) {
                moveTo(0f, 34f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(4f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF666666))) {
                moveTo(24f, 36f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color.LightGray)) {
                moveTo(24f, 36f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
        }
        .build()
        return _gameBlackWhite!!
    }

private var _gameBlackWhite: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameBlackWhite, contentDescription = null)
    }
}
