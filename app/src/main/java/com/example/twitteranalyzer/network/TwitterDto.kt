package com.example.twitteranalyzer.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class TwitterList(
        @Json(name = "data") val data: List<Twitter>,
        @Json(name = "includes") val includes: Include

)

@JsonClass(generateAdapter = true)
data class Twitter(
        @Json(name = "id") val id: Long,
        @Json(name = "text") val text: String,
        @Json(name = "author_id") val authorId: Long
)

@JsonClass(generateAdapter = true)
data class Include(
        @Json(name = "users") val user: List<User>
)

@JsonClass(generateAdapter = true)
data class User(
        @Json(name = "name") val name: String,
        val id: Long
)

@Parcelize
data class TwitterModel(val id: Long, val text: String, val userName: String?) : Parcelable


fun TwitterList.asTwitterModelList(): List<TwitterModel> =
        data.map { v ->
            TwitterModel(
                    id = v.id,
                    text = v.text,
                    userName = includes.user.find { user -> user.id == v.authorId }?.name
            )
        }
