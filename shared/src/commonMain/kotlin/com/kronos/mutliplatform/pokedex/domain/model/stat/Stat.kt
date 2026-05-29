package com.kronos.mutliplatform.pokedex.domain.model.stat

import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val baseStat:Int = 0,
    val statName:String = "",
    val statEffort:Int = 0,
){
    fun calculateMaxStat(): Int {
        return if (statName.lowercase() == "hp") {
            // Fórmula HP: floor(((2 * base + 31 + floor(252/4)) * 100) / 100) + 100 + 10
            val iv = 31; val ev = 252; val level = 100
            ((2 * baseStat + iv + (ev / 4)) * level / 100) + level + 10
        } else {
            // Fórmula stat normal (naturaleza 1.0x)
            val iv = 31; val ev = 252; val level = 100
            val base = ((2 * baseStat + iv + (ev / 4)) * level / 100) + 5
            (base * 1.1f).toInt() // naturaleza beneficent
        }
    }
}
