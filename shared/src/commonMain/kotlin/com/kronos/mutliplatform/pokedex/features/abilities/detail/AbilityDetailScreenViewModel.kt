package com.kronos.mutliplatform.pokedex.features.abilities.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.ability.AbilityInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AbilityDetailScreenViewModel(
    private val abilityRemoteRepository: AbilityRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _abilityInfo = MutableStateFlow(AbilityInfo())
    var abilityInfo: StateFlow<AbilityInfo> = _abilityInfo.asStateFlow()

    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())
    var pokemons = _pokemons.asStateFlow()

    fun loadAbilityInfo(ability: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                abilityRemoteRepository.getAbility(ability)
                    .onSuccess { abilityData ->
                        _abilityInfo.value = abilityData
                        _pokemons.value = abilityData.pokemon.map { resource ->
                            val id = urlProvider.extractIdFromUrl(resource.pokemon.url)
                            PokemonDexEntry(
                                pokemonId = id,
                                dexEntry = id,
                                pokemon = resource.pokemon,
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

    fun refreshMove(ability: String) {
        _abilityInfo.value = AbilityInfo()
        _message.value = hashMapOf()
        loadAbilityInfo(ability)
    }
}