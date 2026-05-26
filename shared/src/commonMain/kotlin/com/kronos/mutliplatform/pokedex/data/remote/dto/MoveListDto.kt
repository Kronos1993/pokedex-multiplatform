package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveListDto(
    val move: NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("version_group_details")
    var moveDetails: List<MoveDetailDto> = listOf()

)