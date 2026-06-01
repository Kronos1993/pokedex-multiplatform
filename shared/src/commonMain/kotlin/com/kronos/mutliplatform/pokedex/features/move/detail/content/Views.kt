package com.kronos.mutliplatform.pokedex.features.move.detail.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kronos.mutliplatform.pokedex.components.EmptyList
import com.kronos.mutliplatform.pokedex.components.icon.Check
import com.kronos.mutliplatform.pokedex.components.icon.Error
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.toPokemonTypeIcon
import com.kronos.mutliplatform.pokedex.features.pokemon.list.content.PokemonItemCard
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.empty_pokemon_by_move_list
import pokedex.shared.generated.resources.move_detail_info_screen_accuracy
import pokedex.shared.generated.resources.move_detail_info_screen_category_title
import pokedex.shared.generated.resources.move_detail_info_screen_description_title
import pokedex.shared.generated.resources.move_detail_info_screen_effect_title
import pokedex.shared.generated.resources.move_detail_info_screen_info_title
import pokedex.shared.generated.resources.move_detail_info_screen_power
import pokedex.shared.generated.resources.move_detail_info_screen_pp
import pokedex.shared.generated.resources.move_detail_info_screen_priority
import pokedex.shared.generated.resources.move_detail_info_screen_type

// ── Screen ────────────────────────────────────────────────────────────────────

@Composable
fun MoveInfoScreen(
    moveInfo: MoveInfo?,
    lang: String,
    pokemonItemsPerRow: Int = 2,
    pokemonList: List<PokemonDexEntry>,
    onPokemonClick: (PokemonDexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        if (moveInfo != null) {
            MoveSectionCard(title = stringResource(Res.string.move_detail_info_screen_info_title)) {
                MoveStatsGrid(moveInfo = moveInfo)
            }

            MoveSectionCard(title = stringResource(Res.string.move_detail_info_screen_category_title)) {
                MoveCategoryChip(category = moveInfo.moveCategory)
            }
        }

        MoveSectionCard(title = stringResource(Res.string.move_detail_info_screen_description_title)) {
            MoveTextContent(text = moveInfo?.getDescription(lang).orEmpty().replace("\n"," "))
        }

        if (!moveInfo?.getMoveEffect(lang).isNullOrBlank()) {
            MoveSectionCard(title = stringResource(Res.string.move_detail_info_screen_effect_title)) {
                MoveTextContent(
                    text = moveInfo.getMoveEffect(lang).orEmpty().replace("\n"," "),
                    maxHeight = 120.dp,
                    scrollable = true,
                )
            }
        }

        // ── Pokémon that learn this move ───────────────────────────────────
        PokemonFlowRow(
            pokemonList = pokemonList,
            itemsPerRow = pokemonItemsPerRow,
            onPokemonClick = onPokemonClick,
        )
    }
}

// ── Reusable section card with labelled header ────────────────────────────────

@Composable
private fun MoveSectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 4.dp, height = 16.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(MaterialTheme.colorScheme.primary),
                )
                TitleText(
                    text = title,
                    size = ComponentSize.SMALL,
                    fontWeight = FontWeight.Bold,
                    textColor = MaterialTheme.colorScheme.onSurface,
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                thickness = 1.dp,
            )

            Box(modifier = Modifier.padding(16.dp)) {
                content()
            }
        }
    }
}

// ── Stats grid (accuracy / PP / power / type / priority) ─────────────────────

@Composable
private fun MoveStatsGrid(moveInfo: MoveInfo) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        MoveStatPill(
            label = stringResource(Res.string.move_detail_info_screen_accuracy),
            value = moveInfo.accuracy.toString(),
        )
        MoveStatPill(
            label = stringResource(Res.string.move_detail_info_screen_pp),
            value = moveInfo.pp.toString(),
        )
        MoveStatPill(
            label = stringResource(Res.string.move_detail_info_screen_power),
            value = moveInfo.power.toString(),
        )

        // Type icon pill
        MoveIconPill(label = stringResource(Res.string.move_detail_info_screen_type)) {
            MoveTypeIcon(typeName = moveInfo.type.name, modifier = Modifier.size(28.dp))
        }

        // Priority icon pill
        MoveIconPill(label = stringResource(Res.string.move_detail_info_screen_priority)) {
            MovePriorityIcon(priority = moveInfo.priority, modifier = Modifier.size(28.dp))
        }
    }
}

