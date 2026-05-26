package com.kronos.mutliplatform.pokedex.core.util

actual class AppInfo : IAppInfo {
    override fun getAppVersion(): String {
        return try {
            AppInfo::class.java.`package`?.implementationVersion ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}