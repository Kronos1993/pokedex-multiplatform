/*
 * Copyright (c) 2022. Kronos
 * Created by Marcos Octavio Guerra Liso
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//models the object from pokemon api ws

@Serializable
data class PokemonDexEntryDto(
    var entry_number:Int = 0,
    @SerialName("pokemon_species")
    var pokemon:NamedResourceApiDto = NamedResourceApiDto(),
)
