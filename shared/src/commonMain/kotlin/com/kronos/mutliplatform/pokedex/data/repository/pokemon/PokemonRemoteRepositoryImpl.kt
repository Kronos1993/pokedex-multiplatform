package com.kronos.mutliplatform.pokedex.data.repository.pokemon

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokemon.PokemonRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.repository.PokemonRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo

class PokemonRemoteRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRemoteRepository {
    override suspend fun listPokemon(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return pokemonRemoteDataSource.listPokemon(limit, offset)
    }

    override suspend fun getPokemonInfo(pokemon: String): Result<PokemonInfo, Error> {
        return pokemonRemoteDataSource.getPokemonInfo(pokemon)
    }

    override suspend fun getPokemonEncountersInfo(pokemon: String): Result<List<Encounter>, Error> {
        return pokemonRemoteDataSource.getPokemonEncountersInfo(pokemon)
    }

}