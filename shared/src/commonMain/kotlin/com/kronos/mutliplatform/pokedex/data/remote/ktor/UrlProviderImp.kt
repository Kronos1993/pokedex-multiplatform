package com.kronos.mutliplatform.pokedex.data.remote.ktor

class UrlProviderImp (
) : UrlProvider {
    override fun getPublicApiUrl(): String {
        return UrlConstants.API
    }

    override fun getPrivateApiUrl(): String {
        return UrlConstants.API
    }

    override fun getServerUrl(): String {
        return UrlConstants.API
    }

    override fun getImageUrl(type: ImageType, id: String): String {
        return when(type){
            ImageType.POKEMON -> "${UrlConstants.POKEMON_IMAGE_URL + id}.png"
            ImageType.ITEM -> "${UrlConstants.ITEM_IMAGE_URL + id}.png"

        }
    }

    override fun extractIdFromUrl(url: String): Int {
        return "/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }
            .toInt()
    }
}