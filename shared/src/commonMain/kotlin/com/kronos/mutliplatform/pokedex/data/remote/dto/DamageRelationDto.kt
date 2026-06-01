package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelationDto(
    @SerialName("double_damage_from")
    var doubleDamageFrom:List<NamedResourceApiDto> = listOf(),
    @SerialName("double_damage_to")
    var doubleDamageTo:List<NamedResourceApiDto> = listOf(),
    @SerialName("half_damage_from")
    var halfDamageFrom:List<NamedResourceApiDto> = listOf(),
    @SerialName("half_damage_to")
    var halfDamageTo:List<NamedResourceApiDto> = listOf(),
    @SerialName("no_damage_from")
    var noDamageFrom:List<NamedResourceApiDto> = listOf(),
    @SerialName("no_damage_to")
    var noDamageTo:List<NamedResourceApiDto> = listOf(),
)
