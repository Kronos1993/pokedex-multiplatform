package com.kronos.mutliplatform.pokedex.features.pokemon.detail.content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kronos.mutliplatform.pokedex.components.icon.Bolt
import com.kronos.mutliplatform.pokedex.components.icon.Bug
import com.kronos.mutliplatform.pokedex.components.icon.Dark
import com.kronos.mutliplatform.pokedex.components.icon.Dragon
import com.kronos.mutliplatform.pokedex.components.icon.Egg
import com.kronos.mutliplatform.pokedex.components.icon.Electric
import com.kronos.mutliplatform.pokedex.components.icon.Fairy
import com.kronos.mutliplatform.pokedex.components.icon.Female
import com.kronos.mutliplatform.pokedex.components.icon.Fighting
import com.kronos.mutliplatform.pokedex.components.icon.Fire
import com.kronos.mutliplatform.pokedex.components.icon.Flying
import com.kronos.mutliplatform.pokedex.components.icon.Ghost
import com.kronos.mutliplatform.pokedex.components.icon.Grass
import com.kronos.mutliplatform.pokedex.components.icon.Ground
import com.kronos.mutliplatform.pokedex.components.icon.Heart
import com.kronos.mutliplatform.pokedex.components.icon.Ice
import com.kronos.mutliplatform.pokedex.components.icon.LevelUp
import com.kronos.mutliplatform.pokedex.components.icon.Male
import com.kronos.mutliplatform.pokedex.components.icon.Natures
import com.kronos.mutliplatform.pokedex.components.icon.Normal
import com.kronos.mutliplatform.pokedex.components.icon.Poison
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.components.icon.PokemonTypes
import com.kronos.mutliplatform.pokedex.components.icon.Psychic
import com.kronos.mutliplatform.pokedex.components.icon.Rock
import com.kronos.mutliplatform.pokedex.components.icon.Scale
import com.kronos.mutliplatform.pokedex.components.icon.Steel
import com.kronos.mutliplatform.pokedex.components.icon.UpArrow
import com.kronos.mutliplatform.pokedex.components.icon.Water
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.ratingColorContainerLight
import com.kronos.mutliplatform.pokedex.core.util.format
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.specie.GenderPossibility
import com.kronos.mutliplatform.pokedex.domain.model.specie.PokemonGenera
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.baby_pokemon
import pokedex.shared.generated.resources.base_exp
import pokedex.shared.generated.resources.capture_rate
import pokedex.shared.generated.resources.capture_rate_value
import pokedex.shared.generated.resources.genderless
import pokedex.shared.generated.resources.growth_rate
import pokedex.shared.generated.resources.habitat
import pokedex.shared.generated.resources.happiness
import pokedex.shared.generated.resources.hatch_counter
import pokedex.shared.generated.resources.hatch_counter_value
import pokedex.shared.generated.resources.height
import pokedex.shared.generated.resources.legendary_pokemon
import pokedex.shared.generated.resources.mythical_pokemon
import pokedex.shared.generated.resources.weight

