package com.kronos.mutliplatform.pokedex.features.abilities.list

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AbilityListScreenViewModel(
    private val appInfo: IAppInfo,
    private val abilityRemoteRepository: AbilityRemoteRepository,
    val platform: Platform
) : ParentViewModel() {

    private val _allAbilities = MutableStateFlow<List<NamedResourceApi>>(emptyList())

    var abilities: StateFlow<List<NamedResourceApi>> =
        combine(_allAbilities, _searchQuery) { abilities, query ->

            if (query.isBlank()) {
                abilities
            } else {
                abilities.filter {
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

    private fun postAbilities(results: List<NamedResourceApi>) {
        _allAbilities.value = _allAbilities.value.plus(results)
    }

    fun loadAbilities(reset: Boolean = false) {
        _loading.value = true
        if (reset) {
            setLimit(50)
            setOffset(0)
            setLastPage(false)
        }
        viewModelScope.launch(Dispatchers.IO) {
            abilityRemoteRepository.listAbility(
                limit.value,
                offset.value,
            )
                .onSuccess {
                    _loading.value = (false)
                    if (reset)
                        _allAbilities.value = listOf()

                    if (it.results.isNotEmpty()) {
                        setOffset(offset.value + limit.value)
                        postAbilities(it.results)
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