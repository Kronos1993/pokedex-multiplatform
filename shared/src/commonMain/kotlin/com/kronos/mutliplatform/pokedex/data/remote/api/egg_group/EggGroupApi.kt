package com.kronos.mutliplatform.pokedex.data.remote.api.egg_group

class EggGroupApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "egg-group?limit=$limit&offset=$offset"
        fun GET_EGG_GROUP(eggGroup: String) = "egg-group/$eggGroup"
    }
}