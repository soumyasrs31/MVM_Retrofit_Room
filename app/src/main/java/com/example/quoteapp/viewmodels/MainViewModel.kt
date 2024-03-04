package com.example.quoteapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapp.api.QuoteService
import com.example.quoteapp.models.QuotesList
import com.example.quoteapp.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository): ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }

    }
    val quotes : LiveData<QuotesList>
        get() = repository.quotes

}