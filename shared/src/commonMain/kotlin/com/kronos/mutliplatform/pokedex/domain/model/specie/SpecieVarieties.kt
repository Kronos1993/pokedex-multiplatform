package com.kronos.mutliplatform.pokedex.domain.model.specie

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class SpecieVarieties(
    var isDefault: Boolean = false,
    var pokemon: NamedResourceApi = NamedResourceApi(),
)
