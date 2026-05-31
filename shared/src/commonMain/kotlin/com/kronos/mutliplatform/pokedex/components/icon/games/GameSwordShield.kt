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

val Games.GameSwordShield: ImageVector
    get() {
        if (_gameSwordShield != null) {
            return _gameSwordShield!!
        }
        _gameSwordShield = Builder(
            name = "GameSwordShield", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF0044AA))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC3300))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDDDDDD))) {
                moveTo(12f, 6f)
                lineTo(12.5f, 6f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 13.5f, 7f)
                lineTo(13.5f, 33f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12.5f, 34f)
                lineTo(12f, 34f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11f, 33f)
                lineTo(11f, 7f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12f, 6f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDDDDDD))) {
                moveTo(12.25f, 6f)
                lineToRelative(-3.25f, 4f)
                lineToRelative(6.5f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAAAA))) {
                moveTo(8f, 28f)
                lineTo(16.5f, 28f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17.5f, 29f)
                lineTo(17.5f, 30f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16.5f, 31f)
                lineTo(8f, 31f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7f, 30f)
                lineTo(7f, 29f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 28f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAAAAAA))) {
                moveTo(11.5f, 31f)
                lineTo(13f, 31f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 32f)
                lineTo(14f, 36f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 13f, 37f)
                lineTo(11.5f, 37f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 10.5f, 36f)
                lineTo(10.5f, 32f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11.5f, 31f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC3300)), stroke = SolidColor(Color(0xFFFF6644)), strokeLineWidth = 1.2f) {
                moveTo(36f, 6f)
                quadTo(42f, 6f, 44f, 10f)
                lineTo(44f, 26f)
                quadTo(44f, 34f, 36f, 40f)
                quadTo(28f, 34f, 28f, 26f)
                lineTo(28f, 10f)
                quadTo(30f, 6f, 36f, 6f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEE4422)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(36f, 10f)
                quadTo(40f, 10f, 42f, 13f)
                lineTo(42f, 25f)
                quadTo(42f, 32f, 36f, 37f)
                quadTo(30f, 32f, 30f, 25f)
                lineTo(30f, 13f)
                quadTo(32f, 10f, 36f, 10f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFCC00))) {
                moveTo(35.5f, 14f)
                lineTo(36.5f, 14f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 37.5f, 15f)
                lineTo(37.5f, 31f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 36.5f, 32f)
                lineTo(35.5f, 32f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 34.5f, 31f)
                lineTo(34.5f, 15f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 35.5f, 14f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFCC00))) {
                moveTo(30f, 22f)
                lineTo(42f, 22f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 43f, 23f)
                lineTo(43f, 24f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 42f, 25f)
                lineTo(30f, 25f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 29f, 24f)
                lineTo(29f, 23f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 30f, 22f)
                close()
            }
        }
        .build()
        return _gameSwordShield!!
    }

private var _gameSwordShield: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameSwordShield, contentDescription = null)
    }
}
