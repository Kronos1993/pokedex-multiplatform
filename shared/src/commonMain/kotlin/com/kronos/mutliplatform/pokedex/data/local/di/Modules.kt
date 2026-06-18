package com.kronos.mutliplatform.pokedex.data.local.di

import com.kronos.mutliplatform.pokedex.data.local.database.createDatabase
import com.kronos.mutliplatform.pokedex.data.local.datasource.api_cache.ApiCacheLocalDataSource
import com.kronos.mutliplatform.pokedex.data.local.datasource.api_cache.ApiCacheLocalDatasourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.type.TypeRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.type.TypeRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.di.KtorClientFactoryType
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformLocalDataBaseModules: Module

val localDatabaseModule = module {
    single { createDatabase(get()) }
}

val localDatabaseDataSourceModule = module {
    single {
        ApiCacheLocalDatasourceImpl(
            get(),
        )
    }.bind<ApiCacheLocalDataSource>()
}