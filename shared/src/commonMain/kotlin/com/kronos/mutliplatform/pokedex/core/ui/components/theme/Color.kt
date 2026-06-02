package com.kronos.mutliplatform.pokedex.core.ui.components.theme

import androidx.compose.ui.graphics.Color

// Definición de colores principales

// Primary — Rojo Pokédex
val primaryLight = Color(0xFFE53935)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFFFFCDD2)
val onPrimaryContainerLight = Color(0xFF7F0000)

val primaryDark = Color(0xFFEF9A9A)
val onPrimaryDark = Color(0xFF7F0000)
val primaryContainerDark = Color(0xFFC62828)
val onPrimaryContainerDark = Color(0xFFFFCDD2)

// Secondary — Gris azulado
val secondaryLight = Color(0xFF37474F)
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFCFD8DC)
val onSecondaryContainerLight = Color(0xFF1C313A)

val secondaryDark = Color(0xFFB0BEC5)
val onSecondaryDark = Color(0xFF1C313A)
val secondaryContainerDark = Color(0xFF263238)
val onSecondaryContainerDark = Color(0xFFCFD8DC)

// Tertiary — Amarillo Pikachu
val tertiaryLight = Color(0xFFF9A825)
val onTertiaryLight = Color(0xFF000000)
val tertiaryContainerLight = Color(0xFFFFECB3)
val onTertiaryContainerLight = Color(0xFF4E3300)

val tertiaryDark = Color(0xFFFFD600)
val onTertiaryDark = Color(0xFF3E2800)
val tertiaryContainerDark = Color(0xFF7A5900)
val onTertiaryContainerDark = Color(0xFFFFECB3)

// Background y Surface
val backgroundLight = Color(0xFFF5F5F5)
val onBackgroundLight = Color(0xFF1A1A1A)
val surfaceLight = Color(0xFFFAFAFA)
val onSurfaceLight = Color(0xFF1A1A1A)

val backgroundDark = Color(0xFF0D0D0D)
val onBackgroundDark = Color(0xFFE8E8E8)
val surfaceDark = Color(0xFF121212)
val onSurfaceDark = Color(0xFFE8E8E8)

// Surface containers dark
val surfaceContainerLowestDark = Color(0xFF080808)
val surfaceContainerLowDark = Color(0xFF1A1A1A)
val surfaceContainerDark = Color(0xFF1E1E1E)
val surfaceContainerHighDark = Color(0xFF282828)
val surfaceContainerHighestDark = Color(0xFF323232)

// Surface containers light
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF5F5F5)
val surfaceContainerLight = Color(0xFFEEEEEE)
val surfaceContainerHighLight = Color(0xFFE8E8E8)
val surfaceContainerHighestLight = Color(0xFFE0E0E0)

val surfaceVariantLight = Color(0xFFECEFF1)
val onSurfaceVariantLight = Color(0xFF455A64)
val surfaceVariantDark = Color(0xFF37474F)
val onSurfaceVariantDark = Color(0xFFB0BEC5)


val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF93000A)
val outlineLight = Color(0xFF7A757F)
val outlineVariantLight = Color(0xFFCBC4CF)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF322F35)
val inverseOnSurfaceLight = Color(0xFFF5EFF7)
val inversePrimaryLight = Color(0xFFD3BCFD)
val surfaceDimLight = Color(0xFFDED8E0)
val surfaceBrightLight = Color(0xFFFEF7FF)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)
val outlineDark = Color(0xFF948F99)
val outlineVariantDark = Color(0xFF49454E)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFFE7E0E8)
val inverseOnSurfaceDark = Color(0xFF322F35)
val inversePrimaryDark = Color(0xFF68548E)
val surfaceDimDark = Color(0xFF151218)
val surfaceBrightDark = Color(0xFF3B383E)
val ratingColorContainerDark = Color(0xFFF5BB27)
val ratingColorContainerLight = Color(0xFFFFC849)

// Toolbar
val toolbarLight = Color(0xFFCC0000)      // rojo oscuro, contrasta bien con blanco
val toolbarDark = Color(0xFFB71C1C)       // rojo más profundo para dark mode

