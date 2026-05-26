package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NatureDetailDto(
    val id: Int,
    val name: String,
    val names: List<NameDto>,
    @SerialName("decreased_stat")
    val decreasedStat: NamedResourceApiDto?,
    @SerialName("increased_stat")
    val increasedStat: NamedResourceApiDto?,
    @SerialName("hates_flavor")
    val hatesFlavor: NamedResourceApiDto?,
    @SerialName("likes_flavor")
    val likesFlavor: NamedResourceApiDto?,
)
