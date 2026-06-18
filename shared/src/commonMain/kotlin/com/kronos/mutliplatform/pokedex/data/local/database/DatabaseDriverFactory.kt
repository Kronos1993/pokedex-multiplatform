package com.kronos.mutliplatform.pokedex.data.local.database

import app.cash.sqldelight.db.SqlDriver

const val DATABASE_NAME = "pokedex.db"

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(factory: DatabaseDriverFactory): ApplicationDatabase =
    ApplicationDatabase(factory.createDriver())