package com.kronos.mutliplatform.pokedex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class FlavorText(
    var description:String = "",
    var language:String = "",
)