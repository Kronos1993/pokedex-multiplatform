package com.kronos.mutliplatform.pokedex.data.mapper

import com.kronos.mutliplatform.pokedex.data.remote.dto.AbilityDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.AbilityInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.BerryFlavorDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.BerryInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.ChainLinkDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.DamageRelationDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EffectEntryDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EggGroupInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EncounterDetailDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EncounterDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EvolutionChainDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EvolutionDetailDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.EvolutionTriggerDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.FlavorTextDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.FlavorTextEntryDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.GameIndexDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.ItemCategoryDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.ItemInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.MoveDetailDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.MoveInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.MoveListDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.NamedResourceApiDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.NatureDetailDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.PokedexDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.PokemonDexEntryDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.PokemonGeneraDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.PokemonInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.PokemonWithAbilityDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.ResponseListDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.SpecieInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.SpecieVarietiesDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.SpriteDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.StatDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.TypeDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.TypeInfoDto
import com.kronos.mutliplatform.pokedex.data.remote.dto.VersionDetailDto
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.domain.model.EffectEntry
import com.kronos.mutliplatform.pokedex.domain.model.FlavorText
import com.kronos.mutliplatform.pokedex.domain.model.Name
import com.kronos.mutliplatform.pokedex.domain.model.NamedResourceApi
import com.kronos.mutliplatform.pokedex.domain.model.ResponseList
import com.kronos.mutliplatform.pokedex.domain.model.ability.Ability
import com.kronos.mutliplatform.pokedex.domain.model.ability.AbilityInfo
import com.kronos.mutliplatform.pokedex.domain.model.ability.PokemonWithAbility
import com.kronos.mutliplatform.pokedex.domain.model.egg_group.EggGroupInfo
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.ChainLink
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionChain
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionDetail
import com.kronos.mutliplatform.pokedex.domain.model.evolution_chain.EvolutionTrigger
import com.kronos.mutliplatform.pokedex.domain.model.game.Game
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryFlavor
import com.kronos.mutliplatform.pokedex.domain.model.item.BerryInfo
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemCategory
import com.kronos.mutliplatform.pokedex.domain.model.item.ItemInfo
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveDetail
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveInfo
import com.kronos.mutliplatform.pokedex.domain.model.move.MoveList
import com.kronos.mutliplatform.pokedex.domain.model.nature.NatureDetail
import com.kronos.mutliplatform.pokedex.domain.model.pokedex.Pokedex
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.Encounter
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.EncounterDetail
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonDexEntry
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.PokemonInfo
import com.kronos.mutliplatform.pokedex.domain.model.pokemon.VersionDetail
import com.kronos.mutliplatform.pokedex.domain.model.specie.PokemonGenera
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieInfo
import com.kronos.mutliplatform.pokedex.domain.model.specie.SpecieVarieties
import com.kronos.mutliplatform.pokedex.domain.model.sprite.Sprite
import com.kronos.mutliplatform.pokedex.domain.model.stat.Stat
import com.kronos.mutliplatform.pokedex.domain.model.type.DamageRelation
import com.kronos.mutliplatform.pokedex.domain.model.type.Type
import com.kronos.mutliplatform.pokedex.domain.model.type.TypeInfo

fun AbilityDto.toAbility(): Ability =
    Ability(
        ability = ability.toNamedResource(),
        isHidden = isHidden,
    )


fun AbilityInfoDto.toAbilityInfo(): AbilityInfo =
    AbilityInfo(
        id = id,
        name = name,
        names = names.map { Name(it.name, it.language) },
        pokemon = pokemon.map { it.toPokemonWithAbility() },
        flavorText = flavorTextEntryEntries.map { it.toFlavorText() },
        effects = effectEntries.map { it.toEffectEntry() },
    )


fun PokemonWithAbilityDto.toPokemonWithAbility(): PokemonWithAbility =
    PokemonWithAbility(
        pokemon = pokemon.toNamedResource(),
        isHidden = isHidden,
    )

