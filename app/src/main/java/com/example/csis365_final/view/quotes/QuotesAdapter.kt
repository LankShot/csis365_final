package com.example.csis365_final.view.quotes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.Quote
import com.example.csis365_final.view.characters.CharacterActivity

class QuotesAdapter(private val quotes: List<Quote>) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text =  quotes[position].character + " : " + quotes[position].dialog
        holder.tvName.text = text
        holder.tvName.setOnClickListener { view ->
            view as TextView
            val context = holder.itemView.context
            var bundle = bundleOf(
                "character" to quotes[position].character,
                "movie" to quotes[position].movie,
                "dialog" to quotes[position].dialog
            )
            val intent = Intent(context, QuoteActivity::class.java).apply{
                putExtra("bundle", bundle)
            }
            ContextCompat.startActivity(context, intent, bundle)
        }
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
    }
}