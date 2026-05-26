package com.kronos.mutliplatform.pokedex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EffectEntry(
    var effect:String = "",
    var shortEffect:String = "",
    var language:String = "",
)