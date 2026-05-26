package com.kronos.mutliplatform.pokedex.data.repository.move

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.move.MoveRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository

class MoveRemoteRepositoryImpl(
    private val moveRemoteDataSource: MoveRemoteDataSource
) : MoveRemoteRepository {
    override suspend fun listMove(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return moveRemoteDataSource.listMove(limit, offset)
    }

    override suspend fun getMove(move: String): Result<MoveInfo, Error> {
        return moveRemoteDataSource.getMove(move)
    }

}