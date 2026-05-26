package com.kronos.mutliplatform.pokedex.core.util

import androidx.compose.runtime.Composable

actual class CloseAppImpl : ICloseApp {
    override fun closeApp() {
    }
}

@Composable
actual fun BackPressHandlerEffect(enabled: Boolean, onBack: () -> Unit) {
}