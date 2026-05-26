package com.kronos.mutliplatform.pokedex.data.remote.datasources.species

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo

interface SpecieRemoteDataSource {
    suspend fun getSpecie(pokemon:String): Result<SpecieInfo, Error>
}