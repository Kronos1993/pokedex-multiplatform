package com.kronos.mutliplatform.pokedex

import android.app.Application
import android.util.Log
import com.kronos.mutliplatform.pokedex.core.exception.ExceptionHandler
import com.kronos.mutliplatform.pokedex.di.initKoin
import java.util.Date
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext

const val TAG = "PokedexApp"


class PokedexApplication : Application() {

    private val exceptionHandler: ExceptionHandler by inject()

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PokedexApplication)
        }

        try {
            exceptionHandler.init()
            Log.d(TAG, "App open on ${Date().toLocaleString()}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}