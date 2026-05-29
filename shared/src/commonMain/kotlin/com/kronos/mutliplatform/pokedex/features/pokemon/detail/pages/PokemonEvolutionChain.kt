package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.EvolutionChainItem
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_evolution_list

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonEvolutionChainTab(
    pokemonEvolutionChain: List<ChainLink>,
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    onChainClick: ((item: NamedResourceApi) -> Unit)?,
    urlProvider: UrlProvider,
    modifier: Modifier = Modifier
) {

    if (pokemonEvolutionChain.isEmpty()){
        EmptyList(
            title = stringResource(Res.string.empty_pokemon_evolution_list),
            subtitle = "",
            showRetryButton = false,
            modifier = modifier
        )
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
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
            items(pokemonEvolutionChain) {
                EvolutionChainItem(
                    sprite = urlProvider.getImageUrl(ImageType.POKEMON,urlProvider.extractIdFromUrl(it.species.url).toString()),
                    chain = it,
                    detail = it.evolutionDetails.firstOrNull(),
                    dominantColor,
                    modifier = Modifier.fillMaxSize(),
                    onChainClick = onChainClick
                )
            }
        }
    }
}