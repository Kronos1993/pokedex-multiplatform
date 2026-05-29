package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveList
import com.kronos.mutliplatform.pokedex.features.move.list.content.MoveFilterRow
import com.kronos.mutliplatform.pokedex.features.move.list.content.MoveInfoItemCard
import com.kronos.mutliplatform.pokedex.features.move.list.content.learnMethodIcon
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_moves_list
import pokedex.shared.generated.resources.move_detail_tab_info_all
import pokedex.shared.generated.resources.move_detail_tab_info_egg
import pokedex.shared.generated.resources.move_detail_tab_info_lv
import pokedex.shared.generated.resources.move_detail_tab_info_other
import pokedex.shared.generated.resources.move_detail_tab_info_tm
import pokedex.shared.generated.resources.move_detail_tab_info_tut

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonMovesTab(
    moves: List<MoveList> = listOf(),
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    gridColumns: Int = 1,
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<PokemonMovesTabViewModel>()
    val filteredMoves by viewModel.filteredMoves.collectAsStateWithLifecycle()
    val selectedFilter by viewModel.selectedFilter.collectAsStateWithLifecycle()
    val availableFilter by viewModel.availableFilter.collectAsStateWithLifecycle()

    val stringEgg = stringResource(Res.string.move_detail_tab_info_egg)
    val stringLevel = stringResource(Res.string.move_detail_tab_info_lv)
    val stringTM = stringResource(Res.string.move_detail_tab_info_tm)
    val stringOther = stringResource(Res.string.move_detail_tab_info_other)
    val stringTutor = stringResource(Res.string.move_detail_tab_info_tut)
    val stringAllMoves = stringResource(Res.string.move_detail_tab_info_all)

    LaunchedEffect(Unit) {
        viewModel.initStrings(
            stringAllMoves = stringAllMoves,
            stringEgg = stringEgg,
            stringLevel = stringLevel,
            stringTM = stringTM,
            stringOther = stringOther,
            stringTutor = stringTutor
        )
        viewModel.availableFilters()
        viewModel.postMoves(moves)
    }

    if (moves.isEmpty()) {
        EmptyList(
            title = stringResource(Res.string.empty_pokemon_moves_list),
            subtitle = "",
            showRetryButton = false,
            modifier = modifier
        )
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            dominantColor.copy(alpha = 0.25f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            MoveFilterRow(
                filters = availableFilter,
                selectedFilter = selectedFilter,
                onFilterSelected = { viewModel.setFilter(it) }
            )

            Spacer(modifier = Modifier.height(4.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(gridColumns),
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = filteredMoves) { move ->
                    MoveInfoItemCard(
                        item = move,
                        icon = move.learnMethodIcon(),
                        onClick = { /* todo */ },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}