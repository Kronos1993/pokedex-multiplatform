package com.kronos.mutliplatform.pokedex.features.natures.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.NatureRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NatureListScreenViewModel(
    private val appInfo: IAppInfo,
    private val natureRemoteRepository: NatureRemoteRepository,
    val platform: Platform
): ParentViewModel() {

    private var _natures = MutableStateFlow(listOf<NamedResourceApi>())
    var natures: StateFlow<List<NamedResourceApi>> = _natures.asStateFlow()

    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postNatures(results: List<NamedResourceApi>) {
        _natures.value = _natures.value.plus(results)
    }

    fun loadNatures(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setLimit(50)
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
                        _natures.value = listOf()

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