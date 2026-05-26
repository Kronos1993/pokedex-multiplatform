package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecieVarietiesDto(
    @SerialName("is_default")
    var is_default: Boolean = false,
    var pokemon: NamedResourceApiDto = NamedResourceApiDto(),
)
