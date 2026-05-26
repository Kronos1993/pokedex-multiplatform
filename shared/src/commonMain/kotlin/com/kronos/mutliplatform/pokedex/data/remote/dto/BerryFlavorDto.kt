package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class BerryFlavorDto(
    var flavor: NamedResourceApiDto = NamedResourceApiDto(),
    var potency:Int = 0,
)