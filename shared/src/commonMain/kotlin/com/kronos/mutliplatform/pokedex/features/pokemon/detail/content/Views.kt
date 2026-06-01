package com.kronos.mutliplatform.pokedex.features.pokemon.detail.content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.BeachAccess
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.Forest
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Hiking
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.NaturePeople
import androidx.compose.material.icons.filled.NightShelter
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Phishing
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.ScreenRotation
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.SportsKabaddi
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.filled.Straight
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material.icons.filled.Umbrella
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import coil3.compose.AsyncImage
import com.kronos.mutliplatform.pokedex.components.EmptyList
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
import com.kronos.mutliplatform.pokedex.components.icon.NoEgg
import com.kronos.mutliplatform.pokedex.components.icon.Normal
import com.kronos.mutliplatform.pokedex.components.icon.Poison
import com.kronos.mutliplatform.pokedex.components.icon.Pokeball
import com.kronos.mutliplatform.pokedex.components.icon.PokemonTypes
import com.kronos.mutliplatform.pokedex.components.icon.Psychic
import com.kronos.mutliplatform.pokedex.components.icon.Rock
import com.kronos.mutliplatform.pokedex.components.icon.Scale
import com.kronos.mutliplatform.pokedex.components.icon.Steel
import com.kronos.mutliplatform.pokedex.components.icon.TmDisk
import com.kronos.mutliplatform.pokedex.components.icon.UpArrow
import com.kronos.mutliplatform.pokedex.components.icon.Water
import com.kronos.mutliplatform.pokedex.components.icon.games.GameBdsp
import com.kronos.mutliplatform.pokedex.components.icon.games.GameBlack2White2
import com.kronos.mutliplatform.pokedex.components.icon.games.GameBlackWhite
import com.kronos.mutliplatform.pokedex.components.icon.games.GameColosseum
import com.kronos.mutliplatform.pokedex.components.icon.games.GameCrystal
import com.kronos.mutliplatform.pokedex.components.icon.games.GameDiamondPearl
import com.kronos.mutliplatform.pokedex.components.icon.games.GameEmerald
import com.kronos.mutliplatform.pokedex.components.icon.games.GameFireredLeafgreen
import com.kronos.mutliplatform.pokedex.components.icon.games.GameGoldSilver
import com.kronos.mutliplatform.pokedex.components.icon.games.GameHeartgoldSoulsilver
import com.kronos.mutliplatform.pokedex.components.icon.games.GameLegendsArceus
import com.kronos.mutliplatform.pokedex.components.icon.games.GameLgpe
import com.kronos.mutliplatform.pokedex.components.icon.games.GameOras
import com.kronos.mutliplatform.pokedex.components.icon.games.GamePlatinum
import com.kronos.mutliplatform.pokedex.components.icon.games.GameRedBlue
import com.kronos.mutliplatform.pokedex.components.icon.games.GameRubySapphire
import com.kronos.mutliplatform.pokedex.components.icon.games.GameScarletViolet
import com.kronos.mutliplatform.pokedex.components.icon.games.GameSunMoon
import com.kronos.mutliplatform.pokedex.components.icon.games.GameSwordShield
import com.kronos.mutliplatform.pokedex.components.icon.games.GameUsum
import com.kronos.mutliplatform.pokedex.components.icon.games.GameXd
import com.kronos.mutliplatform.pokedex.components.icon.games.GameXy
import com.kronos.mutliplatform.pokedex.components.icon.games.GameYellow
import com.kronos.mutliplatform.pokedex.components.icon.games.Games
import com.kronos.mutliplatform.pokedex.components.icon.games.Pokemon
import com.kronos.mutliplatform.pokedex.core.ui.components.BaseCardView
import com.kronos.mutliplatform.pokedex.core.ui.components.BodyText
import com.kronos.mutliplatform.pokedex.core.ui.components.ComponentSize
import com.kronos.mutliplatform.pokedex.core.ui.components.LabelText
import com.kronos.mutliplatform.pokedex.core.ui.components.TitleText
import com.kronos.mutliplatform.pokedex.core.ui.components.button.IconButton
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.AppTheme
import com.kronos.mutliplatform.pokedex.core.ui.components.theme.ratingColorContainerLight
import com.kronos.mutliplatform.pokedex.core.util.format
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionDetail
import com.kronos.mutliplatform.pokedex.domain.model.game.Game
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.EncounterDetail
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.VersionDetail
import com.kronos.mutliplatform.pokedex.domain.model.specie.GenderPossibility
import com.kronos.mutliplatform.pokedex.domain.model.specie.PokemonGenera
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.domain.PokemonOtherForm
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages.PokemonStatsTab
import org.jetbrains.compose.resources.stringResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.baby_pokemon
import pokedex.shared.generated.resources.empty_pokemon_ability_list
import pokedex.shared.generated.resources.legendary_pokemon
import pokedex.shared.generated.resources.mythical_pokemon
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter_game_version
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter_max_chance
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter_max_level
import pokedex.shared.generated.resources.pokemon_detail_tab_encounter_min_level
import pokedex.shared.generated.resources.pokemon_detail_tab_info_base_exp
import pokedex.shared.generated.resources.pokemon_detail_tab_info_capture_rate
import pokedex.shared.generated.resources.pokemon_detail_tab_info_capture_rate_value
import pokedex.shared.generated.resources.pokemon_detail_tab_info_genderless
import pokedex.shared.generated.resources.pokemon_detail_tab_info_growth_rate
import pokedex.shared.generated.resources.pokemon_detail_tab_info_habitat
import pokedex.shared.generated.resources.pokemon_detail_tab_info_happiness
import pokedex.shared.generated.resources.pokemon_detail_tab_info_hatch_counter
import pokedex.shared.generated.resources.pokemon_detail_tab_info_hatch_counter_value
import pokedex.shared.generated.resources.pokemon_detail_tab_info_height
import pokedex.shared.generated.resources.pokemon_detail_tab_info_high_happiness
import pokedex.shared.generated.resources.pokemon_detail_tab_info_lower_happiness
import pokedex.shared.generated.resources.pokemon_detail_tab_info_no_info_available
import pokedex.shared.generated.resources.pokemon_detail_tab_info_normal_happiness
import pokedex.shared.generated.resources.pokemon_detail_tab_info_weight
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_attack
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_defense
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_ev_yield
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_hp
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_max_stats
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_max_stats_tooltip
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_special_attack
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_special_defense
import pokedex.shared.generated.resources.pokemon_detail_tab_stats_speed

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
                        maxItemsInEachRow = 2,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
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

        BaseCardView(
            shape = RoundedCornerShape(28.dp),
            elevation = 6.dp
        ) {

            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content
            )
        }
    }
}


