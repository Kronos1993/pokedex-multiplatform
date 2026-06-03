package com.kronos.mutliplatform.pokedex.domain.model.item

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class BerryInfo(
    var firmness: NamedResourceApi = NamedResourceApi(),
    var flavors: List<BerryFlavor> = listOf(),
    var growthTime: Int = 0,
    var id: Int = 0,
    var itemResource: NamedResourceApi = NamedResourceApi(),
    var item: ItemInfo = ItemInfo(),
    var maxHarvest: Int = 0,
    var name: String = "",
    var names: List<Name> = listOf(),
    var naturalGiftPower: Int = 0,
    var naturalGiftType: NamedResourceApi = NamedResourceApi(),
    var size: Int = 0,
    var smoothness: Int = 0,
    var soilDryness: Int = 0,
) {

    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names
                .firstOrNull { it.language.name == "en" }
                ?.name
            ?: names
                .firstOrNull()
                ?.name
            ?: name
    }
}
