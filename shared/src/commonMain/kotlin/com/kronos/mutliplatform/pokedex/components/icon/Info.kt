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

val Icons.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info = Builder(
            name = "Info", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 24f, 
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFE53935)), fillAlpha = 0.5f, strokeAlpha = 0.5f) {
                moveTo(22f, 12f)
                curveTo(22f, 17.523f, 17.523f, 22f, 12f, 22f)
                curveTo(6.477f, 22f, 2f, 17.523f, 2f, 12f)
                curveTo(2f, 6.477f, 6.477f, 2f, 12f, 2f)
                curveTo(17.523f, 2f, 22f, 6.477f, 22f, 12f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 17.75f)
                curveTo(12.414f, 17.75f, 12.75f, 17.414f, 12.75f, 17f)
                verticalLineTo(11f)
                curveTo(12.75f, 10.586f, 12.414f, 10.25f, 12f, 10.25f)
                curveTo(11.586f, 10.25f, 11.25f, 10.586f, 11.25f, 11f)
                verticalLineTo(17f)
                curveTo(11.25f, 17.414f, 11.586f, 17.75f, 12f, 17.75f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 7f)
                curveTo(12.552f, 7f, 13f, 7.448f, 13f, 8f)
                curveTo(13f, 8.552f, 12.552f, 9f, 12f, 9f)
                curveTo(11.448f, 9f, 11f, 8.552f, 11f, 8f)
                curveTo(11f, 7.448f, 11.448f, 7f, 12f, 7f)
                close()
            }
        }
        .build()
        return _info!!
    }

private var _info: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Info, contentDescription = null)
    }
}
