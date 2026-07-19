package com.kronos.mutliplatform.pokedex.core.ui

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import org.jetbrains.compose.resources.painterResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.ic_app_icon

@Composable
expect fun ConfigureSystemBars(
    darkTheme: Boolean
)


@Composable
fun appIconPainter() = painterResource(Res.drawable.ic_app_icon)

fun Modifier.zoomable(
    minScale: Float = 1f,
    maxScale: Float = 4f
): Modifier = composed {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    this
        .pointerInput(Unit) {
            detectTransformGestures { _, pan, zoom, _ ->
                val newScale = (scale * zoom).coerceIn(minScale, maxScale)

                // Solo permitir pan si hay zoom aplicado
                val maxX = (size.width * (newScale - 1) / 2).coerceAtLeast(0f)
                val maxY = (size.height * (newScale - 1) / 2).coerceAtLeast(0f)

                offset = Offset(
                    x = (offset.x + pan.x * newScale).coerceIn(-maxX, maxX),
                    y = (offset.y + pan.y * newScale).coerceIn(-maxY, maxY)
                )
                scale = newScale
            }
        }
        .pointerInput(Unit) {
            detectTapGestures(
                onDoubleTap = {
                    scale = if (scale > 1f) 1f else 2.5f
                    offset = Offset.Zero
                }
            )
        }
        .graphicsLayer(
            scaleX = scale,
            scaleY = scale,
            translationX = offset.x,
            translationY = offset.y
        )
}
