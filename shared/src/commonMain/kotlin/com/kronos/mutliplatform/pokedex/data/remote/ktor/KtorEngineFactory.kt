package com.kronos.mutliplatform.pokedex.data.remote.ktor

import io.ktor.client.engine.HttpClientEngine

interface KtorEngineFactory {
    fun createKtorEngine(): HttpClientEngine
}