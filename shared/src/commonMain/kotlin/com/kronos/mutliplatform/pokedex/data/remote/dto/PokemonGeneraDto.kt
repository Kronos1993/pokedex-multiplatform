package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonGeneraDto(
    var genus: String = "",
    var language: NamedResourceApiDto
)
