package com.kronos.mutliplatform.pokedex.data.remote.api.species

class SpeciesApi {

    companion object {
        fun GET_SPECIE_INFO(pokemon: String) = "pokemon-species/$pokemon"
    }
}