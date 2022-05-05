package com.example.csis365_final.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.csis365_final.R
import com.example.csis365_final.service.TheOneService
import com.example.csis365_final.view.books.BooksFragment
import com.example.csis365_final.view.characters.CharactersFragment
import com.example.csis365_final.view.quotes.QuotesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var textMain : TextView
    lateinit var fragmentContainer: FrameLayout
    lateinit var bottomBar: BottomNavigationView

    lateinit var btnBooks : Button
    lateinit var btnCharacters: Button
    lateinit var btnQuotes : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textMain = findViewById(R.id.text_main)
        val service = TheOneService()

        btnBooks = findViewById(R.id.btn_books)
        btnCharacters = findViewById(R.id.btn_characters)
        btnQuotes = findViewById(R.id.btn_quotes)

        btnBooks.setOnClickListener {
            val fragment = BooksFragment.newInstance()
            openFragment(fragment)
        }

        btnCharacters.setOnClickListener {
            val fragment = CharactersFragment.newInstance()
            openFragment(fragment)
        }

        btnQuotes.setOnClickListener {
            val fragment = QuotesFragment.newInstance()
            openFragment(fragment)
        }



    }

    private fun setupNavBar() {
        bottomBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                // This first case will prevent us from opening a page if it's already selected
                bottomBar.selectedItemId -> true

                R.id.action_books -> openBooksPage()
                R.id.action_characters -> openCharactersPage()
                R.id.action_quotes -> openQuotesPage()
                else -> throw IllegalStateException("Unknown action id, cannot open any fragment")
            }
            true
        }

        openMainPage()
    }


    private fun openMainPage() {
        val fragment = MainFragment.newInstance()
        openFragment(fragment)
    }

    private fun openBooksPage() {
        val fragment = BooksFragment.newInstance()
        openFragment(fragment)
    }

    private fun openCharactersPage() {
        val fragment = CharactersFragment.newInstance()
        openFragment(fragment)
    }

    private fun openQuotesPage() {
        val fragment = QuotesFragment.newInstance()
        openFragment(fragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.frame_container, fragment, null)

        transaction.commit()
    }

}