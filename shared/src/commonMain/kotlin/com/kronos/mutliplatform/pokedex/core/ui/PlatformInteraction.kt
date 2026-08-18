package com.kronos.mutliplatform.pokedex.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kronos.mutliplatform.pokedex.core.Platform
import com.kronos.mutliplatform.pokedex.core.PlatformType
import org.koin.compose.koinInject

fun isDesktop(platform: Platform): Boolean = platform.platformType == PlatformType.DESKTOP

@Composable
fun rememberIsDesktop(): Boolean {
    val platform = koinInject<Platform>()
    return remember(platform) { isDesktop(platform) }
}