package com.kronos.mutliplatform.pokedex.domain.model.move

import kotlinx.serialization.Serializable

@Serializable
data class Move(
    var name:String = "",
    var url:String = "",
    var moveDetail: MoveDetail = MoveDetail()
)
