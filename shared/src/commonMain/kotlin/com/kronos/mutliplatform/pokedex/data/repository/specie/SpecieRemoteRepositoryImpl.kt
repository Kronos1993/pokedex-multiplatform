package com.kronos.mutliplatform.pokedex.data.repository.specie

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.species.SpecieRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import com.kronos.mutliplatform.pokedex.domain.repository.SpecieRemoteRepository

class SpecieRemoteRepositoryImpl(
    private val specieRemoteDataSource: SpecieRemoteDataSource
) : SpecieRemoteRepository {
    override suspend fun getSpecie(pokemon: String): Result<SpecieInfo, Error> {
        return specieRemoteDataSource.getSpecie(pokemon)
    }

}