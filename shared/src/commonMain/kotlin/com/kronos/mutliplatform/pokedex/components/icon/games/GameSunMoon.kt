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

val Games.GameSunMoon: ImageVector
    get() {
        if (_gameSunMoon != null) {
            return _gameSunMoon!!
        }
        _gameSunMoon = Builder(
            name = "GameSunMoon", 
            defaultWidth = 48.dp, 
            defaultHeight = 48.dp, 
            viewportWidth = 48f, 
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFFF8800))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF002266))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFEE00))) {
                moveTo(12f, 24f)
                moveToRelative(-8f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 16f, 0f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -16f, 0f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(12f, 10f)
                lineTo(12f, 14f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(12f, 34f)
                lineTo(12f, 38f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(0f, 24f)
                lineTo(4f, 24f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(20f, 24f)
                lineTo(23f, 24f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(3f, 13f)
                lineTo(6f, 16f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(18f, 16f)
                lineTo(21f, 13f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(3f, 35f)
                lineTo(6f, 32f)
            }
            path(fill = SolidColor(Color.Black), stroke = SolidColor(Color(0xFFFFEE00)), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(18f, 32f)
                lineTo(21f, 35f)
            }
            path(fill = SolidColor(Color(0xFFEEEEFF))) {
                moveTo(44f, 14f)
                quadTo(34f, 16f, 32f, 24f)
                quadTo(34f, 32f, 44f, 34f)
                quadTo(36f, 32f, 36f, 24f)
                quadTo(36f, 16f, 44f, 14f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(28f, 10f)
                moveToRelative(-1.2f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.4f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2.4f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(44f, 20f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(30f, 38f)
                moveToRelative(-1.2f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.4f, 0f)
                arcToRelative(1.2f, 1.2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2.4f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(42f, 42f)
                moveToRelative(-0.8f, 0f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.6f, 0f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.6f, 0f)
            }
        }
        .build()
        return _gameSunMoon!!
    }

private var _gameSunMoon: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameSunMoon, contentDescription = null)
    }
}
