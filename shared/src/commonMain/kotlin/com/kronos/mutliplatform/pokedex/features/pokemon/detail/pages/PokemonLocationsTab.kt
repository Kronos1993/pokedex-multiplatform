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
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.EncounterByGeneration
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.EncounterByVersion
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.GenerationHeader
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonEncounterGridItem
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.generationDisplayName
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_encounter_list

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

sealed interface EncounterListItem {
    data class Header(val generation: Int) : EncounterListItem
    data class Version(val encounter: EncounterByVersion) : EncounterListItem
}

@Composable
fun PokemonLocationTab(
    pokemonEncounters: List<EncounterByGeneration> = listOf(),
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
        val flatItems = remember(pokemonEncounters) {
            buildList {
                pokemonEncounters.forEach { gen ->
                    add(EncounterListItem.Header(gen.generation))
                    gen.versions.forEach { version ->
                        add(EncounterListItem.Version(version))
                    }
                }
            }
        }

        val expandedVersions = remember(pokemonEncounters) {
            mutableStateMapOf<String, Boolean>().apply {
                pokemonEncounters.forEach { gen ->
                    gen.versions.forEach { version ->
                        put(version.version.name, true)
                    }
                }
            }
        }

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
                items = flatItems,
                key = { item ->
                    when (item) {
                        is EncounterListItem.Header -> "header_${item.generation}"
                        is EncounterListItem.Version -> "version_${item.encounter.version.name}"
                    }
                },
                contentType = { item ->
                    when (item) {
                        is EncounterListItem.Header -> "header"
                        is EncounterListItem.Version -> "version"
                    }
                }
            ) { item ->
                when (item) {
                    is EncounterListItem.Header -> {
                        GenerationHeader(
                            title = generationDisplayName(item.generation)
                        )
                    }
                    is EncounterListItem.Version -> {
                        val isExpanded = expandedVersions[item.encounter.version.name] == true
                        PokemonEncounterGridItem(
                            item = item.encounter,
                            itemsPerRow = gridColumns,
                            isExpanded = isExpanded,
                            onToggle = {
                                expandedVersions[item.encounter.version.name] = !isExpanded
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}