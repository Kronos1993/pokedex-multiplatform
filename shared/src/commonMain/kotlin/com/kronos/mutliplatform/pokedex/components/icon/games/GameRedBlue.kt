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

val Games.GameRedBlue: ImageVector
    get() {
        if (_gameRedBlue != null) {
            return _gameRedBlue!!
        }
        _gameRedBlue = Builder(
            name = "GameRedBlue", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFCC0000))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0033CC))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(0f, 21f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(24f, 24f)
                moveToRelative(-7f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, 14f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, -14f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(24f, 24f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(4f, 21f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 44f, 21f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(4f, 27f)
                arcTo(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = false, 44f, 27f)
            }
        }
        .build()
        return _gameRedBlue!!
    }

private var _gameRedBlue: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameRedBlue, contentDescription = null)
    }
}
