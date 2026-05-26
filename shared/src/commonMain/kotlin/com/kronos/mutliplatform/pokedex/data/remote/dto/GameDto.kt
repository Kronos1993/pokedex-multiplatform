/*
 * Kronos Tech. Copyright (c) 2023.
 *
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    val id:Int = 0,
    val name:String = "",
    val names:List<NameDto> = listOf(),
    val versionGroup: NamedResourceApiDto = NamedResourceApiDto()
)
