package com.kronos.mutliplatform.pokedex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val name: String = "",
    val language: NamedResourceApi = NamedResourceApi()
)
