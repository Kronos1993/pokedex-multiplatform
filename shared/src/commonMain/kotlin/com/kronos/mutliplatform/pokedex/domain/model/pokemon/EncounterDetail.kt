/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class EncounterDetail(
    var chance: Int = 0,
    var maxLevel:Int = 0,
    var minLevel:Int = 0,
    var method:NamedResourceApi = NamedResourceApi()
)
