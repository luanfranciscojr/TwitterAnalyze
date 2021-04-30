package com.example.twitteranalyzer.repository

import com.example.twitteranalyzer.network.TwitterList

interface TwitterRepository {
    suspend fun getTweeters(userName: String): TwitterList
}