package com.example.quoteapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quoteapp.api.QuoteService
import com.example.quoteapp.db.QuoteDatabase
import com.example.quoteapp.models.QuotesList
import com.example.quoteapp.utils.NetworkUtils

class QuoteRepository(private val quoteService: QuoteService, private val quoteDatabase: QuoteDatabase, private val context: Context) {

    private val quotesLiveData = MutableLiveData<QuotesList>()

    val quotes: LiveData<QuotesList>
        get() = quotesLiveData


    suspend fun getQuotes(page: Int){
        if(NetworkUtils().isOnline(context)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addQuote(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuotesList(1,1,1,quotes,1,1)
            quotesLiveData.postValue(quoteList)
        }

    }
}

