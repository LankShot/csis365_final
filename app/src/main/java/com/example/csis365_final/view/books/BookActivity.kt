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
import java.io.IOException
import java.io.InputStream

class BookActivity : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    lateinit var book : String
    lateinit var bookText: TextView
    lateinit var bookName: TextView
    lateinit var btnBack: Button
    lateinit var btnNext: Button
    lateinit var btnSave: Button
    lateinit var btnLoad: Button
    lateinit var btnBackAct: Button
    var curPage: Int = 0
    val streamSize: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        bindViews()
        getBook()
        updateText()
        btnSave.setOnClickListener {
            saveValue()
        }
        btnLoad.setOnClickListener {
            curPage = getValue()
            updateText()
        }
        btnNext.setOnClickListener {
            curPage += streamSize
            updateText()
        }
        btnBack.setOnClickListener {
            if(curPage <= streamSize){
                curPage = 0;
            } else {
                curPage -= streamSize;
            }
            updateText()
        }
        btnBackAct.setOnClickListener { finish() }

    }

    fun updateText(){

        val myOutput: String

        val myInputStream: InputStream

        try {
            myInputStream = assets.open(book + ".txt")
            val size: Int = streamSize
            val buffer = ByteArray(size)
            myInputStream.skip(curPage.toLong())
            myInputStream.read(buffer)
            myOutput = String(buffer)

            // Sets the TextView with the string
            bookText.text = myOutput

        } catch (e: IOException) {
            // Exception
            e.printStackTrace()
        }
    }

    fun bindViews(){
        bookText = findViewById(R.id.book_text)
        bookName = findViewById(R.id.book_name)
        btnNext = findViewById(R.id.book_next)
        btnBack = findViewById(R.id.book_previous)
        btnLoad = findViewById(R.id.book_load)
        btnSave = findViewById(R.id.book_save)
        btnBackAct = findViewById(R.id.book_back)
        sharedPreferences = applicationContext.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    }

    fun getBook(){
        val bundle = intent.extras?.getBundle("bundle")
        val id = bundle?.getString("id").toString()
        bookName.text = bundle?.getString("name").toString()
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

