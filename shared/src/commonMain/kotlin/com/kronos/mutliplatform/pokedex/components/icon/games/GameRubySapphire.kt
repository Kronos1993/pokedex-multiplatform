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

val Games.GameRubySapphire: ImageVector
    get() {
        if (_gameRubySapphire != null) {
            return _gameRubySapphire!!
        }
        _gameRubySapphire = Builder(
            name = "GameRubySapphire", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFCC1100))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0044BB))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF4444)), stroke = SolidColor(Color(0xFFFFAAAA)), strokeLineWidth = 0.8f) {
                moveTo(12f, 8f)
                lineToRelative(6f, 6f)
                lineToRelative(0f, 8f)
                lineToRelative(-6f, 4f)
                lineToRelative(-6f, -4f)
                lineToRelative(0f, -8f)
                close()
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFCCCC)), strokeLineWidth = 0.8f) {
                moveTo(12f, 8f)
                lineTo(12f, 14f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFCCCC)), strokeLineWidth = 0.8f) {
                moveTo(6f, 14f)
                lineTo(18f, 14f)
            }
            path(fill = SolidColor(Color(0xFF4488FF)), stroke = SolidColor(Color(0xFFAACCFF)), strokeLineWidth = 0.8f) {
                moveTo(36f, 8f)
                lineToRelative(6f, 6f)
                lineToRelative(0f, 8f)
                lineToRelative(-6f, 4f)
                lineToRelative(-6f, -4f)
                lineToRelative(0f, -8f)
                close()
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFCCDDFF)), strokeLineWidth = 0.8f) {
                moveTo(36f, 8f)
                lineTo(36f, 14f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFCCDDFF)), strokeLineWidth = 0.8f) {
                moveTo(30f, 14f)
                lineTo(42f, 14f)
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(0f, 31f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(5f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(24f, 33.5f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(24f, 33.5f)
                moveToRelative(-4f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, -8f, 0f)
            }
        }
        .build()
        return _gameRubySapphire!!
    }

private var _gameRubySapphire: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameRubySapphire, contentDescription = null)
    }
}
