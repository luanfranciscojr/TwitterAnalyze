package com.example.twitteranalyzer.di

import com.example.twitteranalyzer.twitter.TwitterListViewModel
import com.example.twitteranalyzer.twitteranalyze.TwitterAnalyzeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build CountriesViewModel
    viewModel {
        TwitterListViewModel(repository = get())
    }

    viewModel {
        TwitterAnalyzeViewModel(repository = get())
    }

}