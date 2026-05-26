package com.kronos.mutliplatform.pokedex.core.util

interface IAppInfo{
    fun getAppVersion():String
}

expect class AppInfo: IAppInfo