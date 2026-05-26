package com.kronos.mutliplatform.pokedex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class NamedResourceApi(
    var name:String = "",
    var url:String = "",
)