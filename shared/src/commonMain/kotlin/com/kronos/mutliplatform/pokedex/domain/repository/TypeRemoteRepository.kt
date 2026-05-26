package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo

interface TypeRemoteRepository {
    suspend fun listType(
        limit: Int = 20,
        offset: Int = 0
    ): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getTypeInfo(type: String): Result<TypeInfo, Error>
}
