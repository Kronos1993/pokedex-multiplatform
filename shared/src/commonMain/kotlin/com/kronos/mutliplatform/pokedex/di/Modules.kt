package com.kronos.mutliplatform.pokedex.di

import com.kronos.mutliplatform.pokedex.AppViewModel
import com.kronos.mutliplatform.pokedex.features.abilities.detail.AbilityDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.abilities.list.AbilityListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.about.AboutViewModel
import com.kronos.mutliplatform.pokedex.features.berries.detail.BerryDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.berries.list.BerryListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.egg_group.detail.EggGroupDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.egg_group.list.EggGroupListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.items.categories.ItemCategoryListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.items.detail.ItemDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.items.list.ItemListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.move.detail.MoveDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.move.list.MoveListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.natures.detail.NatureDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.natures.list.NatureListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokedex.PokedexScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.PokemonDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.pages.PokemonMovesTabViewModel
import com.kronos.mutliplatform.pokedex.features.pokemon.list.PokemonListScreenViewModel
import com.kronos.mutliplatform.pokedex.features.types.detail.TypeDetailScreenViewModel
import com.kronos.mutliplatform.pokedex.features.types.list.TypeListScreenViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    //ui viewmodels
    singleOf(::AppViewModel)
    viewModelOf(::PokedexScreenViewModel)
    viewModelOf(::MoveListScreenViewModel)
    viewModelOf(::MoveDetailScreenViewModel)
    viewModelOf(::PokemonListScreenViewModel)
    viewModelOf(::PokemonDetailScreenViewModel)
    viewModelOf(::PokemonMovesTabViewModel)
    viewModelOf(::TypeListScreenViewModel)
    viewModelOf(::TypeDetailScreenViewModel)
    viewModelOf(::AbilityListScreenViewModel)
    viewModelOf(::AbilityDetailScreenViewModel)
    viewModelOf(::NatureListScreenViewModel)
    viewModelOf(::NatureDetailScreenViewModel)
    viewModelOf(::EggGroupListScreenViewModel)
    viewModelOf(::EggGroupDetailScreenViewModel)
    viewModelOf(::ItemCategoryListScreenViewModel)
    viewModelOf(::ItemListScreenViewModel)
    viewModelOf(::ItemDetailScreenViewModel)
    viewModelOf(::BerryListScreenViewModel)
    viewModelOf(::BerryDetailScreenViewModel)
    viewModelOf(::AboutViewModel)
}