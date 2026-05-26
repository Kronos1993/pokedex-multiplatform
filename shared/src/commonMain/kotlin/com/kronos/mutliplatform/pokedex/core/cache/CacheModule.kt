package com.kronos.mutliplatform.pokedex.core.cache

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val cacheModule = module {
    singleOf(::AppCache ).bind<ICache>()
}