package com.kronos.mutliplatform.pokedex.domain.model.ability

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val ability: NamedResourceApi = NamedResourceApi(),
    val isHidden:Boolean = true,
)