fun BerryInfoDto.toBerryInfo(): BerryInfo =
    BerryInfo(
        name = name,
        names = names.map { Name(it.name, it.language) },
        id = id,
        size = size,
        firmness = firmness.toNamedResource(),
        flavors = flavors.map { it.toBerryFlavor() },
        growthTime = growthTime,
        itemResource = itemResource.toNamedResource(),
        maxHarvest = maxHarvest,
        naturalGiftPower = naturalGiftPower,
        naturalGiftType = naturalGiftType.toNamedResource(),
        smoothness = smoothness,
        soilDryness = soilDryness
    )


fun BerryFlavorDto.toBerryFlavor(): BerryFlavor =
    BerryFlavor(
        flavor = flavor.toNamedResource(),
        potency = potency
    )

fun FlavorTextEntryDto.toFlavorText(): FlavorText =
    FlavorText(
        description = flavorText,
        language = language.name
    )

fun FlavorTextDto.toFlavorText(): FlavorText =
    FlavorText(
        description = flavorText,
        language = language.name
    )

fun EffectEntryDto.toEffectEntry(): EffectEntry =
    EffectEntry(
        effect = effect,
        shortEffect = shortEffect,
        language = language.name
    )

fun EggGroupInfoDto.toEggGroupInfo(): EggGroupInfo =
    EggGroupInfo(
        id = id,
        name = name,
        names = names.map { Name(it.name, it.language) },
        pokemonSpecies = pokemonSpecies.map { it.toNamedResource() }
    )


fun ChainLinkDto.toChainLink(): ChainLink =
    ChainLink(
        evolutionDetails = evolutionDetails?.let {
            it.map { it.toEvolutionDetail() }
        } ?: listOf(),
        evolvesTo = evolvesTo?.let {
            it.map { it.toChainLink() }
        } ?: listOf(),
        isBaby = isBaby,
        species = species?.toNamedResource() ?: NamedResourceApi()
    )

fun EvolutionChainDto.toEvolutionChain(): EvolutionChain =
    EvolutionChain(
        id = id,
        babyTriggerItem = babyFriggerItem?.toNamedResource() ?: NamedResourceApi(),
        chain = chain?.toChainLink(),
    )

fun EvolutionDetailDto.toEvolutionDetail(): EvolutionDetail =
    EvolutionDetail(
        trigger = trigger?.toNamedResource() ?: NamedResourceApi(),
        item = item?.toNamedResource() ?: NamedResourceApi(),
        gender = gender,
        heldItem = heldItem?.toNamedResource() ?: NamedResourceApi(),
        knownMove = knownMove?.toNamedResource() ?: NamedResourceApi(),
        knownMoveType = knownMoveType?.toNamedResource() ?: NamedResourceApi(),
        location = location?.toNamedResource() ?: NamedResourceApi(),
        minLevel = minLevel,
        minHappiness = minHappiness,
        minBeauty = minBeauty,
        minAffection = minAffection,
        partySpecies = partySpecies?.toNamedResource() ?: NamedResourceApi(),
        partyType = partyType?.toNamedResource() ?: NamedResourceApi(),
        relativePhysicalStats = relativePhysicalStats,
        timeOfDay = timeOfDay,
        tradeSpecies = tradeSpecies?.toNamedResource() ?: NamedResourceApi(),
        needsOverworldRain = needsOverworldRain,
        turnUpsideDown = turnUpsideDown
    )

fun EvolutionTriggerDto.toEvolutionTrigger(): EvolutionTrigger =
    EvolutionTrigger(
        id = id,
        name = name,
        pokemonSpecies = pokemonSpecies.map {
            it.toNamedResource()
        }
    )

fun GameIndexDto.toGame() = Game(
    name = version.name,
    url = version.url
)

