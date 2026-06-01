package com.kronos.mutliplatform.pokedex.features.types.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.type.DamageRelationContainer
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo
import com.kronos.mutliplatform.pokedex.domain.repository.TypeRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TypeDetailScreenViewModel(
    private var typeRemoteRepository: TypeRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private val _typeInfo = MutableStateFlow(TypeInfo())
    val typeInfo = _typeInfo.asStateFlow()

    private val _doubleDamageFrom = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val doubleDamageFrom = _doubleDamageFrom.asStateFlow()

    private val _halfDamageFrom = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val halfDamageFrom = _halfDamageFrom.asStateFlow()

    private val _noDamageFrom = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val noDamageFrom = _noDamageFrom.asStateFlow()

    private val _doubleDamageTo = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val doubleDamageTo = _doubleDamageTo.asStateFlow()

    private val _halfDamageTo = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val halfDamageTo = _halfDamageTo.asStateFlow()

    private val _noDamageTo = MutableStateFlow<List<DamageRelationContainer>>(listOf())
    val noDamageTo = _noDamageTo.asStateFlow()

    private fun postTypeInfo(type: TypeInfo) {
        _typeInfo.value = (type)
    }

    fun postAll(typeInfo: TypeInfo) {
        postTypeInfo(typeInfo)

        _doubleDamageFrom.value = (typeInfo.damageRelations.doubleDamageFrom.map {
            DamageRelationContainer(
                it.name,
                "x2"
            )
        })
        _halfDamageFrom.value = (typeInfo.damageRelations.halfDamageFrom.map {
            DamageRelationContainer(
                it.name,
                "x1/2"
            )
        })
        _noDamageFrom.value = (typeInfo.damageRelations.noDamageFrom.map {
            DamageRelationContainer(
                it.name,
                "x0"
            )
        })

        _doubleDamageTo.value = (typeInfo.damageRelations.doubleDamageTo.map {
            DamageRelationContainer(
                it.name,
                "x2"
            )
        })
        _halfDamageTo.value = (typeInfo.damageRelations.halfDamageTo.map {
            DamageRelationContainer(
                it.name,
                "x1/2"
            )
        })
        _noDamageTo.value = (typeInfo.damageRelations.noDamageTo.map {
            DamageRelationContainer(
                it.name,
                "x0"
            )
        })
    }


    fun loadTypeInfo(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = (true)
            typeRemoteRepository.getTypeInfo (type)
                .onSuccess {
                    _loading.value = (false)
                    postAll(it)
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