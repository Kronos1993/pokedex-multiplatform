package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.Effect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityEffectChangeDto(
    @SerialName("effect_entries")
    val effectEntries: List<Effect>,
    @SerialName("version_group")
    val versionGroup: NamedResourceApiDto
)
