package com.kronos.mutliplatform.pokedex.data.local.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver("jdbc:sqlite:$DATABASE_NAME").also {
            ApplicationDatabase.Schema.create(it)
        }
}