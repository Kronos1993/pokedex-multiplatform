package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.pokedex.Pokedex

interface PokedexRemoteRepository {
    suspend fun list(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getPokedex(pokedexId: Int = 1):Result<Pokedex, Error>

    suspend fun getPokedex(pokedex: String):Result<Pokedex, Error>
}
