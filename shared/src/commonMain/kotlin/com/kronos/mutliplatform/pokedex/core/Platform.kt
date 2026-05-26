package com.kronos.mutliplatform.pokedex.core

interface Platform {
    val platformType: PlatformType
    val deviceName: String
    val deviceId: String
}

enum class PlatformType {
    ANDROID,IOS,DESKTOP
}

expect class DevicePlatform: Platform