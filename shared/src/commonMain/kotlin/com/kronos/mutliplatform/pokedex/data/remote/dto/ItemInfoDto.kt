package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import com.kronos.mutliplatform.pokedex.domain.model.ResourceApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemInfoDto(
    var attributes:List<NamedResourceApiDto> = listOf(),
    @SerialName("baby_trigger_for")
    var babyTriggerFor:ResourceApi=ResourceApi(),
    var category:NamedResourceApiDto = NamedResourceApiDto(),
    var cost:Int = 0,
    @SerialName("effect_entries")
    var effectEntries:List<EffectEntryDto> = listOf(),
    @SerialName("flavor_text_entries")
    var descriptions:List<FlavorTextDto> = listOf(),
    @SerialName("fling_effect")
    var flingEffect:NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("fling_power")
    var flingPower:Int = 0,
    @SerialName("held_by_pokemon")
    var heldByPokemon:List<ItemHeldByPokemonDto> = listOf(),
    var id:Int = 0,
    var name:String = "",
    val names: List<NameDto>,
    var sprites:SpriteDto = SpriteDto()
)
