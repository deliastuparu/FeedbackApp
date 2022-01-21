package com.pub.feedbackapp.network

import retrofit2.http.*

interface MainApi {
    @GET("random")
    suspend fun getQuotes(@Query("count") count: Int): QuotesResponse
}

