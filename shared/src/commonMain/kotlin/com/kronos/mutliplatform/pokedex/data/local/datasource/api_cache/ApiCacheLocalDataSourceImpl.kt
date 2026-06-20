package com.kronos.mutliplatform.pokedex.data.local.datasource.api_cache

import com.kronos.mutliplatform.pokedex.data.local.database.ApiCache
import com.kronos.mutliplatform.pokedex.data.local.database.ApplicationDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days


class ApiCacheLocalDatasourceImpl(
    private val db: ApplicationDatabase
) : ApiCacheLocalDataSource {

    private val queries = db.apiCacheQueries
    private val ttlMs = 7.days.inWholeMilliseconds

    override suspend fun getByUrl(url: String): ApiCache? =
        withContext(Dispatchers.IO) {
            try {
                val row = queries.getByUrl(url).executeAsOneOrNull() ?: return@withContext null
                val age = Clock.System.now().toEpochMilliseconds() - row.timestamp
                if (age > ttlMs) {
                    queries.deleteByUrl(url)
                    null
                } else
                    ApiCache(url = row.url, response = row.response, timestamp = row.timestamp)
            } catch (ex: Exception) {
                ex.printStackTrace()
                null
            }
        }

    override suspend fun insertOrUpdate(entity: ApiCache): ApiCache? =
        withContext(Dispatchers.IO) {
            try {
                queries.upsert(
                    url = entity.url,
                    response = entity.response,
                    timestamp = entity.timestamp
                )
                val row = queries.getByUrl(entity.url).executeAsOneOrNull()
                row?.let {
                    ApiCache(
                        url = it.url,
                        response = it.response,
                        timestamp = it.timestamp
                    )
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                null
            }
        }

    override suspend fun deleteExpired(expiry: Long) {
        withContext(Dispatchers.IO) {
            try {
                val cutoff = Clock.System.now().toEpochMilliseconds() - ttlMs
                queries.deleteExpired(cutoff)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}