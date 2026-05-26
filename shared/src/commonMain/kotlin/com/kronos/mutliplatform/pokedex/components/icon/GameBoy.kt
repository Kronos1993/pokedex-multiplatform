package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Icons.GameBoy: ImageVector
    get() {
        if (_gameBoy != null) {
            return _gameBoy!!
        }
        _gameBoy = Builder(
            name = "GameBoy", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 64f, 
            viewportHeight = 64f
        ).apply {
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(54f, 61f)
                curveTo(54f, 62.1f, 53.1f, 63f, 52f, 63f)
                lineTo(12f, 63f)
                curveTo(10.9f, 63f, 10f, 62.1f, 10f, 61f)
                lineTo(10f, 3f)
                curveTo(10f, 1.9f, 10.9f, 1f, 12f, 1f)
                lineTo(52f, 1f)
                curveTo(53.1f, 1f, 54f, 1.9f, 54f, 3f)
                lineTo(54f, 61f)
                lineTo(54f, 61f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(48f, 32f)
                curveTo(48f, 33.1f, 47.1f, 34f, 46f, 34f)
                lineTo(18f, 34f)
                curveTo(16.9f, 34f, 16f, 33.1f, 16f, 32f)
                lineTo(16f, 10f)
                curveTo(16f, 8.9f, 16.9f, 8f, 18f, 8f)
                lineTo(46f, 8f)
                curveTo(47.1f, 8f, 48f, 8.9f, 48f, 10f)
                lineTo(48f, 32f)
                lineTo(48f, 32f)
                close()
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(22f, 43f)
                lineTo(22f, 53f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(17f, 48f)
                lineTo(27f, 48f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(45f, 46f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF6B6C6E)), strokeLineWidth = 2f, pathFillType = EvenOdd) {
                moveTo(38f, 54f)
                moveToRelative(-3f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, 6f, 0f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = true, isPositiveArc = true, -6f, 0f)
            }
        }
        .build()
        return _gameBoy!!
    }

private var _gameBoy: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.GameBoy, contentDescription = null)
    }
}
