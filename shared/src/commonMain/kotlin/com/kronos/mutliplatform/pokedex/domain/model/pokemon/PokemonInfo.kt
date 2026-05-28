package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.game.Game
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveList
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfo(
    val id:Int = 0,
    val name:String = "",
    val abilities:List<Ability> = listOf(),
    val baseExperience:Int = 0,
    val height:Double = 0.0,
    val weight:Double = 0.0,
    val types:List<Type> = listOf(),
    val stats:List<Stat> = listOf(),
    val sprites:Sprite = Sprite(),
    val moves:List<MoveList> = listOf(),
    var specieInfo: SpecieInfo? = SpecieInfo(),
    var specie: NamedResourceApi = NamedResourceApi(),
    var games:List<Game> = listOf()
){
    fun getTotalStat():Int{
        var total = 0
        this.stats.forEach { total += it.baseStat}
        return total
    }

    fun getMaxStatValue():Int{
        val stat = this.stats.maxByOrNull { it.baseStat }
        return stat.let {
            if (it!=null)
                it.baseStat + 10
            else
                0
        }
    }
}
