package com.kronos.mutliplatform.pokedex.core.util

import java.util.Locale

actual class ChangeLang : IChangeLang {

    override fun onLangChange(lang: String) {
        if (isCurrentLanguage(lang)) return

        val locale = when {
            lang == "not-set" || lang.isEmpty() -> getSystemLocale()
            else -> Locale(lang)
        }

        updateAppLocale(locale)
    }

    override fun getSystemLang(): String {
        return getSystemLocale().language.lowercase()
    }

    private fun isCurrentLanguage(targetLang: String): Boolean {
        val currentLocale = Locale.getDefault()
        return when {
            targetLang == "not-set" -> currentLocale == getSystemLocale()
            else -> currentLocale.language == targetLang
        }
    }

    private fun getSystemLocale(): Locale {
        return Locale.getDefault()
    }

    private fun updateAppLocale(locale: Locale) {
        Locale.setDefault(locale)
    }
}