package com.example.csis365_final.view.books

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.csis365_final.R
import android.content.SharedPreferences
import androidx.core.content.ContentProviderCompat.requireContext

class BookActivity : AppCompatActivity() {
    val sharedPreferences = applicationContext.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    lateinit var book : String
    lateinit var bookText: TextView
    lateinit var bookName: TextView
    lateinit var btnBack: Button
    lateinit var btnNext: Button
    lateinit var btnSave: Button
    lateinit var btnLoad: Button
    var curPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        getBook()
        bindViews()
        btnSave.setOnClickListener {
            saveValue()
        }
        btnLoad.setOnClickListener {
            curPage = getValue()
        }

    }

    fun bindViews(){
        bookText = findViewById(R.id.book_text)
        bookName = findViewById(R.id.book_name)
        btnNext = findViewById(R.id.book_next)
        btnBack = findViewById(R.id.book_previous)
        btnLoad = findViewById(R.id.book_load)
        btnSave = findViewById(R.id.book_save)
    }

    fun getBook(){
        val bundle = intent.extras?.getBundle("bundle")
        val id = bundle?.getString("id").toString()
        if(id == "5cf5805fb53e011a64671582"){
            book = getString(R.string.book1)
        } else if(id == "5cf58077b53e011a64671583"){
            book = getString(R.string.book2)
        } else if(id == "5cf58080b53e011a64671584"){
            book = getString(R.string.book3)
        } else {
            Log.i("asdf", "Book id does not match a book")
        }
    }

    private fun saveValue() {

        val editor = sharedPreferences.edit()
        editor.putInt(book, curPage)
        editor.commit()

        val recalledString = sharedPreferences.getInt(book, 0)
    }

    private fun getValue(): Int {
        return sharedPreferences.getInt(book, 0)
    }
}