fun ItemInfoDto.toItemInfo(): ItemInfo =
    ItemInfo(
        name = name,
        names = names.map { Name(it.name, it.language) },
        id = id,
        attributes = attributes.map { it.toNamedResource() },
        sprites = sprites.toSprite(),
        babyTriggerFor = babyTriggerFor,
        category = category.toNamedResource(),
        cost = cost,
        descriptions = descriptions.map { it.toFlavorText() },
        effectEntries = effectEntries.map { it.toEffectEntry() },
        flingEffect = flingEffect?.toNamedResource() ?: NamedResourceApi(),
        flingPower = flingPower,
        heldByPokemon = heldByPokemon.map { it.pokemon.toNamedResource() }
    )

fun ItemCategoryDto.toItemCategory(): ItemCategory =
    ItemCategory(
        id = id,
        name = name,
        items = items.map { it.toNamedResource() },
        pocket = pocket.toNamedResource()
    )

fun MoveDetailDto.toMoveDetail(): MoveDetail =
    MoveDetail(
        levelLearned = levelLearned,
        moveLearnMethod = moveLearnedMethodDto.name
    )

fun MoveInfoDto.toMoveInfo(): MoveInfo =
    MoveInfo(
        accuracy = accuracy?:0,
        power = power?:0,
        pp = pp?:0,
        moveName = moveName,
        names = names.map { Name(it.name, it.language) },
        moveCategory = moveCategory.name,
        priority = priority?:0,
        type = type.toNamedResource(),
        moveFlavorText = moveDescription.map {
            it.toFlavorText()
        },
        learnedBy = learnedBy.map {
            it.toNamedResource()
        },
        effects = effectEntries.map { it.toEffectEntry() },
        effectChance = effectChance,
    )

fun MoveListDto.toMoveList(): MoveList =
    MoveList(
        move = move.toNamedResource(),
        moveDetails = moveDetails.map {
            it.toMoveDetail()
        },
        order = moveDetails.let {
            if (it.isNotEmpty()) {
                it[0].levelLearned
            } else {
                0
            }
        }
    )

fun NatureDetailDto.toNatureDetail(): NatureDetail =
    NatureDetail(
        name = name,
        names = names.map { Name(it.name,it.language) },
        decreasedStat = decreasedStat.let { it?.name },
        increasedStat = increasedStat.let { it?.name },
        hatesFlavor = hatesFlavor.let { it?.name },
        likesFlavor = likesFlavor.let { it?.name },
    )

fun PokedexDto.toPokedex(urlProvider: UrlProvider): Pokedex =
    Pokedex(
        id = id,
        name = name,
        names = names.map { Name(it.name,it.language) },
        pokemons = pokemons.map {
            it.toPokemonDexEntry(urlProvider.extractIdFromUrl(it.pokemon.url))
        }

    )

fun EncounterDto.toEncounter(): Encounter =
    Encounter(
        location = location.toNamedResource(),
        versionDetails = versionDetails.map {
            it.toVersionDetail()
        }
    )

fun VersionDetailDto.toVersionDetail(): VersionDetail =
    VersionDetail(
        if (encounterDetails.isNotEmpty())
            encounterDetails[0].toEncounterDetail()
        else
            EncounterDetail(),
        maxChance,
        version.toNamedResource()
    )

fun EncounterDetailDto.toEncounterDetail(): EncounterDetail =
    EncounterDetail(
        chance,
        maxLevel,
        minLevel,
        method.toNamedResource()
    )

fun PokemonDexEntryDto.toPokemonDexEntry(pokemonId:Int): PokemonDexEntry =
    PokemonDexEntry(
        dexEntry = entry_number,
        pokemonId = pokemonId,
        pokemon = pokemon.toNamedResource()

    )

fun PokemonInfoDto.toPokemonInfo(): PokemonInfo =
    PokemonInfo(
        id = id,
        abilities = abilities.map {
            it.toAbility()
        },
        name = name,
        height = height,
        weight = weight,
        sprites = sprites.toSprite(),
        baseExperience = baseExperience?:0,
        types = types.map {
            it.toType()
        },
        stats = stats.map {
            it.toStat()
        },
        moves = moves.map {
            it.toMoveList()
        },
        specieInfo = SpecieInfo(),
        specie = species.toNamedResource()
    )

