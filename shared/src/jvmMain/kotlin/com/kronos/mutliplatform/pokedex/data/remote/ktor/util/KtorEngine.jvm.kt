package com.kronos.mutliplatform.pokedex.data.remote.ktor.util

import com.kronos.mutliplatform.pokedex.data.remote.ktor.KtorEngineFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual class KtorEngine : KtorEngineFactory {
    override fun createKtorEngine(): HttpClientEngine {
        return OkHttp.create()
    }
}