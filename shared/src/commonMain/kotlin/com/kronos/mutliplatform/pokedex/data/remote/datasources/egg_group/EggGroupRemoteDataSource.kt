package com.kronos.mutliplatform.pokedex.data.remote.datasources.egg_group

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.egg_group.EggGroupInfo

interface EggGroupRemoteDataSource {
    suspend fun listEggGroup(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getEggGroup(eggGroup: String): Result<EggGroupInfo, Error>
}