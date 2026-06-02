package com.kronos.mutliplatform.pokedex.domain.model.ability

import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import kotlinx.serialization.Serializable

@Serializable
data class AbilityInfo(
    var id: Int = 0,
    var name: String = "",
    var names: List<Name> = listOf(),
    var pokemon: List<PokemonWithAbility> = listOf(),
    var flavorText: List<FlavorText> = listOf(),
    var effects: List<EffectEntry> = listOf(),
) {
    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names.firstOrNull { it.language.name == "en" }?.name
            ?: names.firstOrNull()?.name
            ?: name
    }

    fun getDescription(language: String): String {
        return flavorText
            .firstOrNull { it.language == language }
            ?.description?.replace("\n", " ")
            ?: flavorText.firstOrNull()?.description?.replace("\n", " ")
            ?: flavorText
                .firstOrNull { it.language == "en" }
                ?.description?.replace("\n", " ")
            ?: flavorText.firstOrNull()?.description?.replace("\n", " ")
            ?: ""
    }

    fun getEffect(language: String): String {
        return effects
            .firstOrNull { it.language == language }
            ?.effect?.replace("\n", " ")
            ?.replace(
                "\u000c",
                " "
            ) ?: effects
            .firstOrNull { it.language == "en" }
            ?.effect?.replace("\n", " ")
            ?.replace(
                "\u000c",
                " "
            ) ?: ""
    }

}
