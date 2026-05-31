/*
 * Copyright (c) 2022. Kronos
 * Created by Marcos Octavio Guerra Liso
 */

package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDexEntry(
    var dexEntry:Int = 0,
    val pokemonId:Int = 0,
    var pokemon:NamedResourceApi = NamedResourceApi(),
    var imageUrl:String = ""
)
