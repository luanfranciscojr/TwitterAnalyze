package com.example.twitteranalyzer.network

import retrofit2.http.GET
import retrofit2.http.Query

interface TwitterApi {

    @GET("search/recent?expansions=author_id&user.fields=name")
    suspend fun getTwitters(@Query("query") userName: String): TwitterList

}