/*
 * Copyright (c) 2022. Kronos
 * Created by Marcos Octavio Guerra Liso
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//models the object from pokemon api ws

@Serializable
data class PokemonInfoDto(
    val id:Int = 0,
    val name:String = "",
    val abilities:List<AbilityDto> = listOf(),
    @SerialName("base_experience")
    val baseExperience:Int = 0,
    val forms:List<NamedResourceApi> = listOf(),
    val height:Double = 0.0,
    val weight:Double = 0.0,
    val types:List<TypeDto> = listOf(),
    val stats:List<StatDto> = listOf(),
    val sprites: SpriteDto = SpriteDto(),
    val moves:List<MoveListDto> = listOf(),
    val species: NamedResourceApiDto = NamedResourceApiDto(),
    @SerialName("game_indices")
    val gameIndices: List<GameIndexDto> = listOf(),
    val specieInfoDto: SpecieInfoDto = SpecieInfoDto(),
    )
