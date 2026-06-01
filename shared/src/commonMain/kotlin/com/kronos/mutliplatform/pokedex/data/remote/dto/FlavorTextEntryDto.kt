package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextEntryDto(
    @SerialName("flavor_text")
    val flavorText: String,
    val language: NamedResourceApiDto,
    val version: NamedResourceApiDto? = null
    )