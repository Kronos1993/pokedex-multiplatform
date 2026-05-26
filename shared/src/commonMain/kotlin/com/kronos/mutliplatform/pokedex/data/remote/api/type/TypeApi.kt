package com.kronos.mutliplatform.pokedex.data.remote.api.type

class TypeApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "type?limit=$limit&offset=$offset"
        fun GET_TYPE(type: String) = "type/$type"
    }
}