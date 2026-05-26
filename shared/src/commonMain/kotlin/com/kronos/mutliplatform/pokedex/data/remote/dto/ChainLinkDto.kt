package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChainLinkDto (
    @SerialName("evolution_details")
    var evolutionDetails:List<EvolutionDetailDto>? = listOf(),
    @SerialName("evolves_to")
    var evolvesTo:List<ChainLinkDto>? = listOf(),
    @SerialName("is_baby")
    var isBaby:Boolean = false,
    @SerialName("species")
    var species:NamedResourceApiDto? = NamedResourceApiDto()
)