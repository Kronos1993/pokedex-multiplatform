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

val Icons.Backpack: ImageVector
    get() {
        if (_backpack != null) {
            return _backpack!!
        }
        _backpack = Builder(
            name = "Backpack", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 36f, 
            viewportHeight = 36f
        ).apply {
            path(fill = SolidColor(Color(0xFFC1694F))) {
                moveTo(11.946f, 27f)
                curveTo(-1.036f, 7.876f, 7.524f, 2.752f, 9.114f, 2f)
                curveToRelative(0.149f, -0.07f, 0.242f, -0.105f, 0.245f, -0.107f)
                arcTo(0.998f, 0.998f, 0f, isMoreThanHalf = false, isPositiveArc = false, 9.888f, 0.768f)
                arcTo(1.01f, 1.01f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8.903f, 0f)
                horizontalLineTo(4.847f)
                curveTo(1.054f, 0f, -4.282f, 11f, 5.859f, 28f)
                curveToRelative(0.151f, 0.253f, 5.073f, 0f, 5.073f, 0f)
                curveToRelative(0.559f, 0f, 1.324f, -0.541f, 1.014f, -1f)
                close()
                moveTo(31.229f, 0f)
                horizontalLineToRelative(-4f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.45f, 1.893f)
                curveToRelative(0.004f, 0.002f, 0.095f, 0.037f, 0.242f, 0.107f)
                curveToRelative(1.568f, 0.752f, 10.01f, 5.876f, -2.792f, 25f)
                curveToRelative(-0.307f, 0.459f, 0.448f, 1f, 1f, 1f)
                curveToRelative(0f, 0f, 4.854f, 0.253f, 5.002f, 0f)
                curveToRelative(10f, -17f, 4.739f, -28f, 0.998f, -28f)
                close()
            }
            path(fill = SolidColor(Color(0xFF662113))) {
                moveTo(6.889f, 28.836f)
                lineToRelative(0.004f, 0.01f)
                curveToRelative(-0.064f, -0.293f, 5.363f, -1.387f, 5.053f, -1.846f)
                curveTo(-1.036f, 7.876f, 7.524f, 2.752f, 9.114f, 2f)
                horizontalLineTo(4.845f)
                curveTo(1.053f, 2f, -3.268f, 13f, 6.889f, 28.836f)
                close()
                moveTo(31.231f, 2f)
                horizontalLineToRelative(-4.21f)
                curveToRelative(1.568f, 0.752f, 10.01f, 5.876f, -2.792f, 25f)
                curveToRelative(-0.307f, 0.459f, 4.984f, 1.839f, 4.986f, 1.836f)
                curveTo(39.231f, 13f, 34.971f, 2f, 31.231f, 2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC1694F))) {
                moveTo(9.916f, 8f)
                arcToRelative(1.007f, 1.007f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.015f, -1f)
                curveToRelative(0f, -3.316f, -2.028f, -5f, -4.056f, -5f)
                curveToRelative(-0.47f, 0f, -0.08f, -0.782f, 0.029f, -1.232f)
                curveToRelative(0.11f, -0.45f, 0.516f, -0.768f, 0.985f, -0.768f)
                horizontalLineToRelative(5.071f)
                curveToRelative(3.791f, 0f, 4.938f, 6.136f, 5.057f, 6.835f)
                arcToRelative(0.993f, 0.993f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.226f, 0.811f)
                arcToRelative(1.026f, 1.026f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.775f, 0.354f)
                horizontalLineToRelative(-5.07f)
                close()
                moveTo(26.231f, 8f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                curveToRelative(0f, -3.316f, 2f, -5f, 4f, -5f)
                curveToRelative(0.463f, 0f, 0.078f, -0.782f, -0.029f, -1.232f)
                arcTo(0.998f, 0.998f, 0f, isMoreThanHalf = false, isPositiveArc = false, 30.231f, 0f)
                horizontalLineToRelative(-5f)
                curveToRelative(-3.738f, 0f, -4.869f, 6.136f, -4.986f, 6.835f)
                arcTo(0.999f, 0.999f, 0f, isMoreThanHalf = false, isPositiveArc = false, 21.231f, 8f)
                horizontalLineToRelative(5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBE1931))) {
                moveTo(6f, 32f)
                reflectiveCurveToRelative(0f, 4f, 4f, 4f)
                horizontalLineToRelative(16f)
                reflectiveCurveToRelative(4f, 0f, 4f, -4f)
                verticalLineTo(10f)
                reflectiveCurveToRelative(0f, -4f, -4f, -4f)
                horizontalLineTo(10f)
                curveToRelative(-4f, 0f, -4f, 4f, -4f, 4f)
                verticalLineToRelative(22f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0041E))) {
                moveTo(24f, 28f)
                horizontalLineTo(12f)
                curveToRelative(-2.201f, 0f, -3f, -1.794f, -3f, -3f)
                verticalLineTo(11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 0f)
                verticalLineToRelative(14f)
                curveToRelative(0.012f, 0.45f, 0.195f, 1f, 1f, 1f)
                horizontalLineToRelative(12f)
                curveToRelative(0.45f, -0.012f, 1f, -0.194f, 1f, -1f)
                verticalLineTo(11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                verticalLineToRelative(14f)
                curveToRelative(0f, 2.201f, -1.794f, 3f, -3f, 3f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(16f, 25f)
                reflectiveCurveToRelative(0f, -1f, 1f, -1f)
                horizontalLineToRelative(2f)
                reflectiveCurveToRelative(1f, 0f, 1f, 1f)
                verticalLineToRelative(5f)
                reflectiveCurveToRelative(0f, 1f, -1f, 1f)
                horizontalLineToRelative(-2f)
                reflectiveCurveToRelative(-1f, 0f, -1f, -1f)
                verticalLineToRelative(-5f)
                close()
            }
        }
        .build()
        return _backpack!!
    }

private var _backpack: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Backpack, contentDescription = null)
    }
}
