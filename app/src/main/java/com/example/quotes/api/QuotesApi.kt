package com.example.quotes.api

import com.example.quotes.quotes_list.domain.models.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<Quotes>
}