package com.example.quoteapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quoteapp.models.QuotesList
import com.example.quoteapp.models.Result

@Dao
interface QuoteDAO {
    @Insert
    suspend fun addQuote(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<Result>
}