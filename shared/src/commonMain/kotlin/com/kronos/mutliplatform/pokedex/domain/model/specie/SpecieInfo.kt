package com.kronos.mutliplatform.pokedex.domain.model.specie

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import kotlinx.serialization.Serializable

@Serializable
data class SpecieInfo(
    var baseHappiness:Int = 0,
    var captureRate:Int = 0,
    var genderRate:Int = -1,
    var hatchCounter:Int = -1,
    var evolutionChain: ResourceApi? = ResourceApi(),
    var evolvesFrom:NamedResourceApi? = NamedResourceApi(),
    var flavorText:List<FlavorText> = listOf(),
    var growthRate:NamedResourceApi? = NamedResourceApi(),
    var habitat:NamedResourceApi? = NamedResourceApi(),
    var hasGenderDifferences:Boolean = false,
    var isBaby:Boolean = false,
    var isLegendary:Boolean = false,
    var isMythical:Boolean = false,
    var name:String = "",
    var names:List<Name> = listOf(),
    var varieties:List<SpecieVarieties> = listOf(),
    var eggGroup:List<NamedResourceApi> = listOf(),
    var genera:List<PokemonGenera> = listOf(),
)
