package com.kronos.mutliplatform.pokedex.features.egg_group.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.egg_group.EggGroupInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.repository.EggGroupRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EggGroupDetailScreenViewModel(
    private var eggGroupRemoteRepository: EggGroupRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _eggGroupInfo = MutableStateFlow(EggGroupInfo())
    var eggGroupInfo: StateFlow<EggGroupInfo> = _eggGroupInfo.asStateFlow()

    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())
    var pokemons = _pokemons.asStateFlow()

    fun loadEggGroupInfo(eggGroup: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                eggGroupRemoteRepository.getEggGroup(eggGroup)
                    .onSuccess { eggGroupData ->
                        _eggGroupInfo.value = eggGroupData
                        _pokemons.value = eggGroupData.pokemonSpecies.map { resource ->
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

    fun refreshEggGroup(eggGroup: String) {
        _eggGroupInfo.value = EggGroupInfo()
        _message.value = hashMapOf()
        loadEggGroupInfo(eggGroup)
    }
}