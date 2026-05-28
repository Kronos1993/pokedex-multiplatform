package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonAbilitiesCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonBasicInfoCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonBreedingCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonDetailItem
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonOtherFormsCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonSpritesCard

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonDetailTab(
    pokemon: PokemonInfo,
    pokemonSprites: List<Pair<String, String>>,
    pokemonOtherForms: List<Triple<String, String, String>>,
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    gridColumns: Int = 1,
    onTypeClick: (item: Type) -> Unit,
    onEggGroupClick: (item: NamedResourceApi) -> Unit,
    onAbilityClick: (item: Ability) -> Unit,
    onSpriteClick: (item: String) -> Unit,
    onOtherFormsClick: (item: String) -> Unit,
    modifier: Modifier = Modifier
) {



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

        item(span = { GridItemSpan(maxLineSpan) }) {
            PokemonDetailItem(
                pokemon = pokemon,
                dominantColor = dominantColor,
                isDarkTheme = isDarkTheme,
                currentLang = currentLang,
                onTypeClick = onTypeClick
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            PokemonBasicInfoCard(pokemon)
        }

        item(span = { GridItemSpan(maxLineSpan) }) {

            AnimatedVisibility(
                visible = pokemon.specieInfo?.eggGroup?.isNotEmpty() == true
            ) {
                PokemonBreedingCard(
                    pokemon = pokemon,
                    onEggGroupClick = onEggGroupClick
                )
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            AnimatedVisibility(
                visible = pokemon.abilities.isNotEmpty()
            ) {

                PokemonAbilitiesCard(
                    pokemon = pokemon,
                    onAbilityClick = onAbilityClick
                )
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            PokemonSpritesCard(
                pokemonSprites = pokemonSprites,
                onSpriteClick = onSpriteClick
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            PokemonOtherFormsCard(
                pokemonOtherForms = pokemonOtherForms,
                onOtherFormsClick = onOtherFormsClick
            )
        }
    }
}