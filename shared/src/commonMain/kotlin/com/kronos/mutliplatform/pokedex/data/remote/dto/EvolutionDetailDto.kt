package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionDetailDto(
    val trigger: NamedResourceApiDto? = NamedResourceApiDto(),
    val item: NamedResourceApiDto? = NamedResourceApiDto(),
    val gender: Int? = 0,
    @SerialName("held_item")
    val heldItem: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("known_move")
    val knownMove: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("known_move_type")
    val knownMoveType: NamedResourceApiDto? = NamedResourceApiDto(),
    val location: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("min_level")
    val minLevel: Int? = 0,
    @SerialName("min_happiness")
    val minHappiness: Int? = 0,
    @SerialName("min_beauty")
    val minBeauty: Int? = 0,
    @SerialName("min_affection")
    val minAffection: Int? = 0,
    @SerialName("party_species")
    val partySpecies: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("party_type")
    val partyType: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("relative_physical_stats")
    val relativePhysicalStats: Int? = 0,
    @SerialName("time_of_day")
    val timeOfDay: String? = "",
    @SerialName("trade_species")
    val tradeSpecies: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("needs_overworld_rain")
    val needsOverworldRain: Boolean = false,
    @SerialName("turn_upside_down")
    val turnUpsideDown: Boolean = false
)
