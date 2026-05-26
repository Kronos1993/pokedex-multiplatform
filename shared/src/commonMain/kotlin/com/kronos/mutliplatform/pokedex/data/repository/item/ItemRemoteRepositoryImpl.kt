package com.kronos.mutliplatform.pokedex.data.repository.item

import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.data.remote.datasources.item.ItemRemoteDataSource
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemCategory
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemInfo
import com.kronos.mutliplatform.pokedex.domain.repository.ItemRemoteRepository

class ItemRemoteRepositoryImpl(
    private val itemRemoteDataSource: ItemRemoteDataSource
) : ItemRemoteRepository {
    override suspend fun listItem(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return itemRemoteDataSource.listItem(limit, offset)
    }

    override suspend fun getItem(item: String): Result<ItemInfo, Error> {
        return itemRemoteDataSource.getItem(item)
    }

    override suspend fun listItemCategories(
        limit: Int,
        offset: Int
    ): Result<ResponseList<NamedResourceApi>, Error> {
        return itemRemoteDataSource.listItemCategories(limit, offset)
    }

    override suspend fun getItemCategory(item: String): Result<ItemCategory, Error> {
        return itemRemoteDataSource.getItemCategory(item)
    }

}