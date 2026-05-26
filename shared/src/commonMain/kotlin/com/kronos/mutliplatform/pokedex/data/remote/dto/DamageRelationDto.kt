package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class DamageRelationDto(
    var doubleDamageFrom:List<NamedResourceApiDto> = listOf(),
    var doubleDamageTo:List<NamedResourceApiDto> = listOf(),
    var halfDamageFrom:List<NamedResourceApiDto> = listOf(),
    var halfDamageTo:List<NamedResourceApiDto> = listOf(),
    var noDamageFrom:List<NamedResourceApiDto> = listOf(),
    var noDamageTo:List<NamedResourceApiDto> = listOf(),
)
