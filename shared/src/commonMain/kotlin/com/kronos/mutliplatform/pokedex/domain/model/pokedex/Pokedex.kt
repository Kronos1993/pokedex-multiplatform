package com.kronos.mutliplatform.pokedex.domain.model.pokedex

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry

data class Pokedex(
    var id:String = "",
    var name:String = "",
    var names:List<Name> = listOf(),
    var pokemons:List<PokemonDexEntry> = listOf()
)