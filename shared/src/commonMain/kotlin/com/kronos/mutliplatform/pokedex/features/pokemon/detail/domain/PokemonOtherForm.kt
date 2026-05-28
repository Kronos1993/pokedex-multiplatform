package com.kronos.mutliplatform.pokedex.features.pokemon.detail.domain

import kotlinx.serialization.Serializable

@Serializable
data class PokemonOtherForm(
    val imgUrl:String,
    val nameFormatted:String,
    val name:String,
    val url:String
)