package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import pokedex.shared.generated.resources.empty_pokedex_list
import pokedex.shared.generated.resources.refresh_list

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonLocationTab(
    pokemonEncounters: List<Encounter> = listOf(),
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    gridColumns: Int = 1,
    modifier: Modifier = Modifier
) {

    if (pokemonEncounters.isEmpty()){
        EmptyList(
            title = stringResource(Res.string.empty_pokedex_list),
            subtitle = stringResource(Res.string.refresh_list),
            showRetryButton = false,
            modifier = modifier
        )
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(gridColumns),
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = pokemonEncounters
            ) { encounter ->
                PokemonEncounterGridItem(
                    item = encounter,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}