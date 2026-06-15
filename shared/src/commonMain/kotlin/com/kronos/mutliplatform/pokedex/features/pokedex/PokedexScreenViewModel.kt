package com.kronos.mutliplatform.pokedex.features.pokedex

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.PlatformType
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import com.kronos.mutliplatform.pokedex.features.pokedex.domain.PokedexItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokedexScreenViewModel(
    private val pokedexRemoteRepository: PokedexRemoteRepository,
    private val appInfo: IAppInfo,
    var urlProvider: UrlProvider,
    val platform: Platform,
) : ParentViewModel() {

    private val _allPokedex = MutableStateFlow<List<PokedexItem>>(emptyList())

    val pokedex: StateFlow<List<PokedexItem>> =
        combine(_allPokedex, _searchQuery) { pokedexList, query ->

            if (query.isBlank()) {
                pokedexList
            } else {
                pokedexList.filter {
                    it.normalizeName.contains(
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

    private fun postPokedex(newItems: List<NamedResourceApi>) {

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
        _allPokedex.value.forEach { result[it.normalizeName] = it }

        newItems.forEach { item ->

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

        _allPokedex.value = result.values.toList()
    }

    fun loadPokedex(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            pokedexRemoteRepository.list(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    _loading.value = (false)
                    if (reset)
                        _allPokedex.value = listOf()

                    if (it.results.isNotEmpty()) {
                        setOffset(offset.value + limit.value)
                        postPokedex(it.results)
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

