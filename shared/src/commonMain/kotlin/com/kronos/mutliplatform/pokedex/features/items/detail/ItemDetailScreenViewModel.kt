package com.kronos.mutliplatform.pokedex.features.items.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.repository.ItemRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemDetailScreenViewModel(
    private var itemRemoteRepository: ItemRemoteRepository,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private var _item = MutableStateFlow(ItemInfo())
    var item = _item.asStateFlow()

    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())
    var pokemons = _pokemons.asStateFlow()


    private fun postItems(items: ItemInfo) {
        _item.value = items
    }

    private fun postPokemons(pokemons: List<PokemonDexEntry>) {
        _pokemons.value = pokemons
    }


    fun loadItem(item: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                itemRemoteRepository.getItem(item)
                    .onSuccess { item ->
                        val pokemon = item.heldByPokemon.map { resource ->
                            val id = urlProvider.extractIdFromUrl(resource.url)
                            PokemonDexEntry(
                                pokemonId = id,
                                dexEntry = id,
                                pokemon = NamedResourceApi(resource.name, resource.url),
                                imageUrl = urlProvider.getImageUrl(
                                    ImageType.POKEMON,
                                    id.toString()
                                )
                            )
                        }
                        postItems(item)
                        postPokemons(pokemon)
                    }
                    .onError { error ->
                        _message.value = hashMapOf(
                            "error" to if (error is FullNetworkError) error.errorMessage
                            else error.toString()
                        )
                    }
            } finally {
                _loading.value = false
            }
        }
    }

    fun refreshItems(item: String) {
        _item.value = ItemInfo()
        val err = HashMap<String, String>()
        _message.value = (err)
        loadItem(item)
    }
}

