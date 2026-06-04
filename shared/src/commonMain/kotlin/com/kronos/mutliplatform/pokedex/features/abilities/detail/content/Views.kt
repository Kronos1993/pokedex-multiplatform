package com.kronos.mutliplatform.pokedex.features.abilities.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.AbilityInfo
import com.kronos.mutliplatform.pokedex.domain.model.ability.PokemonWithAbility
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.features.pokemon.list.content.PokemonItemCard
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.ability_detail_info_screen_effect
import pokedex.shared.generated.resources.ability_detail_info_screen_game_description
import pokedex.shared.generated.resources.ability_detail_info_screen_pokemon_title
import pokedex.shared.generated.resources.empty_pokemon_by_move_list

// ── Screen ────────────────────────────────────────────────────────────────────

@Composable
fun AbilityInfoScreen(
    abilityInfo: AbilityInfo?,
    pokemonList: List<PokemonDexEntry>,
    lang: String,
    pokemonItemsPerRow: Int = 2,
    onPokemonClick: (PokemonDexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {

    val gameDescription = remember(abilityInfo, lang) {
        abilityInfo?.getDescription(lang)
    }

    val effectText = remember(abilityInfo, lang) {
        abilityInfo?.getEffect(lang)
    }

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

        // ── Game Description ─────────────────────────────────────────────
        item(span = fullSpan) {
            AbilitySectionCard(
                title = stringResource(Res.string.ability_detail_info_screen_game_description),
            ) {
                AbilityTextContent(
                    text = gameDescription.orEmpty().replace("\n", " "),
                )
            }
        }

        // ── Effect ───────────────────────────────────────────────────────

        if (effectText.orEmpty().isNotBlank()) {
            item(span = fullSpan) {
                AbilitySectionCard(
                    title = stringResource(Res.string.ability_detail_info_screen_effect),
                ) {
                    AbilityTextContent(
                        text = effectText.orEmpty(),
                    )
                }
            }
        }

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
                    text = stringResource(Res.string.ability_detail_info_screen_pokemon_title),
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.onSurface,
                )
            }
        }

        if (pokemonList.isEmpty()) {
            item {
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

// ── Reusable section card ────────────────────────────────────────────────────

@Composable
private fun AbilitySectionCard(
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

// ── Text content ─────────────────────────────────────────────────────────────

@Composable
private fun AbilityTextContent(
    text: String,
    maxHeight: Dp? = null,
    scrollable: Boolean = false,
) {

    val textModifier = if (maxHeight != null) {
        Modifier
            .heightIn(max = maxHeight)
            .then(
                if (scrollable) {
                    Modifier.verticalScroll(rememberScrollState())
                } else {
                    Modifier
                },
            )
    } else {
        Modifier
    }

    BodyText(
        text = text.ifBlank { "—" },
        textColor = MaterialTheme.colorScheme.onSurfaceVariant,
        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
        modifier = textModifier,
    )
}

@Preview
@Composable
private fun AbilitySectionCardPreview() {
    AppTheme {
        Surface {
            AbilitySectionCard(
                title = "Effect",
                modifier = Modifier.padding(16.dp),
            ) {
                AbilityTextContent(
                    text = "This Pokémon is immune to Ground-type moves.",
                )
            }
        }
    }
}

@Preview
@Composable
private fun AbilityTextContentPreview() {
    AppTheme {
        Surface {
            AbilityTextContent(
                text = "Raises Speed sharply when hit by an Electric-type move.",
                maxHeight = 120.dp,
                scrollable = true,
            )
        }
    }
}

@Preview
@Composable
private fun AbilityInfoScreenPreview() {

    val abilityInfo = AbilityInfo(
        id = 26,
        name = "levitate",
        flavorText = listOf(
            FlavorText(
                description = "By floating in the air, the Pokémon receives full immunity to all Ground-type moves.",
                language = "en",
            ),
        ),
        effects = listOf(
            EffectEntry(
                effect = "This Pokémon is immune to Ground-type moves, Spikes, Toxic Spikes, and Arena Trap.",
                shortEffect = "Immune to Ground moves.",
                language = "en",
            ),
        ),
        pokemon = listOf(
            PokemonWithAbility(
                pokemon = NamedResourceApi(
                    name = "gastly",
                    url = "https://pokeapi.co/api/v2/pokemon/92/",
                ),
                isHidden = false,
            ),
            PokemonWithAbility(
                pokemon = NamedResourceApi(
                    name = "haunter",
                    url = "https://pokeapi.co/api/v2/pokemon/93/",
                ),
                isHidden = false,
            ),
            PokemonWithAbility(
                pokemon = NamedResourceApi(
                    name = "gengar",
                    url = "https://pokeapi.co/api/v2/pokemon/94/",
                ),
                isHidden = false,
            ),
        ),
    )

    AppTheme {
        Surface {
            AbilityInfoScreen(
                abilityInfo = abilityInfo,
                lang = "en",
                pokemonItemsPerRow = 2,
                pokemonList = listOf(
                    PokemonDexEntry(
                        dexEntry = 1,
                        pokemonId = 1,
                        pokemon = NamedResourceApi(
                            name = "gastly",
                            url = "https://pokeapi.co/api/v2/pokemon/92"
                        ),
                        imageUrl = "https://pokeapi.co/api/v2/pokemon/92/",
                    ),
                ),
                onPokemonClick = {},
            )
        }
    }
}