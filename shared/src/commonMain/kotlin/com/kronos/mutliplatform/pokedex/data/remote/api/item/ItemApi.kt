package com.kronos.mutliplatform.pokedex.data.remote.api.item

class ItemApi {

    companion object {
        fun LIST_ITEMS(limit: Int, offset: Int) = "item?limit=$limit&offset=$offset"
        fun GET_ITEM(item: String) = "item/$item"
        fun LIST_ITEM_CATEGORIES(limit: Int, offset: Int) = "item-category?limit=$limit&offset=$offset"
        fun GET_ITEM_CATEGORY(itemCategory: String) = "item-category/$itemCategory"
    }
}

