package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NamedResourceApiDto(
    var name:String = "",
    var url:String = "",
)