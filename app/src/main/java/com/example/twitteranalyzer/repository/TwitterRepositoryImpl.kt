package com.example.twitteranalyzer.repository

import com.example.twitteranalyzer.network.TwitterApi
import com.example.twitteranalyzer.network.TwitterList

class TwitterRepositoryImpl(private val api: TwitterApi) : TwitterRepository {

    override suspend fun getTweeters(userName: String): TwitterList {
        return api.getTwitters(userName)
    }
}