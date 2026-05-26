package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexDto(
    var id:String = "",
    var name:String = "",
    val names: List<NameDto>,
    @SerialName("pokemon_entries")
    var pokemons:List<PokemonDexEntryDto> = listOf()
)