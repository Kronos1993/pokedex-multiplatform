package com.kronos.mutliplatform.pokedex.data.remote.api.pokedex

class PokedexApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "pokedex?limit=$limit&offset=$offset"
        fun GET_POKEDEX_BY_ID(pokedexId: Int) = "pokedex/$pokedexId"
        fun GET_POKEDEX_BY_NAME(pokedex: String) = "pokedex/$pokedex"
    }
}