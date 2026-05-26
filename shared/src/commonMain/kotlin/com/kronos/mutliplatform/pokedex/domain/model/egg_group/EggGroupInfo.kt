package com.kronos.mutliplatform.pokedex.domain.model.egg_group

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class EggGroupInfo(
    var id:Int = 0,
    var name:String = "",
    var names:List<Name> = listOf(),
    var pokemonSpecies:List<NamedResourceApi> = listOf(),
)
