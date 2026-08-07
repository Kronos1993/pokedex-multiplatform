package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemPriceDto(
    var currency: NamedResourceApiDto? = NamedResourceApiDto(),
    @SerialName("purchase_price")
    var purchasePrice: Int? = 0,
    @SerialName("sell_price")
    var sellPrice: Int? = 0,
    @SerialName("version_group")
    var versionGroup: NamedResourceApiDto? = NamedResourceApiDto(),
)