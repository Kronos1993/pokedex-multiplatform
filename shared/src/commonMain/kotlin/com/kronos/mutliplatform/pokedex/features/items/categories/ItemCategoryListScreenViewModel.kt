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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemCategoryListScreenViewModel(
    private var itemRemoteRepository: ItemRemoteRepository,
    private val appInfo: IAppInfo,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private var _itemCategory = MutableStateFlow(listOf<NamedResourceApi>())
    var itemCategory: StateFlow<List<NamedResourceApi>> = _itemCategory.asStateFlow()


    private var _appVersion = MutableStateFlow("")
    var appVersion: StateFlow<String> = _appVersion.asStateFlow()

    fun getAppVersion() {
        _appVersion.value = appInfo.getAppVersion()
    }

    private fun postItems(itemCategory: List<NamedResourceApi>) {
        _itemCategory.value = _itemCategory.value.plus(itemCategory)
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
                        _itemCategory.value = listOf()

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
        _itemCategory.value = listOf()
        val err = HashMap<String, String>()
        _message.value = (err)
        loadItemCategories(reset)
    }
}

