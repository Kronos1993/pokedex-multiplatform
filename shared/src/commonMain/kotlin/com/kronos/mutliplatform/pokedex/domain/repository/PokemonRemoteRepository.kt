package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo


interface PokemonRemoteRepository {
    suspend fun listPokemon(
        limit: Int = 20,
        offset: Int = 0
    ): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getPokemonInfo(pokemon: String): Result<PokemonInfo, Error>

    suspend fun getPokemonEncountersInfo(pokemon: String): Result<List<Encounter>, Error>
}
