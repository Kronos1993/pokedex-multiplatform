package com.kronos.mutliplatform.pokedex.domain.model.move

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class MoveList(
    val move: NamedResourceApi,
    var moveDetails: List<MoveDetail> = listOf(),
    var order : Int = 0
)
