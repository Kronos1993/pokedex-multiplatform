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

val Games.GamePlatinum: ImageVector
    get() {
        if (_gamePlatinum != null) {
            return _gamePlatinum!!
        }
        _gamePlatinum = Builder(
            name = "GamePlatinum", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF444466))) {
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
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.5f, stroke = SolidColor(Color(0xFF8888BB)), strokeAlpha = 0.5f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-20f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, 40f, 0f)
                arcToRelative(20f, 20f, 0f, isMoreThanHalf = true, isPositiveArc = true, -40f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.6f, stroke = SolidColor(Color(0xFFAAAACC)), strokeAlpha = 0.6f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-14f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, 28f, 0f)
                arcToRelative(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, -28f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), fillAlpha = 0.7f, stroke = SolidColor(Color(0xFFCCCCEE)), strokeAlpha = 0.7f, strokeLineWidth = 1f) {
                moveTo(24f, 24f)
                moveToRelative(-8f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 16f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -16f, 0f)
            }
            path(fill = SolidColor(Color(0xFF8844AA)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(4f, 18f)
                quadTo(10f, 14f, 14f, 20f)
                quadTo(10f, 22f, 4f, 22f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8844AA)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(44f, 18f)
                quadTo(38f, 14f, 34f, 20f)
                quadTo(38f, 22f, 44f, 22f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6633AA)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(4f, 26f)
                quadTo(10f, 22f, 14f, 28f)
                quadTo(10f, 30f, 4f, 30f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6633AA)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(44f, 26f)
                quadTo(38f, 22f, 34f, 28f)
                quadTo(38f, 30f, 44f, 30f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAACC)), stroke = SolidColor(Color(0xFFCCCCEE)), strokeLineWidth = 1f) {
                moveTo(24f, 10f)
                lineToRelative(6f, 7f)
                lineToRelative(0f, 7f)
                lineToRelative(-6f, 6f)
                lineToRelative(-6f, -6f)
                lineToRelative(0f, -7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCCCCEE)), fillAlpha = 0.7f, strokeAlpha = 0.7f) {
                moveTo(24f, 10f)
                lineToRelative(6f, 7f)
                lineToRelative(-6f, 0f)
                lineToRelative(-6f, 0f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.6f, stroke = SolidColor(Color(0xFFCCCCEE)), strokeAlpha = 0.6f, strokeLineWidth = 0.5f) {
                moveTo(24f, 17f)
                lineTo(24f, 30f)
            }
        }
        .build()
        return _gamePlatinum!!
    }

private var _gamePlatinum: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GamePlatinum, contentDescription = null)
    }
}
