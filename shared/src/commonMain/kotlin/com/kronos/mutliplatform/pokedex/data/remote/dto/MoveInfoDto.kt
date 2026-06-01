package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveInfoDto(
    var accuracy: Int?= 0,
    @SerialName("damage_class")
    var moveCategory: NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("flavor_text_entries")
    var moveDescription: List<FlavorTextEntryDto> = listOf(),
    @SerialName("effect_entries")
    val effectEntries: List<EffectEntryDto>,
    @SerialName("learned_by_pokemon")
    var learnedBy: List<NamedResourceApiDto> = listOf(),
    @SerialName("name")
    var moveName: String = "",
    val names: List<NameDto>,
    var power: Int? = 0,
    var pp: Int? = 0,
    var priority: Int? = 0,
    var type: NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("effect_chance")
    var effectChance: Int? = 0,
)