// Cards
val cardLight = Color(0xFFFFFFFF)         // blanco puro
val cardDark = Color(0xFF1E1E1E)          // gris oscuro (ya lo tienes como surfaceContainerDark)

// Textos sobre cards
val cardTextLight = Color(0xFF1A1A1A)     // negro
val cardTextDark = Color(0xFFE8E8E8)      // blanco suave

val PokemonGenderlessColor = Color(0xFF7A757F)
val PokemonFemaleColor = Color(0xFFE040FB)
val PokemonMaleColor = Color(0xFF448AFF)

val PokemonEncounterColorVersion = Color(0xFF534AB7)   // purple
val PokemonEncounterColorMinLevel = Color(0xFF1D9E75)  // teal
val PokemonEncounterColorMaxLevel = Color(0xFFBA7517)  // amber
val PokemonEncounterColorChance = Color(0xFFD85A30)    // coral

val PokemonEvolutionUseItemColor = Color(0xFFC22E28)
val PokemonEvolutionBeautyColor = Color(0xFFF7D02C)
val PokemonEvolutionKnowMoveColor = Color(0xFF444441)
val PokemonEvolutionLocationColor = Color(0xFFA8A77A)

val PokemonEvolutionDaytimeColor = Color(0xFFF7D02C)
val PokemonEvolutionNighttimeColor = Color(0xFF444441)
val PokemonEvolutionOtherTimeColor = Color(0xFF2C2C2A)
val PokemonEvolutionNeedsRainColor = Color(0xFF185FA5)
val PokemonEvolutionNeedsScreenRotationColor = Color(0xFF993C1D)

// ─── Pokémon Type Colors ───────────────────────────────────────────────────────
val PokemonTypeNormalColor   = Color(0xFFA8A77A)
val PokemonTypeFireColor     = Color(0xFFEE8130)
val PokemonTypeWaterColor    = Color(0xFF6390F0)
val PokemonTypeElectricColor = Color(0xFFF7D02C)
val PokemonTypeGrassColor    = Color(0xFF7AC74C)
val PokemonTypeIceColor      = Color(0xFF96D9D6)
val PokemonTypeFightingColor = Color(0xFFC22E28)
val PokemonTypePoisonColor   = Color(0xFFA33EA1)
val PokemonTypeGroundColor   = Color(0xFFE2BF65)
val PokemonTypeFlyingColor   = Color(0xFFA98FF3)
val PokemonTypePsychicColor  = Color(0xFFF95587)
val PokemonTypeBugColor      = Color(0xFFA6B91A)
val PokemonTypeRockColor     = Color(0xFFB6A136)
val PokemonTypeGhostColor    = Color(0xFF735797)
val PokemonTypeDragonColor   = Color(0xFF6F35FC)
val PokemonTypeDarkColor     = Color(0xFF705746)
val PokemonTypeSteelColor    = Color(0xFFB7B7CE)
val PokemonTypeFairyColor    = Color(0xFFD685AD)

// ─── Pokémon Encounter Method Colors ──────────────────────────────────────────

// Grass / walking
val PokemonEncounterWalkBackground      = Color(0xFFE1F5EE)
val PokemonEncounterWalkContent         = Color(0xFF0F6E56)

val PokemonEncounterFlowerBackground    = Color(0xFFEAF3DE)
val PokemonEncounterFlowerContent       = Color(0xFF3B6D11)

val PokemonEncounterGrassBackground     = Color(0xFFEAF3DE)
val PokemonEncounterGrassContent        = Color(0xFF639922)

val PokemonEncounterHeadbuttBackground  = Color(0xFFEAF3DE)
val PokemonEncounterHeadbuttContent     = Color(0xFF27500A)

val PokemonEncounterGrottoBackground    = Color(0xFFEAF3DE)
val PokemonEncounterGrottoContent       = Color(0xFF173404)

val PokemonEncounterOverworldBackground = Color(0xFFE1F5EE)
val PokemonEncounterOverworldContent    = Color(0xFF1D9E75)

