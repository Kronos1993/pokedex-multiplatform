package com.kronos.mutliplatform.pokedex.domain.model.pokemon

import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import kotlinx.serialization.Serializable

@Serializable
data class EncounterByVersion(
    val version: NamedResourceApi = NamedResourceApi(),
    val locations: List<LocationEncounter> = listOf()
)

@Serializable
data class LocationEncounter(
    val location: NamedResourceApi = NamedResourceApi(),
    val encounterDetail: EncounterDetail = EncounterDetail(),
    val maxChance: Int = 100
)