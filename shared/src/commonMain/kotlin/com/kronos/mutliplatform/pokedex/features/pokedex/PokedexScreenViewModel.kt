package com.kronos.mutliplatform.pokedex.features.pokedex

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.cache.ICache
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.util.ICloseApp
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import com.kronos.mutliplatform.pokedex.features.pokedex.domain.PokedexItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokedexScreenViewModel(
    private val pokedexRemoteRepository: PokedexRemoteRepository,
    private val appInfo: IAppInfo,
    private var closeApp: ICloseApp,
    var urlProvider: UrlProvider,
    var appCache: ICache,
    val platform: Platform,
) : ParentViewModel() {

    private var _pokedex = MutableStateFlow(listOf<PokedexItem>())
    var pokedex: StateFlow<List<PokedexItem>> = _pokedex.asStateFlow()

    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postPokedex(pokedex: List<NamedResourceApi>) {

        val specialPrefixes = listOf(
            "updated-",
            "extended-",
            "letsgo-",
            "conquest-gallery"
        )

        fun normalizeName(name: String): String {
            return name
                .removePrefix("updated-")
                .removePrefix("extended-")
                .removePrefix("original-")
                .removePrefix("letsgo-")
        }

        val result = linkedMapOf<String, PokedexItem>()

        pokedex.forEach { item ->

            val normalizedName = normalizeName(item.name)

            val pokedexItem = PokedexItem(
                name = item.name,
                url = item.url,
                normalizeName = normalizedName
            )

            val isSpecial = specialPrefixes.any(item.name::contains)

            if (!isSpecial) {

                result[normalizedName] = pokedexItem

            } else {

                val match = result.entries.firstOrNull { (_, value) ->
                    item.name.contains(value.normalizeName)
                }

                if (match != null) {
                    result[match.key] = pokedexItem
                }
            }
        }

        _pokedex.value = result.values.toList()
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

