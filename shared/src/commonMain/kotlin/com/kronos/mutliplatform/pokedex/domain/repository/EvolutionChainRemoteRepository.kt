package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.pokedex.domian.model.evolution_chain.EvolutionChain
import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result

interface EvolutionChainRemoteRepository {
    suspend fun list(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getEvolutionChain(chainId: Int = 1): Result<EvolutionChain, Error>
}
