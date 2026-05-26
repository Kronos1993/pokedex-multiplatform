package com.kronos.mutliplatform.pokedex.core.util

actual class AppInfo : IAppInfo {
    override fun getAppVersion(): String {
        return "1.0"
    }
}