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

val Games.GameFireredLeafgreen: ImageVector
    get() {
        if (_gameFireredLeafgreen != null) {
            return _gameFireredLeafgreen!!
        }
        _gameFireredLeafgreen = Builder(
            name = "GameFireredLeafgreen", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFCC3300))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF227722))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8800)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(8f, 36f)
                quadTo(6f, 28f, 10f, 22f)
                quadTo(8f, 26f, 13f, 22f)
                quadTo(10f, 18f, 14f, 12f)
                quadTo(15f, 18f, 18f, 16f)
                quadTo(16f, 22f, 19f, 20f)
                quadTo(18f, 27f, 15f, 30f)
                quadTo(18f, 28f, 17f, 36f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFDD00)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(10f, 36f)
                quadTo(9f, 30f, 12f, 25f)
                quadTo(11f, 28f, 14f, 25f)
                quadTo(12f, 22f, 15f, 17f)
                quadTo(16f, 21f, 18f, 20f)
                quadTo(17f, 24f, 19f, 22f)
                quadTo(18f, 28f, 16f, 31f)
                quadTo(18f, 30f, 17f, 36f)
                close()
            }
            path(fill = SolidColor(Color(0xFF44BB44))) {
                moveTo(40f, 10f)
                quadTo(44f, 20f, 38f, 28f)
                quadTo(42f, 22f, 36f, 30f)
                quadTo(40f, 26f, 34f, 36f)
                quadTo(30f, 30f, 32f, 22f)
                quadTo(28f, 28f, 30f, 20f)
                quadTo(26f, 26f, 28f, 16f)
                quadTo(34f, 18f, 36f, 12f)
                quadTo(38f, 8f, 40f, 10f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88EE88)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(37f, 14f)
                quadTo(40f, 20f, 36f, 26f)
                quadTo(38f, 22f, 34f, 28f)
                quadTo(36f, 24f, 32f, 32f)
                quadTo(30f, 27f, 31f, 22f)
                quadTo(29f, 26f, 30f, 20f)
                quadTo(28f, 24f, 30f, 16f)
                quadTo(34f, 17f, 35f, 13f)
                quadTo(36f, 10f, 37f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF111111)), fillAlpha = 0.4f, strokeAlpha = 0.4f) {
                moveTo(23f, 0f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(48f)
                horizontalLineToRelative(-2f)
                close()
            }
        }
        .build()
        return _gameFireredLeafgreen!!
    }

private var _gameFireredLeafgreen: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameFireredLeafgreen, contentDescription = null)
    }
}
