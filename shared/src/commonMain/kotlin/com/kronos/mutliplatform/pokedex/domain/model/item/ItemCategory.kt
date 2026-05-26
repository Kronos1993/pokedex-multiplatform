package com.kronos.mutliplatform.pokedex.domain.model.item

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class ItemCategory(
    var id:Int = 0,
    var items:List<NamedResourceApi> = listOf(),
    var name: String = "",
    var pocket: NamedResourceApi = NamedResourceApi()
)