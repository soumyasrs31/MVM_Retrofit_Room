package com.example.quoteapp.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.quoteapp.R
import com.example.quoteapp.models.Result

class MyAdapter(val quotesList: List<Result>): Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.quote.text = quotesList[position].content
        holder.author.text = quotesList[position].author
    }

    class MyViewHolder(private val viewItem: View): ViewHolder(viewItem){
        val quote = itemView.findViewById<TextView>(R.id.quote)
        val author = itemView.findViewById<TextView>(R.id.author)
    }
}
