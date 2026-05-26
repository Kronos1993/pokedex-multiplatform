package com.kronos.mutliplatform.pokedex.core

import java.io.File
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.UUID

actual class DevicePlatform : Platform {
    override val platformType = PlatformType.DESKTOP

    override val deviceName: String by lazy {
        val os = System.getProperty("os.name") ?: ""
        val host = try {
            InetAddress.getLocalHost().hostName
        } catch (e: Exception) {
            ""
        }
        "$host ($os)".trim()
    }

    override val deviceId: String by lazy {
        getMacAddress().takeIf { it.isNotEmpty() }
            ?: getPersistentUUID().toString()
    }

    private fun getMacAddress(): String {
        return try {
            NetworkInterface.getNetworkInterfaces()
                .toList()
                .firstOrNull { !it.isLoopback && it.hardwareAddress != null }
                ?.hardwareAddress
                ?.joinToString("") { String.format("%02X", it) }
                ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    private fun getPersistentUUID(): UUID {
        val file = File(System.getProperty("user.home"), ".device_uuid")
        return if (file.exists()) {
            UUID.fromString(file.readText().trim())
        } else {
            val newUUID = UUID.randomUUID()
            file.writeText(newUUID.toString())
            newUUID
        }
    }
}