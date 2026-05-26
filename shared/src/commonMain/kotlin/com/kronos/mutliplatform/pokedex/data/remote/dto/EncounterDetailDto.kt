/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EncounterDetailDto(
    var chance: Int = 0,
    @SerialName("max_level")
    var maxLevel:Int = 0,
    @SerialName("min_level")
    var minLevel:Int = 0,
    var method:NamedResourceApiDto = NamedResourceApiDto()
)
