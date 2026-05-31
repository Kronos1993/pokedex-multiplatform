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

val Games.GameHeartgoldSoulsilver: ImageVector
    get() {
        if (_gameHeartgoldSoulsilver != null) {
            return _gameHeartgoldSoulsilver!!
        }
        _gameHeartgoldSoulsilver = Builder(
            name = "GameHeartgoldSoulsilver", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFDDAA00))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8888CC))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF4444))) {
                moveTo(12f, 10f)
                quadTo(8f, 6f, 4f, 10f)
                quadTo(4f, 14f, 12f, 20f)
                quadTo(20f, 14f, 20f, 10f)
                quadTo(16f, 6f, 12f, 10f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8888)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(12f, 10f)
                quadTo(9f, 7f, 6f, 10f)
                quadTo(6f, 13f, 12f, 18f)
                quadTo(18f, 13f, 18f, 10f)
                quadTo(15f, 7f, 12f, 10f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAAFF)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(28f, 8f)
                quadTo(34f, 5f, 40f, 10f)
                quadTo(44f, 16f, 40f, 22f)
                quadTo(36f, 26f, 30f, 24f)
                quadTo(26f, 20f, 28f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCCCCFF)), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(30f, 10f)
                quadTo(35f, 8f, 39f, 12f)
                quadTo(42f, 17f, 39f, 21f)
                quadTo(36f, 24f, 31f, 22f)
                quadTo(28f, 19f, 30f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333322))) {
                moveTo(0f, 33f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(5f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333322))) {
                moveTo(24f, 35.5f)
                moveToRelative(-5.5f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 11f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -11f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEECC))) {
                moveTo(24f, 35.5f)
                moveToRelative(-3.5f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 7f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -7f, 0f)
            }
        }
        .build()
        return _gameHeartgoldSoulsilver!!
    }

private var _gameHeartgoldSoulsilver: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameHeartgoldSoulsilver, contentDescription = null)
    }
}
