package com.kronos.mutliplatform.pokedex.core.cache

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.features.pokedex.domain.PokedexItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface ICache {
    var _currentPokedex: MutableStateFlow<PokedexItem?>
    val currentPokedex: StateFlow<PokedexItem?>

    var _currentPokemon: MutableStateFlow<NamedResourceApi?>
    val currentPokemon: StateFlow<NamedResourceApi?>
}
