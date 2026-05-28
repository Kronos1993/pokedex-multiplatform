package com.kronos.mutliplatform.pokedex.features.pokemon.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionChain
import com.kronos.mutliplatform.pokedex.domain.model.game.Game
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.EvolutionChainRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.PokemonRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailScreenViewModel(
    val pokemonRemoteRepository: PokemonRemoteRepository,
    private var pokemonEvolutionChainRemoteRepository: EvolutionChainRemoteRepository,
    private var abilityRemoteRepository: AbilityRemoteRepository,
    private var moveRemoteRepository: MoveRemoteRepository,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _pokemon = MutableStateFlow(PokemonInfo())
    var pokemon: StateFlow<PokemonInfo> = _pokemon.asStateFlow()

    private val _pokemonStats = MutableStateFlow<List<Stat>>(emptyList())
    val pokemonStats = _pokemonStats.asStateFlow()

    private val _pokemonEvolutionChain = MutableStateFlow<EvolutionChain>(EvolutionChain())

    private val _pokemonEvolutionList = MutableStateFlow<List<ChainLink>>(emptyList())
    val pokemonEvolutionList = _pokemonEvolutionList.asStateFlow()

    private val _pokemonSpritesUrl = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val pokemonSpritesUrl = _pokemonSpritesUrl.asStateFlow()

    private val _pokemonOtherFormsUrl = MutableStateFlow<List<Triple<String, String, String>>>(emptyList())
    val pokemonOtherFormsUrl = _pokemonOtherFormsUrl.asStateFlow()

    private val _pokemonGames = MutableStateFlow<List<Game>>(emptyList())
    val pokemonGames = _pokemonGames.asStateFlow()

    private val _pokemonEncounterList = MutableStateFlow<List<Encounter>>(emptyList())
    val pokemonEncounterList = _pokemonEncounterList.asStateFlow()

    var stringSpriteHome = ""
    var stringSpriteHomeShiny = ""
    var stringSpriteFront = ""
    var stringSpriteFemale = ""
    var stringSpriteFrontShiny = ""
    var stringSpriteFemaleShiny = ""

    fun initStrings(
        stringSpriteHome: String = "",
        stringSpriteHomeShiny: String = "",
        stringSpriteFront: String = "",
        stringSpriteFemale: String = "",
        stringSpriteFrontShiny: String = "",
        stringSpriteFemaleShiny: String = ""
    ) {
        this.stringSpriteHome = stringSpriteHome
        this.stringSpriteHomeShiny = stringSpriteHomeShiny
        this.stringSpriteFront = stringSpriteFront
        this.stringSpriteFemale = stringSpriteFemale
        this.stringSpriteFrontShiny = stringSpriteFrontShiny
        this.stringSpriteFemaleShiny = stringSpriteFemaleShiny
    }

    private fun postPokemon(pokemon: PokemonInfo) {
        val sprites = mutableListOf<Pair<String, String>>()

        fun addSprite(url: String, label: String) {
            if (url.isNotBlank()) {
                sprites.add(url to label)
            }
        }

        val s = pokemon.sprites

        // HOME
        addSprite(s.frontHome, stringSpriteHome)
        addSprite(s.frontHomeShiny, stringSpriteHomeShiny)

        // FRONT
        addSprite(s.frontDefault, stringSpriteFront)
        addSprite(s.frontShiny, stringSpriteFrontShiny)

        // FEMALE
        addSprite(s.frontFemale, stringSpriteFemale)
        addSprite(s.frontShinyFemale, stringSpriteFemaleShiny)

        if (s.frontHome.isBlank()) {
            addSprite(
                urlProvider.getImageUrl(ImageType.POKEMON, pokemon.id.toString()),
                stringSpriteHome
            )
        }

        _pokemonSpritesUrl.value = sprites


        val pokemonOtherForms = mutableListOf<Triple<String, String, String>>()
        pokemon.specieInfo?.varieties.orEmpty().forEach {
            if (it.pokemon.name.isNotEmpty() && pokemon.name != it.pokemon.name) {
                pokemonOtherForms.add(
                    Triple(
                        urlProvider.getImageUrl(ImageType.POKEMON, urlProvider.extractIdFromUrl(it.pokemon.url).toString()),
                        it.pokemon.name,
                        it.pokemon.name.replace("-".toRegex(), " ").uppercase()
                    )
                )
            }
        }
        _pokemonOtherFormsUrl.value = pokemonOtherForms

        val updatedSprites = pokemon.sprites.copy(
            frontHome = pokemon.sprites.frontHome.ifBlank {
                urlProvider.getImageUrl(
                    ImageType.POKEMON,
                    pokemon.id.toString()
                )
            }
        )

        val updatedPokemon = pokemon.copy(
            sprites = updatedSprites
        )

        _pokemon.value = updatedPokemon

        /*if (pokemonInfo.specieInfo.name.isNotEmpty()) {
            val genderPossibility = GenderPossibility()
            genderPossibility.getPossibilities(pokemonInfo.specieInfo.genderRate)
            pokemonGenderPossibility.set(genderPossibility)
            postSpecieInfo(pokemonInfo.specieInfo)

        } else {
            pokemonName.set(pokemonInfo.name)
            pokemonInfo.specieInfo = SpecieInfo()
            postPokemonEvolutionChain(EvolutionChain())
            postPokemonEvolutionChainList(listOf())
        }

        postPokemonInfo(pokemonInfo)
        postPokemonMoves(pokemonInfo.moves)
        groupMoves(pokemonInfo.moves)
        postPokemonStats(pokemonInfo.stats)
        postPokemonGames(pokemonInfo.games)

        val pokemonSprite = mutableListOf<Pair<String, String>>()
        pokemonInfo.sprites.frontHome.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.home)))
            }
        }
        pokemonInfo.sprites.frontHomeShiny.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.home_shiny)))
            }
        }
        pokemonInfo.sprites.frontDefault.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.front)))
            }
        }
        pokemonInfo.sprites.frontFemale.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.female)))
            }
        }
        pokemonInfo.sprites.frontShiny.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.front_shiny)))
            }
        }
        pokemonInfo.sprites.frontShinyFemale.let {
            if (it.isNotEmpty()) {
                pokemonSprite.add(Pair(it, context.getString(R.string.female_shiny)))
            }
        }
        postPokemonSprites(pokemonSprite)

        val pokemonOtherForms = mutableListOf<Pair<String, String>>()
        pokemonInfo.specieInfo.varieties.forEach {
            if (it.pokemon.name.isNotEmpty() && pokemonInfo.name != it.pokemon.name) {
                pokemonOtherForms.add(
                    Pair(
                        it.pokemon.url,
                        it.pokemon.name.replace("-".toRegex(), " ").uppercase()
                    )
                )
            }
        }
        postPokemonOtherForms(pokemonOtherForms)
        statsTotal.set(pokemonInfo.totalStat())
        loading.postValue(false)*/

    }

    fun loadPokemonInfo(pokemon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loading = (true)
            pokemonRemoteRepository.getPokemonInfo(pokemon)
                .onSuccess {
                    loading = (false)
                    postPokemon(it)
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError) {
                        err["error"] = it.errorMessage
                    } else {
                        err["error"] = it.toString()
                    }
                    message = (err)
                    loading = (false)
                }

        }
    }
}

