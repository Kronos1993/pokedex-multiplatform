package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeInfoDto(
    var id:Int = 0,
    var name:String = "",
    @SerialName("damage_relations")
    var damageRelations: DamageRelationDto = DamageRelationDto(),
    var moves:List<NamedResourceApiDto> = listOf(),
    var names:List<NameDto> = listOf(),
    var pokemon:List<NamedResourceApiDto> = listOf(),
)