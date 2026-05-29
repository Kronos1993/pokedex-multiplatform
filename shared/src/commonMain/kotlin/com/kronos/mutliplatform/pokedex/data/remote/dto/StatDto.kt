package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatDto(
    @SerialName("base_stat")
    val baseStat: Int = 0,
    @SerialName("stat")
    val statDto: NamedResourceApiDto = NamedResourceApiDto(),
    val effort: Int = 0,
    )
