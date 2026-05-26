package com.kronos.mutliplatform.pokedex.data.remote.datasources.nature

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.nature.NatureDetail

interface NatureRemoteDataSource {

    suspend fun listNature(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>


    suspend fun getNature(nature: String): Result<NatureDetail, Error>

}