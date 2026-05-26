package com.kronos.mutliplatform.pokedex.data.remote.datasources.item

import com.kronos.mutliplatform.pokedex.core.result.Result
import com.kronos.mutliplatform.pokedex.core.result.Error
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemCategory
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemInfo

interface ItemRemoteDataSource {
    suspend fun listItem(limit:Int = 20,offset:Int = 0): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getItem(item: String): Result<ItemInfo, Error>

    suspend fun listItemCategories(limit:Int,offset:Int): Result<ResponseList<NamedResourceApi>, Error>

    suspend fun getItemCategory(item: String): Result<ItemCategory, Error>

}