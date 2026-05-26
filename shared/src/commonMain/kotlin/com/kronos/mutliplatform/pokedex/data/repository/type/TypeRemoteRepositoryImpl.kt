package com.kronos.mutliplatform.pokedex.data.repository.type

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.type.TypeRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.repository.TypeRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo

class TypeRemoteRepositoryImpl(
    private val typeRemoteDataSource: TypeRemoteDataSource
) : TypeRemoteRepository {
    override suspend fun listType(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return typeRemoteDataSource.listType(limit, offset)
    }

    override suspend fun getTypeInfo(type: String): Result<TypeInfo, Error> {
        return typeRemoteDataSource.getTypeInfo(type)
    }

}