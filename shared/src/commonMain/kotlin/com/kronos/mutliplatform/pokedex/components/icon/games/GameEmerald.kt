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

val Games.GameEmerald: ImageVector
    get() {
        if (_gameEmerald != null) {
            return _gameEmerald!!
        }
        _gameEmerald = Builder(
            name = "GameEmerald", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF006633))) {
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
            path(fill = SolidColor(Color(0xFF00AA55)), stroke = SolidColor(Color(0xFF88FFBB)), strokeLineWidth = 1.2f) {
                moveTo(24f, 4f)
                lineToRelative(12f, 8f)
                lineToRelative(4f, 12f)
                lineToRelative(-4f, 12f)
                lineToRelative(-12f, 8f)
                lineToRelative(-12f, -8f)
                lineToRelative(-4f, -12f)
                lineToRelative(4f, -12f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00CC66)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(24f, 8f)
                lineToRelative(9f, 6f)
                lineToRelative(4f, 10f)
                lineToRelative(-4f, 10f)
                lineToRelative(-9f, 6f)
                lineToRelative(-9f, -6f)
                lineToRelative(-4f, -10f)
                lineToRelative(4f, -10f)
                close()
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFF88FFBB)), strokeAlpha = 0.4f, strokeLineWidth = 0.5f) {
                moveTo(24f, 4f)
                lineTo(24f, 44f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFF88FFBB)), strokeAlpha = 0.4f, strokeLineWidth = 0.5f) {
                moveTo(8f, 24f)
                lineTo(40f, 24f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFF88FFBB)), strokeAlpha = 0.4f, strokeLineWidth = 0.5f) {
                moveTo(12f, 12f)
                lineTo(36f, 36f)
            }
            path(fill = SolidColor(Color.Black), fillAlpha = 0.4f, stroke = SolidColor(Color(0xFF88FFBB)), strokeAlpha = 0.4f, strokeLineWidth = 0.5f) {
                moveTo(36f, 12f)
                lineTo(12f, 36f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2.5f, strokeLineCap = Round) {
                moveTo(20f, 10f)
                quadTo(28f, 16f, 20f, 22f)
                quadTo(28f, 28f, 20f, 34f)
                quadTo(28f, 40f, 24f, 44f)
            }
            path(fill = SolidColor(Color(0xFFFF4400))) {
                moveTo(21f, 10f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(fill = SolidColor(Color.Yellow)) {
                moveTo(21f, 10f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
        }
        .build()
        return _gameEmerald!!
    }

private var _gameEmerald: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameEmerald, contentDescription = null)
    }
}
