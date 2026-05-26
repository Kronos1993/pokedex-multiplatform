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

val Icons.TmDisk: ImageVector
    get() {
        if (_tmDisk != null) {
            return _tmDisk!!
        }
        _tmDisk = Builder(
            name = "TmDisk", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 24f, 
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFBDC3C7))) {
                moveToRelative(12f, 1f)
                curveToRelative(-6.075f, 0f, -11f, 4.9f, -11f, 11f)
                curveToRelative(0f, 6f, 4.925f, 11f, 11f, 11f)
                curveToRelative(6.075f, 0f, 11f, -5f, 11f, -11f)
                curveToRelative(0f, -6.1f, -4.925f, -11f, -11f, -11f)
                close()
                moveTo(12f, 5f)
                curveToRelative(3.866f, 0f, 7f, 3.1f, 7f, 7f)
                curveToRelative(0f, 3.8f, -3.134f, 7f, -7f, 7f)
                reflectiveCurveToRelative(-7f, -3.2f, -7f, -7f)
                curveToRelative(0f, -3.9f, 3.134f, -7f, 7f, -7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBDC3C7))) {
                moveToRelative(17f, 3.3f)
                curveToRelative(-4.783f, -2.8f, -10.899f, -1.1f, -13.66f, 3.7f)
                curveToRelative(-2.762f, 4.7f, -1.123f, 10.9f, 3.66f, 13.6f)
                curveToRelative(4.783f, 2.8f, 10.899f, 1.1f, 13.66f, -3.6f)
                curveToRelative(2.762f, -4.8f, 1.123f, -10.9f, -3.66f, -13.7f)
                close()
                moveTo(13f, 10.2f)
                curveToRelative(0.957f, 0.6f, 1.284f, 1.8f, 0.732f, 2.8f)
                curveToRelative(-0.552f, 0.9f, -1.775f, 1.2f, -2.732f, 0.7f)
                curveToRelative(-0.957f, -0.6f, -1.284f, -1.8f, -0.732f, -2.7f)
                curveToRelative(0.552f, -1f, 1.775f, -1.3f, 2.732f, -0.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFECF0F1))) {
                moveToRelative(13.5f, 9.4f)
                curveToRelative(-1.435f, -0.9f, -3.27f, -0.4f, -4.098f, 1.1f)
                curveToRelative(-0.828f, 1.4f, -0.337f, 3.2f, 1.098f, 4.1f)
                curveToRelative(1.435f, 0.8f, 3.27f, 0.3f, 4.098f, -1.1f)
                curveToRelative(0.829f, -1.5f, 0.337f, -3.3f, -1.098f, -4.1f)
                close()
                moveTo(13f, 10.2f)
                curveToRelative(0.957f, 0.6f, 1.284f, 1.8f, 0.732f, 2.8f)
                curveToRelative(-0.552f, 0.9f, -1.775f, 1.2f, -2.732f, 0.7f)
                curveToRelative(-0.957f, -0.6f, -1.284f, -1.8f, -0.732f, -2.7f)
                curveToRelative(0.552f, -1f, 1.775f, -1.3f, 2.732f, -0.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFECF0F1))) {
                moveToRelative(6.01f, 3.9f)
                curveToRelative(-2.249f, 1.7f, -3.622f, 4.2f, -3.938f, 6.8f)
                lineToRelative(7.965f, 1f)
                curveToRelative(0.065f, -0.6f, 0.33f, -1f, 0.782f, -1.4f)
                lineToRelative(-4.809f, -6.4f)
                close()
                moveTo(21.923f, 13.1f)
                lineTo(13.985f, 12.1f)
                curveToRelative(-0.065f, 0.6f, -0.357f, 1f, -0.808f, 1.4f)
                lineToRelative(4.809f, 6.4f)
                curveToRelative(2.248f, -1.7f, 3.621f, -4.2f, 3.937f, -6.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBDC3C7))) {
                moveToRelative(12f, 8f)
                curveToRelative(-2.209f, 0f, -4f, 1.8f, -4f, 4f)
                reflectiveCurveToRelative(1.791f, 4f, 4f, 4f)
                curveToRelative(2.209f, 0f, 4f, -1.8f, 4f, -4f)
                reflectiveCurveToRelative(-1.791f, -4f, -4f, -4f)
                close()
                moveTo(12f, 9f)
                curveToRelative(1.657f, 0f, 3f, 1.3f, 3f, 3f)
                curveToRelative(0f, 1.6f, -1.343f, 3f, -3f, 3f)
                reflectiveCurveToRelative(-3f, -1.4f, -3f, -3f)
                curveToRelative(0f, -1.7f, 1.343f, -3f, 3f, -3f)
                close()
            }
        }
        .build()
        return _tmDisk!!
    }

private var _tmDisk: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.TmDisk, contentDescription = null)
    }
}
