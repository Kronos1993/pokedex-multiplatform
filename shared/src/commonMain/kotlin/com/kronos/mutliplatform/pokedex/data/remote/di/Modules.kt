package com.kronos.mutliplatform.pokedex.data.remote.di

import com.kronos.mutliplatform.pokedex.data.remote.datasources.ability.AbilityRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.ability.AbilityRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.berry.BerryRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.berry.BerryRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.egg_group.EggGroupRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.egg_group.EggGroupRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.evolution_chain.EvolutionChainRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.evolution_chain.EvolutionChainRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.item.ItemRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.item.ItemRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.move.MoveRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.move.MoveRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.nature.NatureRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.nature.NatureRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokedex.PokedexRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokedex.PokedexRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokemon.PokemonRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.pokemon.PokemonRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.datasources.species.SpecieRemoteDataSource
import com.kronos.mutliplatform.pokedex.data.remote.datasources.species.SpecieRemoteDataSourceImpl
import com.kronos.mutliplatform.pokedex.data.remote.ktor.KtorClientFactory
import com.kronos.mutliplatform.pokedex.data.remote.ktor.PrivateKtorClientFactoryImpl
import com.kronos.mutliplatform.pokedex.data.remote.ktor.PublicKtorClientFactoryImpl
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProvider
import com.kronos.mutliplatform.pokedex.data.remote.ktor.UrlProviderImp
import com.kronos.mutliplatform.pokedex.data.repository.ability.AbilityRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.berry.BerryRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.egg_group.EggGroupRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.evolution_chain.EvolutionChainRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.item.ItemRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.move.MoveRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.nature.NatureRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.pokedex.PokedexRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.pokemon.PokemonRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.specie.SpecieRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.data.repository.type.TypeRemoteRepositoryImpl
import com.kronos.mutliplatform.pokedex.domain.repository.AbilityRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.BerryRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.EggGroupRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.EvolutionChainRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.ItemRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.MoveRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.NatureRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.PokedexRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.PokemonRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.SpecieRemoteRepository
import com.kronos.mutliplatform.pokedex.domain.repository.TypeRemoteRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module


val commonRemoteModules = module {
    //ktor client
    single<KtorClientFactory>(named(KtorClientFactoryType.PUBLIC)) { PublicKtorClientFactoryImpl() }
    single<KtorClientFactory>(named(KtorClientFactoryType.PRIVATE)) { PrivateKtorClientFactoryImpl() }

    //datasources using a qualifier
    single {
        PokedexRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get()
        )
    }.bind<PokedexRemoteDataSource>()

    single {
        PokemonRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
            get()
        )
    }.bind<PokemonRemoteDataSource>()

    single {
        SpecieRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<SpecieRemoteDataSource>()

    single {
        AbilityRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<AbilityRemoteDataSource>()

    single {
        BerryRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<BerryRemoteDataSource>()

    single {
        EggGroupRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<EggGroupRemoteDataSource>()

    single {
        EvolutionChainRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<EvolutionChainRemoteDataSource>()

    single {
        ItemRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<ItemRemoteDataSource>()

    single {
        MoveRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<MoveRemoteDataSource>()

    single {
        NatureRemoteDataSourceImpl(
            get(),
            get(named(KtorClientFactoryType.PUBLIC)),
            get(),
        )
    }.bind<NatureRemoteDataSource>()

    //repositories
    singleOf(::PokemonRemoteRepositoryImpl).bind<PokemonRemoteRepository>()
    singleOf(::PokedexRemoteRepositoryImpl).bind<PokedexRemoteRepository>()
    singleOf(::AbilityRemoteRepositoryImpl).bind<AbilityRemoteRepository>()
    singleOf(::BerryRemoteRepositoryImpl).bind<BerryRemoteRepository>()
    singleOf(::EggGroupRemoteRepositoryImpl).bind<EggGroupRemoteRepository>()
    singleOf(::EvolutionChainRemoteRepositoryImpl).bind<EvolutionChainRemoteRepository>()
    singleOf(::ItemRemoteRepositoryImpl).bind<ItemRemoteRepository>()
    singleOf(::MoveRemoteRepositoryImpl).bind<MoveRemoteRepository>()
    singleOf(::NatureRemoteRepositoryImpl).bind<NatureRemoteRepository>()
    singleOf(::SpecieRemoteRepositoryImpl).bind<SpecieRemoteRepository>()
    singleOf(::TypeRemoteRepositoryImpl).bind<TypeRemoteRepository>()

    //url provider
    singleOf(::UrlProviderImp).bind<UrlProvider>()
}

enum class KtorClientFactoryType {
    PUBLIC,
    PRIVATE
}

expect val platformDataRemoteModules: Module