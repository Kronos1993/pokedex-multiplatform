package com.kronos.mutliplatform.pokedex.core.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseCardView(
    modifier: Modifier = Modifier,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    elevation: Dp = 4.dp,
    borderStroke: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit,
) {
    val animatedElevation by animateDpAsState(
        targetValue = if (interactionSource != null && onClick != null) {
            val isPressed by interactionSource.collectIsPressedAsState()
            if (isPressed) elevation / 2 else elevation
        } else elevation,
        animationSpec = tween(
            durationMillis = 200,
            easing = FastOutSlowInEasing
        ),
        label = "card_elevation"
    )

    Card(
        modifier = modifier
            .padding(4.dp)
            .then(
                if (onClick != null && interactionSource != null) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = LocalIndication.current
                    ) { onClick() }
                } else {
                    Modifier
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = animatedElevation
        ),
        border = borderStroke
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpressiveBaseCardView(
    modifier: Modifier = Modifier,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    elevation: Dp = 4.dp,
    borderStroke: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val animatedElevation by animateDpAsState(
        targetValue = if (isPressed) elevation / 2 else elevation,
        animationSpec = tween(
            durationMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "card_elevation"
    )

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "card_scale"
    )

    Card(
        modifier = modifier
            .padding(4.dp)
            .scale(scale)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = ripple()
                    ) { onClick() }
                } else {
                    Modifier
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor
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
fun BaseCardViewPreview() {
    val interactionSource = remember { MutableInteractionSource() }

    MaterialTheme {
        BaseCardView(
            interactionSource = interactionSource,
            onClick = {}
        ) {
            Column(Modifier.padding(16.dp)) {
                TitleText("Base Card")
                Spacer(Modifier.height(8.dp))
                BodyText("This is a simple card content")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaseCardViewNoClickPreview() {
    MaterialTheme {
        BaseCardView {
            Column(Modifier.padding(16.dp)) {
                TitleText("Static Card")
                BodyText("No interaction")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpressiveBaseCardViewPreview() {
    MaterialTheme {
        ExpressiveBaseCardView(
            onClick = {}
        ) {
            Column(Modifier.padding(16.dp)) {
                TitleText("Expressive Card")
                Spacer(Modifier.height(8.dp))
                BodyText("Press me 👇")
            }
        }
    }
}