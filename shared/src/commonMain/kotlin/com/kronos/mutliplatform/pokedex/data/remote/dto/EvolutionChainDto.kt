package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionChainDto(
    @SerialName("baby_trigger_item")
    var babyFriggerItem:NamedResourceApiDto? = NamedResourceApiDto(),
    var chain: ChainLinkDto? = ChainLinkDto(),
    var id:Int = 0,
)
