package com.example.csis365_final.view.characters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.csis365_final.R
import com.example.csis365_final.dto.Characters

class CharactersAdapter(
    private val characters: List<com.example.csis365_final.dto.Character>
    ) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = characters[position].name
        holder.tvName.setOnClickListener { view ->
            view as TextView
            val context = holder.itemView.context
            var charBundle = bundleOf(
                "height" to characters[position].height,
                "race" to characters[position].race,
                "gender" to characters[position].gender,
                "birth" to characters[position].birth,
                "spouse" to characters[position].spouse,
                "death" to characters[position].death,
                "realm" to characters[position].realm,
                "hair" to characters[position].hair,
                "name" to characters[position].name,
                "wikiUrl" to characters[position].wikiUrl
            )
            val intent = Intent(context, CharacterActivity::class.java).apply{
                putExtra("bundle", charBundle)
            }
            startActivity(context, intent, charBundle)
        }

    }

    override fun getItemCount(): Int {
        return characters.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
    }

}