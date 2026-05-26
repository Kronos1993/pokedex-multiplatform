package com.kronos.mutliplatform.pokedex.data.repository.berry

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.berry.BerryRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryInfo
import com.kronos.mutliplatform.pokedex.domain.repository.BerryRemoteRepository

class BerryRemoteRepositoryImpl(
    private val berryRemoteDataSource: BerryRemoteDataSource
) : BerryRemoteRepository {
    override suspend fun listBerry(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return berryRemoteDataSource.listBerry(limit, offset)
    }

    override suspend fun getBerry(berry: String): Result<BerryInfo, Error> {
        return berryRemoteDataSource.getBerry(berry)
    }

}