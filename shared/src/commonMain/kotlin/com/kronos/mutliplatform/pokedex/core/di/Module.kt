package com.kronos.mutliplatform.pokedex.core.di

import com.kronos.mutliplatform.pokedex.core.preferences.PreferenceViewModel
import com.kronos.mutliplatform.pokedex.core.preferences.datasource.PreferenceDataSource
import com.kronos.mutliplatform.pokedex.core.preferences.datasource.PreferenceDatasourceImpl
import com.kronos.mutliplatform.pokedex.core.preferences.repository.PreferenceRepository
import com.kronos.mutliplatform.pokedex.core.preferences.repository.PreferenceRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module


val coreViewModel = module{
    //core viewmodels
    singleOf(::PreferenceViewModel)
}


val preferenceModule = module {
    singleOf(::PreferenceDatasourceImpl).bind<PreferenceDataSource>()
    singleOf(::PreferenceRepositoryImpl).bind<PreferenceRepository>()
}