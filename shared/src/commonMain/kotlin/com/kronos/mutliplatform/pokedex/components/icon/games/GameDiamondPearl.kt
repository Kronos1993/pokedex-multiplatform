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

val Games.GameDiamondPearl: ImageVector
    get() {
        if (_gameDiamondPearl != null) {
            return _gameDiamondPearl!!
        }
        _gameDiamondPearl = Builder(
            name = "GameDiamondPearl", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF5588DD))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDDAACC))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88BBFF)), stroke = SolidColor(Color(0xFFCCDDFF)), strokeLineWidth = 0.8f) {
                moveTo(12f, 6f)
                lineToRelative(8f, 8f)
                lineToRelative(0f, 8f)
                lineToRelative(-8f, 6f)
                lineToRelative(-8f, -6f)
                lineToRelative(0f, -8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAACCFF)), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(12f, 6f)
                lineToRelative(8f, 8f)
                lineToRelative(-8f, 0f)
                lineToRelative(-8f, 0f)
                close()
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFCCDDFF)), strokeLineWidth = 0.5f) {
                moveTo(12f, 14f)
                lineTo(12f, 28f)
            }
            path(fill = SolidColor(Color(0xFFFFDDEE)), stroke = SolidColor(Color(0xFFFFBBCC)), strokeLineWidth = 0.8f) {
                moveTo(36f, 17f)
                moveToRelative(-11f, 0f)
                arcToRelative(11f, 11f, 0f, isMoreThanHalf = true, isPositiveArc = true, 22f, 0f)
                arcToRelative(11f, 11f, 0f, isMoreThanHalf = true, isPositiveArc = true, -22f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(33f, 14f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFCCDD)), strokeLineWidth = 0.5f) {
                moveTo(36f, 17f)
                moveToRelative(-8f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 16f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -16f, 0f)
            }
            path(fill = SolidColor(Color(0xFF222233))) {
                moveTo(0f, 33f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(5f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222233))) {
                moveTo(24f, 35.5f)
                moveToRelative(-5.5f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 11f, 0f)
                arcToRelative(5.5f, 5.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -11f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEFF))) {
                moveTo(24f, 35.5f)
                moveToRelative(-3.5f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 7f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -7f, 0f)
            }
        }
        .build()
        return _gameDiamondPearl!!
    }

private var _gameDiamondPearl: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameDiamondPearl, contentDescription = null)
    }
}
