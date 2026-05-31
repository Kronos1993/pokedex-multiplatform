package com.kronos.mutliplatform.pokedex.features.move.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoveListScreenViewModel(
    private val appInfo: IAppInfo,
    private val moveRemoteRepository: MoveRemoteRepository,
    val platform: Platform
): ParentViewModel() {

    private var _moves = MutableStateFlow(listOf<NamedResourceApi>())
    var moves: StateFlow<List<NamedResourceApi>> = _moves.asStateFlow()

    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postMoves(results: List<NamedResourceApi>) {
        _moves.value = _moves.value.plus(results)
    }

    fun loadMoves() {
        loading = true
        viewModelScope.launch(Dispatchers.IO) {
            moveRemoteRepository.listMove(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    loading = (false)
                    setOffset(offset.value + limit.value)
                    postMoves(it.results)
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

    fun loadMoves(reset: Boolean = false) {
        loading = true
        if (reset) {
            setLimit(50)
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            moveRemoteRepository.listMove(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    loading = (false)
                    if (reset)
                        _moves.value = listOf()

                    if (it.results.isNotEmpty()) {
                        setOffset(offset.value + limit.value)
                        postMoves(it.results)
                    } else
                        setLastPage(true)

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
}