package com.kronos.mutliplatform.pokedex.core.util

import java.awt.Desktop
import java.net.URI

actual class ExpectedIntents : IExpectedIntents {
    override fun openBrowser(url: String) {
        try {
            Desktop.getDesktop().browse(URI(url))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun makeCall(phone: String) {
        // No aplica en desktop
    }

    override fun sendEmail(email: String) {
        if (email.isBlank()) return
        try {
            Desktop.getDesktop().mail(URI("mailto:$email"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}