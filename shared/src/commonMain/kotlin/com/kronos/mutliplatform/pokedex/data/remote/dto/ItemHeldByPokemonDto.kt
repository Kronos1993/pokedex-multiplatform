package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemHeldByPokemonDto(
    var pokemon:NamedResourceApiDto = NamedResourceApiDto(),
)
