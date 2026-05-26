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

val PokemonTypes.Rock: ImageVector
    get() {
        if (_rock != null) {
            return _rock!!
        }
        _rock = Builder(
            name = "Rock", 
            defaultWidth = 256.dp, 
            defaultHeight = 256.dp, 
            viewportWidth = 256f, 
            viewportHeight = 256f
        ).apply {
            path(fill = SolidColor(Color(0xFFA9A481))) {
                moveTo(128f, 128f)
                moveToRelative(-128f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, 256f, 0f)
                arcToRelative(128f, 128f, 0f, isMoreThanHalf = true, isPositiveArc = true, -256f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(199.67f, 98.23f)
                lineToRelative(-19.62f, -19.62f)
                lineToRelative(3.55f, 23.38f)
                curveToRelative(0.03f, 0.19f, -0.2f, 0.31f, -0.34f, 0.17f)
                lineToRelative(-29.18f, -29.18f)
                curveToRelative(-0.14f, -0.14f, -0.02f, -0.37f, 0.17f, -0.34f)
                lineToRelative(23.38f, 3.55f)
                lineToRelative(-19.87f, -19.87f)
                reflectiveCurveToRelative(-0.09f, -0.06f, -0.14f, -0.06f)
                horizontalLineToRelative(-59.26f)
                curveToRelative(-0.05f, 0f, -0.1f, 0.02f, -0.14f, 0.06f)
                lineToRelative(-41.9f, 41.9f)
                reflectiveCurveToRelative(-0.06f, 0.09f, -0.06f, 0.14f)
                verticalLineToRelative(59.26f)
                curveToRelative(0f, 0.05f, 0.02f, 0.1f, 0.06f, 0.14f)
                lineToRelative(19.53f, 19.53f)
                lineToRelative(-9.71f, -45.05f)
                curveToRelative(-0.04f, -0.19f, 0.2f, -0.32f, 0.34f, -0.18f)
                lineToRelative(57.77f, 57.77f)
                curveToRelative(0.14f, 0.14f, 0.01f, 0.38f, -0.18f, 0.34f)
                lineToRelative(-45.05f, -9.71f)
                lineToRelative(19.21f, 19.21f)
                reflectiveCurveToRelative(0.09f, 0.06f, 0.14f, 0.06f)
                horizontalLineToRelative(59.26f)
                curveToRelative(0.05f, 0f, 0.1f, -0.02f, 0.14f, -0.06f)
                lineToRelative(19.24f, -19.24f)
                lineToRelative(-45.14f, 9.75f)
                curveToRelative(-0.19f, 0.04f, -0.32f, -0.2f, -0.18f, -0.34f)
                lineToRelative(57.76f, -57.76f)
                curveToRelative(0.14f, -0.14f, 0.38f, -0.01f, 0.34f, 0.18f)
                lineToRelative(-9.75f, 45.14f)
                lineToRelative(19.64f, -19.64f)
                reflectiveCurveToRelative(0.06f, -0.09f, 0.06f, -0.14f)
                verticalLineToRelative(-59.26f)
                curveToRelative(0f, -0.05f, -0.02f, -0.1f, -0.06f, -0.14f)
                close()
            }
        }
        .build()
        return _rock!!
    }

private var _rock: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokemonTypes.Rock, contentDescription = null)
    }
}
