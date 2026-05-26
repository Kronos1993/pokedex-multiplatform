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

val Icons.LevelUp: ImageVector
    get() {
        if (_levelUp != null) {
            return _levelUp!!
        }
        _levelUp = Builder(
            name = "LevelUp", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 16f, 
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFFFBC02D)), pathFillType = EvenOdd) {
                moveTo(12.586f, 5f)
                lineTo(10f, 5f)
                curveTo(9.448f, 5f, 9f, 4.552f, 9f, 4f)
                curveTo(9f, 3.448f, 9.448f, 3f, 10f, 3f)
                lineTo(15f, 3f)
                curveTo(15.552f, 3f, 16f, 3.448f, 16f, 4f)
                lineTo(16f, 9f)
                curveTo(16f, 9.552f, 15.552f, 10f, 15f, 10f)
                curveTo(14.448f, 10f, 14f, 9.552f, 14f, 9f)
                lineTo(14f, 6.414f)
                lineTo(9.707f, 10.707f)
                curveTo(9.317f, 11.098f, 8.683f, 11.098f, 8.293f, 10.707f)
                lineTo(6f, 8.414f)
                lineTo(1.707f, 12.707f)
                curveTo(1.317f, 13.098f, 0.683f, 13.098f, 0.293f, 12.707f)
                curveTo(-0.098f, 12.317f, -0.098f, 11.683f, 0.293f, 11.293f)
                lineTo(5.293f, 6.293f)
                curveTo(5.683f, 5.902f, 6.317f, 5.902f, 6.707f, 6.293f)
                lineTo(9f, 8.586f)
                lineTo(12.586f, 5f)
                close()
            }
        }
        .build()
        return _levelUp!!
    }

private var _levelUp: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.LevelUp, contentDescription = null)
    }
}
