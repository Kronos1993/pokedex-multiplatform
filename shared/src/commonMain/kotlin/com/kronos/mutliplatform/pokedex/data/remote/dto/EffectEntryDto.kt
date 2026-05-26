package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EffectEntryDto(
    var effect:String = "",
    @SerialName("short_effect")
    var shortEffect:String = "",
    val language: NamedResourceApiDto,
)