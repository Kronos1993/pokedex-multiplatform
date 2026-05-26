package com.kronos.mutliplatform.pokedex.domain.model.item

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class BerryFlavor(
    var flavor: NamedResourceApi = NamedResourceApi(),
    var potency:Int = 0,
)