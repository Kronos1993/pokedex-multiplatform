package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonHomeDto(
    val frontHome: String = "",
    val frontHomeShiny: String = ""
)