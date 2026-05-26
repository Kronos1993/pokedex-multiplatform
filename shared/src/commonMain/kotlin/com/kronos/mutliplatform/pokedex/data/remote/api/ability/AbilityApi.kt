package com.kronos.mutliplatform.pokedex.data.remote.api.ability

class AbilityApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "ability?limit=$limit&offset=$offset"
        fun GET_ABILITY(ability: String) = "ability/$ability"
    }
}