package com.kronos.mutliplatform.pokedex.features.berries.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryInfo
import com.kronos.mutliplatform.pokedex.domain.repository.BerryRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BerryDetailScreenViewModel(
    private val berryRemoteRepository: BerryRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _berryInfo = MutableStateFlow(BerryInfo())
    var berryInfo = _berryInfo.asStateFlow()

    fun loadBerryInfo(berry: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                berryRemoteRepository.getBerry(berry)
                    .onSuccess { berryData ->
                        val sprite = urlProvider.getImageUrl(
                            ImageType.ITEM,
                            berryData.itemResource.name,
                        )

                        berryData.item = berryData.item.copy(
                            sprites = berryData.item.sprites.copy(
                                defaultImg = sprite,
                            ),
                        )

                        _berryInfo.value = berryData
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

    fun refreshMove(berry: String) {
        _berryInfo.value = BerryInfo()
        _message.value = hashMapOf()
        loadBerryInfo(berry)
    }
}