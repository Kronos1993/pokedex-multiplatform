package com.kronos.mutliplatform.pokedex.core.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
actual fun ConfigureSystemBars(darkTheme: Boolean) {
    val view = LocalView.current

    SideEffect {

        val window = (view.context as Activity).window

        window.statusBarColor = android.graphics.Color.TRANSPARENT

        WindowInsetsControllerCompat(window, view).apply {
            isAppearanceLightStatusBars = !darkTheme
        }
    }
}