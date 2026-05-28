package com.kronos.mutliplatform.pokedex.features.pokedex.domain

import kotlinx.serialization.Serializable

@Serializable
data class PokedexItem(
    val name:String,
    val url:String,
    val normalizeName:String
)