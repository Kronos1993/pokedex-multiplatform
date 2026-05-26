package com.kronos.mutliplatform.pokedex.features.pokedex

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.cache.ICache
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.util.ICloseApp
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokedexScreenViewModel (
    private val pokedexRemoteRepository: PokedexRemoteRepository,
    private val appInfo: IAppInfo,
    private var closeApp: ICloseApp,
    var appCache: ICache,
    val platform: Platform,
) : ParentViewModel() {

    private var _pokedex = MutableStateFlow(listOf<NamedResourceApi>())
    var pokedex: StateFlow<List<NamedResourceApi>> = _pokedex.asStateFlow()

    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion(){
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postPokedex(pokedex: List<NamedResourceApi>) {
        val filtered = pokedex.filter { item ->
            !item.name.contains("updated-") &&
                    !item.name.contains("original-") &&
                    !item.name.contains("extended-") &&
                    !item.name.contains("letsgo-") &&
                    !item.name.contains("conquest-gallery")
        }
        _pokedex.value = filtered
    }

    fun loadPokedex() {
        loading = true
        viewModelScope.launch(Dispatchers.IO) {
            pokedexRemoteRepository.list(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    loading = (false)
                    postPokedex(it.results)
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError){
                        err["error"] = it.errorMessage
                    }else{
                        err["error"] = it.toString()
                    }
                    message = (err)
                    loading = (false)
                }
        }
    }

    fun refreshPokedex() {
        _pokedex.value = listOf()
        setLimit(50)
        setOffset(0)
        val err = HashMap<String, String>()
        message = (err)
        loadPokedex()
    }

    fun closeApp() {
        viewModelScope.launch(Dispatchers.IO) {
            closeApp.closeApp()
        }
    }

}

