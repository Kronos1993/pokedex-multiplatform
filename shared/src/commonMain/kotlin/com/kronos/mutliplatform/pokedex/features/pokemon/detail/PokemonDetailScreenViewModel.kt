package com.kronos.mutliplatform.pokedex.features.pokemon.detail

import androidx.lifecycle.viewModelScope
import com.kronos.mutliplatform.pokedex.core.cache.ICache
import com.kronos.mutliplatform.pokedex.core.result.onError
import com.kronos.mutliplatform.pokedex.core.result.onSuccess
import com.kronos.mutliplatform.pokedex.core.viewmodel.ParentViewModel
import com.kronos.mutliplatform.pokedex.data.mapper.toEncountersByGeneration
import com.kronos.mutliplatform.pokedex.data.remote.ktor.ImageType
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.util.FullNetworkError
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionChain
import com.kronos.mutliplatform.pokedex.domain.model.game.Game
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.EncounterByGeneration
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.EvolutionChainRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.PokemonRemoteRepository
import com.kronos.mutliplatform.pokedex.features.pokemon.detail.domain.PokemonOtherForm
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
    private var appCache: ICache,
    var urlProvider: UrlProvider,
) : ParentViewModel() {

    private var _currentTab = MutableStateFlow(0)
    var currentTab = _currentTab.asStateFlow()

    private var _pokemon = MutableStateFlow(PokemonInfo())
    var pokemon: StateFlow<PokemonInfo> = _pokemon.asStateFlow()

    private val _pokemonStats = MutableStateFlow<List<Stat>>(emptyList())
    val pokemonStats = _pokemonStats.asStateFlow()

    private val _pokemonEvolutionChain = MutableStateFlow<EvolutionChain>(EvolutionChain())

    private val _pokemonEvolutionList = MutableStateFlow<List<ChainLink>>(emptyList())
    val pokemonEvolutionList = _pokemonEvolutionList.asStateFlow()

    private val _pokemonSpritesUrl = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val pokemonSpritesUrl = _pokemonSpritesUrl.asStateFlow()

    private val _pokemonOtherFormsUrl = MutableStateFlow<List<PokemonOtherForm>>(emptyList())
    val pokemonOtherFormsUrl = _pokemonOtherFormsUrl.asStateFlow()

    private val _pokemonGames = MutableStateFlow<List<Game>>(emptyList())
    val pokemonGames = _pokemonGames.asStateFlow()

    private val _pokemonEncounterList = MutableStateFlow<List<EncounterByGeneration>>(emptyList())
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

    fun postCurrentTab(tab: Int) {
        _currentTab.value = tab
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


        val pokemonOtherForms = mutableListOf<PokemonOtherForm>()
        pokemon.specieInfo?.varieties.orEmpty().forEach {
            if (it.pokemon.name.isNotEmpty() && pokemon.name != it.pokemon.name) {
                pokemonOtherForms.add(
                    PokemonOtherForm(
                        imgUrl = urlProvider.getImageUrl(
                            ImageType.POKEMON,
                            urlProvider.extractIdFromUrl(it.pokemon.url).toString()
                        ),
                        nameFormatted = it.pokemon.name.replace("-".toRegex(), " ").uppercase(),
                        name = it.pokemon.name,
                        url = it.pokemon.url
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

    }

    private fun postPokemonEncounters(list: List<EncounterByGeneration>) {
        _pokemonEncounterList.value = (list)
    }

    private fun postPokemonEvolutionChain(
        evolutionChain: EvolutionChain
    ) {
        _pokemonEvolutionChain.value = evolutionChain

        val evolutionList = evolutionChain.getEvolutionChain(
            pokemonName = pokemon.value.name,
            evoList = mutableListOf(evolutionChain.chain!!),
            chain = evolutionChain.chain!!
        )

        postPokemonEvolutionChainList(evolutionList)
    }

    private fun postPokemonEvolutionChainList(evolutionChainList: List<ChainLink>) {
        _pokemonEvolutionList.value = (evolutionChainList)
    }

    fun loadPokemonInfo(pokemon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = (true)

            pokemonRemoteRepository.getPokemonInfo(pokemon)
                .onSuccess {
                    _loading.value = (false)
                    postPokemon(it)
                    getPokemonEvolution(it)
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError) {
                        err["error"] = it.errorMessage
                    } else {
                        err["error"] = it.toString()
                    }
                    _message.value = (err)
                    _loading.value = (false)
                }
        }
    }

    fun getPokemonEncounters(pokemon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonRemoteRepository.getPokemonEncountersInfo(pokemon)
                .onSuccess {
                    postPokemonEncounters(it.toEncountersByGeneration() )
                }
                .onError {
                    val err = HashMap<String, String>()
                    if (it is FullNetworkError) {
                        err["error"] = it.errorMessage
                    } else {
                        err["error"] = it.toString()
                    }
                    _message.value = (err)
                }
        }
    }

    fun getPokemonEvolution(pokemonInfo: PokemonInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!pokemonInfo.specieInfo?.evolutionChain?.url.isNullOrEmpty()) {
                pokemonEvolutionChainRemoteRepository.getEvolutionChain(
                    urlProvider.extractIdFromUrl(pokemonInfo.specieInfo?.evolutionChain.let {
                        if (it != null && it.url.isNotEmpty())
                            it.url
                        else
                            "0"
                    })
                )
                    .onSuccess {
                        postPokemonEvolutionChain(it)
                    }
                    .onError {
                        val err = HashMap<String, String>()
                        if (it is FullNetworkError) {
                            err["error"] = it.errorMessage
                        } else {
                            err["error"] = it.toString()
                        }
                        _message.value = (err)
                    }

            }
        }
    }
}

