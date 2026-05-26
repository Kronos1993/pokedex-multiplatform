package com.kronos.mutliplatform.pokedex.features.pokemon.detail

import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.repository.PokemonRemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonDetailScreenViewModel(
    val pokemonRemoteRepository: PokemonRemoteRepository
) : ParentViewModel() {

    private var _pokemon = MutableStateFlow(PokemonInfo())
    var pokemon: StateFlow<PokemonInfo> = _pokemon.asStateFlow()



}

