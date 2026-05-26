package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class OtherSpriteDto(
    val home: PokemonHomeDto = PokemonHomeDto(),
)