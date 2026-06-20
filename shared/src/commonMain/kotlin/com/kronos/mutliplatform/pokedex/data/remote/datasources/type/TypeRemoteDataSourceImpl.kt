package com.kronos.mutliplatform.pokedex.data.remote.datasources.type

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.local.database.ApiCache
import com.kronos.mutliplatform.pokedex.data.local.datasource.api_cache.ApiCacheLocalDataSource
import com.kronos.mutliplatform.pokedex.data.mapper.toNamedResource
import com.kronos.mutliplatform.pokedex.data.mapper.toResponseList
import com.kronos.mutliplatform.pokedex.data.mapper.toTypeInfo
import com.kronos.mutliplatform.pokedex.data.remote.api.type.TypeApi
import com.kronos.mutliplatform.pokedex.data.remote.dto.NamedResourceApiDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.ResponseListDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.TypeInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.ktor.KtorClientFactory
import com.kronos.mutliplatform.pokedex.data.remote.ktor.KtorEngineFactory
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.NetworkError
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlin.time.Clock

class TypeRemoteDataSourceImpl(
    private val urlProvider: UrlProvider,
    private val httpClient: KtorClientFactory,
    private val httpEngine: KtorEngineFactory,
    private val apiCache: ApiCacheLocalDataSource
) : TypeRemoteDataSource {


    override suspend fun listType(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        val url = urlProvider.getPublicApiUrl() + TypeApi.LIST(limit, offset)

        val cached = apiCache.getByUrl(url)
        if (cached != null) {
            return try {
                val json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    allowSpecialFloatingPointValues = true
                }
                val list =
                    json.decodeFromString<ResponseListDto<NamedResourceApiDto>>(cached.response)
                Result.Success(list.toResponseList { it.toNamedResource() })
            } catch (e: Exception) {
                e.printStackTrace()
                fetchTypeListFromNetwork(url)
            }
        }

        return fetchTypeListFromNetwork(url)
    }

    private suspend fun fetchTypeListFromNetwork(url: String): Result<ResponseList<NamedResourceApi>, Error> {
        val response =
            try {
                httpClient.createKtorClient(httpEngine).get(url)
            } catch (e: UnresolvedAddressException) {
                e.printStackTrace()
                return Result.Error(
                    FullNetworkError(
                        NetworkError.NO_INTERNET,
                        "No internet connection: ${e.message} - $url",
                        0
                    )
                )
            } catch (e: SerializationException) {
                e.printStackTrace()
                return Result.Error(
                    FullNetworkError(
                        NetworkError.NO_INTERNET,
                        "No internet connection: ${e.message} - $url",
                        0
                    )
                )
            } catch (e: SocketTimeoutException) {
                e.printStackTrace()
                return Result.Error(
                    FullNetworkError(
                        NetworkError.NO_INTERNET,
                        "No internet connection: ${e.message} - $url",
                        0
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
                return Result.Error(
                    FullNetworkError(
                        NetworkError.NO_INTERNET,
                        "No internet connection: ${e.message} - $url",
                        0
                    )
                )
            }

        return when (response.status.value) {
            in 200..299 -> {
                val result: String = response.body<String>()
                if (result.isNotEmpty()) {
                    try {
                        val json = Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                            allowSpecialFloatingPointValues = true
                        }
                        val list =
                            json.decodeFromString<ResponseListDto<NamedResourceApiDto>>(result)

                        apiCache.insertOrUpdate(
                            ApiCache(
                                url = url,
                                response = result,
                                timestamp = Clock.System.now().toEpochMilliseconds()
                            )
                        )

                        Result.Success(list.toResponseList { it.toNamedResource() })
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Result.Error(
                            FullNetworkError(
                                NetworkError.SERIALIZATION,
                                "Serialization error",
                                0
                            )
                        )
                    }
                } else {
                    Result.Error(
                        FullNetworkError(
                            NetworkError.SERIALIZATION,
                            "Serialization error",
                            0
                        )
                    )
                }
            }

            400 -> {
                val result: String = response.body<String>()
                if (result.isNotEmpty()) {
                    try {
                        Result.Error(
                            FullNetworkError(
                                NetworkError.SERIALIZATION,
                                NetworkError.SERIALIZATION.name,
                                409
                            )
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Result.Error(
                            FullNetworkError(
                                NetworkError.SERIALIZATION,
                                "Serialization error",
                                0
                            )
                        )
                    }
                } else {
                    Result.Error(
                        FullNetworkError(
                            NetworkError.SERIALIZATION,
                            "Serialization error",
                            0
                        )
                    )
                }
            }

            401 -> Result.Error(FullNetworkError(NetworkError.UNAUTHORIZED, "UNAUTHORIZED", 401))
            409 -> Result.Error(FullNetworkError(NetworkError.CONFLICT, "CONFLICT", 409))
            408 -> Result.Error(FullNetworkError(NetworkError.REQUEST_TIMEOUT, "CONFLICT", 408))
            413 -> Result.Error(
                FullNetworkError(
                    NetworkError.PAYLOAD_TOO_LARGE,
                    "PAYLOAD TOO LARGE",
                    413
                )
            )

            in 500..599 -> Result.Error(
                FullNetworkError(NetworkError.SERVER_ERROR, "SERVER ERROR", response.status.value)
            )

            else -> Result.Error(
                FullNetworkError(
                    NetworkError.UNKNOWN,
                    "UNKNOWN",
                    response.status.value
                )
            )
        }
    }

    override suspend fun getTypeInfo(type: String): Result<TypeInfo, Error> {
        val url = urlProvider.getPublicApiUrl() + TypeApi.GET_TYPE(type)

        val cached = apiCache.getByUrl(url)
        if (cached != null) {
            return try {
                val json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    allowSpecialFloatingPointValues = true
                }
                Result.Success(json.decodeFromString<TypeInfoDto>(cached.response).toTypeInfo())
            } catch (e: Exception) {
                e.printStackTrace()
                fetchTypeInfoFromNetwork(url)
            }
        }

        return fetchTypeInfoFromNetwork(url)
    }

    private suspend fun fetchTypeInfoFromNetwork(url: String): Result<TypeInfo, Error> {
        val response = try {
            httpClient.createKtorClient(httpEngine).get(url)
        } catch (e: UnresolvedAddressException) {
            e.printStackTrace()
            return Result.Error(FullNetworkError(NetworkError.NO_INTERNET, e.message ?: "", 0))
        } catch (e: SerializationException) {
            e.printStackTrace()
            return Result.Error(FullNetworkError(NetworkError.NO_INTERNET, e.message ?: "", 0))
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            return Result.Error(FullNetworkError(NetworkError.NO_INTERNET, e.message ?: "", 0))
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(FullNetworkError(NetworkError.NO_INTERNET, e.message ?: "", 0))
        }

        return when (response.status.value) {
            in 200..299 -> {
                val result: String = response.body<String>()
                if (result.isNotEmpty()) {
                    try {
                        val json = Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                            allowSpecialFloatingPointValues = true
                        }
                        val dto = json.decodeFromString<TypeInfoDto>(result)

                        apiCache.insertOrUpdate(
                            ApiCache(
                                url = url,
                                response = result,
                                timestamp = Clock.System.now().toEpochMilliseconds()
                            )
                        )

                        Result.Success(dto.toTypeInfo())
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Result.Error(
                            FullNetworkError(
                                NetworkError.SERIALIZATION,
                                "Serialization error",
                                0
                            )
                        )
                    }
                } else {
                    Result.Error(
                        FullNetworkError(
                            NetworkError.SERIALIZATION,
                            "Serialization error",
                            0
                        )
                    )
                }
            }

            401 -> Result.Error(FullNetworkError(NetworkError.UNAUTHORIZED, "UNAUTHORIZED", 401))
            408 -> Result.Error(
                FullNetworkError(
                    NetworkError.REQUEST_TIMEOUT,
                    "REQUEST_TIMEOUT",
                    408
                )
            )

            409 -> Result.Error(FullNetworkError(NetworkError.CONFLICT, "CONFLICT", 409))
            413 -> Result.Error(
                FullNetworkError(
                    NetworkError.PAYLOAD_TOO_LARGE,
                    "PAYLOAD TOO LARGE",
                    413
                )
            )

            in 500..599 -> Result.Error(
                FullNetworkError(
                    NetworkError.SERVER_ERROR,
                    "SERVER ERROR",
                    response.status.value
                )
            )

            else -> Result.Error(
                FullNetworkError(
                    NetworkError.UNKNOWN,
                    "UNKNOWN",
                    response.status.value
                )
            )
        }
    }
}
