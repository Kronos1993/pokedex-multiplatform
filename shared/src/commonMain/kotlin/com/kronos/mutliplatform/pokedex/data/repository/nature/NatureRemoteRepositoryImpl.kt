package com.kronos.mutliplatform.pokedex.data.repository.nature

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.nature.NatureRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.nature.NatureDetail
import com.kronos.mutliplatform.pokedex.domain.repository.NatureRemoteRepository

class NatureRemoteRepositoryImpl(
    private val natureRemoteDataSource: NatureRemoteDataSource
) : NatureRemoteRepository {
    override suspend fun listNature(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return natureRemoteDataSource.listNature(limit, offset)
    }

    override suspend fun getNature(nature: String): Result<NatureDetail, Error> {
        return natureRemoteDataSource.getNature(nature)
    }

}