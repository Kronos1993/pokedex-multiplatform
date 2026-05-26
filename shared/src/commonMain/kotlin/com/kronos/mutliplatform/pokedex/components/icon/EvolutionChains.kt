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

val Icons.EvolutionChains: ImageVector
    get() {
        if (_evolutionChains != null) {
            return _evolutionChains!!
        }
        _evolutionChains = Builder(
            name = "EvolutionChains", 
            defaultWidth = 800.dp, 
            defaultHeight = 800.dp, 
            viewportWidth = 512f, 
            viewportHeight = 512f
        ).apply {
            path(fill = SolidColor(Color(0xFF6FC5D6))) {
                moveTo(82.97f, 269.94f)
                lineToRelative(-50.16f, 50.16f)
                curveToRelative(-43.75f, 43.75f, -43.75f, 115.34f, 0f, 159.09f)
                reflectiveCurveToRelative(115.34f, 43.75f, 159.09f, 0f)
                lineToRelative(50.16f, -50.16f)
                curveToRelative(43.75f, -43.75f, 43.75f, -115.34f, 0f, -159.09f)
                reflectiveCurveTo(126.72f, 226.19f, 82.97f, 269.94f)
                close()
                moveTo(210.24f, 397.21f)
                lineToRelative(-50.16f, 50.16f)
                curveToRelative(-26.32f, 26.32f, -69.14f, 26.32f, -95.45f, 0f)
                curveToRelative(-26.32f, -26.32f, -26.32f, -69.14f, 0f, -95.45f)
                lineToRelative(50.16f, -50.16f)
                curveToRelative(26.32f, -26.32f, 69.14f, -26.32f, 95.45f, 0f)
                curveTo(236.56f, 328.07f, 236.56f, 370.89f, 210.24f, 397.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6FC5D6))) {
                moveTo(320.1f, 32.81f)
                lineToRelative(-50.16f, 50.16f)
                curveToRelative(-43.75f, 43.75f, -43.75f, 115.34f, 0f, 159.09f)
                reflectiveCurveToRelative(115.34f, 43.75f, 159.09f, 0f)
                lineToRelative(50.16f, -50.16f)
                curveToRelative(43.75f, -43.75f, 43.75f, -115.34f, 0f, -159.09f)
                reflectiveCurveTo(363.85f, -10.94f, 320.1f, 32.81f)
                close()
                moveTo(447.37f, 160.08f)
                lineToRelative(-50.16f, 50.16f)
                curveToRelative(-26.32f, 26.32f, -69.14f, 26.32f, -95.45f, 0f)
                curveToRelative(-26.32f, -26.32f, -26.32f, -69.14f, 0f, -95.45f)
                lineToRelative(50.16f, -50.16f)
                curveToRelative(26.32f, -26.32f, 69.14f, -26.32f, 95.45f, 0f)
                curveTo(473.69f, 90.95f, 473.69f, 133.77f, 447.37f, 160.08f)
                close()
            }
            path(fill = SolidColor(Color(0xFF609399))) {
                moveTo(357.45f, 186.37f)
                curveToRelative(8.79f, -8.79f, 8.79f, -23.03f, 0f, -31.82f)
                curveToRelative(-8.79f, -8.79f, -23.03f, -8.79f, -31.82f, 0f)
                curveToRelative(-0.59f, 0.59f, -170.65f, 170.65f, -171.08f, 171.08f)
                curveToRelative(-8.79f, 8.79f, -8.79f, 23.03f, 0f, 31.82f)
                curveToRelative(8.79f, 8.79f, 23.03f, 8.79f, 31.82f, 0f)
                curveTo(186.78f, 357.04f, 356.83f, 186.99f, 357.45f, 186.37f)
                close()
            }
        }
        .build()
        return _evolutionChains!!
    }

private var _evolutionChains: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.EvolutionChains, contentDescription = null)
    }
}
