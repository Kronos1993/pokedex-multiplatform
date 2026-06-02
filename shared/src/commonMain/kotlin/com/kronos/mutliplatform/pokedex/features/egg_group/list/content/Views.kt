package com.kronos.mutliplatform.pokedex.features.egg_group.list.content

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
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.icon.Egg
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.toEggGroupIcon

@Composable
fun EggGroupContent(
    listState: LazyGridState,
    gridColumns: Int = 1,
    eggGroups: List<NamedResourceApi>,
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
            items(eggGroups, key = { it.name }) {
                EggGroupItemCard(
                    it,
                    icon = it.name.toEggGroupIcon(),
                    onClick = {
                        onClick(it)
                    })
            }

            item { Spacer(modifier = Modifier.height(5.dp)) }
        }
    }
}

@Composable
fun EggGroupItemCard(
    item: NamedResourceApi,
    icon: ImageVector = Icons.Egg,
    iconTint: Color = Color.Unspecified,
    iconSize: Dp = 96.dp,
    onClick: (item: NamedResourceApi) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCardView(
        onClick = {
            onClick(item)
        },
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                tint = iconTint,
                contentDescription = item.name,
                modifier = Modifier.size(iconSize)
            )
            BodyText(
                text = item.name.replace("-", " ").replaceFirstChar { it.uppercase() },
                size = ComponentSize.LARGE
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokedexItemCardPreview() {
    AppTheme() {
        EggGroupItemCard(
            item = NamedResourceApi("national", ""),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexContentPreview() {

    val fakeList = listOf(
        NamedResourceApi(
            name = "mineral",
            url = "",
        ),
        NamedResourceApi(
            name = "wather",
            url = "",
        ),
        NamedResourceApi(
            name = "humanshape",
            url = "",
        ),
        NamedResourceApi(
            name = "ditto",
            url = "",
        ),
        NamedResourceApi(
            name = "sinnoh",
            url = "",
        ),
        NamedResourceApi(
            name = "unova",
            url = "",
        )
    )

    AppTheme {
        EggGroupContent(
            listState = rememberLazyGridState(),
            gridColumns = 2,
            eggGroups = fakeList,
            onClick = {}
        )
    }
}