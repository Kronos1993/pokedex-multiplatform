package com.kronos.mutliplatform.pokedex.data.remote.datasources.evolution_chain

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.pokedex.domian.model.evolution_chain.EvolutionChain

interface EvolutionChainRemoteDataSource {
    suspend fun list(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getEvolutionChain(chainId: Int = 1): Result<EvolutionChain, Error>

}