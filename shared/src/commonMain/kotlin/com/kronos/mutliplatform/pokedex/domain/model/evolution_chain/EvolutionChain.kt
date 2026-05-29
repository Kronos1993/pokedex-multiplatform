package com.kronos.mutliplatform.pokedex.domain.model.evolution_chain

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionChain(
    var babyTriggerItem:NamedResourceApi? = NamedResourceApi(),
    var chain: ChainLink? = ChainLink(),
    var id:Int? = 0,
){
    fun getEvolutionChain(
        pokemonName: String,
        evoList: MutableList<ChainLink>,
        chain: ChainLink
    ): MutableList<ChainLink> {

        if (evoList.size == 1) {
            if (pokemonName == chain.species.name) {
                chain.isCurrentSelected = true
            }
        }

        if (chain.evolvesTo.isNotEmpty()) {

            for (item in chain.evolvesTo) {

                item.evolvesFrom = chain.species.name

                if (pokemonName == item.species.name) {
                    item.isCurrentSelected = true
                }
                evoList.add(item)
                getEvolutionChain(
                    pokemonName = pokemonName,
                    evoList = evoList,
                    chain = item
                )
            }
        }

        return evoList
    }
}
