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

val Games.GameXy: ImageVector
    get() {
        if (_gameXy != null) {
            return _gameXy!!
        }
        _gameXy = Builder(
            name = "GameXy", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF003399))) {
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
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFF44FFCC)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(8f, 6f)
                lineTo(22f, 20f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFF44FFCC)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(22f, 6f)
                lineTo(8f, 20f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFF4444)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(30f, 6f)
                lineTo(38f, 16f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFF4444)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(46f, 6f)
                lineTo(38f, 16f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFF4444)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(38f, 16f)
                lineTo(38f, 26f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFD700)), strokeLineWidth = 2f) {
                moveTo(24f, 34f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFD700)), strokeLineWidth = 1f) {
                moveTo(24f, 34f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFFD700))) {
                moveTo(24f, 34f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(fill = SolidColor(Color(0xFF44FFCC)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(10f, 34f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFF4444)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(38f, 34f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(24f, 14f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
        }
        .build()
        return _gameXy!!
    }

private var _gameXy: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameXy, contentDescription = null)
    }
}
