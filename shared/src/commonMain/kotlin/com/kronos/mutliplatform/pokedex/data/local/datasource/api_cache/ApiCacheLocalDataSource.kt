package com.kronos.mutliplatform.pokedex.data.local.datasource.api_cache

import com.kronos.mutliplatform.pokedex.data.local.database.ApiCache


interface ApiCacheLocalDataSource {

    suspend fun getByUrl(url: String): ApiCache?

    suspend fun insertOrUpdate(entity: ApiCache): ApiCache?

    suspend fun deleteExpired(expiry: Long)

}