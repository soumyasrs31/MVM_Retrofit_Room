package com.example.quoteapp

import android.app.Application
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapp.api.QuoteService
import com.example.quoteapp.api.RetrofitHelper
import com.example.quoteapp.repository.QuoteRepository
import com.example.quoteapp.screens.MyAdapter
import com.example.quoteapp.viewmodels.MainViewModel
import com.example.quoteapp.viewmodels.MainViewModelFactory

private lateinit var mainViewModel: MainViewModel
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        val recycleView = findViewById<RecyclerView>(R.id.quotesList)
        recycleView.layoutManager = LinearLayoutManager(this)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("soumya","${it.results.size}")
            recycleView.adapter = MyAdapter(it.results)

        })
    }
}