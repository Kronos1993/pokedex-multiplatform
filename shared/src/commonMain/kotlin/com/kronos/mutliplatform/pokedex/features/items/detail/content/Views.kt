package com.kronos.mutliplatform.pokedex.features.items.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.prettyName
import com.kronos.mutliplatform.pokedex.features.pokemon.list.content.PokemonItemCard
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_by_move_list
import pokedex.shared.generated.resources.item_detail_info_screen_category
import pokedex.shared.generated.resources.item_detail_info_screen_cost
import pokedex.shared.generated.resources.item_detail_info_screen_effect
import pokedex.shared.generated.resources.item_detail_info_screen_effect_explanation
import pokedex.shared.generated.resources.item_detail_info_screen_fling_effect
import pokedex.shared.generated.resources.item_detail_info_screen_fling_power
import pokedex.shared.generated.resources.item_detail_info_screen_held_by
import pokedex.shared.generated.resources.item_detail_info_screen_info
import pokedex.shared.generated.resources.item_detail_info_screen_none

// ─────────────────────────────────────────────────────────────────────────────
// Item Info Screen
// ─────────────────────────────────────────────────────────────────────────────

@Composable
fun ItemInfoScreen(
    itemInfo: ItemInfo?,
    lang: String,
    pokemonItemsPerRow: Int = 2,
    pokemonList: List<PokemonDexEntry>,
    onPokemonClick: (PokemonDexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        state = rememberLazyGridState(),
        columns = GridCells.Fixed(pokemonItemsPerRow),
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val fullSpan: LazyGridItemSpanScope.() -> GridItemSpan = { GridItemSpan(maxLineSpan) }

        if (itemInfo != null) {
            item(span = fullSpan) {
                // ── Header Card ─────────────────────────────────────────────────────

                ItemHeaderCard(
                    itemInfo = itemInfo,
                    lang = lang,
                )
            }
            item(span = fullSpan) {
                // ── Info ────────────────────────────────────────────────────────
                ItemSectionCard(
                    title = stringResource(Res.string.item_detail_info_screen_info),
                ) {
                    ItemInfoContent(
                        itemInfo = itemInfo,
                        lang = lang,
                    )
                }
            }
        }

        // ── Pokémon Holding Item ───────────────────────────────────────────

        item(span = fullSpan) {
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
                    text = stringResource(Res.string.item_detail_info_screen_held_by),
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.onSurface,
                )
            }
        }

        if (pokemonList.isEmpty()) {
            item(span = fullSpan) {
                EmptyList(
                    title = stringResource(Res.string.empty_pokemon_by_move_list),
                    modifier = modifier.fillMaxSize(),
                )
            }
        } else {
            items(pokemonList, key = { it.pokemonId }) { entry ->
                PokemonItemCard(
                    item = entry,
                    onClick = { onPokemonClick(entry) },
                    modifier = Modifier,
                )
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Header
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ItemHeaderCard(
    itemInfo: ItemInfo,
    lang: String,
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
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            AsyncImage(
                model = itemInfo.sprites.defaultImg,
                contentDescription = itemInfo.name,
                modifier = Modifier.size(72.dp),
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                LabelText(
                    text = "#${itemInfo.id}",
                    size = ComponentSize.SMALL,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                TitleText(
                    text = itemInfo.getName(lang).prettyName(),
                    size = ComponentSize.MEDIUM,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.onSurface,
                )

                BodyText(
                    text = itemInfo.getDescription(lang)
                        .replace("\n", " ")
                        .ifBlank { "—" },
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 5,
                )
            }
        }
    }
}


// ─────────────────────────────────────────────────────────────────────────────
// Section Card
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ItemSectionCard(
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

            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                content()
            }
        }
    }
}


// ─────────────────────────────────────────────────────────────────────────────
// Item Info Content
// ─────────────────────────────────────────────────────────────────────────────

// ─────────────────────────────────────────────────────────────────────────────
// Item Info Content
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ItemInfoContent(
    itemInfo: ItemInfo,
    lang: String,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        // ── Main Stats ────────────────────────────────────────────────────

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            ItemStatPill(
                label = stringResource(Res.string.item_detail_info_screen_cost),
                value = "$${itemInfo.cost}",
                modifier = Modifier.weight(1f),
            )

            ItemStatPill(
                label = stringResource(Res.string.item_detail_info_screen_category),
                value = itemInfo.category.name
                    .replace("-", " ")
                    .replaceFirstChar { it.uppercase() },
                modifier = Modifier.weight(1f),
            )
        }

        // ── Fling Info ────────────────────────────────────────────────────

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            ItemStatPill(
                label = stringResource(Res.string.item_detail_info_screen_fling_power),
                value = itemInfo.flingPower
                    .takeIf { (it?:0) > 0 }
                    ?.toString()
                    ?: stringResource(Res.string.item_detail_info_screen_none),
                modifier = Modifier.weight(1f),
            )

            ItemStatPill(
                label = stringResource(Res.string.item_detail_info_screen_fling_effect),
                value = itemInfo.flingEffect?.name
                    .takeIf { it.orEmpty().isNotEmpty() }
                    ?.replace("-", " ")
                    ?.replaceFirstChar { it.uppercase() }
                    ?: stringResource(Res.string.item_detail_info_screen_none),
                modifier = Modifier.weight(1f),
            )
        }

        // ── Effects ───────────────────────────────────────────────────────

        ItemTextBlock(
            title = stringResource(Res.string.item_detail_info_screen_effect),
            text = itemInfo.getShortEffect(lang),
        )

        ItemTextBlock(
            title = stringResource(Res.string.item_detail_info_screen_effect_explanation),
            text = itemInfo.getEffect(lang),
        )
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Stat Pill
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ItemStatPill(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
    ) {

        TitleText(
            text = value,
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.ExtraBold,
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
// Text Block
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ItemTextBlock(
    title: String,
    text: String?,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        LabelText(
            text = title,
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.Bold,
            textColor = MaterialTheme.colorScheme.onSurface,
        )

        BodyText(
            text = text
                ?.replace("\n", " ")
                ?.ifBlank { "—" }
                ?: "—",
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
        )
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Previews
// ─────────────────────────────────────────────────────────────────────────────

@Preview
@Composable
private fun PreviewItemInfoContent() {
    AppTheme {

        Surface {
            ItemSectionCard(
                title = "Info",
            ) {
                ItemInfoContent(
                    itemInfo = mockItemInfo(),
                    lang = "en",
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewItemInfoScreen() {
    AppTheme {

        Surface {
            ItemInfoScreen(
                itemInfo = mockItemInfo(),
                lang = "en",
                pokemonList = mockPokemonList(),
                onPokemonClick = {},
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Mock Data
// ─────────────────────────────────────────────────────────────────────────────

private fun mockItemInfo() = ItemInfo(
    id = 1,
    name = "master-ball",
    cost = 0,
    flingPower = 10,
    flingEffect = NamedResourceApi(
        name = "flinch",
        url = "",
    ),
    category = NamedResourceApi(
        name = "standard-balls",
        url = "",
    ),
    sprites = Sprite(
        defaultImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/master-ball.png",
    ),
)

private fun mockPokemonList() = listOf(
    PokemonDexEntry(
        dexEntry = 25,
        pokemonId = 25,
        pokemon = NamedResourceApi("pikachu", "")
    ),
    PokemonDexEntry(
        dexEntry = 6,
        pokemonId = 6,
        pokemon = NamedResourceApi("charizard", "")
    ),
)