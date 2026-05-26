package com.kronos.mutliplatform.pokedex.data.remote.api.nature

class NatureApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "nature?limit=$limit&offset=$offset"
        fun GET_NATURE(nature: String) = "nature/$nature"
    }
}

