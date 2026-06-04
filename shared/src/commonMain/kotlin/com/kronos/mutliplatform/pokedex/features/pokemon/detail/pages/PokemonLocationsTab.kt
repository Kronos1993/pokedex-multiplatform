package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonEncounterGridItem
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_encounter_list

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonLocationTab(
    pokemonEncounters: List<Encounter> = listOf(),
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyListState,
    gridColumns: Int = 1,
    modifier: Modifier = Modifier
) {

    if (pokemonEncounters.isEmpty()) {
        EmptyList(
            title = stringResource(Res.string.empty_pokemon_encounter_list),
            showRetryButton = false,
            modifier = modifier
        )
    } else {
        LazyColumn(
            state = listState,
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            dominantColor.copy(alpha = 0.25f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                ),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = pokemonEncounters
            ) { encounter ->
                PokemonEncounterGridItem(
                    item = encounter,
                    itemsPerRow = gridColumns,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}