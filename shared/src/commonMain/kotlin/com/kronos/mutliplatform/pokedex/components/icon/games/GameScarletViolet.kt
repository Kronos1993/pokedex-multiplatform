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

val Games.GameScarletViolet: ImageVector
    get() {
        if (_gameScarletViolet != null) {
            return _gameScarletViolet!!
        }
        _gameScarletViolet = Builder(
            name = "GameScarletViolet", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFCC2200))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6600CC))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF6644)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(4f, 10f)
                quadTo(12f, 6f, 18f, 14f)
                quadTo(14f, 10f, 16f, 18f)
                quadTo(10f, 16f, 6f, 22f)
                quadTo(2f, 18f, 4f, 10f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF4422)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(4f, 22f)
                quadTo(10f, 18f, 16f, 24f)
                quadTo(12f, 22f, 14f, 30f)
                quadTo(8f, 28f, 4f, 34f)
                quadTo(0f, 28f, 4f, 22f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8844FF)), stroke = SolidColor(Color(0xFFAA66FF)), strokeLineWidth = 1f) {
                moveTo(32f, 16f)
                arcToRelative(6f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = false, 12f, 0f)
                arcToRelative(6f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = false, -12f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAA66FF)), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(34.5f, 16f)
                arcToRelative(3.5f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = false, 7f, 0f)
                arcToRelative(3.5f, 6f, 0f, isMoreThanHalf = true, isPositiveArc = false, -7f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDDBBFF))) {
                moveTo(38f, 16f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(fill = SolidColor(Color(0xFF6622DD)), stroke = SolidColor(Color(0xFF9944FF)), strokeLineWidth = 1f) {
                moveTo(33f, 34f)
                arcToRelative(5f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = false, 10f, 0f)
                arcToRelative(5f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = false, -10f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF9944FF)), fillAlpha = 0.6f, strokeAlpha = 0.6f) {
                moveTo(35f, 34f)
                arcToRelative(3f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = false, 6f, 0f)
                arcToRelative(3f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = false, -6f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCCAAFF))) {
                moveTo(38f, 34f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(fill = SolidColor(Color(0xFF222222)), fillAlpha = 0.4f, strokeAlpha = 0.4f) {
                moveTo(23f, 0f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(48f)
                horizontalLineToRelative(-2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFEE88)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(24f, 4f)
                lineToRelative(3f, 6f)
                lineToRelative(-3f, -2f)
                lineToRelative(-3f, 2f)
                close()
            }
        }
        .build()
        return _gameScarletViolet!!
    }

private var _gameScarletViolet: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameScarletViolet, contentDescription = null)
    }
}
