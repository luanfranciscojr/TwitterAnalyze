package com.example.twitteranalyzer.twitteranalyze

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twitteranalyzer.di.ApiStatus
import com.example.twitteranalyzer.network.AnalyzeSentiment
import com.example.twitteranalyzer.network.TwitterModel
import com.example.twitteranalyzer.repository.NaturalLanguageRepository
import kotlinx.coroutines.launch

class TwitterAnalyzeViewModel(var repository: NaturalLanguageRepository) : ViewModel() {

    var tweetSentiment = MutableLiveData<AnalyzeSentiment>()
    val status = MutableLiveData<ApiStatus>(ApiStatus.LOADING)

    fun getTweetSentiment(tweet: TwitterModel) {
        viewModelScope.launch {
            try {
                status.value = ApiStatus.LOADING
                tweetSentiment.value = repository.getTweetSentiment(tweet)
                status.value = ApiStatus.DONE
            } catch (e: Exception) {
                status.value = ApiStatus.ERROR
            }
        }
    }
}