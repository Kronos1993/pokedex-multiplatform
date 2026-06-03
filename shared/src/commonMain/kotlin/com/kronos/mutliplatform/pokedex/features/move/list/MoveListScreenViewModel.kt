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
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MoveListScreenViewModel(
    private val appInfo: IAppInfo,
    private val moveRemoteRepository: MoveRemoteRepository,
    val platform: Platform
): ParentViewModel() {

    private val _allMoves = MutableStateFlow<List<NamedResourceApi>>(emptyList())

    var moves: StateFlow<List<NamedResourceApi>> =
        combine(_allMoves, _searchQuery) { moves, query ->

            if (query.isBlank()) {
                moves
            } else {
                moves.filter {
                    it.name.contains(
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

    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postMoves(results: List<NamedResourceApi>) {
        _allMoves.value = _allMoves.value.plus(results)
    }

    fun loadMoves(reset: Boolean = false) {
        _loading.value = true
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
                    _loading.value = (false)
                    if (reset)
                        _allMoves.value = listOf()

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
                    _message.value = (err)
                    _loading.value = (false)
                }
        }
    }
}