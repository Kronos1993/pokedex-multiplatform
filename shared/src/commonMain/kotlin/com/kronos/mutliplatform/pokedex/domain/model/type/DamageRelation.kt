package com.kronos.mutliplatform.pokedex.domain.model.type

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelation(
    var doubleDamageFrom:List<NamedResourceApi> = listOf(),
    var doubleDamageTo:List<NamedResourceApi> = listOf(),
    var halfDamageFrom:List<NamedResourceApi> = listOf(),
    var halfDamageTo:List<NamedResourceApi> = listOf(),
    var noDamageFrom:List<NamedResourceApi> = listOf(),
    var noDamageTo:List<NamedResourceApi> = listOf(),
)
