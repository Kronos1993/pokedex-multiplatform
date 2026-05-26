package com.kronos.mutliplatform.pokedex.data.remote.ktor

interface UrlProvider {
    fun getPublicApiUrl():String
    fun getPrivateApiUrl():String
    fun getServerUrl():String
    fun getImageUrl(type:ImageType,id:String):String

    fun extractIdFromUrl(url:String):Int
}

enum class ImageType{
    POKEMON,ITEM
}