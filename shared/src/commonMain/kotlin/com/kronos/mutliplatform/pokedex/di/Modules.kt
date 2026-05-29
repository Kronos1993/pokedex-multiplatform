package com.kronos.mutliplatform.pokedex.di

import com.kronos.mutliplatform.pokedex.features.move.list.MoveListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokedex.PokedexScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.PokemonDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages.PokemonMovesTabViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.list.PokemonListScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    //ui viewmodels
    viewModelOf(::PokedexScreenViewModel)
    viewModelOf(::MoveListScreenViewModel)
    viewModelOf(::PokemonListScreenViewModel)
    viewModelOf(::PokemonDetailScreenViewModel)
    viewModelOf(::PokemonMovesTabViewModel)
}