@Composable
fun PokemonEncounterSectionCard(
    title: String,
    icon: ImageVector,
    iconTint: Color,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        BodyText(
            text = title,
            vector = icon,
            iconTint = iconTint,
            fontWeight = FontWeight.Bold,
            size = ComponentSize.LARGE,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        BaseCardView(
            cardBackgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {

            Column(
                modifier = Modifier,
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
            title = stringResource(Res.string.pokemon_detail_tab_info_base_exp),
            value = "${pokemon.baseExperience}",
            icon = Icons.Bolt,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.pokemon_detail_tab_info_height),
            value = pokemon.height.formatHeight(),
            icon = Icons.UpArrow,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.pokemon_detail_tab_info_weight),
            value = pokemon.weight.formatWeight(),
            icon = Icons.Scale,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.pokemon_detail_tab_info_happiness),
            value =
                when {
                    (pokemon.specieInfo?.baseHappiness ?: 0) in 0..<50 -> {
                        stringResource(Res.string.pokemon_detail_tab_info_lower_happiness)
                    }

                    (pokemon.specieInfo?.baseHappiness ?: 0) in 50..<100 -> {
                        stringResource(Res.string.pokemon_detail_tab_info_normal_happiness)
                    }

                    (pokemon.specieInfo?.baseHappiness ?: 0) >= 100 -> {
                        stringResource(Res.string.pokemon_detail_tab_info_high_happiness)
                    }

                    else -> {
                        stringResource(Res.string.pokemon_detail_tab_info_no_info_available)
                    }
                },
            icon = Icons.Heart,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.pokemon_detail_tab_info_growth_rate),
            value = pokemon.specieInfo?.growthRate?.name?.takeIf { it.isNotBlank() }
                ?: stringResource(Res.string.pokemon_detail_tab_info_no_info_available),
            icon = Icons.LevelUp,
            iconTint = Color.Unspecified
        ),
        PokemonInfoItem(
            title = stringResource(Res.string.pokemon_detail_tab_info_habitat),
            value = pokemon.specieInfo?.habitat?.name?.takeIf { it.isNotBlank() }
                ?: stringResource(Res.string.pokemon_detail_tab_info_no_info_available),
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
                    title = stringResource(Res.string.pokemon_detail_tab_info_capture_rate),
                    value = stringResource(Res.string.pokemon_detail_tab_info_capture_rate_value).format(
                        pokemon.specieInfo?.captureRate ?: 0,
                        pokemon.specieInfo?.calculateCaptureRate() ?: 0
                    ),
                    icon = Icons.Pokeball
                )
            )

            PokemonInfoGridItem(
                modifier = Modifier.weight(1f),
                item = PokemonInfoItem(
                    title = stringResource(Res.string.pokemon_detail_tab_info_hatch_counter),
                    value = stringResource(Res.string.pokemon_detail_tab_info_hatch_counter_value).format(
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
            color = if (genderPossibility?.genderless == true) Color(0xFF7A757F) else Color(
                0xFF448AFF
            ),
            trackColor = if (genderPossibility?.genderless == true) Color(0xFF7A757F) else Color(
                0xFFE040FB
            ),
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
                BodyText(stringResource(Res.string.pokemon_detail_tab_info_genderless))
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
        title = "Abilities",
    ) {

        if (pokemon.abilities.isEmpty()){
            EmptyList(
                icon = null,
                title = stringResource(Res.string.empty_pokemon_ability_list),
                modifier = Modifier.fillMaxWidth()
            )
        }else{
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                pokemon.abilities.forEach { ability ->

                    BaseCardView(
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

                BaseCardView(
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
    pokemonOtherForms: List<PokemonOtherForm>,
    onOtherFormsClick: (item: NamedResourceApi) -> Unit
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

                BaseCardView(
                    modifier = Modifier
                        .fillMaxWidth(.48f)
                        .aspectRatio(1f),
                    shape = RoundedCornerShape(24.dp),
                    onClick = {
                        onOtherFormsClick(NamedResourceApi(sprite.name, sprite.url))
                    }
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = sprite.imgUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = sprite.nameFormatted,
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
/* ENCOUNTERS                                                               */
/* -------------------------------------------------------------------------- */

private val ColorVersion = Color(0xFF534AB7)   // purple
private val ColorMinLevel = Color(0xFF1D9E75)  // teal
private val ColorMaxLevel = Color(0xFFBA7517)  // amber
private val ColorChance = Color(0xFFD85A30)    // coral

@Composable
fun PokemonEncounterGridItem(
    item: Encounter,
    modifier: Modifier = Modifier,
) {
    PokemonEncounterSectionCard(
        title = item.location.name.prettyName(),
        icon = Icons.Default.Place,
        iconTint = MaterialTheme.colorScheme.onSurface,
        modifier = modifier.background(Color.Transparent)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            maxItemsInEachRow = 2
        ) {
            item.versionDetails.forEach { detail ->
                VersionItem(
                    item = detail,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun VersionItem(
    item: VersionDetail,
    modifier: Modifier = Modifier,
) {
    val methodName = item.encounterDetail.method.name
    val (badgeBg, badgeFg) = encounterMethodColors(methodName)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(badgeBg)
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = encounterMethodIcon(methodName),
                contentDescription = null,
                tint = badgeFg,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = methodName.prettyName(),
                style = MaterialTheme.typography.labelMedium,
                color = badgeFg,
                fontWeight = FontWeight.Medium
            )
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 0.5.dp
        )

        val infoItems = listOf(
            PokemonInfoItem(
                title = stringResource(Res.string.pokemon_detail_tab_encounter_game_version),
                value = item.version.name.prettyName(),
                icon = Icons.Default.VideogameAsset,
                iconTint = ColorVersion
            ),
            PokemonInfoItem(
                title = stringResource(Res.string.pokemon_detail_tab_encounter_min_level),
                value = item.encounterDetail.minLevel.toString(),
                icon = Icons.Default.KeyboardArrowDown,
                iconTint = ColorMinLevel
            ),
            PokemonInfoItem(
                title = stringResource(Res.string.pokemon_detail_tab_encounter_max_level),
                value = item.encounterDetail.maxLevel.toString(),
                icon = Icons.Default.KeyboardArrowUp,
                iconTint = ColorMaxLevel
            ),
            PokemonInfoItem(
                title = stringResource(Res.string.pokemon_detail_tab_encounter_max_chance),
                value = "${item.encounterDetail.chance}%",
                icon = Icons.Default.Percent,
                iconTint = ColorChance
            ),
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            infoItems.forEach { info ->
                PokemonInfoGridItem(
                    item = info,
                    modifier = Modifier.fillMaxWidth(.48f)
                )
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/* EVOLUTION CHAINS                                                                 */
/* -------------------------------------------------------------------------- */

@Composable
fun EvolutionChainItem(
    sprite: String?,
    chain: ChainLink,
    detail: EvolutionDetail?,
    dominantColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
    onChainClick: ((item: NamedResourceApi) -> Unit)? = null,
) {
    val isSelected = chain.isCurrentSelected
    val hasDetails = chain.evolutionDetails.isNotEmpty() && detail != null

    BaseCardView(
        modifier = modifier.fillMaxWidth(),
        cardBackgroundColor = if (isSelected)
            dominantColor.copy(alpha = .08f)
        else
            MaterialTheme.colorScheme.surfaceContainer,
        elevation = 0.dp,
        onClick = {
            onChainClick?.invoke(chain.species)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // ── Sprite ───────────────────────────────────────────────────────
            EvolutionArtwork(
                imageUrl = sprite,
                dominantColor = dominantColor,
                isSelected = isSelected
            )

            Spacer(modifier = Modifier.height(10.dp))

            // ── Name ─────────────────────────────────────────────────────────
            TitleText(
                text = chain.species.name.prettyName(),
                fontWeight = FontWeight.Bold,
                textColor = if (isSelected) dominantColor
                else MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 1,
                textOverflow = TextOverflow.Ellipsis,
            )

            // ── Evolution details ─────────────────────────────────────────────
            AnimatedVisibility(visible = hasDetails) {
                if (detail != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 14.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        HorizontalDivider(
                            color = dominantColor.copy(alpha = .12f),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        EvolutionDetails(chain = chain, detail = detail)
                    }
                }
            }
        }
    }
}

// ─── Sprite ───────────────────────────────────────────────────────────────────

@Composable
private fun EvolutionArtwork(
    imageUrl: String?,
    dominantColor: Color,
    isSelected: Boolean
) {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "evo_artwork_scale"
    )

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(dominantColor.copy(alpha = if (isSelected) .14f else .07f)),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(.85f)
                .scale(scale),
            contentScale = ContentScale.Fit
        )
    }
}

// ─── Details rows ─────────────────────────────────────────────────────────────

@Composable
private fun EvolutionDetails(
    chain: ChainLink,
    detail: EvolutionDetail
) {
    // Evolves from
    chain.evolvesFrom.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Pokeball,
            label = "Evolves from",
            value = it.prettyName()
        )
    }

    // Trigger
    detail.trigger?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Bolt,
            label = "Trigger",
            value = it.prettyName()
        )
    }

    // Min level
    detail.minLevel?.let {
        EvolutionDetailRow(
            icon = Icons.LevelUp,
            label = "Level",
            value = "Lv. $it"
        )
    }

    // Use item
    detail.item?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.Inventory2,
            iconTint = Color(0xFFC22E28),
            label = "Use item",
            value = it.prettyName()
        )
    }

    // Held item
    detail.heldItem?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.Inventory2,
            iconTint = Color(0xFFC22E28),
            label = "Held item",
            value = it.prettyName()
        )
    }

    // Min happiness
    detail.minHappiness?.takeIf { it > 0 }?.let {
        EvolutionDetailRow(
            icon = Icons.Heart,
            label = "Happiness",
            value = "≥ $it"
        )
    }

    // Min affection
    detail.minAffection?.takeIf { it > 0 }?.let {
        EvolutionDetailRow(
            icon = Icons.Heart,
            label = "Affection",
            value = "≥ $it"
        )
    }

    // Min beauty
    detail.minBeauty?.takeIf { it > 0 }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.AutoAwesome,
            iconTint = Color(0xFFF7D02C),
            label = "Beauty",
            value = "≥ $it"
        )
    }

    // Gender
    detail.gender?.let { genderId ->
        val (icon, label) = when (genderId) {
            1 -> Icons.Female to "Female"
            else -> Icons.Male to "Male"
        }
        EvolutionDetailRow(
            icon = icon,
            label = "Gender",
            value = label
        )
    }

    // Known move
    detail.knownMove?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.SportsKabaddi,
            iconTint = Color(0xFF444441),
            label = "Know move",
            value = it.prettyName()
        )
    }

    // Known move type
    detail.knownMoveType?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.TmDisk,
            label = "Move type",
            value = it.prettyName()
        )
    }

    // Location
    detail.location?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.Place,
            iconTint = Color(0xFFA8A77A),
            label = "Location",
            value = it.prettyName()
        )
    }

    // Party species
    detail.partySpecies?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.Group,
            iconTint = Color(0xFFA8A77A),
            label = "Party member",
            value = it.prettyName()
        )
    }

    // Party type
    detail.partyType?.name?.takeIf { it.isNotBlank() }?.let {
        EvolutionDetailRow(
            icon = Icons.Default.Category,
            iconTint = Color(0xFFC22E28),
            label = "Party type",
            value = it.prettyName()
        )
    }

    // Time of day
    detail.timeOfDay?.takeIf { it.isNotBlank() }?.let {
        val icon = when (it.lowercase()) {
            "day" -> Icons.Default.WbSunny
            "night" -> Icons.Default.NightShelter
            else -> Icons.Default.AccessTime
        }
        val iconTint = when (it.lowercase()) {
            "day" -> Color(0xFFF7D02C)
            "night" -> Color(0xFF444441)
            else -> Color(0xFF2C2C2A)
        }

        EvolutionDetailRow(
            icon = icon,
            iconTint = iconTint,
            label = "Time of day",
            value = it.prettyName()
        )
    }

    // Needs rain
    if (detail.needsOverworldRain) {
        EvolutionDetailRow(
            icon = Icons.Default.Umbrella,
            iconTint = Color(0xFF185FA5),
            label = "Raining",
            value = "Required"
        )
    }

    // Turn upside down
    if (detail.turnUpsideDown) {
        EvolutionDetailRow(
            icon = Icons.Default.ScreenRotation,
            iconTint = Color(0xFF993C1D),
            label = "Turn upside down",
            value = "Required"
        )
    }
}

