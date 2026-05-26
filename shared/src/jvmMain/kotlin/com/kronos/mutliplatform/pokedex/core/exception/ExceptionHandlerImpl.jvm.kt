package com.kronos.mutliplatform.pokedex.core.exception

actual class ExceptionHandlerImpl : ExceptionHandler, Thread.UncaughtExceptionHandler {
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null

    override fun init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        println("uncaughtException on thread ${t.name}: ${e.message}")
        e.printStackTrace()
    }
}