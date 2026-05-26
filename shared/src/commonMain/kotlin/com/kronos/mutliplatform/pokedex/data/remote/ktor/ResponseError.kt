package com.kronos.mutliplatform.pokedex.data.remote.ktor

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    var code:Int = 0,
    var message:String = ""
)
