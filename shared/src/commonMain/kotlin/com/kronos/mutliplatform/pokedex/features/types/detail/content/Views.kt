package com.kronos.mutliplatform.pokedex.features.types.detail.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kronos.mutliplatform.pokedex.components.icon.Shield
import com.kronos.mutliplatform.pokedex.components.icon.Sword
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.type.DamageRelation
import com.kronos.mutliplatform.pokedex.domain.model.type.DamageRelationContainer
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.content.toPokemonTypeIcon
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.type_detail_info_screen_attaking_no_effect
import pokedex.shared.generated.resources.type_detail_info_screen_attaking_not_very_effective
import pokedex.shared.generated.resources.type_detail_info_screen_attaking_supper_effective
import pokedex.shared.generated.resources.type_detail_info_screen_attaking_title
import pokedex.shared.generated.resources.type_detail_info_screen_defending_double_damage
import pokedex.shared.generated.resources.type_detail_info_screen_defending_half_damage
import pokedex.shared.generated.resources.type_detail_info_screen_defending_inmune_damage
import pokedex.shared.generated.resources.type_detail_info_screen_defending_title
import pokedex.shared.generated.resources.type_detail_info_screen_no_data

@Composable
fun TypeInfoScreen(
    typeInfo: TypeInfo,
    onTypeClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        val dr = typeInfo.damageRelations
        val defendingGroups = buildList {
            if (dr.doubleDamageFrom.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_defending_double_damage) to dr.doubleDamageFrom.map {
                    DamageRelationContainer(
                        it.name,
                        "2×"
                    )
                })
            if (dr.halfDamageFrom.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_defending_half_damage) to dr.halfDamageFrom.map {
                    DamageRelationContainer(
                        it.name,
                        "½×"
                    )
                })
            if (dr.noDamageFrom.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_defending_inmune_damage) to dr.noDamageFrom.map {
                    DamageRelationContainer(
                        it.name,
                        "0×"
                    )
                })
        }

        val attackingGroups = buildList {
            if (dr.doubleDamageTo.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_attaking_supper_effective) to dr.doubleDamageTo.map {
                    DamageRelationContainer(
                        it.name,
                        "2×"
                    )
                })
            if (dr.halfDamageTo.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_attaking_not_very_effective) to dr.halfDamageTo.map {
                    DamageRelationContainer(
                        it.name,
                        "½×"
                    )
                })
            if (dr.noDamageTo.isNotEmpty())
                add(stringResource(Res.string.type_detail_info_screen_attaking_no_effect) to dr.noDamageTo.map {
                    DamageRelationContainer(
                        it.name,
                        "0×"
                    )
                })
        }

        val hasAnyData = defendingGroups.isNotEmpty() || attackingGroups.isNotEmpty()

        if (hasAnyData) {
            DamageSectionCard(
                title = stringResource(Res.string.type_detail_info_screen_defending_title),
                icon = Icons.Shield,
                groups = defendingGroups,
                onTypeClick = onTypeClick,
            )
            DamageSectionCard(
                title = stringResource(Res.string.type_detail_info_screen_attaking_title),
                icon = Icons.Sword,
                groups = attackingGroups,
                onTypeClick = onTypeClick,
            )
        } else {
            TypeInfoEmptyState()
        }
    }
}

// ─── Section card ─────────────────────────────────────────────────────────────

@Composable
private fun DamageSectionCard(
    title: String,
    groups: List<Pair<String, List<DamageRelationContainer>>>,
    onTypeClick: (String) -> Unit,
    icon: ImageVector? = null,
    iconTint: Color = Color.Unspecified,
) {
    if (groups.isEmpty()) return

    BaseCardView(
        cardBackgroundColor = MaterialTheme.colorScheme.surface,
        elevation = 0.dp,
        borderStroke = BorderStroke(
            width = 0.5.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column {
            SectionHeader(title = title, icon = icon, iconTint = iconTint)

            groups.forEachIndexed { index, (label, items) ->
                if (index > 0) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        thickness = 0.5.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                    )
                }
                DamageGroup(label = label, items = items, onTypeClick = onTypeClick)
            }

            Spacer(Modifier.height(4.dp))
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    icon: ImageVector? = null,
    iconTint: Color = Color.Unspecified
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        TitleText(
            text = title.uppercase(),
            size = ComponentSize.SMALL,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.08.sp,
            vector = icon,
            iconTint = iconTint,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
    HorizontalDivider(
        thickness = 0.5.dp,
        color = MaterialTheme.colorScheme.outlineVariant,
    )
}

@Composable
private fun DamageGroup(
    label: String,
    items: List<DamageRelationContainer>,
    onTypeClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        LabelText(
            text = label.uppercase(),
            size = ComponentSize.MEDIUM,
            letterSpacing = 0.06.sp,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items.forEach { relation ->
                TypeChip(relation = relation, onTypeClick = onTypeClick)
            }
        }
    }
}

// ─── Type chip ────────────────────────────────────────────────────────────────

@Composable
private fun TypeChip(
    relation: DamageRelationContainer,
    onTypeClick: (String) -> Unit
) {
    val bgColor = typeColor(relation.typeName).copy(alpha = 0.15f)
    val contentColor = typeColor(relation.typeName)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(999.dp))
            .clickable(
                enabled = true,
                onClick = { onTypeClick(relation.typeName) }
            )
            .background(bgColor)
            .padding(start = 7.dp, end = 3.dp, top = 5.dp, bottom = 5.dp),
    ) {
        Icon(
            imageVector = relation.typeName.toPokemonTypeIcon(),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(14.dp),
        )

        LabelText(
            text = relation.typeName.replaceFirstChar { it.uppercase() },
            textColor = contentColor,
            size = ComponentSize.MEDIUM,
            maxLines = 1,
            textOverflow = TextOverflow.Ellipsis,
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(contentColor.copy(alpha = 0.2f))
                .padding(horizontal = 5.dp, vertical = 1.dp),
        ) {
            LabelText(
                text = relation.damage,
                size = ComponentSize.MEDIUM,
                textColor = contentColor,
                fontWeight = FontWeight.Medium,
            )
        }

        Spacer(Modifier.width(4.dp))
    }
}


