package com.kronos.mutliplatform.pokedex.features.natures.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.NatureDecreaseStatContainerColor
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.NatureDecreaseStatIconColor
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.NatureIncreaseStatContainerColor
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.NatureIncreaseStatIconColor
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.nature.NatureDetail
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.nature_detail_info_screen_decreased_stat
import pokedex.shared.generated.resources.nature_detail_info_screen_hates_flavor
import pokedex.shared.generated.resources.nature_detail_info_screen_increased_stat
import pokedex.shared.generated.resources.nature_detail_info_screen_info_title
import pokedex.shared.generated.resources.nature_detail_info_screen_likes_flavor

@Composable
fun NatureInfoCard(
    natureDetail: NatureDetail,
    modifier: Modifier = Modifier,
) {
    NatureSectionCard(
        title = stringResource(Res.string.nature_detail_info_screen_info_title),
        modifier = modifier,
    ) {
        NatureStatRow(
            increasedStat = natureDetail.increasedStat,
            decreasedStat = natureDetail.decreasedStat,
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
            thickness = 1.dp,
        )

        NatureFlavorRow(
            likesFlavor = natureDetail.likesFlavor,
            hatesFlavor = natureDetail.hatesFlavor,
        )
    }
}

@Composable
private fun NatureStatRow(
    increasedStat: String?,
    decreasedStat: String?,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        NatureStatItem(
            label = stringResource(Res.string.nature_detail_info_screen_increased_stat),
            value = increasedStat,
            modifier = Modifier.weight(1f),
            icon = {
                if (!increasedStat.isNullOrBlank()) {
                    StatDirectionBadge(isIncrease = true)
                }
            },
        )
        NatureStatItem(
            label = stringResource(Res.string.nature_detail_info_screen_decreased_stat),
            value = decreasedStat,
            modifier = Modifier.weight(1f),
            icon = {
                if (!decreasedStat.isNullOrBlank()) {
                    StatDirectionBadge(isIncrease = false)
                }
            },
        )
    }
}

@Composable
private fun NatureFlavorRow(
    likesFlavor: String?,
    hatesFlavor: String?,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        NatureStatItem(
            label = stringResource(Res.string.nature_detail_info_screen_likes_flavor),
            value = likesFlavor,
            modifier = Modifier.weight(1f),
            icon = {
                if (!likesFlavor.isNullOrBlank()) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(16.dp),
                    )
                }
            },
        )
        NatureStatItem(
            label = stringResource(Res.string.nature_detail_info_screen_hates_flavor),
            value = hatesFlavor,
            modifier = Modifier.weight(1f),
            icon = {
                if (!hatesFlavor.isNullOrBlank()) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp),
                    )
                }
            },
        )
    }
}

@Composable
private fun NatureStatItem(
    label: String,
    value: String?,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        LabelText(
            text = label,
            size = ComponentSize.SMALL,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            icon?.invoke()
            TitleText(
                text = value?.replaceFirstChar { it.uppercase() }.orEmpty().ifBlank { "—" },
                size = ComponentSize.SMALL,
                fontWeight = FontWeight.Medium,
                textColor = if (value.isNullOrBlank())
                    MaterialTheme.colorScheme.onSurfaceVariant
                else
                    MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
private fun StatDirectionBadge(isIncrease: Boolean) {
    val containerColor = if (isIncrease)
        NatureIncreaseStatContainerColor
    else
        NatureDecreaseStatContainerColor
    val contentColor = if (isIncrease)
        NatureIncreaseStatIconColor
    else
        NatureDecreaseStatIconColor
    val icon = if (isIncrease) Icons.Filled.ArrowUpward else Icons.Filled.ArrowDownward

    Box(
        modifier = Modifier
            .size(18.dp)
            .clip(CircleShape)
            .background(containerColor),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.size(11.dp),
        )
    }
}

// ── Reusable section card (mismo patrón que MoveSectionCard) ──────────────────

@Composable
fun NatureSectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BaseCardView(
        modifier = modifier.fillMaxWidth(),
        cardBackgroundColor = MaterialTheme.colorScheme.surfaceContainerLow,
        elevation = 0.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 4.dp, height = 16.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(MaterialTheme.colorScheme.primary),
                )
                TitleText(
                    text = title,
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.onSurface,
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                thickness = 1.dp,
            )

            Column(modifier = Modifier.padding(16.dp)) {
                content()
            }
        }
    }
}

// ── Preview data ──────────────────────────────────────────────────────────────
@Preview
@Composable
fun NatureInfoCardPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // Con stats y flavors
            NatureInfoCard(
                natureDetail = NatureDetail(
                    increasedStat = "speed",
                    decreasedStat = "special-attack",
                    likesFlavor = "spicy",
                    hatesFlavor = "dry",
                    name = "jolly",
                    names = listOf(
                        Name(language = NamedResourceApi("en"), name = "Jolly"),
                        Name(language = NamedResourceApi("es"), name = "Alegre"),
                    ),
                ),
            )

            // Naturaleza neutra (sin efecto)
            NatureInfoCard(
                natureDetail = NatureDetail(
                    increasedStat = null,
                    decreasedStat = null,
                    likesFlavor = null,
                    hatesFlavor = null,
                    name = "serious",
                    names = listOf(
                        Name(language = NamedResourceApi("en"), name = "Serious"),
                        Name(language = NamedResourceApi("es"), name = "Seria"),
                    ),
                ),
            )
        }
    }
}