package com.kronos.mutliplatform.pokedex.domain.model.ability

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class PokemonWithAbility(
    val pokemon: NamedResourceApi = NamedResourceApi(),
    val isHidden:Boolean = true,
)
