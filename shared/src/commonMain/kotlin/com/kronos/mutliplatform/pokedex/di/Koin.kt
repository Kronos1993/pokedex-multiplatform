package com.kronos.mutliplatform.pokedex.di

import com.kronos.mutliplatform.pokedex.core.cache.cacheModule
import com.kronos.mutliplatform.pokedex.core.di.coreViewModel
import com.kronos.mutliplatform.pokedex.core.di.platformModule
import com.kronos.mutliplatform.pokedex.core.di.preferenceModule
import com.kronos.mutliplatform.pokedex.data.local.di.localDatabaseDataSourceModule
import com.kronos.mutliplatform.pokedex.data.local.di.localDatabaseModule
import com.kronos.mutliplatform.pokedex.data.local.di.platformLocalDataBaseModules
import com.kronos.mutliplatform.pokedex.data.remote.di.commonRemoteModules
import com.kronos.mutliplatform.pokedex.data.remote.di.platformDataRemoteModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config : KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            coreViewModel,
            viewModelModule,
            preferenceModule,
            commonRemoteModules,
            platformDataRemoteModules,
            localDatabaseModule,
            localDatabaseDataSourceModule,
            platformModule,
            platformLocalDataBaseModules,
            cacheModule,
        )
    }
}