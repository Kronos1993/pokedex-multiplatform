package com.kronos.mutliplatform.pokedex.domain.model.move

import kotlinx.serialization.Serializable

@Serializable
data class MoveDetail(
    var levelLearned:Int = 0,
    var moveLearnMethod:String = "",
)
