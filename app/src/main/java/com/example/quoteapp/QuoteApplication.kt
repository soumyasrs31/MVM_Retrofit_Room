package com.example.quoteapp

import android.app.Application
import com.example.quoteapp.api.QuoteService
import com.example.quoteapp.api.RetrofitHelper
import com.example.quoteapp.db.QuoteDatabase
import com.example.quoteapp.repository.QuoteRepository

class QuoteApplication: Application() {
    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }
    private fun initialize(){
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService,quoteDatabase,applicationContext)
    }
}