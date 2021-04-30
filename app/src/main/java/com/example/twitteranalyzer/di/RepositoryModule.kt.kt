package com.example.twitteranalyzer.di

import com.example.twitteranalyzer.network.NaturalLanguageApi
import com.example.twitteranalyzer.network.TwitterApi
import com.example.twitteranalyzer.repository.NaturalLanguageRepository
import com.example.twitteranalyzer.repository.NaturalLanguageRepositoryImpl
import com.example.twitteranalyzer.repository.TwitterRepository
import com.example.twitteranalyzer.repository.TwitterRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    fun provideTwitterRepository(api: TwitterApi): TwitterRepository {
        return TwitterRepositoryImpl(api)
    }

    fun providerNaturalLanguageRepository(api: NaturalLanguageApi): NaturalLanguageRepository {
        return NaturalLanguageRepositoryImpl(api)
    }

    single { provideTwitterRepository(get()) }

    single { providerNaturalLanguageRepository(get()) }

}