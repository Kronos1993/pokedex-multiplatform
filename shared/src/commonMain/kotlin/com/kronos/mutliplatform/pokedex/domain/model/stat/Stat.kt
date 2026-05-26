package com.kronos.mutliplatform.pokedex.domain.model.stat

import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val baseStat:Int = 0,
    val statName:String = "",
    val statEffort:Int = 0,
)
