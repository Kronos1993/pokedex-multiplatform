/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EncounterDto (
    @SerialName("location_area")
    var location:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("version_details")
    var versionDetails:List<VersionDetailDto> = listOf(),
)