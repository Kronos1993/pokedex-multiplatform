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

val Games.GameLegendsArceus: ImageVector
    get() {
        if (_gameLegendsArceus != null) {
            return _gameLegendsArceus!!
        }
        _gameLegendsArceus = Builder(
            name = "GameLegendsArceus", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF1A1A2E))) {
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
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.3f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.3f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-20f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, 40f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, -40f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.5f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.5f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-15f, 0f)
                arcToRelative(15f, 15f, 0f, isMoreThanHalf = true, isPositiveArc = true, 30f, 0f)
                arcToRelative(15f, 15f, 0f, isMoreThanHalf = true, isPositiveArc = true, -30f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.7f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.7f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color.White), strokeLineWidth = 2.5f) {
                moveTo(24f, 24f)
                moveToRelative(-18f, 0f)
                arcToRelative(18f, 18f, 0f, isMoreThanHalf = true, isPositiveArc = true, 36f, 0f)
                arcToRelative(18f, 18f, 0f, isMoreThanHalf = true, isPositiveArc = true, -36f, 0f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.6f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.6f, strokeLineWidth = 1.5f) {
                moveTo(24f, 6f)
                lineTo(24f, 42f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.6f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.6f, strokeLineWidth = 1.5f) {
                moveTo(6f, 24f)
                lineTo(42f, 24f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.4f, strokeLineWidth = 1f) {
                moveTo(11f, 11f)
                lineTo(37f, 37f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFFFFD700)), strokeAlpha = 0.4f, strokeLineWidth = 1f) {
                moveTo(37f, 11f)
                lineTo(11f, 37f)
            }
            path(fill = SolidColor(Color(0xFFFFD700))) {
                moveTo(24f, 24f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(24f, 24f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFFD700))) {
                moveTo(24f, 24f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(8f, 8f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(40f, 10f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(6f, 38f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(42f, 40f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
        }
        .build()
        return _gameLegendsArceus!!
    }

private var _gameLegendsArceus: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameLegendsArceus, contentDescription = null)
    }
}
