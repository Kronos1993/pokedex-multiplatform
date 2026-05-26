package com.kronos.mutliplatform.pokedex.data.repository.ability

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.ability.AbilityRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.ability.AbilityInfo
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository

class AbilityRemoteRepositoryImpl(
    private val abilityRemoteDataSource: AbilityRemoteDataSource
) : AbilityRemoteRepository {
    override suspend fun listAbility(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return abilityRemoteDataSource.listAbility(limit, offset)
    }

    override suspend fun getAbility(ability: String): Result<AbilityInfo, Error> {
        return abilityRemoteDataSource.getAbility(ability)
    }

}