package com.kronos.mutliplatform.pokedex.domain.model.type

import kotlinx.serialization.Serializable

@Serializable
data class Type(
    var name:String = "",
    var slot:Int = 0,
)
