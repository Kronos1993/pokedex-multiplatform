package com.kronos.mutliplatform.pokedex.features.items.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.cache.ICache
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
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

class ItemListScreenViewModel(
    private var itemRemoteRepository: ItemRemoteRepository,
    var appCache: ICache,
    val platform: Platform,
    val urlProvider: UrlProvider
) : ParentViewModel() {

    private var _items = MutableStateFlow(listOf<NamedResourceApi>())
    var items: StateFlow<List<NamedResourceApi>> = _items.asStateFlow()


    private fun postItems(items: List<NamedResourceApi>) {
        _items.value = _items.value.plus(items)

    }

    fun loadItems(itemCategory: String? = null, reset: Boolean = false) {
        if (itemCategory != null)
            getItemsByCategories(itemCategory)
        else
            getItems(reset)
    }

    fun getItems(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setLimit(50)
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            itemRemoteRepository.listItem(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    _loading.value = (false)
                    if (reset)
                        _items.value = listOf()

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

    fun getItemsByCategories(itemCategory: String) {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            itemRemoteRepository.getItemCategory(
                itemCategory
            )
                .onSuccess {
                    _loading.value = (false)
                    if (it.items.isNotEmpty()) {
                        postItems(it.items)
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

    fun refreshItems(itemCategory: String? = null, reset: Boolean = false) {
        _items.value = listOf()
        val err = HashMap<String, String>()
        _message.value = (err)
        loadItems(itemCategory, reset)
    }
}

