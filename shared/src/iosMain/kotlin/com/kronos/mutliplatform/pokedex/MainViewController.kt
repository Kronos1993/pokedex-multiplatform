package com.kronos.mutliplatform.pokedex

import androidx.compose.ui.window.ComposeUIViewController
import com.kronos.mutliplatform.pokedex.di.initKoin


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin ()
    }
) { App() }