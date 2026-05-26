/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetail(
    var encounterDetail: EncounterDetail = EncounterDetail(),
    var maxChance:Int = 100,
    var version: NamedResourceApi = NamedResourceApi()
)
