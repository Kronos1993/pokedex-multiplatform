package com.kronos.mutliplatform.pokedex.data.repository.egg_group

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.egg_group.EggGroupRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.egg_group.EggGroupInfo
import com.kronos.mutliplatform.pokedex.domain.repository.EggGroupRemoteRepository

class EggGroupRemoteRepositoryImpl(
    private val eggGroupRemoteDataSource: EggGroupRemoteDataSource
) : EggGroupRemoteRepository {
    override suspend fun listEggGroup(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return eggGroupRemoteDataSource.listEggGroup(limit, offset)
    }

    override suspend fun getEggGroup(eggGroup: String): Result<EggGroupInfo, Error> {
        return eggGroupRemoteDataSource.getEggGroup(eggGroup)
    }

}