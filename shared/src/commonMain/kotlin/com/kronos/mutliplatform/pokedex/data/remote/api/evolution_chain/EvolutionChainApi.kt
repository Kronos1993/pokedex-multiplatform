package com.kronos.mutliplatform.pokedex.data.remote.api.evolution_chain

class EvolutionChainApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "evolution-chain?limit=$limit&offset=$offset"
        fun GET_EVOLUTION_CHAIN(chainId: Int) = "evolution-chain/$chainId"
    }
}
