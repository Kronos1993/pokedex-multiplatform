package com.kronos.mutliplatform.pokedex.core.exception

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import platform.Foundation.NSSetUncaughtExceptionHandler

@OptIn(ExperimentalForeignApi::class)
actual class ExceptionHandlerImpl : ExceptionHandler {
    override fun init() {
        NSSetUncaughtExceptionHandler(staticCFunction { exception ->
            exception?.reason?.let { println("uncaughtException: $it") }
            exception?.callStackSymbols?.forEach { println(it) }
        })
    }
}