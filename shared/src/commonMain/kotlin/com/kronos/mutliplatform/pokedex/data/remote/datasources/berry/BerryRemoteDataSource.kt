package com.kronos.mutliplatform.pokedex.data.remote.datasources.berry

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryInfo


interface BerryRemoteDataSource {
    suspend fun listBerry(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getBerry(berry: String): Result<BerryInfo, Error>
}