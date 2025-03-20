package com.aniruddha81.hiltretrofitnavigationmvvm.api

import com.aniruddha81.hiltretrofitnavigationmvvm.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("/v3/b/67daa27d8960c979a574ae01?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<Tweet>>

    @GET("/v3/b/67daa27d8960c979a574ae01?meta=false")
    @Headers("X-JSON-Path:tweats..category")
    suspend fun getCategories(): Response<List<String>>
}