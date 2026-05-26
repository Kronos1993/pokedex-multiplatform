package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BerryInfoDto(
    var firmness:NamedResourceApiDto = NamedResourceApiDto(),
    var flavors:List<BerryFlavorDto> = listOf(),
    @SerialName("growth_time")
    var growthTime:Int = 0,
    var id:Int = 0,
    var itemResource:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("max_harvest")
    var maxHarvest:Int = 0,
    var name:String = "",
    val names: List<NameDto> = listOf(),
    @SerialName("natural_gift_power")
    var naturalGiftPower:Int = 0,
    @SerialName("natural_gift_type")
    var naturalGiftType:NamedResourceApiDto = NamedResourceApiDto(),
    var size:Int = 0,
    var smoothness:Int = 0,
    @SerialName("soil_dryness")
    var soilDryness:Int = 0
)
