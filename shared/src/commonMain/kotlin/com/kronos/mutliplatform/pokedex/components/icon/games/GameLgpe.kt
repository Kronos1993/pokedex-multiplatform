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

val Games.GameLgpe: ImageVector
    get() {
        if (_gameLgpe != null) {
            return _gameLgpe!!
        }
        _gameLgpe = Builder(
            name = "GameLgpe",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFFDDAA00))) {
                moveTo(0f, 0f)
                horizontalLineTo(24f)
                verticalLineTo(48f)
                horizontalLineTo(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC8844))) {
                moveTo(24f, 0f)
                horizontalLineTo(48f)
                verticalLineTo(48f)
                horizontalLineTo(24f)
                close()
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFFFFCC00)),
                strokeLineWidth = 3f,
                strokeLineCap = Round
            ) {
                moveTo(4f, 36f)
                quadTo(8f, 28f, 14f, 32f)
                quadTo(10f, 26f, 16f, 22f)
                quadTo(14f, 28f, 20f, 28f)
            }
            path(fill = SolidColor(Color(0xFFFFDD00))) {
                moveTo(6f, 18f)
                lineToRelative(4f, -12f)
                lineToRelative(4f, 12f)
                close()
            }
            path(fill = SolidColor(Color(0xFF222222))) {
                moveTo(8f, 18f)
                lineToRelative(2f, -9f)
                lineToRelative(2f, 9f)
                close()
            }
            path(
                fill = SolidColor(Color.Transparent),
                stroke = SolidColor(Color(0xFFCC8844)),
                strokeLineWidth = 3f,
                strokeLineCap = Round
            ) {
                moveTo(44f, 36f)
                quadTo(40f, 28f, 34f, 30f)
                quadTo(38f, 24f, 34f, 18f)
            }
            path(fill = SolidColor(Color(0xFFFFCCAA)), fillAlpha = 0.8f, strokeAlpha = 0.8f) {
                moveTo(28f, 26f)
                quadTo(32f, 22f, 36f, 24f)
                quadTo(38f, 28f, 36f, 32f)
                quadTo(32f, 34f, 28f, 32f)
                quadTo(26f, 28f, 28f, 26f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCC4444))) {
                moveTo(0f, 36f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(4f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(fill = SolidColor(Color(0xFF882222))) {
                moveTo(0f, 36f)
                horizontalLineToRelative(48f)
                verticalLineToRelative(1f)
                horizontalLineToRelative(-48f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFCC4444)),
                stroke = SolidColor(Color(0xFF882222)),
                strokeLineWidth = 1f
            ) {
                moveTo(24f, 38f)
                moveToRelative(-4f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, -8f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(24f, 38f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
        }
            .build()
        return _gameLgpe!!
    }

private var _gameLgpe: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Games.GameLgpe, contentDescription = null)
    }
}
