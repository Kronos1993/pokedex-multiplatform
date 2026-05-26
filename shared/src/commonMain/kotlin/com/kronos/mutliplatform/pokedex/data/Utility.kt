package com.kronos.mutliplatform.pokedex.data

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class Effect(
    val effect: String,
    val language: NamedResourceApi
)

@Serializable
data class NameDto(
    val name: String,
    val language: NamedResourceApi
)
