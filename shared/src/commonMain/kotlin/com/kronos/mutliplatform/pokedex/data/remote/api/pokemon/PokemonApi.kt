package com.kronos.mutliplatform.pokedex.data.remote.api.pokemon

class PokemonApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "pokemon?limit=$limit&offset=$offset"
        fun GET_POKEMON_INFO(pokemon: String) = "pokemon/$pokemon"
        fun GET_POKEMON_ENCOUNTERS(pokemon: String) = "pokemon/$pokemon/encounters"
    }
}