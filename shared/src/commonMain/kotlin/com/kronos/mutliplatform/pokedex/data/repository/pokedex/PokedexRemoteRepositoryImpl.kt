package com.kronos.mutliplatform.pokedex.data.repository.pokedex

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokedex.PokedexRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.model.pokedex.Pokedex

class PokedexRemoteRepositoryImpl(
    private val pokedexRemoteDataSource: PokedexRemoteDataSource
) : PokedexRemoteRepository {
    override suspend fun list(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return pokedexRemoteDataSource.list(limit, offset)
    }

    override suspend fun getPokedex(pokedexId: Int): Result<Pokedex, Error> {
        return pokedexRemoteDataSource.getPokedex(pokedexId)
    }

    override suspend fun getPokedex(pokedex: String): Result<Pokedex, Error> {
        return pokedexRemoteDataSource.getPokedex(pokedex)
    }

}