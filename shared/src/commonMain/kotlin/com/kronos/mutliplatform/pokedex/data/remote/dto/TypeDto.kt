package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TypeDto(
    var slot:Int = 0,
    var type: NamedResourceApiDto = NamedResourceApiDto(),
)
