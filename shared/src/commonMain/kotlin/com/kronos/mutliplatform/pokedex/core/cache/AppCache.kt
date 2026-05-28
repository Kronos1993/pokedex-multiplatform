package com.kronos.mutliplatform.pokedex.core.cache

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.features.pokedex.domain.PokedexItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppCache : ICache {

    override var _currentPokedex = MutableStateFlow<PokedexItem?>(null)
    override val currentPokedex: StateFlow<PokedexItem?> = _currentPokedex.asStateFlow()

    override var _currentPokemon = MutableStateFlow<NamedResourceApi?>(null)
    override val currentPokemon: StateFlow<NamedResourceApi?> = _currentPokemon.asStateFlow()

}
