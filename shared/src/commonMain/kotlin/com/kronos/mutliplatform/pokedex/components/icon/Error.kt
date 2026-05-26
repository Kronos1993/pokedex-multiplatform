package com.kronos.mutliplatform.pokedex.components.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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

val Icons.Error: ImageVector
    get() {
        if (_error != null) {
            return _error!!
        }
        _error = Builder(
            name = "Error", 
            defaultWidth = 50.dp, 
            defaultHeight = 50.dp, 
            viewportWidth = 50f, 
            viewportHeight = 50f
        ).apply {
            path(fill = SolidColor(Color(0xFFD75A4A))) {
                moveTo(25f, 25f)
                moveToRelative(-25f, 0f)
                arcToRelative(25f, 25f, 0f, isMoreThanHalf = true, isPositiveArc = true, 50f, 0f)
                arcToRelative(25f, 25f, 0f, isMoreThanHalf = true, isPositiveArc = true, -50f, 0f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color.White), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(16f, 34f)
                lineToRelative(9f, -9f)
                lineToRelative(9f, -9f)
            }
            path(fill = SolidColor(Color.Transparent), stroke = SolidColor(Color.White), strokeLineWidth = 2f, strokeLineCap = Round) {
                moveTo(16f, 16f)
                lineToRelative(9f, 9f)
                lineToRelative(9f, 9f)
            }
        }
        .build()
        return _error!!
    }

private var _error: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Error, contentDescription = null)
    }
}
