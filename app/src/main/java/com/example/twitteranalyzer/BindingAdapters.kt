package com.example.twitteranalyzer

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.twitteranalyzer.di.ApiStatus
import com.example.twitteranalyzer.network.AnalyzeSentiment
import com.example.twitteranalyzer.network.TwitterModel
import com.example.twitteranalyzer.twitter.TwitterAdapter

@BindingAdapter("listTweet")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<TwitterModel>?) {
    val adapter = recyclerView.adapter as TwitterAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(progressBar: ProgressBar, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            progressBar.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            progressBar.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            progressBar.visibility = View.GONE
        }
    }
}

@BindingAdapter("tweetSentiment")
fun bindTweetSentiment(imageView: ImageView, resourceSentiment: Int) {
        imageView.setImageResource(resourceSentiment)
}