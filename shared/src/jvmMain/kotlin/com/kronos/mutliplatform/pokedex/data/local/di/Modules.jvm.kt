package com.kronos.mutliplatform.pokedex.data.local.di

import com.kronos.mutliplatform.pokedex.data.local.database.DatabaseDriverFactory
import org.koin.dsl.module

actual val platformLocalDataBaseModules = module{
    single { DatabaseDriverFactory() }
}
