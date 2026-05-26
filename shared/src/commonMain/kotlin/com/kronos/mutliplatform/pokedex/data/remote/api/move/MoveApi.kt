package com.kronos.mutliplatform.pokedex.data.remote.api.move

class MoveApi {

    companion object {
        fun LIST(limit: Int, offset: Int) = "move?limit=$limit&offset=$offset"
        fun GET_MOVE(move: String) = "move/$move"
    }
}

