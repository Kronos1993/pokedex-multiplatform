package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityInfoDto(
    val id: Int,
    val name: String,
    @SerialName("is_main_series")
    val isMainSeries: Boolean,
    val generation: NamedResourceApi,
    val names: List<NameDto>,
    @SerialName("effect_entries")
    val effectEntries: List<EffectEntryDto>,
    @SerialName("effect_changes")
    val effectChanges: List<AbilityEffectChangeDto>,
    @SerialName("flavor_text_entries")
    val flavorTextEntryEntries: List<FlavorTextEntryDto>,
    val pokemon: List<PokemonWithAbilityDto>
)
