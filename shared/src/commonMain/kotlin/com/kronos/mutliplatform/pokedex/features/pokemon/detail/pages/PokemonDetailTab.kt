package com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kronos.mutliplatform.pokedex.core.ui.components.button.ButtonType
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.core.ui.zoomable
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.ImagePreviewDialog
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonAbilitiesCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonBasicInfoCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonBreedingCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonDetailItem
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonOtherFormsCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.PokemonSpritesCard
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.domain.PokemonOtherForm

/* -------------------------------------------------------------------------- */
/* SCREEN                                                                     */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonDetailTab(
    pokemon: PokemonInfo,
    pokemonSprites: List<Pair<String, String>>,
    pokemonOtherForms: List<PokemonOtherForm>,
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    listState: LazyGridState,
    gridColumns: Int = 1,
    onTypeClick: (item: Type) -> Unit,
    onEggGroupClick: (item: NamedResourceApi) -> Unit,
    onAbilityClick: (item: Ability) -> Unit,
    onSpriteClick: (item: String) -> Unit,
    onPokemonImageClick: (imageUrl: String) -> Unit,
    onClosePokemonImageDialog: () -> Unit,
    showPokemonImage: Boolean,
    onOtherFormsClick: (item: NamedResourceApi) -> Unit,
    modifier: Modifier = Modifier,
    pokemonImageToShow: String? = null
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

        item(span = { GridItemSpan(gridColumns) }) {
            PokemonDetailItem(
                pokemon = pokemon,
                dominantColor = dominantColor,
                isDarkTheme = isDarkTheme,
                currentLang = currentLang,
                onTypeClick = onTypeClick,
                onPokemonImageClick = onPokemonImageClick
            )
        }

        item {
            PokemonBasicInfoCard(pokemon)
        }

        item {

            AnimatedVisibility(
                visible = pokemon.specieInfo?.eggGroup?.isNotEmpty() == true
            ) {
                PokemonBreedingCard(
                    pokemon = pokemon,
                    onEggGroupClick = onEggGroupClick
                )
            }
        }

        item {
                AnimatedVisibility(
                    visible =true
                ) {

                    PokemonAbilitiesCard(
                        pokemon = pokemon,
                        onAbilityClick = onAbilityClick
                    )
                }
        }

        item {
            PokemonSpritesCard(
                pokemonSprites = pokemonSprites,
                onSpriteClick = onSpriteClick
            )
        }

        item {
            PokemonOtherFormsCard(
                pokemonOtherForms = pokemonOtherForms,
                onOtherFormsClick = onOtherFormsClick
            )
        }
    }


    ImagePreviewDialog(
        showDialog = showPokemonImage,
        onClose = onClosePokemonImageDialog
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(.6f)
                .aspectRatio(1f)
                .background(color = Color.Transparent)
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = pokemonImageToShow,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .zoomable(),
                    contentScale = ContentScale.Fit
                )
            }

            IconButton(
                onClick = onClosePokemonImageDialog,
                icon = Icons.Default.Close,
                iconColor = Color.White,
                type = ButtonType.TEXT,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(
                        color = Color.Black.copy(alpha = 0.4f),
                        shape = CircleShape
                    )
            )
        }
    }
}