@Composable
private fun TypeInfoEmptyState() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Icon(
                imageVector = Icons.Shield, // o un ícono más genérico
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f),
                modifier = Modifier.size(40.dp),
            )
            BodyText(
                text = stringResource(Res.string.type_detail_info_screen_no_data),
                textColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                textAlign = TextAlign.Center,
            )
        }
    }
}

// ─── Type color map ───────────────────────────────────────────────────────────

fun typeColor(typeName: String): Color = when (typeName.lowercase()) {
    "fire" -> Color(0xFFD85A30)
    "water" -> Color(0xFF378ADD)
    "grass" -> Color(0xFF639922)
    "electric" -> Color(0xFFBA7517)
    "ice" -> Color(0xFF85B7EB)
    "fighting" -> Color(0xFFC0392B)
    "poison" -> Color(0xFFD4537E)
    "ground" -> Color(0xFFEF9F27)
    "flying" -> Color(0xFF7F77DD)
    "psychic" -> Color(0xFFE91E8C)
    "bug" -> Color(0xFF97C459)
    "rock" -> Color(0xFFB8A038)
    "ghost" -> Color(0xFF534AB7)
    "dragon" -> Color(0xFF534AB7)
    "dark" -> Color(0xFF5F5E5A)
    "steel" -> Color(0xFF888780)
    "fairy" -> Color(0xFFD4537E)
    "normal" -> Color(0xFF888780)
    else -> Color(0xFF888780)
}

private val waterTypePreview = TypeInfo(
    id = 11,
    name = "water",
    damageRelations = DamageRelation(
        doubleDamageFrom = listOf(
            NamedResourceApi("electric"),
            NamedResourceApi("grass"),
        ),
        halfDamageFrom = listOf(
            NamedResourceApi("fire"),
            NamedResourceApi("water"),
            NamedResourceApi("ice"),
            NamedResourceApi("steel"),
        ),
        noDamageFrom = emptyList(),
        doubleDamageTo = listOf(
            NamedResourceApi("fire"),
            NamedResourceApi("ground"),
            NamedResourceApi("rock"),
        ),
        halfDamageTo = listOf(
            NamedResourceApi("water"),
            NamedResourceApi("grass"),
            NamedResourceApi("dragon"),
        ),
        noDamageTo = emptyList(),
    ),
    names = listOf(
        Name(name = "Water", language = NamedResourceApi("en")),
        Name(name = "Agua", language = NamedResourceApi("es")),
    ),
)

private val fireTypePreview = TypeInfo(
    id = 10,
    name = "fire",
    damageRelations = DamageRelation(
        doubleDamageFrom = listOf(
            NamedResourceApi("water"),
            NamedResourceApi("ground"),
            NamedResourceApi("rock"),
        ),
        halfDamageFrom = listOf(
            NamedResourceApi("fire"),
            NamedResourceApi("grass"),
            NamedResourceApi("ice"),
            NamedResourceApi("bug"),
            NamedResourceApi("steel"),
            NamedResourceApi("fairy"),
        ),
        noDamageFrom = emptyList(),
        doubleDamageTo = listOf(
            NamedResourceApi("grass"),
            NamedResourceApi("ice"),
            NamedResourceApi("bug"),
            NamedResourceApi("steel"),
        ),
        halfDamageTo = listOf(
            NamedResourceApi("fire"),
            NamedResourceApi("water"),
            NamedResourceApi("rock"),
            NamedResourceApi("dragon"),
        ),
        noDamageTo = emptyList(),
    ),
    names = listOf(
        Name(name = "Fire", language = NamedResourceApi("en")),
        Name(name = "Fuego", language = NamedResourceApi("es")),
    ),
)

private val ghostTypePreview = TypeInfo(
    id = 8,
    name = "ghost",
    damageRelations = DamageRelation(
        doubleDamageFrom = listOf(
            NamedResourceApi("ghost"),
            NamedResourceApi("dark"),
        ),
        halfDamageFrom = listOf(
            NamedResourceApi("poison"),
            NamedResourceApi("bug"),
        ),
        noDamageFrom = listOf(
            NamedResourceApi("normal"),
            NamedResourceApi("fighting"),
        ),
        doubleDamageTo = listOf(
            NamedResourceApi("ghost"),
            NamedResourceApi("psychic"),
        ),
        halfDamageTo = listOf(
            NamedResourceApi("dark"),
        ),
        noDamageTo = listOf(
            NamedResourceApi("normal"),
        ),
    ),
    names = listOf(
        Name(name = "Ghost", language = NamedResourceApi("en")),
        Name(name = "Fantasma", language = NamedResourceApi("es")),
    ),
)


@Preview(
    name = "Type Info — Light",
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun TypeInfoScreenPreviewLight(
) {
    AppTheme {
        TypeInfoScreen(typeInfo = waterTypePreview, {})
    }
}