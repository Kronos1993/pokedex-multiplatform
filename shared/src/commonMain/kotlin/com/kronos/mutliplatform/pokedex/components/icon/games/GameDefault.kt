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

val Games.GameDefault: ImageVector
    get() {
        if (_gameDefault != null) {
            return _gameDefault!!
        }
        _gameDefault = Builder(
            name = "GameDefault", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFDDDDDD)), stroke = SolidColor(Color.Gray), strokeLineWidth = 1.5f) {
                moveTo(24f, 24f)
                moveToRelative(-22f, 0f)
                arcToRelative(22f, 22f, 0f, isMoreThanHalf = true, isPositiveArc = true, 44f, 0f)
                arcToRelative(22f, 22f, 0f, isMoreThanHalf = true, isPositiveArc = true, -44f, 0f)
            }
            path(fill = SolidColor(Color(0xFFCC2200))) {
                moveTo(2f, 24f)
                arcTo(22f, 22f, 0f, isMoreThanHalf = false, isPositiveArc = true, 46f, 24f)
                lineTo(38f, 24f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10f, 24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEEEEEE))) {
                moveTo(2f, 24f)
                arcTo(22f, 22f, 0f, isMoreThanHalf = false, isPositiveArc = false, 46f, 24f)
                lineTo(38f, 24f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 10f, 24f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(2f, 22f)
                horizontalLineToRelative(44f)
                verticalLineToRelative(4f)
                horizontalLineToRelative(-44f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
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
        }
        .build()
        return _gameDefault!!
    }

private var _gameDefault: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameDefault, contentDescription = null)
    }
}
