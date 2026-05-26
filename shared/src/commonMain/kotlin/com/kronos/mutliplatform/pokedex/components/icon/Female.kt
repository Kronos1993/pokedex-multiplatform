package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.StrokeCap.Companion.Round as strokeCapRound
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round as strokeJoinRound

val Icons.Female: ImageVector
    get() {
        if (_female != null) {
            return _female!!
        }
        _female = Builder(
            name = "Female", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 24f, 
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFFE040FB)), strokeLineWidth = 1.5f, strokeLineCap = strokeCapRound, strokeLineJoin = strokeJoinRound) {
                moveTo(9f, 18f)
                horizontalLineTo(15f)
                moveTo(12f, 13f)
                verticalLineTo(21f)
                moveTo(12f, 13f)
                curveTo(14.761f, 13f, 17f, 10.761f, 17f, 8f)
                curveTo(17f, 5.239f, 14.761f, 3f, 12f, 3f)
                curveTo(9.239f, 3f, 7f, 5.239f, 7f, 8f)
                curveTo(7f, 10.761f, 9.239f, 13f, 12f, 13f)
                close()
            }
        }
        .build()
        return _female!!
    }

private var _female: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Female, contentDescription = null)
    }
}
