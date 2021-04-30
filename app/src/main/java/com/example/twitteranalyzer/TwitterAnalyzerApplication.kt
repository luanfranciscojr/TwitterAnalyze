package com.example.twitteranalyzer

import android.app.Application
import com.example.twitteranalyzer.di.apiModule
import com.example.twitteranalyzer.di.networkModule
import com.example.twitteranalyzer.di.repositoryModule
import com.example.twitteranalyzer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TwitterAnalyzerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TwitterAnalyzerApplication)
            modules(
                    listOf(
                            apiModule,
                            networkModule,
                            viewModelModule,
                            repositoryModule,
                    )
            )
        }
    }
}