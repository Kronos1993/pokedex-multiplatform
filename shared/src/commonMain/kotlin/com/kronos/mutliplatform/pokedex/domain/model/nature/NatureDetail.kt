package com.kronos.mutliplatform.pokedex.domain.model.nature

import com.kronos.mutliplatform.pokedex.domain.model.Name
import kotlinx.serialization.Serializable

@Serializable
data class NatureDetail(
    var decreasedStat: String? = "",
    var increasedStat: String? = "",
    var hatesFlavor: String? = "",
    var likesFlavor: String? = "",
    var name: String = "",
    var names: List<Name> = listOf(),
) {
    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names.firstOrNull()?.name
            ?: name
    }
}
