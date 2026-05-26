package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextDto(
    @SerialName("text")
    val flavorText: String,
    val language: NamedResourceApiDto,
    @SerialName("version_group")
    val versionGroup: NamedResourceApiDto
    )