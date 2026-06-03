package com.kronos.mutliplatform.pokedex.features.items.categories

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.ItemRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ItemCategoryListScreenViewModel(
    private var itemRemoteRepository: ItemRemoteRepository,
    private val appInfo: IAppInfo,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private val _allItemCategory = MutableStateFlow<List<NamedResourceApi>>(emptyList())

    var itemCategory: StateFlow<List<NamedResourceApi>> =
        combine(_allItemCategory, _searchQuery) { categories, query ->

            if (query.isBlank()) {
                categories
            } else {
                categories.filter {
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

    private fun postItems(itemCategory: List<NamedResourceApi>) {
        _allItemCategory.value = _allItemCategory.value.plus(itemCategory)
    }

    fun loadItemCategories(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setLimit(50)
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            itemRemoteRepository.listItemCategories(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    _loading.value = (false)
                    if (reset)
                        _allItemCategory.value = listOf()

                    if (it.results.isNotEmpty()) {
                        setOffset(offset.value + limit.value)
                        postItems(it.results)
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


    fun refreshItems(reset: Boolean = false) {
        _searchQuery.value = ""
        _allItemCategory.value = emptyList()
        val err = HashMap<String, String>()
        _message.value = (err)
        loadItemCategories(reset)
    }
}

