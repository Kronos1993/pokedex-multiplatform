package com.kronos.mutliplatform.pokedex.domain.model.specie

import com.kronos.mutliplatform.pokedex.core.util.roundTo2Decimals
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class SpecieInfo(
    var baseHappiness: Int = 0,
    var captureRate: Int = 0,
    var genderRate: Int = -1,
    var hatchCounter: Int = -1,
    var evolutionChain: ResourceApi? = ResourceApi(),
    var evolvesFrom: NamedResourceApi? = NamedResourceApi(),
    var flavorText: List<FlavorText> = listOf(),
    var growthRate: NamedResourceApi? = NamedResourceApi(),
    var habitat: NamedResourceApi? = NamedResourceApi(),
    var hasGenderDifferences: Boolean = false,
    var isBaby: Boolean = false,
    var isLegendary: Boolean = false,
    var isMythical: Boolean = false,
    var name: String = "",
    var names: List<Name> = listOf(),
    var varieties: List<SpecieVarieties> = listOf(),
    var eggGroup: List<NamedResourceApi> = listOf(),
    var genera: List<PokemonGenera> = listOf(),
) {
    fun getDescription(language: String): String {
        return flavorText
            .firstOrNull { it.language == language }
            ?.description
            ?: flavorText.firstOrNull()?.description
            ?: ""
    }

    fun getPokemonName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names.firstOrNull()?.name
            ?: name
    }

    fun getPokemonGenera(language: String): String {
        return genera
            .firstOrNull { it.language == language.substring(0,2) }
            ?.genus
            ?: genera.firstOrNull()?.genus
            ?: ""
    }

    fun getGenderPossibility(): GenderPossibility {

        if (genderRate == -1) {
            return GenderPossibility(
                male = 0f,
                female = 0f,
                genderless = true
            )
        }

        val femaleRate = genderRate * 12.5f
        val maleRate = 100.0f - femaleRate

        return GenderPossibility(
            male = maleRate,
            female = femaleRate,
            genderless = false
        )
    }

    fun calculateHatchCounter(): Int =
        hatchCounter * 255

    fun calculateCaptureRate(): Double = (captureRate * 0.13).roundTo2Decimals()

}
