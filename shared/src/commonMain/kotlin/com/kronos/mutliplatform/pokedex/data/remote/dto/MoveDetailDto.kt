package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveDetailDto(
    @SerialName("level_learned_at")
    var levelLearned:Int = 0,
    @SerialName("move_learn_method")
    var moveLearnedMethodDto: NamedResourceApiDto = NamedResourceApiDto(),
)