val PokemonEncounterGiftBackground      = Color(0xFFE1F5EE)
val PokemonEncounterGiftContent         = Color(0xFF085041)

// Water
val PokemonEncounterSurfBackground      = Color(0xFFE6F1FB)
val PokemonEncounterSurfContent         = Color(0xFF185FA5)

val PokemonEncounterFishingBackground   = Color(0xFFFAEEDA)
val PokemonEncounterFishingContent      = Color(0xFF854F0B)

val PokemonEncounterSkyBackground       = Color(0xFFE6F1FB)
val PokemonEncounterSkyContent          = Color(0xFF378ADD)

val PokemonEncounterSosBackground       = Color(0xFFE6F1FB)
val PokemonEncounterSosContent          = Color(0xFF0C447C)

val PokemonEncounterIslandBackground    = Color(0xFFE6F1FB)
val PokemonEncounterIslandContent       = Color(0xFF185FA5)

// Cave / rock
val PokemonEncounterCaveBackground      = Color(0xFFF1EFE8)
val PokemonEncounterCaveContent         = Color(0xFF5F5E5A)

val PokemonEncounterBridgeBackground    = Color(0xFFD3D1C7)
val PokemonEncounterBridgeContent       = Color(0xFF444441)

val PokemonEncounterShadowBackground    = Color(0xFFD3D1C7)
val PokemonEncounterShadowContent       = Color(0xFF2C2C2A)

val PokemonEncounterDefaultBackground   = Color(0xFFF1EFE8)
val PokemonEncounterDefaultContent      = Color(0xFF888780)

// Special / rare
val PokemonEncounterRadarBackground     = Color(0xFFEEEDFE)
val PokemonEncounterRadarContent        = Color(0xFF3C3489)

val PokemonEncounterSnagBackground      = Color(0xFFEEEDFE)
val PokemonEncounterSnagContent         = Color(0xFF534AB7)

val PokemonEncounterRoamerBackground    = Color(0xFFFAECE7)
val PokemonEncounterRoamerContent       = Color(0xFF993C1D)

val PokemonEncounterOnlyOneBackground   = Color(0xFFFBEAF0)
val PokemonEncounterOnlyOneContent      = Color(0xFF993556)

val PokemonEncounterStarterBackground   = Color(0xFFFBEAF0)
val PokemonEncounterStarterContent      = Color(0xFF72243E)

val PokemonEncounterFluteBackground     = Color(0xFFFBEAF0)
val PokemonEncounterFluteContent        = Color(0xFF72243E)

val PokemonEncounterColosseumBackground = Color(0xFFFAEEDA)
val PokemonEncounterColosseumContent    = Color(0xFF854F0B)

// Combat
val PokemonEncounterRaidBackground      = Color(0xFFFCEBEB)
val PokemonEncounterRaidContent         = Color(0xFFA32D2D)

// ─── Pokémon Stat Colors ───────────────────────────────────────────────────────
val PokemonStatHpColor             = Color(0xFFFF5959)
val PokemonStatAttackColor         = Color(0xFFF08030)
val PokemonStatDefenseColor        = Color(0xFFF8D030)
val PokemonStatSpecialAttackColor  = Color(0xFF6890F0)
val PokemonStatSpecialDefenseColor = Color(0xFF78C850)
val PokemonStatSpeedColor          = Color(0xFFF85888)

// ─── Pokémon Move Learn Method Colors ─────────────────────────────────────────
val PokemonLearnMethodEggColor     = Color(0xFFF085B6)
val PokemonLearnMethodTutorColor   = Color(0xFF78C850)
val PokemonLearnMethodLevelUpColor = Color(0xFFF8D030)
val PokemonLearnMethodMachineColor = Color(0xFF6890F0)

val NatureDecreaseStatContainerColor = Color(0xff7fa7ff)
val NatureDecreaseStatIconColor = Color(0xff3370f3)

val NatureIncreaseStatContainerColor = Color(0xfffa8383)
val NatureIncreaseStatIconColor = Color(0xFFB71C1C)