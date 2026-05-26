/*
 * Kronos Tech. Copyright (c) 2024.
 *
 */

package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class Encounter (
    var location:NamedResourceApi = NamedResourceApi(),
    var versionDetails:List<VersionDetail> = listOf(),
)