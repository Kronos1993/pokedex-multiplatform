package com.kronos.mutliplatform.pokedex.features.natures.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.PlatformType
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.NatureRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NatureListScreenViewModel(
    private val appInfo: IAppInfo,
    private val natureRemoteRepository: NatureRemoteRepository,
    val platform: Platform
) : ParentViewModel() {

    private val _allNatures = MutableStateFlow<List<NamedResourceApi>>(emptyList())

    var natures: StateFlow<List<NamedResourceApi>> =
        combine(_allNatures, _searchQuery) { natures, query ->

            if (query.isBlank()) {
                natures
            } else {
                natures.filter {
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

    init {
        setLimit(
            if (platform.platformType == PlatformType.DESKTOP)
                100
            else
                50
        )
    }

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postNatures(results: List<NamedResourceApi>) {
        _allNatures.value = _allNatures.value.plus(results)
    }

    fun loadNatures(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            natureRemoteRepository.listNature(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    _loading.value = (false)
                    if (reset)
                        _allNatures.value = listOf()

                    if (it.results.isNotEmpty()) {
                        setOffset(offset.value + limit.value)
                        postNatures(it.results)
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