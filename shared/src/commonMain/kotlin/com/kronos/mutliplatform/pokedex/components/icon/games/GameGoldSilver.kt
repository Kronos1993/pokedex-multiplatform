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

val Games.GameGoldSilver: ImageVector
    get() {
        if (_gameGoldSilver != null) {
            return _gameGoldSilver!!
        }
        _gameGoldSilver = Builder(
            name = "GameGoldSilver", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFC8A400))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA8A8A8))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333333))) {
                moveTo(0f, 21f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333333))) {
                moveTo(24f, 24f)
                moveToRelative(-7f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, 14f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, -14f, 0f)
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(24f, 24f)
                moveToRelative(-5f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 10f, 0f)
                arcToRelative(5f, 5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -10f, 0f)
            }
            path(fill = SolidColor(Color(0xFFFF4400)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(3f, 8f)
                quadTo(10f, 3f, 18f, 10f)
                quadTo(12f, 14f, 6f, 12f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFFFD700)), strokeLineWidth = 0.8f) {
                moveTo(3f, 8f)
                quadTo(10f, 3f, 18f, 10f)
                quadTo(12f, 14f, 6f, 12f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8888FF)), fillAlpha = 0.9f, strokeAlpha = 0.9f) {
                moveTo(45f, 8f)
                quadTo(38f, 3f, 30f, 10f)
                quadTo(36f, 14f, 42f, 12f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFAAAAFF)), strokeLineWidth = 0.8f) {
                moveTo(45f, 8f)
                quadTo(38f, 3f, 30f, 10f)
                quadTo(36f, 14f, 42f, 12f)
                close()
            }
        }
        .build()
        return _gameGoldSilver!!
    }

private var _gameGoldSilver: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameGoldSilver, contentDescription = null)
    }
}
