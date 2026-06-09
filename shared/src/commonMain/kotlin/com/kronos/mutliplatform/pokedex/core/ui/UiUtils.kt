package com.kronos.mutliplatform.pokedex.core.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource
import pokedex.shared.generated.resources.Res
import pokedex.shared.generated.resources.ic_app_icon

@Composable
expect fun ConfigureSystemBars(
    darkTheme: Boolean
)


@Composable
fun appIconPainter() = painterResource(Res.drawable.ic_app_icon)
