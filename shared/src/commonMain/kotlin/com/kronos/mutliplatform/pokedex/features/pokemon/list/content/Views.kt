package com.kronos.mutliplatform.pokedex.features.pokemon.list.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry

@Composable
fun PokemonsContent(
    listState: LazyGridState,
    gridColumns: Int = 1,
    pokemonList: List<PokemonDexEntry>,
    onClick: (item: PokemonDexEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        LazyVerticalGrid(
            state = listState,
            columns = GridCells.Fixed(gridColumns),
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(pokemonList, key = { it.dexEntry }) {
                PokemonItemCard(it, onClick = {
                    onClick(it)
                })
            }

            item { Spacer(modifier = Modifier.height(5.dp)) }
        }
    }
}

@Composable
fun PokemonItemCard(
    item: PokemonDexEntry,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCardView(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                var isLoading by remember { mutableStateOf(true) }
                var isError by remember { mutableStateOf(false) }

                if (isLoading || isError) {
                    Image(
                        imageVector = Icons.Pokeball,
                        contentDescription = item.pokemon.name,
                        modifier = Modifier.size(48.dp)
                    )
                }

                AsyncImage(
                    model = ImageRequest.Builder(LocalPlatformContext.current)
                        .data(item.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = item.pokemon.name,
                    onLoading = { isLoading = true },
                    onSuccess = { isLoading = false },
                    onError = { isLoading = false; isError = true },
                    modifier = Modifier.size(48.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                BodyText(
                    text = "#${item.dexEntry}",
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold
                )
                BodyText(
                    text = item.pokemon.name.replaceFirstChar { it.uppercase() },
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemCardPreview() {
    AppTheme {
        PokemonItemCard(
            item = PokemonDexEntry(
                dexEntry = 1,
                pokemon = NamedResourceApi(name = "bulbasaur", url = "")
            ),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonsContentPreview() {
    val fakeList = listOf(
        PokemonDexEntry(dexEntry = 1, pokemon = NamedResourceApi(name = "bulbasaur", url = "")),
        PokemonDexEntry(dexEntry = 2, pokemon = NamedResourceApi(name = "ivysaur", url = "")),
        PokemonDexEntry(dexEntry = 3, pokemon = NamedResourceApi(name = "venusaur", url = "")),
        PokemonDexEntry(dexEntry = 4, pokemon = NamedResourceApi(name = "charmander", url = "")),
        PokemonDexEntry(dexEntry = 5, pokemon = NamedResourceApi(name = "charmeleon", url = "")),
        PokemonDexEntry(dexEntry = 6, pokemon = NamedResourceApi(name = "charizard", url = "")),
    )

    AppTheme {
        PokemonsContent(
            listState = rememberLazyGridState(),
            gridColumns = 2,
            pokemonList = fakeList,
            onClick = {}
        )
    }
}