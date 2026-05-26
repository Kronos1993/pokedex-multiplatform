package com.kronos.mutliplatform.pokedex.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

actual class AppPreference : IPreference {
    override fun createPrefs(): DataStore<Preferences> {
        return createPrefs {
            File(System.getProperty("user.home"), DATA_STORE_FILE_NAME).absolutePath
        }
    }
}