package com.kronos.mutliplatform.pokedex.data.remote.dto

import com.kronos.mutliplatform.pokedex.data.NameDto
import kotlinx.serialization.Serializable

@Serializable
data class ItemCategoryDto(
    var id:Int = 0,
    var items:List<NamedResourceApiDto> = listOf(),
    var name: String = "",
    val names: List<NameDto>,
    var pocket: NamedResourceApiDto = NamedResourceApiDto()
)