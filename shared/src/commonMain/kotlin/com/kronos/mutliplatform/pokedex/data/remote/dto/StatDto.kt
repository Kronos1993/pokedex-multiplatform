package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class StatDto(
    val baseStat: Int = 0,
    val statDto: NamedResourceApiDto = NamedResourceApiDto(),
    val effort: Int = 0,
    )
