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

val Icons.Check: ImageVector
    get() {
        if (_check != null) {
            return _check!!
        }
        _check = Builder(
            name = "Check", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 64f, 
            viewportHeight = 64f
        ).apply {
            path(fill = SolidColor(Color(0xFF4BD37B))) {
                moveTo(32f, 32f)
                moveToRelative(-30f, 0f)
                arcToRelative(30f, 30f, 0f, isMoreThanHalf = true, isPositiveArc = true, 60f, 0f)
                arcToRelative(30f, 30f, 0f, isMoreThanHalf = true, isPositiveArc = true, -60f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(46f, 14f)
                lineTo(25f, 35.6f)
                lineToRelative(-7f, -7.2f)
                lineToRelative(-7f, 7.2f)
                lineTo(25f, 50f)
                lineToRelative(28f, -28.8f)
                close()
            }
        }
        .build()
        return _check!!
    }

private var _check: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Check, contentDescription = null)
    }
}
