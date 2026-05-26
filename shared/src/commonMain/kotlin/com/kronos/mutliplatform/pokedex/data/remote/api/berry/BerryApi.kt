package com.kronos.mutliplatform.pokedex.data.remote.api.berry

class BerryApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "berry?limit=$limit&offset=$offset"
        fun GET_BERRY(berry: String) = "berry/$berry"
    }
}