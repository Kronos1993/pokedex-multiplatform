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

val Icons.Male: ImageVector
    get() {
        if (_male != null) {
            return _male!!
        }
        _male = Builder(
            name = "Male", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 24f, 
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color(0xFF448AFF)), strokeLineWidth = 1.5f, strokeLineCap = strokeCapRound, strokeLineJoin = strokeJoinRound) {
                moveTo(12f, 11f)
                curveTo(9.239f, 11f, 7f, 13.239f, 7f, 16f)
                curveTo(7f, 18.761f, 9.239f, 21f, 12f, 21f)
                curveTo(14.761f, 21f, 17f, 18.761f, 17f, 16f)
                curveTo(17f, 13.239f, 14.761f, 11f, 12f, 11f)
                close()
                moveTo(12f, 11f)
                verticalLineTo(3f)
                moveTo(12f, 3f)
                lineTo(16f, 7f)
                moveTo(12f, 3f)
                lineTo(8f, 7f)
            }
        }
        .build()
        return _male!!
    }

private var _male: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Male, contentDescription = null)
    }
}
