package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo
import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result

interface MoveRemoteRepository {
    suspend fun listMove(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getMove(move: String): Result<MoveInfo, Error>
}
