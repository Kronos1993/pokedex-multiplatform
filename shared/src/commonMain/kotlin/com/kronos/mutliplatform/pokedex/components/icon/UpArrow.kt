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

val Icons.UpArrow: ImageVector
    get() {
        if (_upArrow != null) {
            return _upArrow!!
        }
        _upArrow = Builder(
            name = "UpArrow", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFF4FBA6F))) {
                moveTo(256f, 0f)
                lineToRelative(-141.24f, 194.21f)
                lineToRelative(97.1f, 0f)
                lineToRelative(0f, 105.93f)
                lineToRelative(88.28f, 0f)
                lineToRelative(0f, -105.93f)
                lineToRelative(97.1f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4FBA6F))) {
                moveTo(282.48f, 335.45f)
                horizontalLineToRelative(-52.97f)
                curveToRelative(-9.71f, 0f, -17.66f, 7.95f, -17.66f, 17.66f)
                reflectiveCurveToRelative(7.95f, 17.66f, 17.66f, 17.66f)
                horizontalLineToRelative(52.97f)
                curveToRelative(9.71f, 0f, 17.66f, -7.95f, 17.66f, -17.66f)
                reflectiveCurveTo(292.19f, 335.45f, 282.48f, 335.45f)
            }
            path(fill = SolidColor(Color(0xFF4FBA6F))) {
                moveTo(282.48f, 406.07f)
                horizontalLineToRelative(-52.97f)
                curveToRelative(-9.71f, 0f, -17.66f, 7.95f, -17.66f, 17.66f)
                curveToRelative(0f, 9.71f, 7.95f, 17.66f, 17.66f, 17.66f)
                horizontalLineToRelative(52.97f)
                curveToRelative(9.71f, 0f, 17.66f, -7.95f, 17.66f, -17.66f)
                curveTo(300.14f, 414.01f, 292.19f, 406.07f, 282.48f, 406.07f)
            }
            path(fill = SolidColor(Color(0xFF4FBA6F))) {
                moveTo(282.48f, 476.69f)
                horizontalLineToRelative(-52.97f)
                curveToRelative(-9.71f, 0f, -17.66f, 7.95f, -17.66f, 17.66f)
                curveToRelative(0f, 9.71f, 7.95f, 17.66f, 17.66f, 17.66f)
                horizontalLineToRelative(52.97f)
                curveToRelative(9.71f, 0f, 17.66f, -7.95f, 17.66f, -17.66f)
                curveTo(300.14f, 484.63f, 292.19f, 476.69f, 282.48f, 476.69f)
            }
        }
        .build()
        return _upArrow!!
    }

private var _upArrow: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.UpArrow, contentDescription = null)
    }
}
