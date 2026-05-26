package com.kronos.pokedex.domian.model.evolution_chain

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink

data class EvolutionChain(
    var babyTriggerItem:NamedResourceApi? = NamedResourceApi(),
    var chain: ChainLink? = ChainLink(),
    var id:Int? = 0,
)