@Composable
private fun MoveStatPill(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        TitleText(
            text = value,
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.ExtraBold,
            textColor = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
        LabelText(
            text = label,
            size = ComponentSize.SMALL,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun MoveIconPill(label: String, content: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        content()
        LabelText(
            text = label,
            size = ComponentSize.SMALL,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

// ── Category chip ─────────────────────────────────────────────────────────────

@Composable
private fun MoveCategoryChip(category: String?) {
    val (containerColor, contentColor) = when (category?.lowercase()) {
        "physical" -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
        "special" -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
        else -> MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(containerColor)
            .padding(horizontal = 20.dp, vertical = 8.dp),
    ) {
        LabelText(
            text = category?.replaceFirstChar { it.uppercase() }.orEmpty(),
            size = ComponentSize.LARGE,
            fontWeight = FontWeight.Bold,
            textColor = contentColor,
        )
    }
}

// ── Text content (description / effect) ───────────────────────────────────────

@Composable
private fun MoveTextContent(
    text: String,
    maxHeight: androidx.compose.ui.unit.Dp? = null,
    scrollable: Boolean = false,
) {
    val textModifier = if (maxHeight != null) {
        Modifier
            .heightIn(max = maxHeight)
            .then(if (scrollable) Modifier.verticalScroll(rememberScrollState()) else Modifier)
    } else {
        Modifier
    }

    BodyText(
        text = text.ifBlank { "—" },
        textColor = MaterialTheme.colorScheme.onSurfaceVariant,
        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
        modifier = textModifier,
    )
}

// ── Type / Priority icons ─────────────────────────────────────────────────────

@Composable
fun MoveTypeIcon(typeName: String, modifier: Modifier = Modifier) {
    Icon(
        imageVector = typeName.toPokemonTypeIcon(),
        contentDescription = typeName,
        tint = Color.Unspecified,
        modifier = modifier.size(24.dp),
    )
}

@Composable
fun MovePriorityIcon(priority: Int, modifier: Modifier = Modifier) {
    val icon = if (priority > 0) Icons.Check else Icons.Error
    Icon(
        imageVector = icon,
        contentDescription = priority.toString(),
        tint = Color.Unspecified,
        modifier = modifier.size(24.dp),
    )
}

// ── Pokémon flow row ──────────────────────────────────────────────────────────

@Composable
fun PokemonFlowRow(
    pokemonList: List<PokemonDexEntry>,
    onPokemonClick: (PokemonDexEntry) -> Unit,
    itemsPerRow: Int = 2,
    modifier: Modifier = Modifier,
) {
    if (pokemonList.isEmpty()) {
        EmptyList(
            title = stringResource(Res.string.empty_pokemon_by_move_list),
            subtitle = "",
            modifier = modifier.fillMaxSize(),
        )
    } else {
        FlowRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            maxItemsInEachRow = itemsPerRow,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            pokemonList.forEach { entry ->
                PokemonItemCard(
                    item = entry,
                    onClick = { onPokemonClick(entry) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

// ── Preview data ──────────────────────────────────────────────────────────────

private val fakePokemonList = listOf(
    PokemonDexEntry(dexEntry = 6,   pokemonId = 6,   imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png").apply  { pokemon = NamedResourceApi(name = "charizard") },
    PokemonDexEntry(dexEntry = 77,  pokemonId = 77,  imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/77.png").apply  { pokemon = NamedResourceApi(name = "ponyta") },
    PokemonDexEntry(dexEntry = 136, pokemonId = 136, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/136.png").apply { pokemon = NamedResourceApi(name = "flareon") },
    PokemonDexEntry(dexEntry = 146, pokemonId = 146, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png").apply { pokemon = NamedResourceApi(name = "moltres") },
    PokemonDexEntry(dexEntry = 244, pokemonId = 244, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/244.png").apply { pokemon = NamedResourceApi(name = "entei") },
    PokemonDexEntry(dexEntry = 257, pokemonId = 257, imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/257.png").apply { pokemon = NamedResourceApi(name = "blaziken") },
)

private val fakeMoveInfo = MoveInfo(
    names = listOf(),
    accuracy = 100,
    pp = 15,
    power = 90,
    priority = 0,
    type = NamedResourceApi(name = "fire"),
    moveCategory = "special",
    moveFlavorText = listOf(),
    effects = listOf(),
    learnedBy = listOf()
)

// Convenience: a move with high priority and physical category
private val fakePriorityMove = fakeMoveInfo.copy(
    priority = 1,
    moveCategory = "physical",
    power = 40,
    accuracy = 100,
    pp = 30,
)

// ── Parameter provider ────────────────────────────────────────────────────────

data class MovePreviewState(
    val moveInfo: MoveInfo?,
    val pokemonList: List<PokemonDexEntry>,
    val label: String,
)

val values = sequenceOf(
    MovePreviewState(
        moveInfo = fakeMoveInfo,
        pokemonList = fakePokemonList,
        label = "Full — special move, list with 6 Pokémon",
    ),
    MovePreviewState(
        moveInfo = fakePriorityMove,
        pokemonList = fakePokemonList.take(2),
        label = "Physical move, short list",
    ),
    MovePreviewState(
        moveInfo = fakeMoveInfo,
        pokemonList = emptyList(),
        label = "Empty Pokémon list",
    ),
    MovePreviewState(
        moveInfo = null,
        pokemonList = fakePokemonList,
        label = "Null MoveInfo (loading state)",
    ),
)
// ── Previews ──────────────────────────────────────────────────────────────────

@Preview(name = "Move Info — Light", showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun MoveInfoScreenPreview(
) {
    AppTheme {
        Surface {
            MoveInfoScreen(
                moveInfo = fakeMoveInfo,
                lang = "en",
                pokemonList = fakeMoveInfo.learnedBy.map {  PokemonDexEntry(1, pokemon = NamedResourceApi(it.name)) },
                onPokemonClick = {},
            )
        }
    }
}

@Preview(
    name = "Move Info — Dark",
    showBackground = true,
    widthDp = 360,
    heightDp = 800,
)
@Composable
private fun MoveInfoScreenDarkPreview() {
    AppTheme {
        Surface {
            MoveInfoScreen(
                moveInfo = fakeMoveInfo,
                lang = "en",
                pokemonList = fakePokemonList,
                onPokemonClick = {},
            )
        }
    }
}

@Preview(name = "Move Info — Empty list", showBackground = true, widthDp = 360, heightDp = 400)
@Composable
private fun MoveInfoScreenEmptyPreview() {
    AppTheme {
        Surface {
            MoveInfoScreen(
                moveInfo = fakeMoveInfo,
                lang = "en",
                pokemonList = emptyList(),
                onPokemonClick = {},
                pokemonItemsPerRow = 4
            )
        }
    }
}

// ── Sub-component previews ────────────────────────────────────────────────────

@Preview(name = "PokemonFlowRow — 6 items", showBackground = true, widthDp = 360)
@Composable
private fun PokemonFlowRowPreview() {
    AppTheme {
        Surface {
            PokemonFlowRow(
                pokemonList = fakePokemonList,
                onPokemonClick = {},
                itemsPerRow = 4
            )
        }
    }
}

@Preview(name = "PokemonFlowRow — Empty", showBackground = true, widthDp = 360, heightDp = 200)
@Composable
private fun PokemonFlowRowEmptyPreview() {
    AppTheme {
        Surface {
            PokemonFlowRow(
                pokemonList = emptyList(),
                onPokemonClick = {},
            )
        }
    }
}

@Preview(name = "PokemonFlowRow — 3 per row", showBackground = true, widthDp = 360)
@Composable
private fun PokemonFlowRow3PerRowPreview() {
    AppTheme {
        Surface {
            PokemonFlowRow(
                pokemonList = fakePokemonList,
                onPokemonClick = {},
                itemsPerRow = 3,
            )
        }
    }
}