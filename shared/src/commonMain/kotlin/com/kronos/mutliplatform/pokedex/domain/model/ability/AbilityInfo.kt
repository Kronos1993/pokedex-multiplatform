package com.kronos.mutliplatform.pokedex.domain.model.ability

import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import kotlinx.serialization.Serializable

@Serializable
data class AbilityInfo(
    var id:Int = 0,
    var name:String = "",
    var names:List<Name> = listOf(),
    var pokemon:List<PokemonWithAbility> = listOf(),
    var flavorText:List<FlavorText> = listOf(),
    var effects:List<EffectEntry> = listOf(),
)
