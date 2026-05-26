package com.kronos.mutliplatform.pokedex.data.remote.ktor.util

import com.kronos.mutliplatform.pokedex.core.result.Error


class FullNetworkError(
    val noInternet: NetworkError,
    override val errorMessage: String,
    override val errorCode: Int
) : Error