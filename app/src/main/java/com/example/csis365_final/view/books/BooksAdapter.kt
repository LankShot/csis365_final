package com.example.csis365_final.view.books

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.Book
import com.example.csis365_final.view.characters.CharacterActivity

class BooksAdapter(private val books: List<Book>) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = books[position].name
        holder.tvName.setOnClickListener { view ->
            view as TextView
            val context = holder.itemView.context
            var bundle = bundleOf(
                "id" to books[position].id,
                "name" to books[position].name
            )
            val intent = Intent(context, BookActivity::class.java).apply{
                putExtra("bundle", bundle)
            }
            ContextCompat.startActivity(context, intent, bundle)
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
    }
}