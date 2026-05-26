package com.kronos.mutliplatform.pokedex.data.repository.evolution_chain

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.evolution_chain.EvolutionChainRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.pokedex.domian.model.evolution_chain.EvolutionChain
import com.kronos.mutliplatform.pokedex.domain.repository.EvolutionChainRemoteRepository

class EvolutionChainRemoteRepositoryImpl(
    private val evolutionChainRemoteDataSource: EvolutionChainRemoteDataSource
) : EvolutionChainRemoteRepository {
    override suspend fun list(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return evolutionChainRemoteDataSource.list(limit, offset)
    }

    override suspend fun getEvolutionChain(chainId: Int): Result<EvolutionChain, Error> {
        return evolutionChainRemoteDataSource.getEvolutionChain(chainId)
    }

}