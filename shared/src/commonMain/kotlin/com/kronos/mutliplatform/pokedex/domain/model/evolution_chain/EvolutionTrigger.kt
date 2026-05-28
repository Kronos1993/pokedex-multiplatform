package com.kronos.mutliplatform.pokedex.domain.model.evolution_chain

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionTrigger(
    val id: Int = 0,
    val name: String = "",
    val pokemonSpecies: List<NamedResourceApi> = listOf()
)
