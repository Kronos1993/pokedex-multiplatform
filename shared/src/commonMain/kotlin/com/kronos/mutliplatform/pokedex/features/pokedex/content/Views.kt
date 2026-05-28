package com.kronos.mutliplatform.pokedex.features.pokedex.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.icon.PokedexSvg
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.features.pokedex.domain.PokedexItem

@Composable
fun PokedexContent(
    listState: LazyGridState,
    gridColumns: Int = 1,
    pokedexList: List<PokedexItem>,
    onClick: (item: PokedexItem) -> Unit,
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
            items(pokedexList, key = { it.name }) {
                PokedexItemCard(it.normalizeName, onClick = {
                    onClick(it)
                })
            }

            item { Spacer(modifier = Modifier.height(5.dp)) }
        }
    }
}

@Composable
fun PokedexItemCard(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCardView(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.PokedexSvg,
                contentDescription = name,
                modifier = Modifier.size(96.dp)
            )
            BodyText(
                text = name.replace("-", " ").replaceFirstChar { it.uppercase() },
                size = ComponentSize.LARGE
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexItemCardPreview() {
    AppTheme() {
        PokedexItemCard(
            name = "national",
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexContentPreview() {

    val fakeList = listOf(
        PokedexItem(
            name = "national",
            url = "",
            normalizeName = "national"
        ),
        PokedexItem(
            name = "kanto",
            url = "",
            normalizeName = "kanto"
        ),
        PokedexItem(
            name = "johto",
            url = "",
            normalizeName = "johto"
        ),
        PokedexItem(
            name = "hoenn",
            url = "",
            normalizeName = "hoenn"
        ),
        PokedexItem(
            name = "sinnoh",
            url = "",
            normalizeName = "sinnoh"
        ),
        PokedexItem(
            name = "unova",
            url = "",
            normalizeName = "unova"
        )
    )

    AppTheme {
        PokedexContent(
            listState = rememberLazyGridState(),
            gridColumns = 2,
            pokedexList = fakeList,
            onClick = {}
        )
    }
}