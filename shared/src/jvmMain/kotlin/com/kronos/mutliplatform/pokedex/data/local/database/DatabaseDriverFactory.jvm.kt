package com.kronos.mutliplatform.pokedex.data.local.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val appDir = File(System.getProperty("user.home"), "Pokedex")
        if (!appDir.exists()) {
            appDir.mkdirs()
        }

        val dbFile = File(appDir, "pokedex.db")
        val isNewDatabase = !dbFile.exists()

        return JdbcSqliteDriver("jdbc:sqlite:${dbFile.absolutePath}").also {
            if (isNewDatabase) {
                ApplicationDatabase.Schema.create(it)
            }
        }
    }
}