fun PokemonInfoDto.toPokemonInfo(specieInfo:SpecieInfo?): PokemonInfo =
    PokemonInfo(
        id = id,
        abilities = abilities.map {
            it.toAbility()
        },
        name = name,
        height = height,
        weight = weight,
        sprites = sprites.toSprite(),
        baseExperience = baseExperience?:0,
        types = types.map {
            it.toType()
        },
        stats = stats.map {
            it.toStat()
        },
        moves = moves.map {
            it.toMoveList()
        },
        specie = species.toNamedResource(),
        specieInfo = specieInfo?: SpecieInfo(),
        games = gameIndices.map {
            it.toGame()
        }
    )


fun NamedResourceApiDto.toNamedResource(): NamedResourceApi =
    NamedResourceApi(
        name = name,
        url = url
    )

fun <T, R> ResponseListDto<T>.toResponseList(mapper: (T) -> R): ResponseList<R> =
    ResponseList(
        count = count,
        next = next,
        results = results.map(mapper)
    )


fun SpecieInfoDto.toSpecieInfo(): SpecieInfo =
    SpecieInfo(
        name = name,
        names = names.map { Name(it.name,it.language) },
        baseHappiness = baseHappiness,
        captureRate = captureRate,
        genderRate = genderRate,
        hatchCounter = hatchCounter,
        evolutionChain = evolutionChain,
        evolvesFrom = evolvesFrom.let{
            if(evolvesFrom!=null)
                evolvesFrom!!.toNamedResource()
            else
                null
        },
        flavorText = description.map {
            it.toFlavorText()
        },
        growthRate = growthRate.toNamedResource(),
        habitat = habitat.let{
            if(habitat!=null)
                habitat!!.toNamedResource()
            else
                null
        },
        hasGenderDifferences = hasGenderDifferences,
        isBaby = isBaby,
        isLegendary = isLegendary,
        isMythical = isMythical,
        varieties = varieties.map {
            it.toSpecieVarieties()
        },
        eggGroup = eggGroups.map {
            it.toNamedResource()
        },
        genera = genera.map {
            it.toPokemonGenera()
        },
    )

fun SpecieVarietiesDto.toSpecieVarieties(): SpecieVarieties =
    SpecieVarieties(
        isDefault = is_default,
        pokemon = pokemon.toNamedResource(),
    )

fun PokemonGeneraDto.toPokemonGenera(): PokemonGenera =
    PokemonGenera(
        genus = genus,
        language = language.name,
    )

fun SpriteDto.toSprite(): Sprite =
    Sprite(
        default.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        backDefault.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        backFemale.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        backShiny.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        backShinyFemale.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        frontDefault.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        frontFemale.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        frontShiny.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        frontShinyFemale.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        otherSprites.home.frontHome.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
        otherSprites.home.frontHomeShiny.let {
            if(it.isNullOrEmpty())
                ""
            else
                it
        },
    )

fun StatDto.toStat(): Stat =
    Stat(
        baseStat = baseStat,
        statName = statDto.name,
        statEffort = effort
    )

fun TypeDto.toType(): Type =
    Type(
        slot = slot,
        name = type.name
    )

fun DamageRelationDto.toDamageRelation(): DamageRelation =
    DamageRelation(
        doubleDamageFrom = doubleDamageFrom.map { it.toNamedResource() },
        doubleDamageTo = doubleDamageTo.map { it.toNamedResource() },
        halfDamageFrom = halfDamageFrom.map { it.toNamedResource() },
        halfDamageTo = halfDamageTo.map { it.toNamedResource() },
        noDamageFrom = noDamageFrom.map { it.toNamedResource() },
        noDamageTo = noDamageTo.map { it.toNamedResource() },
    )

fun TypeInfoDto.toTypeInfo(): TypeInfo =
    TypeInfo(
        name = name,
        names = names.map { Name(it.name,it.language) },
        id = id,
        damageRelations = damageRelations.toDamageRelation(),
        moves = moves.map { it.toNamedResource() },
        pokemon = pokemon.map { it.toNamedResource() }
    )
