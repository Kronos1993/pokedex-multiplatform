package com.kronos.mutliplatform.pokedex.data.remote.datasources.move

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo

interface MoveRemoteDataSource {
    suspend fun listMove(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getMove(move: String): Result<MoveInfo, Error>
}