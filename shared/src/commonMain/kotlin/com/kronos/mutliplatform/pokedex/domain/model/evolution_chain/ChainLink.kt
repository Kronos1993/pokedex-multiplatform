package com.kronos.mutliplatform.pokedex.domain.model.evolution_chain

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class ChainLink (
    var evolvesFrom: String = "",
    var isCurrentSelected: Boolean = false,
    var evolutionDetails:List<EvolutionDetail> = listOf(),
    var evolvesTo:List<ChainLink> = listOf(),
    var isBaby:Boolean = false,
    var species:NamedResourceApi= NamedResourceApi()
)