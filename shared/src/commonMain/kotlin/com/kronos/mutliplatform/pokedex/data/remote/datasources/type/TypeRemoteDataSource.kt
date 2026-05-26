package com.kronos.mutliplatform.pokedex.data.remote.datasources.type

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo

interface TypeRemoteDataSource {
    suspend fun listType(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getTypeInfo(type: String): Result<TypeInfo, Error>
}