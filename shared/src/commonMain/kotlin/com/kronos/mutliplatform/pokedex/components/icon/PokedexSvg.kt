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

val Icons.PokedexSvg: ImageVector
    get() {
        if (_pokedexSvg != null) {
            return _pokedexSvg!!
        }
        _pokedexSvg = Builder(
            name = "PokedexSvg", 
            defaultWidth = 700.dp, 
            defaultHeight = 700.dp, 
            viewportWidth = 700f, 
            viewportHeight = 700f
        ).apply {
            path(fill = SolidColor(Color(0xFFDF5757))) {
                moveTo(224f, 70f)
                lineTo(476f, 70f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 84f)
                lineTo(490f, 306f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 476f, 320f)
                lineTo(224f, 320f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 306f)
                lineTo(210f, 84f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 224f, 70f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8FA2AC))) {
                moveTo(243f, 92f)
                lineTo(457f, 92f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 465f, 100f)
                lineTo(465f, 289f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 457f, 297f)
                lineTo(243f, 297f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 235f, 289f)
                lineTo(235f, 100f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 243f, 92f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBFE3F3))) {
                moveTo(251f, 104f)
                lineTo(449f, 104f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 453f, 108f)
                lineTo(453f, 281f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 449f, 285f)
                lineTo(251f, 285f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 247f, 281f)
                lineTo(247f, 108f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 251f, 104f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5F6F80))) {
                moveTo(186f, 108f)
                lineTo(208f, 108f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 212f, 112f)
                lineTo(212f, 158f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 208f, 162f)
                lineTo(186f, 162f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 182f, 158f)
                lineTo(182f, 112f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 186f, 108f)
                close()
            }
            path(fill = SolidColor(Color(0xFF9BA9B0)), fillAlpha = 0.55f, strokeAlpha = 0.55f) {
                moveTo(190f, 114f)
                lineTo(198f, 114f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 200f, 116f)
                lineTo(200f, 120f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 198f, 122f)
                lineTo(190f, 122f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 188f, 120f)
                lineTo(188f, 116f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 190f, 114f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC0392B))) {
                moveTo(214f, 318f)
                lineTo(486f, 318f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 322f)
                lineTo(490f, 336f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 486f, 340f)
                lineTo(214f, 340f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 336f)
                lineTo(210f, 322f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 214f, 318f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA93226))) {
                moveTo(212f, 324f)
                lineTo(488f, 324f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 326f)
                lineTo(490f, 332f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 488f, 334f)
                lineTo(212f, 334f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 332f)
                lineTo(210f, 326f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 212f, 324f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD0D3D4))) {
                moveTo(210f, 338f)
                lineTo(490f, 338f)
                arcTo(115f, 115f, 0f, isMoreThanHalf = false, isPositiveArc = true, 605f, 453f)
                lineTo(605f, 453f)
                arcTo(115f, 115f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 568f)
                lineTo(210f, 568f)
                arcTo(115f, 115f, 0f, isMoreThanHalf = false, isPositiveArc = true, 95f, 453f)
                lineTo(95f, 453f)
                arcTo(115f, 115f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 338f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE2E5E7)), stroke = SolidColor(Color(0xFFBCC0C2)), strokeLineWidth = 1f) {
                moveTo(210f, 342f)
                lineTo(490f, 342f)
                arcTo(111f, 111f, 0f, isMoreThanHalf = false, isPositiveArc = true, 601f, 453f)
                lineTo(601f, 453f)
                arcTo(111f, 111f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 564f)
                lineTo(210f, 564f)
                arcTo(111f, 111f, 0f, isMoreThanHalf = false, isPositiveArc = true, 99f, 453f)
                lineTo(99f, 453f)
                arcTo(111f, 111f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 342f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF5757))) {
                moveTo(224f, 338f)
                lineTo(476f, 338f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 490f, 352f)
                lineTo(490f, 554f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 476f, 568f)
                lineTo(224f, 568f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 210f, 554f)
                lineTo(210f, 352f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 224f, 338f)
                close()
            }
            path(fill = SolidColor(Color(0xFF8FA2AC))) {
                moveTo(243f, 360f)
                lineTo(457f, 360f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 465f, 368f)
                lineTo(465f, 532f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 457f, 540f)
                lineTo(243f, 540f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 235f, 532f)
                lineTo(235f, 368f)
                arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 243f, 360f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBFE3F3))) {
                moveTo(251f, 372f)
                lineTo(449f, 372f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 453f, 376f)
                lineTo(453f, 524f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 449f, 528f)
                lineTo(251f, 528f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 247f, 524f)
                lineTo(247f, 376f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 251f, 372f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5F6F80))) {
                moveTo(126f, 425f)
                lineTo(192f, 425f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 198f, 431f)
                lineTo(198f, 455f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 192f, 461f)
                lineTo(126f, 461f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 120f, 455f)
                lineTo(120f, 431f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 126f, 425f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5F6F80))) {
                moveTo(147f, 404f)
                lineTo(171f, 404f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 177f, 410f)
                lineTo(177f, 476f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 171f, 482f)
                lineTo(147f, 482f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 141f, 476f)
                lineTo(141f, 410f)
                arcTo(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 147f, 404f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(150f, 440f)
                lineTo(168f, 440f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 170f, 442f)
                lineTo(170f, 444f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 168f, 446f)
                lineTo(150f, 446f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 148f, 444f)
                lineTo(148f, 442f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 150f, 440f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(158f, 432f)
                lineTo(160f, 432f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 162f, 434f)
                lineTo(162f, 452f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 160f, 454f)
                lineTo(158f, 454f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 156f, 452f)
                lineTo(156f, 434f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 158f, 432f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCADABD))) {
                moveTo(540f, 442f)
                moveToRelative(-42f, 0f)
                arcToRelative(42f, 42f, 0f, isMoreThanHalf = true, isPositiveArc = true, 84f, 0f)
                arcToRelative(42f, 42f, 0f, isMoreThanHalf = true, isPositiveArc = true, -84f, 0f)
            }
            path(fill = SolidColor(Color(0xFFA8CA90))) {
                moveTo(540f, 442f)
                moveToRelative(-30f, 0f)
                arcToRelative(30f, 30f, 0f, isMoreThanHalf = true, isPositiveArc = true, 60f, 0f)
                arcToRelative(30f, 30f, 0f, isMoreThanHalf = true, isPositiveArc = true, -60f, 0f)
            }
            path(fill = SolidColor(Color.White), fillAlpha = 0.25f, strokeAlpha = 0.25f) {
                moveTo(530f, 432f)
                moveToRelative(-10f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, 20f, 0f)
                arcToRelative(10f, 10f, 0f, isMoreThanHalf = true, isPositiveArc = true, -20f, 0f)
            }
            path(fill = SolidColor(Color(0xFF88C878))) {
                moveTo(99f, 434f)
                lineTo(99f, 434f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 103f, 438f)
                lineTo(103f, 450f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 99f, 454f)
                lineTo(99f, 454f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 95f, 450f)
                lineTo(95f, 438f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 99f, 434f)
                close()
            }
        }
        .build()
        return _pokedexSvg!!
    }

private var _pokedexSvg: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.PokedexSvg, contentDescription = null)
    }
}
