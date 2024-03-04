package com.example.quoteapp.api

import com.example.quoteapp.models.QuotesList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page: Int): Response<QuotesList>
}