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
    ): MutableList<ChainLink> {
        if (evoList.size==1){
            evoList[0].run {
                if(pokemonName == this.species.name)
                    this.isCurrentSelected = true
                this
            }
        }
        return if (chain!=null || chain?.evolvesTo?.isNotEmpty() == true) {
            for (item in chain!!.evolvesTo) {
                item.evolvesFrom = chain!!.species.name
                if(pokemonName == item.species.name)
                    item.isCurrentSelected = true
                evoList.add(item)
            }
            getEvolutionChain(pokemonName,evoList)
        } else {
            evoList
        }
    }
}
