package com.kronos.mutliplatform.pokedex.data.mapper

object VersionGenerationMapper {

    private val versionToGeneration: Map<String, Int> = mapOf(
        // Gen 1
        "red"               to 1,
        "blue"              to 1,
        "green-japan"       to 1,
        "red-japan"         to 1,
        "yellow"            to 1,
        "stadium"           to 1,
        // Gen 2
        "gold"              to 2,
        "silver"            to 2,
        "crystal"           to 2,
        "stadium-2"         to 2,
        // Gen 3
        "ruby"              to 3,
        "sapphire"          to 3,
        "firered"           to 3,
        "leafgreen"         to 3,
        "emerald"           to 3,
        "colosseum"         to 3,
        "xd"                to 3,
        // Gen 4
        "diamond"           to 4,
        "pearl"             to 4,
        "platinum"          to 4,
        "heartgold"         to 4,
        "soulsilver"        to 4,
        // Gen 5
        "black"             to 5,
        "white"             to 5,
        "black-2"           to 5,
        "white-2"           to 5,
        // Gen 6
        "x"                 to 6,
        "y"                 to 6,
        "omega-ruby"        to 6,
        "alpha-sapphire"    to 6,
        // Gen 7
        "sun"               to 7,
        "moon"              to 7,
        "ultra-sun"         to 7,
        "ultra-moon"        to 7,
        "lets-go-pikachu"   to 7,
        "lets-go-eevee"     to 7,
        // Gen 8
        "sword"             to 8,
        "shield"            to 8,
        "brilliant-diamond" to 8,
        "shining-pearl"     to 8,
        "legends-arceus"    to 8,
        // Gen 9
        "scarlet"           to 9,
        "violet"            to 9,
        "the-teal-mask"     to 9,
        "the-indigo-disk"   to 9,
    )

    private val generationNames: Map<Int, String> = mapOf(
        1 to "Generation I",
        2 to "Generation II",
        3 to "Generation III",
        4 to "Generation IV",
        5 to "Generation V",
        6 to "Generation VI",
        7 to "Generation VII",
        8 to "Generation VIII",
        9 to "Generation IX",
    )

    private val versionOrder: Map<String, Int> = mapOf(
        // Gen 1
        "red"               to 0,
        "blue"              to 1,
        "green-japan"       to 2,
        "red-japan"         to 3,
        "yellow"            to 4,
        "stadium"           to 5,
        // Gen 2
        "gold"              to 0,
        "silver"            to 1,
        "crystal"           to 2,
        "stadium-2"         to 3,
        // Gen 3
        "ruby"              to 0,
        "sapphire"          to 1,
        "firered"           to 2,
        "leafgreen"         to 3,
        "emerald"           to 4,
        "colosseum"         to 5,
        "xd"                to 6,
        // Gen 4
        "diamond"           to 0,
        "pearl"             to 1,
        "platinum"          to 2,
        "heartgold"         to 3,
        "soulsilver"        to 4,
        // Gen 5
        "black"             to 0,
        "white"             to 1,
        "black-2"           to 2,
        "white-2"           to 3,
        // Gen 6
        "x"                 to 0,
        "y"                 to 1,
        "omega-ruby"        to 2,
        "alpha-sapphire"    to 3,
        // Gen 7
        "sun"               to 0,
        "moon"              to 1,
        "ultra-sun"         to 2,
        "ultra-moon"        to 3,
        "lets-go-pikachu"   to 4,
        "lets-go-eevee"     to 5,
        // Gen 8
        "sword"             to 0,
        "shield"            to 1,
        "brilliant-diamond" to 2,
        "shining-pearl"     to 3,
        "legends-arceus"    to 4,
        // Gen 9
        "scarlet"           to 0,
        "violet"            to 1,
        "the-teal-mask"     to 2,
        "the-indigo-disk"   to 3,
    )

    fun getGeneration(versionName: String): Int =
        versionToGeneration[versionName] ?: 99

    fun getGenerationDisplayName(generation: Int): String =
        generationNames[generation] ?: "Generation $generation"

    fun getVersionOrder(versionName: String): Int =
        versionOrder[versionName] ?: 99
}