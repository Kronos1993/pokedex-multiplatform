package com.kronos.mutliplatform.pokedex.di

import com.kronos.mutliplatform.pokedex.features.pokedex.PokedexScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.PokemonDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.list.PokemonListScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    //ui viewmodels
    viewModelOf(::PokedexScreenViewModel)
    viewModelOf(::PokemonListScreenViewModel)
    viewModelOf(::PokemonDetailScreenViewModel)
}