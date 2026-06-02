package com.kronos.mutliplatform.pokedex.features.natures.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.nature.NatureDetail
import com.kronos.mutliplatform.pokedex.domain.repository.NatureRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NatureDetailScreenViewModel(
    private var natureRemoteRepository: NatureRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _natureInfo = MutableStateFlow(NatureDetail())
    var natureInfo: StateFlow<NatureDetail> = _natureInfo.asStateFlow()

    fun loadNatureInfo(nature: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            try {
                natureRemoteRepository.getNature(nature)
                    .onSuccess { moveData ->
                        _natureInfo.value = moveData
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

    fun refreshNature(nature: String) {
        _natureInfo.value = NatureDetail()
        _message.value = hashMapOf()
        loadNatureInfo(nature)
    }
}