package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EggGroupInfoDto(
    var id:Int = 0,
    var name:String = "",
    var names:List<NameDto> = listOf(),
    @SerialName("pokemon_species")
    var pokemonSpecies:List<NamedResourceApiDto> = listOf(),
)
