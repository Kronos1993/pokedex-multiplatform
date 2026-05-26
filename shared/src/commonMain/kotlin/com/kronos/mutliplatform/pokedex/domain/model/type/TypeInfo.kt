package com.kronos.mutliplatform.pokedex.domain.model.type

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class TypeInfo(
    var id:Int = 0,
    var name:String = "",
    var damageRelations: DamageRelation = DamageRelation(),
    var moves:List<NamedResourceApi> = listOf(),
    var names:List<Name> = listOf(),
    var pokemon:List<NamedResourceApi> = listOf(),
)
