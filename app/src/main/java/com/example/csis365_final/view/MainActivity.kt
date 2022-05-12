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
    lateinit var fragmentContainer: FrameLayout
    lateinit var bottomBar: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setupNavBar()

    }

    private fun bindViews() {
        fragmentContainer = findViewById(R.id.frame_container)
        bottomBar = findViewById(R.id.bottom_nav_view)
    }

    private fun setupNavBar() {
        bottomBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                bottomBar.selectedItemId -> true

                R.id.action_main -> openMainPage()
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