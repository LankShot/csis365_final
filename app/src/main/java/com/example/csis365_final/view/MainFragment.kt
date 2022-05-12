package com.example.csis365_final.view

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.csis365_final.R
import com.example.csis365_final.view.books.BooksFragment
import com.example.csis365_final.view.characters.CharactersFragment
import com.example.csis365_final.view.quotes.QuotesFragment

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val btnBooks = view.findViewById<Button>(R.id.btn_books)
        val btnCharacters = view.findViewById<Button>(R.id.btn_characters)
        val btnQuotes = view.findViewById<Button>(R.id.btn_quotes)
        btnBooks.setOnClickListener {
            val fragment = BooksFragment.newInstance()
            OpenFragment(fragment)
        }
        btnCharacters.setOnClickListener {
            val fragment = CharactersFragment.newInstance()
            OpenFragment(fragment)
        }
        btnQuotes.setOnClickListener {
            val fragment = QuotesFragment.newInstance()
            OpenFragment(fragment)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        Log.i("asdf", "Main Fragment resumed")
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    fun OpenFragment(fragment: Fragment){
        val transaction = parentFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.frame_container, fragment, null)

        transaction.commit()
    }



}