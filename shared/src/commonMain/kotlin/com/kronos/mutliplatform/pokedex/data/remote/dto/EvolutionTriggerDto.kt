package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionTriggerDto(
    val id: Int,
    val name: String,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedResourceApiDto>
)
