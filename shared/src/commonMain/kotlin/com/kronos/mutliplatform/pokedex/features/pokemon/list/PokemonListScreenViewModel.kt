package com.kronos.mutliplatform.pokedex.features.pokemon.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.cache.ICache
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokemonListScreenViewModel(
    private val pokedexRemoteRepository: PokedexRemoteRepository,
    var appCache: ICache,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private val _allPokemons = MutableStateFlow<List<PokemonDexEntry>>(emptyList())
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()
    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())

    val pokemons: StateFlow<List<PokemonDexEntry>> =
        combine(_allPokemons, _searchQuery) { pokemons, query ->

            if (query.isBlank()) {
                pokemons
            } else {
                pokemons.filter {
                    it.pokemon.name.contains(
                        query.trim(),
                        ignoreCase = true
                    )
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun isSearching(searching: Boolean = false){
        _isSearching.value = searching
    }

    private fun postPokemons(pokemons: List<PokemonDexEntry>) {
        _allPokemons.value = pokemons.map {
            it.copy(
                imageUrl = urlProvider.getImageUrl(
                    ImageType.POKEMON,
                    urlProvider.extractIdFromUrl(it.pokemon.url).toString()
                )
            )
        }
    }

    fun loadPokemons(pokedex: String) {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            pokedexRemoteRepository.getPokedex(
                pokedex
            )
                .onSuccess {
                    _loading.value = (false)
                    postPokemons(it.pokemons)
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError) {
                        err["error"] = it.errorMessage
                    } else {
                        err["error"] = it.toString()
                    }
                    _message.value = (err)
                    _loading.value = (false)
                }
        }
    }

    fun refreshPokemons(pokedex: String) {
        _pokemons.value = listOf()
        _searchQuery.value = ""
        _allPokemons.value = emptyList()
        val err = HashMap<String, String>()
        _message.value = (err)
        loadPokemons(pokedex)
    }
}

