package com.kronos.mutliplatform.pokedex.core.di

import com.kronos.mutliplatform.pokedex.core.DevicePlatform
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.exception.ExceptionHandler
import com.kronos.mutliplatform.pokedex.core.exception.ExceptionHandlerImpl
import com.kronos.mutliplatform.pokedex.core.logguer.DummyLogger
import com.kronos.mutliplatform.pokedex.core.logguer.ILogManager
import com.kronos.mutliplatform.pokedex.core.preferences.AppPreference
import com.kronos.mutliplatform.pokedex.core.preferences.IPreference
import com.kronos.mutliplatform.pokedex.core.util.AppInfo
import com.kronos.mutliplatform.pokedex.core.util.ChangeLang
import com.kronos.mutliplatform.pokedex.core.util.CloseAppImpl
import com.kronos.mutliplatform.pokedex.core.util.ExpectedIntents
import com.kronos.mutliplatform.pokedex.core.util.IAppInfo
import com.kronos.mutliplatform.pokedex.core.util.IChangeLang
import com.kronos.mutliplatform.pokedex.core.util.ICloseApp
import com.kronos.mutliplatform.pokedex.core.util.IExpectedIntents
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module{
    singleOf(::AppPreference).bind<IPreference>()
    singleOf(::ExpectedIntents).bind<IExpectedIntents>()
    singleOf(::AppInfo).bind<IAppInfo>()
    singleOf(::DevicePlatform).bind<Platform>()
    singleOf(::ExceptionHandlerImpl).bind<ExceptionHandler>()
    singleOf(::ChangeLang).bind<IChangeLang>()
    singleOf(::CloseAppImpl).bind<ICloseApp>()
    singleOf(::DummyLogger).bind<ILogManager>()
}