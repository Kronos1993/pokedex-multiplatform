package com.kronos.mutliplatform.pokedex.core.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseCardView(
    modifier: Modifier = Modifier,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    elevation: Dp = 4.dp,
    pressedElevation: Dp = elevation / 2,
    borderStroke: BorderStroke? = null,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    val isPressed by interactionSource.collectIsPressedAsState()

    val animatedElevation by animateDpAsState(
        targetValue = when {
            onClick != null && isPressed -> pressedElevation
            else -> elevation
        },
        animationSpec = tween(
            durationMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "card_elevation"
    )

    Card(
        modifier = modifier,
        interactionSource = interactionSource,
        enabled = enabled,
        onClick = onClick ?: {},
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = animatedElevation
        ),
        border = borderStroke
    ) {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun BaseCardViewNoClickPreview() {
    AppTheme {
        BaseCardView {
            Column(Modifier.padding(16.dp)) {
                TitleText("Static Card")
                BodyText("No interaction")
            }
        }
    }
}
