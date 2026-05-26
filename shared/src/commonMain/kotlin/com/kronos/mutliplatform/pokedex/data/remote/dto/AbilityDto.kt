package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AbilityDto(
    val ability: NamedResourceApiDto = NamedResourceApiDto(),
    val isHidden:Boolean = true,
)
