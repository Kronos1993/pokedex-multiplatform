package com.kronos.mutliplatform.pokedex.domain.model.specie

import kotlinx.serialization.Serializable

@Serializable
data class PokemonGenera(
    var genus:String = "",
    var language: String = ""
)
