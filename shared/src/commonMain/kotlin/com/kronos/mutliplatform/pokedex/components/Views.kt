package com.kronos.mutliplatform.pokedex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.button.Button
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonStyle
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.button_text_refresh


@Composable
fun EmptyList(
    title: String,
    subtitle: String,
    showRetryButton: Boolean = false,
    onRetryClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Pokeball,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(16.dp))
        TitleText(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        BodyText(
            text = subtitle,
            textAlign = TextAlign.Center
        )
        if (showRetryButton){
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                text = stringResource(Res.string.button_text_refresh),
                onClick = {
                    onRetryClick?.invoke()
                },
                type = ButtonType.OUTLINED,
                style = ButtonStyle.PRIMARY
            )
        }
    }
}

