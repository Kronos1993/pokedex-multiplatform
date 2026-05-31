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

val Games.GameCrystal: ImageVector
    get() {
        if (_gameCrystal != null) {
            return _gameCrystal!!
        }
        _gameCrystal = Builder(
            name = "GameCrystal", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF0066BB))) {
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
            path(fill = SolidColor(Color(0xFF44CCFF)), fillAlpha = 0.3f, strokeAlpha = 0.3f) {
                moveTo(24f, 4f)
                lineToRelative(14f, 12f)
                lineToRelative(0f, 16f)
                lineToRelative(-14f, 12f)
                lineToRelative(-14f, -12f)
                lineToRelative(0f, -16f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF88EEFF)), strokeLineWidth = 1.5f) {
                moveTo(24f, 4f)
                lineToRelative(14f, 12f)
                lineToRelative(0f, 16f)
                lineToRelative(-14f, 12f)
                lineToRelative(-14f, -12f)
                lineToRelative(0f, -16f)
                close()
            }
            path(fill = SolidColor(Color(0xFF88DDFF)), fillAlpha = 0.25f, strokeAlpha = 0.25f) {
                moveTo(24f, 10f)
                lineToRelative(10f, 9f)
                lineToRelative(0f, 10f)
                lineToRelative(-10f, 9f)
                lineToRelative(-10f, -9f)
                lineToRelative(0f, -10f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(6f, 22f)
                quadTo(12f, 18f, 18f, 22f)
                quadTo(12f, 26f, 6f, 26f)
                close()
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(42f, 22f)
                quadTo(36f, 18f, 30f, 22f)
                quadTo(36f, 26f, 42f, 26f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.9f, stroke = SolidColor(Color.White), strokeAlpha = 0.9f, strokeLineWidth = 1.5f) {
                moveTo(24f, 6f)
                lineTo(24f, 12f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.9f, stroke = SolidColor(Color.White), strokeAlpha = 0.9f, strokeLineWidth = 1.5f) {
                moveTo(21f, 9f)
                lineTo(27f, 9f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.8f, stroke = SolidColor(Color(0xFFAADDFF)), strokeAlpha = 0.8f, strokeLineWidth = 1f) {
                moveTo(10f, 14f)
                lineTo(13f, 17f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.8f, stroke = SolidColor(Color(0xFFAADDFF)), strokeAlpha = 0.8f, strokeLineWidth = 1f) {
                moveTo(38f, 14f)
                lineTo(35f, 17f)
            }
            path(fill = SolidColor(Color(0xFF003388)), stroke = SolidColor(Color(0xFF88CCFF)), strokeLineWidth = 1f) {
                moveTo(24f, 28f)
                moveToRelative(-8f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 16f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -16f, 0f)
            }
            path(fill = SolidColor(Color(0xFF88CCFF))) {
                moveTo(16f, 26.5f)
                horizontalLineToRelative(16f)
                verticalLineToRelative(3f)
                horizontalLineToRelative(-16f)
                close()
            }
            path(fill = SolidColor(Color(0xFF003388)), stroke = SolidColor(Color(0xFF88CCFF)), strokeLineWidth = 1f) {
                moveTo(24f, 28f)
                moveToRelative(-3.5f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 7f, 0f)
                arcToRelative(3.5f, 3.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -7f, 0f)
            }
            path(fill = SolidColor(Color(0xFFAADDFF))) {
                moveTo(24f, 28f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
        }
        .build()
        return _gameCrystal!!
    }

private var _gameCrystal: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameCrystal, contentDescription = null)
    }
}
