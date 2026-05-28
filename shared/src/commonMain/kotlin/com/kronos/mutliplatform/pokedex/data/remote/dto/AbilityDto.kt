package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityDto(
    val ability: NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("is_hidden")
    val isHidden:Boolean = true,
)
