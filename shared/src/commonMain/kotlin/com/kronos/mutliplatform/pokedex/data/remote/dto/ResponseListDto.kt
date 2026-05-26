/*
 * Copyright (c) 2022. Kronos
 * Created by Marcos Octavio Guerra Liso
 */

package com.kronos.mutliplatform.pokedex.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponseListDto<Any>(
    var count: Int = 0,
    var next: String? = "",
    var results: List<Any> = listOf(),
)