// ─── Single detail row ────────────────────────────────────────────────────────

@Composable
private fun EvolutionDetailRow(
    label: String,
    value: String,
    icon: ImageVector,
    iconTint: Color = Color.Unspecified,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(16.dp)
            )
            LabelText(
                text = label,
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            LabelText(
                text = value,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

/* -------------------------------------------------------------------------- */
/* STATS                                                                 */
/* -------------------------------------------------------------------------- */

// StatCircleItem.kt
@Composable
fun StatCircleItem(
    stat: Stat,
    statTotal: Int,
    modifier: Modifier = Modifier
) {
    val statColor = statColor(stat.statName)
    val animatedProgress = remember { Animatable(0f) }
    val progress = if (statTotal > 0) stat.baseStat.toFloat() / statTotal.toFloat() else 0f

    LaunchedEffect(stat.baseStat) {
        animatedProgress.animateTo(
            targetValue = progress,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(72.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val strokeWidth = 6.dp.toPx()
                val radius = (size.minDimension - strokeWidth) / 2
                val center = Offset(size.width / 2, size.height / 2)
                // Track
                drawCircle(
                    color = statColor.copy(alpha = 0.15f),
                    radius = radius,
                    center = center,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
                // Progress
                drawArc(
                    color = statColor,
                    startAngle = -90f,
                    sweepAngle = 360f * animatedProgress.value,
                    useCenter = false,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                    topLeft = Offset(center.x - radius, center.y - radius),
                    size = Size(radius * 2, radius * 2)
                )
            }
            Text(
                text = stat.baseStat.toString(),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                color = statColor
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = statShortName(stat.statName),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Composable
fun MaxStatsSection(
    pokemonStats: List<Stat>,
) {
    var showTooltip by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TitleText(
                text = stringResource(Res.string.pokemon_detail_tab_stats_max_stats),
                size = ComponentSize.MEDIUM,
                fontWeight = FontWeight.Bold,
                textColor = MaterialTheme.colorScheme.onBackground
            )
            Box {
                IconButton(
                    onClick = { showTooltip = !showTooltip },
                    icon = Icons.Outlined.Info,
                    modifier = Modifier.size(24.dp)
                )
                if (showTooltip) {
                    Popup(
                        alignment = Alignment.TopStart,
                        offset = IntOffset(0, -120),
                        onDismissRequest = { showTooltip = false }
                    ) {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.inverseSurface,
                            tonalElevation = 4.dp,
                            modifier = Modifier.widthIn(max = 240.dp)
                        ) {
                            BodyText(
                                text = stringResource(Res.string.pokemon_detail_tab_stats_max_stats_tooltip),
                                size = ComponentSize.SMALL,
                                textColor = MaterialTheme.colorScheme.inverseOnSurface,
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
            }
        }

        pokemonStats.forEach { stat ->
            MaxStatRow(stat = stat)
        }
    }
}

@Composable
fun MaxStatRow(
    stat: Stat
) {
    val statColor = statColor(stat.statName)
    val maxValue = stat.calculateMaxStat()
    val animatedProgress = remember { Animatable(0f) }

    val absoluteMax = if (stat.statName.lowercase() == "hp") 714f else 526f

    LaunchedEffect(maxValue) {
        animatedProgress.animateTo(
            targetValue = maxValue / absoluteMax,
            animationSpec = tween(1000, easing = FastOutSlowInEasing)
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        LabelText(
            text = statShortName(stat.statName),
            size = ComponentSize.SMALL,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(52.dp)
        )
        LinearProgressIndicator(
            progress = { animatedProgress.value },
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .clip(CircleShape),
            color = statColor,
            trackColor = statColor.copy(alpha = 0.15f),
            strokeCap = StrokeCap.Round
        )
        LabelText(
            text = maxValue.toString(),
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.Bold,
            textColor = statColor,
            modifier = Modifier.width(36.dp),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun EvYieldSection(
    evYield: List<Stat>,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TitleText(
            text = stringResource(Res.string.pokemon_detail_tab_stats_ev_yield),
            size = ComponentSize.MEDIUM,
            fontWeight = FontWeight.Bold,
            textColor = MaterialTheme.colorScheme.onBackground
        )
        evYield.forEach { stat ->
            val statColor = statColor(stat.statName)
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = statColor.copy(alpha = 0.10f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BodyText(
                        text = statShortName(stat.statName),
                        size = ComponentSize.MEDIUM,
                        fontWeight = FontWeight.Medium,
                        textColor = statColor
                    )
                    Surface(
                        color = statColor.copy(alpha = 0.20f),
                        shape = CircleShape
                    ) {
                        LabelText(
                            text = "+${stat.statEffort}",
                            size = ComponentSize.LARGE,
                            fontWeight = FontWeight.Bold,
                            textColor = statColor,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/* GAME                                                                 */
/* -------------------------------------------------------------------------- */

@Composable
fun PokemonGameGridItem(
    item: Game,
    modifier: Modifier = Modifier
) {
    BaseCardView(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                imageVector = gameIcon(item.name),
                contentDescription = item.name,
                modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            BodyText(
                text = item.name
                    .replace("-", " ")
                    .replaceFirstChar { it.uppercase() },
                size = ComponentSize.LARGE,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/* -------------------------------------------------------------------------- */
/* EXTENSIONS                                                                 */
/* -------------------------------------------------------------------------- */

fun gameIcon(gameName: String): ImageVector {
    return when (gameName.lowercase()) {
        "red" -> Games.GameRedBlue
        "blue" -> Games.GameRedBlue
        "yellow" -> Games.GameYellow
        "gold" -> Games.GameGoldSilver
        "silver" -> Games.GameGoldSilver
        "crystal" -> Games.GameCrystal
        "ruby" -> Games.GameRubySapphire
        "sapphire" -> Games.GameRubySapphire
        "emerald" -> Games.GameEmerald
        "firered" -> Games.GameFireredLeafgreen
        "leafgreen" -> Games.GameFireredLeafgreen
        "diamond" -> Games.GameDiamondPearl
        "pearl" -> Games.GameDiamondPearl
        "platinum" -> Games.GamePlatinum
        "heartgold" -> Games.GameHeartgoldSoulsilver
        "soulsilver" -> Games.GameHeartgoldSoulsilver
        "black" -> Games.GameBlackWhite
        "white" -> Games.GameBlackWhite
        "colosseum" -> Games.GameColosseum
        "xd" -> Games.GameXd
        "black-2" -> Games.GameBlack2White2
        "white-2" -> Games.GameBlack2White2
        "x" -> Games.GameXy
        "y" -> Games.GameXy
        "omega-ruby" -> Games.GameOras
        "alpha-sapphire" -> Games.GameOras
        "sun" -> Games.GameSunMoon
        "moon" -> Games.GameSunMoon
        "ultra-sun" -> Games.GameUsum
        "ultra-moon" -> Games.GameUsum
        "lets-go-pikachu" -> Games.GameLgpe
        "lets-go-eevee" -> Games.GameLgpe
        "sword" -> Games.GameSwordShield
        "shield" -> Games.GameSwordShield
        "the-isle-of-armor" -> Games.GameSwordShield
        "the-crown-tundra" -> Games.GameSwordShield
        "brilliant-diamond" -> Games.GameBdsp
        "shining-pearl" -> Games.GameBdsp
        "legends-arceus" -> Games.GameLegendsArceus
        "scarlet" -> Games.GameScarletViolet
        "violet" -> Games.GameScarletViolet
        "the-teal-mask" -> Games.GameScarletViolet
        "the-indigo-disk" -> Games.GameScarletViolet
        else -> Games.Pokemon
    }
}

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

        else -> Icons.NoEgg
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

private data class EncounterColors(val bg: Color, val fg: Color)

private fun encounterMethodIcon(method: String): ImageVector {
    val m = method.lowercase()
    return when {
        m.contains("walk") || m.contains("dark-grass") || m.contains("grass-spot") ||
                m.contains("shaking-grass") || m.contains("sweet-scent") ->
            Icons.AutoMirrored.Filled.DirectionsWalk

        m.contains("rough-terrain") ->
            Icons.Default.Hiking

        m.contains("flower") ->
            Icons.Default.LocalFlorist

        m.contains("rod") || m.contains("fishing") ->
            Icons.Default.Phishing

        m.contains("surf") ->
            Icons.Default.Pool

        m.contains("cave") || m.contains("rock-smash") ->
            Icons.Default.Terrain

        m.contains("headbutt") ->
            Icons.Default.Forest

        m.contains("bridge") ->
            Icons.Default.Straight

        m.contains("radar") ->
            Icons.Default.TravelExplore

        m.contains("devon") || m.contains("scope") ->
            Icons.Default.Visibility

        m.contains("roamer") ->
            Icons.Default.Air

        m.contains("only-one") ->
            Icons.Default.Stars

        m.contains("gift") ->
            Icons.Default.CardGiftcard

        m.contains("hatch") || m.contains("egg") ->
            Icons.Default.Egg

        m.contains("grotto") ->
            Icons.Default.NaturePeople

        m.contains("sos") ->
            Icons.Default.Wifi

        m.contains("raid") || m.contains("dynamax") ->
            Icons.Default.Shield

        m.contains("shaking-tree") || m.contains("tree") ->
            Icons.Default.Park

        m.contains("shadow") ->
            Icons.Default.DarkMode

        m.contains("overworld") || m.contains("terrestrial") ->
            Icons.Default.Public

        m.contains("sky") ->
            Icons.Default.CloudQueue

        m.contains("starter") ->
            Icons.Default.AutoAwesome

        m.contains("grass") ->
            Icons.Default.Grass

        m.contains("poke-radar") ->
            Icons.Default.TravelExplore

        m.contains("shaking") ->
            Icons.Default.Park

        m.contains("island-scan") || m.contains("island") ->
            Icons.Default.BeachAccess

        m.contains("horde") ->
            Icons.Default.Groups

        m.contains("snag") ->
            Icons.Default.CatchingPokemon

        m.contains("pokeflute") || m.contains("flute") ->
            Icons.Default.MusicNote

        m.contains("colosseum") || m.contains("bonus-disc") ->
            Icons.Default.Album

        else -> Icons.Default.QuestionMark
    }
}

private fun encounterMethodColors(method: String): EncounterColors {
    val m = method.lowercase()
    return when {
        m.contains("walk") || m.contains("dark-grass") || m.contains("grass-spot") ||
                m.contains("shaking-grass") || m.contains("sweet-scent") || m.contains("rough-terrain") ->
            EncounterColors(Color(0xFFE1F5EE), Color(0xFF0F6E56))

        m.contains("flower") ->
            EncounterColors(Color(0xFFEAF3DE), Color(0xFF3B6D11))

        m.contains("surf") ->
            EncounterColors(Color(0xFFE6F1FB), Color(0xFF185FA5))

        m.contains("rod") || m.contains("fishing") ->
            EncounterColors(Color(0xFFFAEEDA), Color(0xFF854F0B))

        m.contains("cave") || m.contains("rock-smash") ->
            EncounterColors(Color(0xFFF1EFE8), Color(0xFF5F5E5A))

        m.contains("headbutt") || m.contains("shaking-tree") ->
            EncounterColors(Color(0xFFEAF3DE), Color(0xFF27500A))

        m.contains("bridge") ->
            EncounterColors(Color(0xFFD3D1C7), Color(0xFF444441))

        m.contains("radar") || m.contains("devon") || m.contains("scope") ->
            EncounterColors(Color(0xFFEEEDFE), Color(0xFF3C3489))

        m.contains("roamer") ->
            EncounterColors(Color(0xFFFAECE7), Color(0xFF993C1D))

        m.contains("only-one") ->
            EncounterColors(Color(0xFFFBEAF0), Color(0xFF993556))

        m.contains("gift") || m.contains("hatch") || m.contains("egg") ->
            EncounterColors(Color(0xFFE1F5EE), Color(0xFF085041))

        m.contains("grotto") ->
            EncounterColors(Color(0xFFEAF3DE), Color(0xFF173404))

        m.contains("sos") ->
            EncounterColors(Color(0xFFE6F1FB), Color(0xFF0C447C))

        m.contains("raid") || m.contains("dynamax") ->
            EncounterColors(Color(0xFFFCEBEB), Color(0xFFA32D2D))

        m.contains("shadow") ->
            EncounterColors(Color(0xFFD3D1C7), Color(0xFF2C2C2A))

        m.contains("overworld") || m.contains("terrestrial") ->
            EncounterColors(Color(0xFFE1F5EE), Color(0xFF1D9E75))

        m.contains("sky") ->
            EncounterColors(Color(0xFFE6F1FB), Color(0xFF378ADD))

        m.contains("starter") ->
            EncounterColors(Color(0xFFFBEAF0), Color(0xFF72243E))

        m.contains("grass") || m.contains("shaking") ->
            EncounterColors(Color(0xFFEAF3DE), Color(0xFF639922))

        m.contains("island-scan") || m.contains("island") ->
            EncounterColors(Color(0xFFE6F1FB), Color(0xFF185FA5))

        m.contains("horde") ->
            EncounterColors(Color(0xFFFCEBEB), Color(0xFFA32D2D))

        m.contains("snag") ->
            EncounterColors(Color(0xFFEEEDFE), Color(0xFF534AB7))

        m.contains("pokeflute") || m.contains("flute") ->
            EncounterColors(Color(0xFFFBEAF0), Color(0xFF72243E))

        m.contains("colosseum") || m.contains("bonus-disc") ->
            EncounterColors(Color(0xFFFAEEDA), Color(0xFF854F0B))

        else ->
            EncounterColors(Color(0xFFF1EFE8), Color(0xFF888780))
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

@Composable
fun statColor(statName: String): Color {
    return when (statName.lowercase()) {
        "hp" -> Color(0xFFFF5959)
        "attack" -> Color(0xFFF08030)
        "defense" -> Color(0xFFF8D030)
        "special-attack" -> Color(0xFF6890F0)
        "special-defense" -> Color(0xFF78C850)
        "speed" -> Color(0xFFF85888)
        else -> MaterialTheme.colorScheme.primary
    }
}

@Composable
fun statShortName(statName: String): String {
    return when (statName.lowercase()) {
        "hp" -> stringResource(Res.string.pokemon_detail_tab_stats_hp)
        "attack" -> stringResource(Res.string.pokemon_detail_tab_stats_attack)
        "defense" -> stringResource(Res.string.pokemon_detail_tab_stats_defense)
        "special-attack" -> stringResource(Res.string.pokemon_detail_tab_stats_special_attack)
        "special-defense" -> stringResource(Res.string.pokemon_detail_tab_stats_special_defense)
        "speed" -> stringResource(Res.string.pokemon_detail_tab_stats_speed)
        else -> statName.take(6).uppercase()
    }
}

/* -------------------------------------------------------------------------- */
/* PREVIEWS                                                                   */
/* -------------------------------------------------------------------------- */

@Preview
@Composable
fun PreviewPokemonDetailItem() {

    AppTheme {
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

    AppTheme {

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

    AppTheme {

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

    AppTheme {

        Surface {

            PokemonAbilitiesCard(
                pokemon = previewPokemonNoAbility(),
                onAbilityClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonSpritesCard() {

    AppTheme {

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
                name = "dragon"
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
private fun previewPokemonNoAbility(): PokemonInfo {

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
                name = "dragon"
            )
        ),

        abilities = listOf(

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

// --- Preview Data ---

private val mockEncounterDetail = EncounterDetail(
    method = NamedResourceApi(name = "walk"),
    minLevel = 5,
    maxLevel = 15,
    chance = 30
)

private val mockVersionDetail = VersionDetail(
    encounterDetail = mockEncounterDetail
)

private val mockEncounter = Encounter(
    location = NamedResourceApi(name = "pallet-town-area"),
    versionDetails = listOf(
        mockVersionDetail,
        mockVersionDetail.copy(
            encounterDetail = mockEncounterDetail.copy(
                method = NamedResourceApi(name = "surf"),
                minLevel = 10,
                maxLevel = 25,
                chance = 15
            )
        )
    )
)

// --- Previews ---

@Preview
@Composable
private fun VersionItemPreview() {
    AppTheme {
        VersionItem(
            item = mockVersionDetail,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun PokemonEncounterGridItemPreview() {
    AppTheme {
        Surface {

            PokemonEncounterGridItem(
                item = mockEncounter,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PokemonEncounterGridItemMultipleVersionsPreview() {
    AppTheme {
        Surface {
            PokemonEncounterGridItem(
                item = mockEncounter.copy(
                    location = NamedResourceApi(name = "viridian-forest"),
                    versionDetails = listOf(
                        mockVersionDetail,
                        mockVersionDetail.copy(
                            encounterDetail = mockEncounterDetail.copy(
                                method = NamedResourceApi(
                                    name = "surf"
                                )
                            )
                        ),
                        mockVersionDetail.copy(
                            encounterDetail = mockEncounterDetail.copy(
                                method = NamedResourceApi(
                                    name = "old-rod"
                                )
                            )
                        ),
                    )
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EvolutionChainItemPreview_Selected() {
    AppTheme {
        EvolutionChainItem(
            sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            dominantColor = Color(0xFFEE8130),
            chain = ChainLink(
                evolvesFrom = "charmeleon",
                isCurrentSelected = true,
                species = NamedResourceApi(
                    name = "charizard"
                ),
                evolutionDetails = listOf(
                    EvolutionDetail(
                        trigger = NamedResourceApi(name = "level-up"),
                        minLevel = 36
                    )
                )
            ),
            detail = EvolutionDetail(
                trigger = NamedResourceApi(name = "level-up"),
                minLevel = 36
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EvolutionChainItemPreview_WithManyDetails() {
    AppTheme {
        EvolutionChainItem(
            sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/133.png",
            dominantColor = Color(0xFFA8A77A),
            chain = ChainLink(
                evolvesFrom = "eevee",
                isCurrentSelected = false,
                species = NamedResourceApi(
                    name = "umbreon"
                ),
                evolutionDetails = listOf(
                    EvolutionDetail(
                        trigger = NamedResourceApi(name = "level-up"),
                        minHappiness = 220,
                        timeOfDay = "night"
                    )
                )
            ),
            detail = EvolutionDetail(
                trigger = NamedResourceApi(name = "level-up"),
                minHappiness = 220,
                timeOfDay = "night",
                knownMove = NamedResourceApi(name = "bite"),
                location = NamedResourceApi(name = "eterna-forest"),
                needsOverworldRain = true
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EvolutionChainItemPreview_ItemEvolution() {
    AppTheme {
        EvolutionChainItem(
            sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/61.png",
            dominantColor = Color(0xFF6390F0),
            chain = ChainLink(
                evolvesFrom = "poliwhirl",
                species = NamedResourceApi(
                    name = "poliwrath"
                ),
                evolutionDetails = listOf(
                    EvolutionDetail(
                        trigger = NamedResourceApi(name = "use-item"),
                        item = NamedResourceApi(name = "water-stone")
                    )
                )
            ),
            detail = EvolutionDetail(
                trigger = NamedResourceApi(name = "use-item"),
                item = NamedResourceApi(name = "water-stone")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EvolutionDetailRowPreview() {
    AppTheme {
        EvolutionDetailRow(
            label = "Level",
            value = "Lv. 36",
            icon = Icons.LevelUp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun CharizardEvolutionChainPreview() {

    val charmander = ChainLink(
        species = NamedResourceApi(name = "charmander"),
        isCurrentSelected = false,
        evolutionDetails = emptyList()
    )

    val charmeleonDetail = EvolutionDetail(
        trigger = NamedResourceApi(name = "level-up"),
        minLevel = 16
    )

    val charmeleon = ChainLink(
        evolvesFrom = "charmander",
        species = NamedResourceApi(name = "charmeleon"),
        isCurrentSelected = false,
        evolutionDetails = listOf(charmeleonDetail)
    )

    val charizardDetail = EvolutionDetail(
        trigger = NamedResourceApi(name = "level-up"),
        minLevel = 36
    )

    val charizard = ChainLink(
        evolvesFrom = "charmeleon",
        species = NamedResourceApi(name = "charizard"),
        isCurrentSelected = true,
        evolutionDetails = listOf(charizardDetail)
    )

    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            EvolutionChainItem(
                sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
                chain = charmander,
                detail = null,
                dominantColor = Color(0xFFEE8130)
            )

            EvolutionChainItem(
                sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
                chain = charmeleon,
                detail = charmeleonDetail,
                dominantColor = Color(0xFFEE8130)
            )

            EvolutionChainItem(
                sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
                chain = charizard,
                detail = charizardDetail,
                dominantColor = Color(0xFFEE8130)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StatCircleItemPreview() {
    MaterialTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf(
                Stat(baseStat = 45, statName = "hp", statEffort = 0),
                Stat(baseStat = 49, statName = "attack", statEffort = 0),
                Stat(baseStat = 49, statName = "defense", statEffort = 0),
                Stat(baseStat = 65, statName = "special-attack", statEffort = 1),
                Stat(baseStat = 65, statName = "special-defense", statEffort = 0),
                Stat(baseStat = 45, statName = "speed", statEffort = 0),
            ).forEach { stat ->
                StatCircleItem(stat = stat, statTotal = 318)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MaxStatsSectionPreview() {
    val sampleStats = listOf(
        Stat(baseStat = 45, statName = "hp", statEffort = 0),
        Stat(baseStat = 49, statName = "attack", statEffort = 0),
        Stat(baseStat = 49, statName = "defense", statEffort = 0),
        Stat(baseStat = 65, statName = "special-attack", statEffort = 1),
        Stat(baseStat = 65, statName = "special-defense", statEffort = 0),
        Stat(baseStat = 45, statName = "speed", statEffort = 0),
    )
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            MaxStatsSection(pokemonStats = sampleStats)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EvYieldSectionPreview() {
    val evStats = listOf(
        Stat(baseStat = 65, statName = "special-attack", statEffort = 1)
    )
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            EvYieldSection(evYield = evStats)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonStatsTabPreview() {
    val bulbasaurStats = listOf(
        Stat(baseStat = 45, statName = "hp", statEffort = 0),
        Stat(baseStat = 49, statName = "attack", statEffort = 0),
        Stat(baseStat = 49, statName = "defense", statEffort = 0),
        Stat(baseStat = 65, statName = "special-attack", statEffort = 1),
        Stat(baseStat = 65, statName = "special-defense", statEffort = 0),
        Stat(baseStat = 45, statName = "speed", statEffort = 0),
    )
    AppTheme {
        PokemonStatsTab(
            pokemonStats = bulbasaurStats,
            dominantColor = Color(0xFF78C850),
            isDarkTheme = true,
            currentLang = "es",
            listState = rememberLazyGridState()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GameItemCardPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf(
                "red",
                "blue",
                "gold",
                "silver",
                "ruby",
                "diamond",
                "black",
                "x",
                "y",
                "sun",
                "sword",
                "scarlet"
            )
                .forEach { name ->
                    PokemonGameGridItem(item = Game(name = name))
                }
        }
    }
}