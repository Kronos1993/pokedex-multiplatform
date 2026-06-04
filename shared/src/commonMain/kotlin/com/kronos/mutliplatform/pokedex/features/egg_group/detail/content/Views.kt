package com.kronos.mutliplatform.pokedex.features.egg_group.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.features.pokemon.list.content.PokemonItemCard
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.egg_group_detail_info_screen_pokemon_title
import pokedex.shared.generated.resources.empty_pokemon_by_move_list

// ── Screen ────────────────────────────────────────────────────────────────────

@Composable
fun EggGroupInfoScreen(
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

        // ── Pokémon that learn this move ───────────────────────────────────
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
                    text = stringResource(Res.string.egg_group_detail_info_screen_pokemon_title),
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

// ── Preview data ──────────────────────────────────────────────────────────────

private val fakePokemonList = listOf(
    PokemonDexEntry(dexEntry = 6,   pokemonId = 6,   imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png").apply  { pokemon = NamedResourceApi(name = "charizard") },
    PokemonDexEntry(dexEntry = 77,  pokemonId = 77,  imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/77.png").apply  { pokemon = NamedResourceApi(name = "ponyta") },
    PokemonDexEntry(dexEntry = 136, pokemonId = 136, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/136.png").apply { pokemon = NamedResourceApi(name = "flareon") },
    PokemonDexEntry(dexEntry = 146, pokemonId = 146, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png").apply { pokemon = NamedResourceApi(name = "moltres") },
    PokemonDexEntry(dexEntry = 244, pokemonId = 244, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/244.png").apply { pokemon = NamedResourceApi(name = "entei") },
    PokemonDexEntry(dexEntry = 257, pokemonId = 257, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/257.png").apply { pokemon = NamedResourceApi(name = "blaziken") },
)

// ── Sub-component previews ────────────────────────────────────────────────────


@Preview(name = "PokemonFlowRow — 3 per row", showBackground = true, widthDp = 360)
@Composable
private fun PokemonFlowRow3PerRowPreview() {
    AppTheme {
        Surface {
            EggGroupInfoScreen(
                pokemonList = fakePokemonList,
                onPokemonClick = {},
                pokemonItemsPerRow = 3,
            )
        }
    }
}