/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetailDto(
    @SerialName("encounter_details")
    var encounterDetails: List<EncounterDetailDto> = listOf(),
    @SerialName("max_chance")
    var maxChance:Int = 0,
    var version: NamedResourceApiDto = NamedResourceApiDto()
)
