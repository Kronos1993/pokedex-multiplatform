package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import com.kronos.mutliplatform.pokedex.domain.model.ResourceApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecieInfoDto(
    @SerialName("base_happiness")
    var baseHappiness:Int = 0,
    @SerialName("capture_rate")
    var captureRate:Int = 0,
    @SerialName("evolution_chain")
    var evolutionChain: ResourceApi = ResourceApi(),
    @SerialName("evolves_from_species")
    var evolvesFrom:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("flavor_text_entries")
    var description:List<FlavorTextEntryDto> = listOf(),
    @SerialName("growth_rate")
    var growthRate:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("gender_rate")
    var genderRate:Int = -1,
    @SerialName("hatch_counter")
    var hatchCounter:Int = -1,
    @SerialName("habitat")
    var habitat:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("has_gender_differences")
    var hasGenderDifferences:Boolean = false,
    @SerialName("is_baby")
    var isBaby:Boolean = false,
    @SerialName("is_legendary")
    var isLegendary:Boolean = false,
    @SerialName("is_mythical")
    var isMythical:Boolean = false,
    var name:String = "",
    val names: List<NameDto> = listOf(),
    var varieties:List<SpecieVarietiesDto> = listOf(),
    @SerialName("egg_groups")
    var eggGroups:List<NamedResourceApiDto> = listOf(),
    var genera:List<PokemonGeneraDto> = listOf(),
)
