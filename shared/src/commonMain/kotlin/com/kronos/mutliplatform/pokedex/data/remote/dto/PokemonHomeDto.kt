package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonHomeDto(
    @SerialName("front_default")
    val frontHome: String? = "",
    @SerialName("front_shiny")
    val frontHomeShiny: String? = ""
)