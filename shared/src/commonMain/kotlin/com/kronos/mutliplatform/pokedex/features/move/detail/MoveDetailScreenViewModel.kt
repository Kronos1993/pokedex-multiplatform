package com.kronos.mutliplatform.pokedex.features.move.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoveDetailScreenViewModel(
    private var moveRemoteRepository: MoveRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _moveInfo = MutableStateFlow(MoveInfo())
    var moveInfo: StateFlow<MoveInfo> = _moveInfo.asStateFlow()

    private var _pokemons = MutableStateFlow(listOf<PokemonDexEntry>())
    var pokemons = _pokemons.asStateFlow()

    fun loadMoveInfo(move: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                moveRemoteRepository.getMove(move)
                    .onSuccess { moveData ->
                        _moveInfo.value = moveData
                        _pokemons.value = moveData.learnedBy.map { resource ->
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

    fun refreshMove(move: String) {
        _moveInfo.value = MoveInfo()
        _message.value = hashMapOf()
        loadMoveInfo(move)
    }
}