package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.EvYieldSection
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.MaxStatsSection
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.StatCircleItem
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.base_stats
import pokedex.shared.generated.resources.empty_pokemon_stats_list
import pokedex.shared.generated.resources.stats_total

@Composable
fun PokemonStatsTab(
    pokemonStats: List<Stat> = listOf(),
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    gridColumns: Int = 1,
    modifier: Modifier = Modifier
) {
    if (pokemonStats.isEmpty()) {
        EmptyList(
            title = stringResource(Res.string.empty_pokemon_stats_list),
            subtitle = "",
            showRetryButton = false,
            modifier = modifier
        )
    } else {
        val statTotal = pokemonStats.sumOf { it.baseStat }
        val evYield = pokemonStats.filter { it.statEffort > 0 }

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
            // — Stats base en grid circular —
            item(span = { GridItemSpan(gridColumns) }) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    TitleText(
                        text = stringResource(Res.string.base_stats),
                        size = ComponentSize.MEDIUM,
                        fontWeight = FontWeight.Bold,
                        textColor = MaterialTheme.colorScheme.onBackground
                    )
                    // Total badge
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BodyText(
                            text = stringResource(Res.string.stats_total),
                            size = ComponentSize.SMALL,
                        )
                        Spacer(Modifier.width(8.dp))
                        Surface(
                            color = dominantColor.copy(alpha = 0.15f),
                            shape = CircleShape
                        ) {
                            LabelText(
                                text = statTotal.toString(),
                                size = ComponentSize.MEDIUM,
                                textColor = dominantColor,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                            )
                        }
                    }

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        maxItemsInEachRow = 3
                    ) {
                        pokemonStats.forEach { stat ->
                            StatCircleItem(
                                stat = stat,
                                statTotal = statTotal,
                                modifier = Modifier.wrapContentWidth()
                            )
                        }
                    }
                }
            }

            // — Stats máximos —
            item(span = { GridItemSpan(gridColumns) }) {
                MaxStatsSection(
                    pokemonStats = pokemonStats,
                )
            }

            // — EV yield —
            if (evYield.isNotEmpty()) {
                item(span = { GridItemSpan(gridColumns) }) {
                    EvYieldSection(
                        evYield = evYield,
                    )
                }
            }
        }
    }
}