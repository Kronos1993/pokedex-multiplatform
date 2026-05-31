package com.kronos.mutliplatform.pokedex

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kronos.mutliplatform.pokedex.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pokedex",
    ) {
        App()
    }
}