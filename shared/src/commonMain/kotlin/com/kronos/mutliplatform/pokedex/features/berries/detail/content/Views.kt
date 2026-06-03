package com.kronos.mutliplatform.pokedex.features.berries.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryFlavor
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryInfo
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.berry_detail_info_screen_firmness
import pokedex.shared.generated.resources.berry_detail_info_screen_flavors
import pokedex.shared.generated.resources.berry_detail_info_screen_growth_time
import pokedex.shared.generated.resources.berry_detail_info_screen_info
import pokedex.shared.generated.resources.berry_detail_info_screen_see_more
import pokedex.shared.generated.resources.berry_detail_info_screen_size
import pokedex.shared.generated.resources.berry_detail_info_screen_smoothness

// ── Screen ────────────────────────────────────────────────────────────────────

@Composable
fun BerryInfoScreen(
    berryInfo: BerryInfo?,
    lang: String,
    onSeeMoreClick: (berry:String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        if (berryInfo != null) {

            // ── Header ─────────────────────────────────────────────────────

            BerryHeaderCard(
                berryInfo = berryInfo,
                lang = lang,
                onSeeMoreClick = onSeeMoreClick,
            )

            // ── Berry Info ────────────────────────────────────────────────

            BerrySectionCard(
                title = stringResource(Res.string.berry_detail_info_screen_info),
            ) {
                BerryInfoContent(berryInfo)
            }

            // ── Berry Flavors ─────────────────────────────────────────────

            BerrySectionCard(
                title = stringResource(Res.string.berry_detail_info_screen_flavors),
            ) {
                BerryFlavorContent(
                    flavors = berryInfo.flavors,
                )
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Section Card
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun BerrySectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BaseCardView(
        modifier = modifier.fillMaxWidth(),
        cardBackgroundColor = MaterialTheme.colorScheme.surfaceContainerLow,
        elevation = 0.dp,
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {

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

            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                content()
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Header
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun BerryHeaderCard(
    berryInfo: BerryInfo,
    lang: String,
    onSeeMoreClick: (berry:String) -> Unit,
) {
    BaseCardView(
        modifier = Modifier.fillMaxWidth(),
        cardBackgroundColor = MaterialTheme.colorScheme.surfaceContainerLow,
        elevation = 0.dp,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalPlatformContext.current)
                        .data(berryInfo.item.sprites.defaultImg)
                        .crossfade(true)
                        .build(),
                    contentDescription = berryInfo.name,
                    modifier = Modifier.size(48.dp)
                )
            }

            TitleText(
                text = berryInfo.getName(lang)
                    .replace("-", " ")
                    .replaceFirstChar { it.uppercase() },
                size = ComponentSize.MEDIUM,
                fontWeight = FontWeight.Bold,
                textColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f),
            )

            LabelText(
                text = stringResource(Res.string.berry_detail_info_screen_see_more),
                textColor = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onSeeMoreClick(berryInfo.itemResource.name)
                },
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Berry Info Content
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun BerryInfoContent(
    berryInfo: BerryInfo,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            BerryStatPill(
                label = stringResource(Res.string.berry_detail_info_screen_firmness),
                value = berryInfo.firmness.name
                    .replace("-", " ")
                    .replaceFirstChar { it.uppercase() },
                modifier = Modifier.weight(1f),
            )

            BerryStatPill(
                label = stringResource(Res.string.berry_detail_info_screen_growth_time),
                value = berryInfo.growthTime.toString(),
                modifier = Modifier.weight(1f),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            BerryStatPill(
                label = stringResource(Res.string.berry_detail_info_screen_smoothness),
                value = berryInfo.smoothness.toString(),
                modifier = Modifier.weight(1f),
            )

            BerryStatPill(
                label = stringResource(Res.string.berry_detail_info_screen_size),
                value = "${berryInfo.size} mm",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Berry Flavor Content
// ─────────────────────────────────────────────────────────────────────────────

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BerryFlavorContent(
    flavors: List<BerryFlavor>,
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        maxItemsInEachRow = 3,
    ) {

        flavors.forEach { flavor ->

            val containerColor = when {
                flavor.potency in 1..5 -> Color(0xffdfc073)
                flavor.potency in 6..10 -> Color(0xffeabb8d)
                flavor.potency > 10 -> Color(0xffda947f)
                else -> MaterialTheme.colorScheme.surfaceContainer
            }

            val textColor = when {
                flavor.potency in 1..5 -> Color(0xff856103)
                flavor.potency in 6..10 -> Color(0xff91451e)
                flavor.potency > 10 -> Color(0xffb10c07)
                else -> MaterialTheme.colorScheme.onSurface
            }

            BaseCardView(
                modifier = Modifier.weight(1f),
                cardBackgroundColor = containerColor,
                elevation = 0.dp,
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {

                    TitleText(
                        text = flavor.potency.toString(),
                        size = ComponentSize.LARGE,
                        fontWeight = FontWeight.Bold,
                        textColor = textColor,
                    )

                    LabelText(
                        text = flavor.flavor.name
                            .replace("-", " ")
                            .replaceFirstChar { it.uppercase() },
                        fontWeight = FontWeight.Bold,
                        textColor = textColor.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Stat Pill
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun BerryStatPill(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {

        TitleText(
            text = value,
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.Bold,
            textColor = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )

        LabelText(
            text = label,
            size = ComponentSize.SMALL,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Previews
// ─────────────────────────────────────────────────────────────────────────────

@Preview
@Composable
private fun PreviewBerryHeaderCard() {
    AppTheme {

        Surface {
            BerryHeaderCard(
                berryInfo = mockBerryInfo(),
                lang = "en",
                onSeeMoreClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBerryInfoContent() {
    AppTheme {

        Surface {
            BerrySectionCard(
                title = "Berry Info",
            ) {
                BerryInfoContent(
                    berryInfo = mockBerryInfo(),
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBerryFlavorContent() {
    AppTheme {

        Surface {
            BerrySectionCard(
                title = "Berry Flavors",
            ) {
                BerryFlavorContent(
                    flavors = mockBerryInfo().flavors,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBerryInfoScreen() {
    AppTheme {

        Surface {
            BerryInfoScreen(
                berryInfo = mockBerryInfo(),
                lang = "en",
                onSeeMoreClick = {},
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Mock Data
// ─────────────────────────────────────────────────────────────────────────────

private fun mockBerryInfo() = BerryInfo(
    id = 1,
    name = "cheri-berry",
    growthTime = 3,
    size = 20,
    smoothness = 25,
    firmness = NamedResourceApi(
        name = "soft",
        url = "",
    ),
    flavors = listOf(
        BerryFlavor(
            potency = 15,
            flavor = NamedResourceApi(
                name = "spicy",
                url = "",
            ),
        ),
        BerryFlavor(
            potency = 10,
            flavor = NamedResourceApi(
                name = "spicy",
                url = "",
            ),
        ),
        BerryFlavor(
            potency = 5,
            flavor = NamedResourceApi(
                name = "sweet",
                url = "",
            ),
        ),
    ),
)