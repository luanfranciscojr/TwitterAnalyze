package com.example.twitteranalyzer

import com.example.twitteranalyzer.network.Include
import com.example.twitteranalyzer.network.Twitter
import com.example.twitteranalyzer.network.TwitterList
import com.example.twitteranalyzer.network.User
import com.example.twitteranalyzer.repository.TwitterRepository
import com.example.twitteranalyzer.twitter.TwitterListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

class FakeTwitterRepository: TwitterRepository {

    override suspend fun getTweeters(userName: String): TwitterList {
       return TwitterList(listOf(Twitter(1 ,"mock", 1),Twitter(2 ,"mock", 1)),Include(listOf(User("luan",1))))
    }
}

val fakeTwitterRepository =module() {
    factory<TwitterRepository> { FakeTwitterRepository() }
}
