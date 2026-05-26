package com.kronos.mutliplatform.pokedex.core.util

interface IChangeLang {
    fun onLangChange(lang: String)
    fun getSystemLang(): String
}
