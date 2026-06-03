package com.kronos.mutliplatform.pokedex.domain.model.pokedex

import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    var id: String = "",
    var name: String = "",
    var names: List<Name> = listOf(),
    var pokemons: List<PokemonDexEntry> = listOf(),
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