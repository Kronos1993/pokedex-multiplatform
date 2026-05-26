package com.kronos.mutliplatform.pokedex.data.remote.datasources.ability

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.ability.AbilityInfo

interface AbilityRemoteDataSource {
    suspend fun listAbility(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getAbility(ability: String): Result<AbilityInfo, Error>
}