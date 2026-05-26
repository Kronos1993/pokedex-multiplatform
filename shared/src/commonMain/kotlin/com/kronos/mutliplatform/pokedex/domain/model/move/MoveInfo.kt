package com.kronos.mutliplatform.pokedex.domain.model.move

import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import kotlinx.serialization.Serializable

@Serializable
data class MoveInfo(
    var accuracy: Int = 0,
    var moveCategory: String = "",
    var moveFlavorText: List<FlavorText> = listOf(),
    var learnedBy: List<NamedResourceApi> = listOf(),
    var moveName: String = "",
    var names:List<Name> = listOf(),
    var power: Int = 0,
    var pp: Int = 0,
    var priority: Int = 0,
    var type:NamedResourceApi = NamedResourceApi(),
    var effects:List<EffectEntry> = listOf(),
    var effectChance:Int? = 0,
)
