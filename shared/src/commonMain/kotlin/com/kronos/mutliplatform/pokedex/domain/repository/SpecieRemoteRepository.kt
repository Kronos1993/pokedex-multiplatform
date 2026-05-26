package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo

interface SpecieRemoteRepository {
    suspend fun getSpecie(pokemon:String): Result<SpecieInfo, Error>
}
