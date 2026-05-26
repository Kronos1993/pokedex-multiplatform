package com.kronos.mutliplatform.pokedex.core.util

import androidx.compose.runtime.Composable
import kotlin.system.exitProcess

actual class CloseAppImpl : ICloseApp {
    override fun closeApp() {
        exitProcess(0)
    }
}

@Composable
actual fun BackPressHandlerEffect(enabled: Boolean, onBack: () -> Unit) {
}