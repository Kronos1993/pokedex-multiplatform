package com.kronos.mutliplatform.pokedex.features.types.list.content

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
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.prettyName
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.toPokemonTypeIcon

@Composable
fun TypesContent(
    listState: LazyGridState,
    gridColumns: Int = 1,
    typeList: List<NamedResourceApi>,
    onClick: (item: NamedResourceApi) -> Unit,
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
            items(typeList, key = { it.name }) {
                TypeItemCard(it, onClick = {
                    onClick(it)
                })
            }

            item { Spacer(modifier = Modifier.height(5.dp)) }
        }
    }
}

@Composable
fun TypeItemCard(
    item: NamedResourceApi,
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
                Icon(
                    imageVector = item.name.toPokemonTypeIcon(),
                    contentDescription = item.name,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(48.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                BodyText(
                    text = item.name.prettyName().replaceFirstChar { it.uppercase() },
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
        TypeItemCard(
            item = NamedResourceApi(name = "Fire", url = ""),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonsContentPreview() {
    val fakeList = listOf(
        NamedResourceApi(name = "fire", url = ""),
        NamedResourceApi(name = "steel", url = ""),
        NamedResourceApi(name = "electric", url = ""),
        NamedResourceApi(name = "grass", url = ""),
        NamedResourceApi(name = "water", url = ""),
        NamedResourceApi(name = "ghost", url = ""),
    )

    AppTheme {
        TypesContent(
            listState = rememberLazyGridState(),
            gridColumns = 2,
            typeList = fakeList,
            onClick = {}
        )
    }
}