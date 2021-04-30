package com.example.twitteranalyzer.twitter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twitteranalyzer.di.ApiStatus
import com.example.twitteranalyzer.network.TwitterModel
import com.example.twitteranalyzer.network.asTwitterModelList
import com.example.twitteranalyzer.repository.TwitterRepository
import kotlinx.coroutines.launch

class TwitterListViewModel(private val repository: TwitterRepository) : ViewModel() {

    var tweets = MutableLiveData<List<TwitterModel>>()
    val status = MutableLiveData<ApiStatus>(ApiStatus.LOADING)

    private val _navigateToSelectedTweet = MutableLiveData<TwitterModel?>()
    val navigateToSelectedProperty: MutableLiveData<TwitterModel?>
        get() = _navigateToSelectedTweet

    fun getTwitter(userName: String) {
        viewModelScope.launch {
            try {
                status.value = ApiStatus.LOADING
                val result = repository.getTweeters("from:$userName")
                tweets.value = result.asTwitterModelList()
                status.value = ApiStatus.DONE
            } catch (e: Exception) {
                tweets.value = ArrayList()
                status.value = ApiStatus.ERROR
            }

        }
    }

    fun onTweetClicked(twitterModel: TwitterModel) {
        _navigateToSelectedTweet.value = twitterModel
    }

    fun openTweetAnalyzerComplete() {
        _navigateToSelectedTweet.value = null
    }
}