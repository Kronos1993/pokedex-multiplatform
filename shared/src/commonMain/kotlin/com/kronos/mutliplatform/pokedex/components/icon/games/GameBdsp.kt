package com.kronos.mutliplatform.pokedex.components.icon.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Games.GameBdsp: ImageVector
    get() {
        if (_gameBdsp != null) {
            return _gameBdsp!!
        }
        _gameBdsp = Builder(
            name = "GameBdsp", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF3355BB))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC6699))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF55AAFF)), stroke = SolidColor(Color(0xFFAADDFF)), strokeLineWidth = 1f) {
                moveTo(12f, 6f)
                lineToRelative(8f, 10f)
                lineToRelative(0f, 12f)
                lineToRelative(-8f, 8f)
                lineToRelative(-8f, -8f)
                lineToRelative(0f, -12f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88CCFF)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(12f, 6f)
                lineToRelative(8f, 10f)
                lineToRelative(-8f, 0f)
                lineToRelative(-8f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3388EE)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(4f, 16f)
                lineToRelative(8f, 0f)
                lineToRelative(0f, 20f)
                lineToRelative(-8f, -8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF66AAFF)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(20f, 16f)
                lineToRelative(-8f, 0f)
                lineToRelative(0f, 20f)
                lineToRelative(8f, -8f)
                close()
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(12f, 4f)
                lineTo(12f, 8f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(10f, 6f)
                lineTo(14f, 6f)
            }
            path(fill = SolidColor(Color(0xFFFFDDEE)), stroke = SolidColor(Color(0xFFFFBBCC)), strokeLineWidth = 1f) {
                moveTo(36f, 21f)
                moveToRelative(-14f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, 28f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, -28f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(32f, 17f)
                moveToRelative(-4f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, -8f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFCCDD)), strokeLineWidth = 0.5f) {
                moveTo(36f, 21f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFCCDD)), strokeLineWidth = 0.5f) {
                moveTo(36f, 21f)
                moveToRelative(-6f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, 12f, 0f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, 0f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(36f, 5f)
                lineTo(36f, 9f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color.White), strokeLineWidth = 1.5f) {
                moveTo(34f, 7f)
                lineTo(38f, 7f)
            }
        }
        .build()
        return _gameBdsp!!
    }

private var _gameBdsp: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Games.GameBdsp, contentDescription = null)
    }
}
