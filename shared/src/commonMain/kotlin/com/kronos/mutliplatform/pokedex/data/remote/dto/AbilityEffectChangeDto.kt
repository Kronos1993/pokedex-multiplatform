package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.Effect
import kotlinx.serialization.Serializable

@Serializable
data class AbilityEffectChangeDto(
    val effectEntries: List<Effect>,
    val versionGroup: NamedResourceApiDto
)
