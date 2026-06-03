/*
 * Kronos Tech. Copyright (c) 2023.
 *
 */

package com.kronos.mutliplatform.pokedex.domain.model.game

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val names: List<Name> = listOf(),
    val versionGroup: NamedResourceApi = NamedResourceApi(),
) {

    fun getName(language: String): String {
        return names
            .firstOrNull { it.language.name == language }
            ?.name
            ?: names
                .firstOrNull { it.language.name == "en" }
                ?.name
            ?: names
                .firstOrNull()
                ?.name
            ?: name
    }
}
