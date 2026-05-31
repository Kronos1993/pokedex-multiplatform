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

val Games.GameOras: ImageVector
    get() {
        if (_gameOras != null) {
            return _gameOras!!
        }
        _gameOras = Builder(
            name = "GameOras", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFAA1100))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0033AA))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFAAAA)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(8f, 30f)
                quadTo(4f, 22f, 8f, 16f)
                quadTo(12f, 10f, 16f, 14f)
                quadTo(20f, 18f, 16f, 24f)
                quadTo(14f, 28f, 12f, 30f)
                lineTo(8f, 30f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFAAAA))) {
                moveTo(9f, 30f)
                lineTo(15f, 30f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 31f)
                lineTo(16f, 31.5f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 15f, 32.5f)
                lineTo(9f, 32.5f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 31.5f)
                lineTo(8f, 31f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 9f, 30f)
                close()
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFAAAAFF)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(32f, 14f)
                lineTo(28f, 30f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFAAAAFF)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(40f, 14f)
                lineTo(44f, 30f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFAAAAFF)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(30f, 22f)
                quadTo(36f, 18f, 42f, 22f)
            }
            path(fill = SolidColor(Color(0xFFFF6600)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(12f, 38f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color(0xFF0066FF)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(36f, 38f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color(0xFF222222)), fillAlpha = 0.4f, strokeAlpha = 0.4f) {
                moveTo(23f, 0f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(48f)
                horizontalLineToRelative(-2f)
                close()
            }
        }
        .build()
        return _gameOras!!
    }

private var _gameOras: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameOras, contentDescription = null)
    }
}
