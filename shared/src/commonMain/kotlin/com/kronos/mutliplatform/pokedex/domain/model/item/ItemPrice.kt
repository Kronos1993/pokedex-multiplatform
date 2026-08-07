package com.kronos.mutliplatform.pokedex.domain.model.item

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class ItemPrice(
    var currency: NamedResourceApi = NamedResourceApi(),
    var purchasePrice: Int = 0,
    var sellPrice: Int = 0,
    var versionGroup:NamedResourceApi = NamedResourceApi(),
)