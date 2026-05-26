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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonListScreenViewModel(
    private val pokedexRemoteRepository: PokedexRemoteRepository,
    var appCache: ICache,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())
    var pokemons: StateFlow<List<PokemonDexEntry>> = _pokemons.asStateFlow()


    private fun postPokemons(pokemons: List<PokemonDexEntry>) {
        _pokemons.value = pokemons.map {
            it.copy(
                imageUrl = urlProvider.getImageUrl(
                    ImageType.POKEMON,
                    urlProvider.extractIdFromUrl(it.pokemon.url).toString()
                )
            )
        }
    }

    fun loadPokemons(pokedex: String) {
        loading = true
        viewModelScope.launch(Dispatchers.IO) {
            pokedexRemoteRepository.getPokedex(
                pokedex
            )
                .onSuccess {
                    loading = (false)
                    postPokemons(it.pokemons)
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError) {
                        err["error"] = it.errorMessage
                    } else {
                        err["error"] = it.toString()
                    }
                    message = (err)
                    loading = (false)
                }
        }
    }

    fun refreshPokemons(pokedex: String) {
        _pokemons.value = listOf()
        val err = HashMap<String, String>()
        message = (err)
        loadPokemons(pokedex)
    }
}

