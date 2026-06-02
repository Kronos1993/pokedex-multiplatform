package com.kronos.mutliplatform.pokedex.domain.model.move

import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class MoveInfo(
    var accuracy: Int = 0,
    var moveCategory: String = "",
    var moveFlavorText: List<FlavorText> = listOf(),
    var learnedBy: List<NamedResourceApi> = listOf(),
    var moveName: String = "",
    var names: List<Name> = listOf(),
    var power: Int = 0,
    var pp: Int = 0,
    var priority: Int = 0,
    var type: NamedResourceApi = NamedResourceApi(),
    var effects: List<EffectEntry> = listOf(),
    var effectChance: Int? = 0,
) {

    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names.firstOrNull()?.name
            ?: moveName
    }

    fun getDescription(language: String): String {
        return moveFlavorText
            .firstOrNull { it.language == language }
            ?.description
            ?: moveFlavorText.firstOrNull()?.description?.replace("\n", " ")
            ?: moveFlavorText
                .firstOrNull { it.language == "en" }
                ?.description
            ?: moveFlavorText.firstOrNull()?.description?.replace("\n", " ")
            ?: ""
    }

    fun getMoveEffect(language: String): String {
        return effects
            .firstOrNull { it.language == language }
            ?.effect?.replace(Regex("effect_chance"), effectChance.toString())?.replace("$", "")
            ?: effects
                .firstOrNull { it.language == "en" }
                ?.effect?.replace(Regex("effect_chance"), effectChance.toString())?.replace("$", "")
            ?: ""
    }

    fun getShortEffect(language: String): String {
        return effects
            .firstOrNull { it.language == language }
            ?.shortEffect?.replace(Regex("effect_chance"), effectChance.toString())
            ?.replace("$", "")
            ?: effects
                .firstOrNull { it.language == "en" }
                ?.shortEffect?.replace(Regex("effect_chance"), effectChance.toString())
                ?.replace("$", "")
            ?: ""
    }

}
