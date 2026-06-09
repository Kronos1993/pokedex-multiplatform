package com.kronos.mutliplatform.pokedex.domain.model.pokemon

data class EncounterByGeneration(
    val generation: Int,
    val generationName: String,
    val versions: List<EncounterByVersion>
)