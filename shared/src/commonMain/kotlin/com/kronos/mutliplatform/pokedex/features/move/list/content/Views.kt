package com.kronos.mutliplatform.pokedex.features.move.list.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllOut
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.icon.Egg
import com.kronos.mutliplatform.pokedex.components.icon.LevelUp
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.components.icon.TmDisk
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveDetail
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveList

@Composable
fun MovesContent(
    listState: LazyGridState,
    gridColumns: Int = 1,
    moves: List<NamedResourceApi>,
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
            items(moves, key = { it.name }) {
                MoveItemCard(it, onClick = {
                    onClick(it)
                })
            }

            item { Spacer(modifier = Modifier.height(5.dp)) }
        }
    }
}

@Composable
fun MoveItemCard(
    item: NamedResourceApi,
    icon: ImageVector = Icons.TmDisk,
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


@Composable
fun MoveInfoItemCard(
    item: MoveList,
    icon: ImageVector = Icons.TmDisk,
    iconTint: Color = Color.Unspecified,
    iconSize: Dp = 36.dp,
    onClick: (item: NamedResourceApi) -> Unit,
    modifier: Modifier = Modifier
) {
    val detail = item.moveDetails.firstOrNull()
    val isLevelUp = detail?.moveLearnMethod == "level-up"
    val level = detail?.levelLearned ?: 0

    BaseCardView(
        onClick = { onClick(item.move) },
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Ícono con fondo tintado
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(iconTint.copy(alpha = 0.12f))
            ) {
                Icon(
                    imageVector = icon,
                    tint = iconTint,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }

            // Nombre del move
            BodyText(
                text = item.move.name
                    .replace("-", " ")
                    .replaceFirstChar { it.uppercase() },
                size = ComponentSize.LARGE,
                modifier = Modifier.weight(1f)
            )

            // Badge de nivel
            if (isLevelUp && level > 0) {
                Surface(
                    shape = CircleShape,
                    color = iconTint.copy(alpha = 0.12f)
                ) {
                    LabelText(
                        text = "Lv.$level",
                        size = ComponentSize.SMALL,
                        textColor = iconTint,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MoveFilterRow(
    filters: List<Pair<String, String>>,
    selectedFilter: String,
    onFilterSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxLines = 2,
        maxItemsInEachRow = 5
    ) {
        filters.forEach { (method, label) ->
            val isSelected = method == selectedFilter
            val chipColor = learnMethodColor(method)

            Surface(
                onClick = { onFilterSelected(method) },
                shape = CircleShape,
                color = if (isSelected) chipColor else chipColor.copy(alpha = 0.12f),
                border = if (!isSelected) BorderStroke(
                    width = 1.dp,
                    color = chipColor.copy(alpha = 0.3f)
                ) else null,
                modifier = Modifier
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = learnMethodIcon(method),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    LabelText(
                        text = label,
                        size = ComponentSize.SMALL,
                        textColor = if (isSelected) Color.White else chipColor
                    )
                }
            }
        }
    }
}

fun MoveList.learnMethodIcon(): ImageVector {
    return when (moveDetails.firstOrNull()?.moveLearnMethod) {
        "egg"      -> Icons.Egg
        "tutor"    -> Icons.Pokeball
        "level-up" -> Icons.LevelUp
        "machine"  -> Icons.TmDisk
        else       -> Icons.TmDisk
    }
}

fun learnMethodIcon(method: String): ImageVector {
    return when (method) {
        "egg"      -> Icons.Egg
        "tutor"    -> Icons.Pokeball
        "level-up" -> Icons.LevelUp
        "machine"  -> Icons.TmDisk
        else      -> Icons.Filled.AllOut
    }
}

fun learnMethodColor(method: String): Color {
    return when (method) {
        "egg"      -> Color(0xFFF085B6)
        "tutor"    -> Color(0xFF78C850)
        "level-up" -> Color(0xFFF8D030)
        "machine"  -> Color(0xFF6890F0)
        else       -> Color.Gray
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexItemCardPreview() {
    AppTheme() {
        MoveItemCard(
            item = NamedResourceApi("national",""),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexContentPreview() {

    val fakeList = listOf(
        NamedResourceApi(
            name = "national",
            url = "",
        ),
        NamedResourceApi(
            name = "kanto",
            url = "",
        ),
        NamedResourceApi(
            name = "johto",
            url = "",
        ),
        NamedResourceApi(
            name = "hoenn",
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
        MovesContent(
            listState = rememberLazyGridState(),
            gridColumns = 2,
            moves = fakeList,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoveInfoItemCardPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Level-up move
            MoveInfoItemCard(
                item = MoveList(
                    move = NamedResourceApi(name = "thunder-punch"),
                    moveDetails = listOf(
                        MoveDetail(levelLearned = 24, moveLearnMethod = "level-up")
                    )
                ),
                icon = Icons.TmDisk,
                iconTint = Color(0xFFF8D030),
                onClick = {}
            )

            // TM move (sin nivel)
            MoveInfoItemCard(
                item = MoveList(
                    move = NamedResourceApi(name = "solar-beam"),
                    moveDetails = listOf(
                        MoveDetail(levelLearned = 0, moveLearnMethod = "machine")
                    )
                ),
                icon = Icons.TmDisk,
                iconTint = Color(0xFF78C850),
                onClick = {}
            )

            // Egg move (sin nivel)
            MoveInfoItemCard(
                item = MoveList(
                    move = NamedResourceApi(name = "dragon-rage"),
                    moveDetails = listOf(
                        MoveDetail(levelLearned = 0, moveLearnMethod = "egg")
                    )
                ),
                icon = Icons.TmDisk,
                iconTint = Color(0xFF6890F0),
                onClick = {}
            )

            // Level-up move nivel 1 (movimiento inicial)
            MoveInfoItemCard(
                item = MoveList(
                    move = NamedResourceApi(name = "scratch"),
                    moveDetails = listOf(
                        MoveDetail(levelLearned = 1, moveLearnMethod = "level-up")
                    )
                ),
                icon = Icons.TmDisk,
                iconTint = Color(0xFFFF5959),
                onClick = {}
            )
        }
    }
}