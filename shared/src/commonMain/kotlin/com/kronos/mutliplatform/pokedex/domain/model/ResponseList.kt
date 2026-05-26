/*
 * Copyright (c) 2022. Kronos
 * Created by Marcos Octavio Guerra Liso
 */

package com.kronos.mutliplatform.pokedex.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseList<Any>(
    var count:Int = 0,
    var next:String? = "",
    var results: List<Any> = listOf(),
)
