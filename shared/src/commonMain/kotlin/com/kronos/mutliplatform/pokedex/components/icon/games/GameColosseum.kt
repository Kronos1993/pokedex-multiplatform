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

val Games.GameColosseum: ImageVector
    get() {
        if (_gameColosseum != null) {
            return _gameColosseum!!
        }
        _gameColosseum = Builder(
            name = "GameColosseum", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF332200))) {
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
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(4f, 28f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(16f)
                horizontalLineToRelative(-40f)
                close()
            }
            path(fill = SolidColor(Color(0xFF664422))) {
                moveTo(4f, 28f)
                quadTo(4f, 18f, 10f, 18f)
                quadTo(16f, 18f, 16f, 28f)
            }
            path(fill = SolidColor(Color(0xFF664422))) {
                moveTo(16f, 28f)
                quadTo(16f, 18f, 22f, 18f)
                quadTo(28f, 18f, 28f, 28f)
            }
            path(fill = SolidColor(Color(0xFF664422))) {
                moveTo(28f, 28f)
                quadTo(28f, 18f, 34f, 18f)
                quadTo(40f, 18f, 40f, 28f)
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(4f, 14f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-40f)
                close()
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(4f, 10f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(12f, 10f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(20f, 10f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(28f, 10f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF886633))) {
                moveTo(36f, 10f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAAAA))) {
                moveTo(20f, 4f)
                lineTo(28f, 4f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 30f, 6f)
                lineTo(30f, 10f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 28f, 12f)
                lineTo(20f, 12f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 10f)
                lineTo(18f, 6f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 20f, 4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC2200))) {
                moveTo(24f, 8f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFF4444))) {
                moveTo(24f, 8f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.3f, strokeAlpha = 0.3f) {
                moveTo(6f, 44f)
                arcToRelative(18f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = false, 36f, 0f)
                arcToRelative(18f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = false, -36f, 0f)
                close()
            }
        }
        .build()
        return _gameColosseum!!
    }

private var _gameColosseum: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameColosseum, contentDescription = null)
    }
}
