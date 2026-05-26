/*
 * Kronos Tech. Copyright (c) 2023.
 *
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndexDto(
    @SerialName("game_index")
    val gameIndex: Int = -1,
    val version: NamedResourceApiDto = NamedResourceApiDto()
)
