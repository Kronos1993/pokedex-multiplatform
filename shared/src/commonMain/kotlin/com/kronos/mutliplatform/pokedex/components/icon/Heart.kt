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

val Icons.Heart: ImageVector
    get() {
        if (_heart != null) {
            return _heart!!
        }
        _heart = Builder(
            name = "Heart", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 72f, 
            viewportHeight = 72f
        ).apply {
            path(fill = SolidColor(Color(0xFFFF473E))) {
                moveTo(60.1f, 23.3f)
                curveToRelative(-5.9f, -7f, -16.5f, -7.4f, -22.8f, -1f)
                curveToRelative(-0.9f, 0.9f, -2.3f, 0.9f, -3.1f, 0f)
                curveToRelative(-6f, -6.1f, -15.9f, -6.1f, -21.9f, 0f)
                curveToRelative(-5.2f, 5.1f, -6f, 13.4f, -2f, 19.5f)
                curveToRelative(1.2f, 1.9f, 2.8f, 3.4f, 4.5f, 4.5f)
                lineToRelative(19.9f, 16.1f)
                curveToRelative(0.7f, 0.6f, 1.7f, 0.6f, 2.4f, 0f)
                lineToRelative(19.8f, -16.1f)
                curveToRelative(1.7f, -1.1f, 3.2f, -2.5f, 4.4f, -4.4f)
                curveToRelative(3.6f, -5.7f, 3.2f, -13.4f, -1.2f, -18.6f)
                close()
            }
        }
        .build()
        return _heart!!
    }

private var _heart: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Heart, contentDescription = null)
    }
}