/* -------------------------------------------------------------------------- */
/* HERO CARD                                                                  */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonDetailItem(
    pokemon: PokemonInfo,
    dominantColor: Color,
    isDarkTheme: Boolean,
    currentLang: String,
    onTypeClick: (type: Type) -> Unit,
    modifier: Modifier = Modifier
) {

    BaseCardView(
        modifier = modifier.fillMaxWidth(),
        cardBackgroundColor = MaterialTheme.colorScheme.surfaceContainer,
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                PokemonArtwork(
                    imageUrl = pokemon.sprites.frontHome,
                    dominantColor = dominantColor
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    TitleText(
                        text = "#${pokemon.id}",
                        fontWeight = FontWeight.Bold,
                        textColor = dominantColor
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    TitleText(
                        text = pokemon.name.prettyName(),
                        maxLines = 1,
                        size = ComponentSize.MEDIUM,
                        textOverflow = TextOverflow.Ellipsis,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    BodyText(
                        text = pokemon.specieInfo?.getPokemonGenera(currentLang) ?: "",
                        textColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    val specieInfo = pokemon.specieInfo
                    val specieLabels = buildList {
                        if (specieInfo?.isBaby == true) add(stringResource(Res.string.baby_pokemon))
                        if (specieInfo?.isLegendary == true) add(stringResource(Res.string.legendary_pokemon))
                        if (specieInfo?.isMythical == true) add(stringResource(Res.string.mythical_pokemon))
                    }
                    if (specieLabels.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            specieLabels.forEach { label ->
                                BodyText(
                                    text = label,
                                    textColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    FlowRow(
                        maxLines = 1,
                        maxItemsInEachRow = 2,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        pokemon.types.forEach { type ->

                            TypeChip(
                                type = type,
                                onClick = {
                                    onTypeClick(type)
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider(
                color = dominantColor.copy(alpha = .12f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            AnimatedContent(
                targetState = pokemon.specieInfo?.getDescription(currentLang) ?: "",
                label = "pokemon_description",
                modifier = Modifier.fillMaxWidth()
            ) { description ->

                BodyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = description.replace("\n", " "),
                    maxLines = 5,
                    textOverflow = TextOverflow.Ellipsis,
                    textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Composable
private fun PokemonArtwork(
    imageUrl: String,
    dominantColor: Color
) {

    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy
        ),
        label = "pokemon_artwork_scale"
    )

    Box(
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
            .background(
                dominantColor.copy(alpha = .08f)
            ),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(.84f)
                .scale(scale),
            contentScale = ContentScale.Fit
        )
    }
}

/* -------------------------------------------------------------------------- */
/* SECTION CARD                                                               */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonSectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        BodyText(
            text = title,
            fontWeight = FontWeight.Bold,
            size = ComponentSize.LARGE,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        ElevatedCard(
            shape = RoundedCornerShape(28.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 6.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content
            )
        }
    }
}

/* -------------------------------------------------------------------------- */
/* BASIC INFO                                                                 */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonBasicInfoCard(
    pokemon: PokemonInfo
) {

    val items = listOf(
        PokemonInfoItem(
            title = stringResource(Res.string.base_exp),
            value = "${pokemon.baseExperience}",
            icon = Icons.Bolt,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.height),
            value = pokemon.height.formatHeight(),
            icon = Icons.UpArrow,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.weight),
            value = pokemon.weight.formatWeight(),
            icon = Icons.Scale,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.happiness),
            value = "${pokemon.specieInfo?.baseHappiness ?: 0}",
            icon = Icons.Heart,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.growth_rate),
            value = pokemon.specieInfo?.growthRate?.name ?: "-",
            icon = Icons.LevelUp,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.habitat),
            value = pokemon.specieInfo?.habitat?.name ?: "-",
            icon = Icons.Natures,
            iconTint = Color.Unspecified
        )
    )

    PokemonSectionCard(
        title = "Info"
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            maxItemsInEachRow = 2
        ) {

            items.forEach { item ->

                PokemonInfoGridItem(
                    item = item,
                    modifier = Modifier.fillMaxWidth(.48f)
                )
            }
        }
    }
}

data class PokemonInfoItem(
    val title: String,
    val value: String,
    val icon: ImageVector,
    val iconTint: Color = Color.Unspecified
)

@Composable
fun PokemonInfoGridItem(
    item: PokemonInfoItem,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TitleText(
            text = item.title,
            textAlign = TextAlign.Center,
            vector = item.icon,
            iconTint = item.iconTint,
        )

        TitleText(
            text = item.value.prettyName(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

/* -------------------------------------------------------------------------- */
/* BREEDING                                                                   */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonBreedingCard(
    pokemon: PokemonInfo,
    onEggGroupClick: (item: NamedResourceApi) -> Unit
) {

    PokemonSectionCard(
        title = "Breeding"
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            pokemon.specieInfo?.eggGroup?.forEach { eggGroup ->

                AssistChip(
                    leadingIcon = {

                        Icon(
                            imageVector = eggGroup.name.lowercase().toEggGroupIcon(),
                            contentDescription = eggGroup.name.lowercase(),
                            tint = Color.Unspecified,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    onClick = {
                        onEggGroupClick(eggGroup)
                    },
                    label = {
                        TitleText(
                            eggGroup.name.prettyName(),
                        )
                    },
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            PokemonInfoGridItem(
                modifier = Modifier.weight(1f),
                item = PokemonInfoItem(
                    title = stringResource(Res.string.capture_rate),
                    value = stringResource(Res.string.capture_rate_value).format(
                        pokemon.specieInfo?.captureRate ?: 0,
                        pokemon.specieInfo?.calculateCaptureRate() ?: 0
                    ),
                    icon = Icons.Pokeball
                )
            )

            PokemonInfoGridItem(
                modifier = Modifier.weight(1f),
                item = PokemonInfoItem(
                    title = stringResource(Res.string.hatch_counter),
                    value = stringResource(Res.string.hatch_counter_value).format(
                        pokemon.specieInfo?.hatchCounter ?: 0,
                        pokemon.specieInfo?.calculateHatchCounter() ?: 0
                    ),
                    icon = Icons.Egg
                )
            )
        }

        GenderRateBar(
            pokemon.specieInfo?.getGenderPossibility(),
        )
    }
}

@Composable
fun GenderRateBar(
    genderPossibility: GenderPossibility?
) {

    Column {

        LinearProgressIndicator(
            progress = { (genderPossibility?.male ?: 0f) / 100f },
            color = if (genderPossibility?.genderless == true) Color(0xFF7A757F) else Color(0xFF448AFF),
            trackColor = if (genderPossibility?.genderless == true) Color(0xFF7A757F) else Color(0xFFE040FB),
            drawStopIndicator = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(18.dp)
                .clip(RoundedCornerShape(50))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (genderPossibility?.genderless == true) {
                BodyText(stringResource(Res.string.genderless))
            } else {
                LabelText(
                    "${genderPossibility?.male}%",
                    vector = Icons.Male,
                    iconTint = Color.Unspecified
                )
                LabelText(
                    "${genderPossibility?.female}%",
                    vector = Icons.Female,
                    iconTint = Color.Unspecified
                )
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/* ABILITIES                                                                  */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonAbilitiesCard(
    pokemon: PokemonInfo,
    onAbilityClick: (item: Ability) -> Unit
) {

    PokemonSectionCard(
        title = "Abilities"
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            pokemon.abilities.forEach { ability ->

                ElevatedCard(
                    modifier = Modifier.clickable {
                        onAbilityClick(ability)
                    },
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(
                            horizontal = 14.dp,
                            vertical = 10.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = if (ability.isHidden) Icons.Default.AutoAwesome else Icons.Default.Psychology,
                            contentDescription = null,
                            tint = if (ability.isHidden) ratingColorContainerLight else MaterialTheme.colorScheme.primary,
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = ability.ability.name.prettyName()
                        )
                    }
                }
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/* SPRITES                                                                    */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonSpritesCard(
    pokemonSprites: List<Pair<String, String>>,
    onSpriteClick: (item: String) -> Unit
) {

    if (pokemonSprites.isEmpty()) return

    PokemonSectionCard(
        title = "Sprites"
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            maxItemsInEachRow = 2
        ) {

            pokemonSprites.forEach { sprite ->

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth(.48f)
                        .aspectRatio(1f)
                        .clickable {
                            onSpriteClick(sprite.first)
                        },
                    shape = RoundedCornerShape(24.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = sprite.first,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = sprite.second,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}


/* -------------------------------------------------------------------------- */
/* OTHER FORMS                                                                    */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonOtherFormsCard(
    pokemonOtherForms: List<Triple<String, String, String>>,
    onOtherFormsClick: (item: String) -> Unit
) {

    if (pokemonOtherForms.isEmpty()) return

    PokemonSectionCard(
        title = "Other Forms"
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            maxItemsInEachRow = 2
        ) {

            pokemonOtherForms.forEach { sprite ->

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth(.48f)
                        .aspectRatio(1f)
                        .clickable {
                            onOtherFormsClick(sprite.second)
                        },
                    shape = RoundedCornerShape(24.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = sprite.first,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = sprite.third,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}


/* -------------------------------------------------------------------------- */
/* TYPE CHIP                                                                  */
/* -------------------------------------------------------------------------- */

@Composable
fun TypeChip(
    type: Type,
    onClick: () -> Unit
) {


    AssistChip(
        onClick = onClick,
        leadingIcon = {

            Icon(
                imageVector = type.name.lowercase().toPokemonTypeIcon(),
                contentDescription = type.name.lowercase(),
                tint = Color.Unspecified,
                modifier = Modifier.size(18.dp)
            )
        },
        label = {
            TitleText(
                type.name.prettyName(),
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = type.name
                .toPokemonColor()
                .copy(alpha = .22f)
        )
    )
}

/* -------------------------------------------------------------------------- */
/* EXTENSIONS                                                                 */
/* -------------------------------------------------------------------------- */

@Composable
fun String.toPokemonColor(): Color {
    return when (lowercase()) {
        "normal" -> Color(0xFFA8A77A)
        "fire" -> Color(0xFFEE8130)
        "water" -> Color(0xFF6390F0)
        "electric" -> Color(0xFFF7D02C)
        "grass" -> Color(0xFF7AC74C)
        "ice" -> Color(0xFF96D9D6)
        "fighting" -> Color(0xFFC22E28)
        "poison" -> Color(0xFFA33EA1)
        "ground" -> Color(0xFFE2BF65)
        "flying" -> Color(0xFFA98FF3)
        "psychic" -> Color(0xFFF95587)
        "bug" -> Color(0xFFA6B91A)
        "rock" -> Color(0xFFB6A136)
        "ghost" -> Color(0xFF735797)
        "dragon" -> Color(0xFF6F35FC)
        "dark" -> Color(0xFF705746)
        "steel" -> Color(0xFFB7B7CE)
        "fairy" -> Color(0xFFD685AD)

        else -> MaterialTheme.colorScheme.primary
    }
}

fun String.toPokemonTypeIcon(): ImageVector {
    return when (lowercase()) {
        "normal" -> PokemonTypes.Normal
        "fire" -> PokemonTypes.Fire
        "water" -> PokemonTypes.Water
        "electric" -> PokemonTypes.Electric
        "grass" -> PokemonTypes.Grass
        "ice" -> PokemonTypes.Ice
        "fighting" -> PokemonTypes.Fighting
        "poison" -> PokemonTypes.Poison
        "ground" -> PokemonTypes.Ground
        "flying" -> PokemonTypes.Flying
        "psychic" -> PokemonTypes.Psychic
        "bug" -> PokemonTypes.Bug
        "rock" -> PokemonTypes.Rock
        "ghost" -> PokemonTypes.Ghost
        "dragon" -> PokemonTypes.Dragon
        "dark" -> PokemonTypes.Dark
        "steel" -> PokemonTypes.Steel
        "fairy" -> PokemonTypes.Fairy

        else -> Icons.Default.CatchingPokemon
    }
}

fun String.toEggGroupIcon(): ImageVector {

    return when (lowercase()) {

        // Reptiles / dragons
        "dragon" -> PokemonTypes.Dragon

        // Cute / fairy-like
        "fairy" -> PokemonTypes.Fairy

        // Plants
        "grass" -> PokemonTypes.Grass
        "plant" -> PokemonTypes.Grass

        // Aquatic
        "water1" -> PokemonTypes.Water
        "water2" -> PokemonTypes.Water
        "water3" -> PokemonTypes.Water

        // Flying creatures
        "flying" -> PokemonTypes.Flying

        // Insects
        "bug" -> PokemonTypes.Bug

        // Rocky creatures
        "mineral" -> PokemonTypes.Rock

        // Amorphous / ghost-like
        "amorphous" -> PokemonTypes.Ghost

        // Fighting / humanoid
        "human-like" -> PokemonTypes.Fighting
        "humanshape" -> PokemonTypes.Fighting

        // Toxic creatures
        "poison" -> PokemonTypes.Poison

        // Monster group
        "monster" -> PokemonTypes.Dark

        // Field group (generic mammals/beasts)
        "field" -> PokemonTypes.Normal
        "ground" -> PokemonTypes.Ground

        // Ditto
        "ditto" -> PokemonTypes.Psychic

        // Undiscovered / legendary babies
        "undiscovered" -> PokemonTypes.Steel

        else -> Icons.Default.CatchingPokemon
    }
}

@Composable
fun String.toEggGroupColor(): Color {

    return when (lowercase()) {

        "dragon" -> "dragon".toPokemonColor()
        "fairy" -> "fairy".toPokemonColor()

        "grass",
        "plant" -> "grass".toPokemonColor()

        "water1",
        "water2",
        "water3" -> "water".toPokemonColor()

        "flying" -> "flying".toPokemonColor()

        "bug" -> "bug".toPokemonColor()

        "mineral" -> "rock".toPokemonColor()

        "amorphous" -> "ghost".toPokemonColor()

        "human-like",
        "humanshape" -> "fighting".toPokemonColor()

        "poison" -> "poison".toPokemonColor()

        "monster" -> "dark".toPokemonColor()

        "field" -> "normal".toPokemonColor()

        "ditto" -> "psychic".toPokemonColor()

        "undiscovered" -> "steel".toPokemonColor()

        else -> MaterialTheme.colorScheme.primary
    }
}

fun String.prettyName(): String {
    return replaceFirstChar { it.uppercase() }.replace("-", " ")
}

fun Double.formatHeight(): String {
    return "${this / 10} m"
}

fun Double.formatWeight(): String {
    return "${this / 10} kg"
}

/* -------------------------------------------------------------------------- */
/* PREVIEWS                                                                   */
/* -------------------------------------------------------------------------- */

@Preview
@Composable
fun PreviewPokemonDetailItem() {

    MaterialTheme {

        Surface {

            PokemonDetailItem(
                pokemon = previewPokemon(),
                dominantColor = Color.Unspecified,
                isDarkTheme = false,
                currentLang = "en",
                onTypeClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonBasicInfoCard() {

    MaterialTheme {

        Surface {

            PokemonBasicInfoCard(
                pokemon = previewPokemon()
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonBreedingCard() {

    MaterialTheme {

        Surface {

            PokemonBreedingCard(
                pokemon = previewPokemon(),
                onEggGroupClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonAbilitiesCard() {

    MaterialTheme {

        Surface {

            PokemonAbilitiesCard(
                pokemon = previewPokemon(),
                onAbilityClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonSpritesCard() {

    MaterialTheme {

        Surface {

            PokemonSpritesCard(
                pokemonSprites = listOf(
                    Pair(
                        "front",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"
                    ),
                    Pair(
                        "back",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png"
                    ),
                    Pair(
                        "shiny",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/6.png"
                    ),
                    Pair(
                        "back-shiny",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/6.png"
                    )
                ),
                onSpriteClick = {}
            )
        }
    }
}

/* -------------------------------------------------------------------------- */
/* FAKE DATA                                                                  */
/* -------------------------------------------------------------------------- */

private fun previewPokemon(): PokemonInfo {

    return PokemonInfo(
        id = 6,
        name = "charizard",
        baseExperience = 240,
        height = 17.0,
        weight = 905.0,

        types = listOf(
            Type(
                slot = 1,
                name = "fire"
            ),
            Type(
                slot = 2,
                name = "flying"
            )
        ),

        abilities = listOf(
            Ability(
                ability = NamedResourceApi(
                    name = "blaze"
                ),
                isHidden = false
            ),
            Ability(
                ability = NamedResourceApi(
                    name = "solar-power"
                ),
                isHidden = true
            )
        ),

        sprites = Sprite(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png",
            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/6.png",
            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/6.png"
        ),

        specieInfo = SpecieInfo(

            baseHappiness = 50,
            captureRate = 45,
            genderRate = 1,
            hatchCounter = 20,

            growthRate = NamedResourceApi(
                name = "medium-slow"
            ),

            habitat = NamedResourceApi(
                name = "mountain"
            ),

            isLegendary = false,
            isMythical = false,
            isBaby = false,

            eggGroup = listOf(
                NamedResourceApi(name = "monster"),
                NamedResourceApi(name = "dragon")
            ),

            genera = listOf(
                PokemonGenera(
                    genus = "Flame Pokémon",
                    language = "en"
                )
            ),

            flavorText = listOf(
                FlavorText(
                    description = "Charizard flies around the sky in search of powerful opponents.",
                    language = "en"
                )
            ),

            names = listOf(
                Name(
                    name = "Charizard",
                    language = NamedResourceApi(
                        name = "en"
                    )
                )
            )
        )
    )
}