package com.example.csis365_final.view.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.csis365_final.R

class QuoteActivity : AppCompatActivity() {
    lateinit var btnBack:Button

    lateinit var quoteCharacter: TextView
    lateinit var quoteDialog: TextView
    lateinit var quoteMovie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        bindViews()
        setText()
        btnBack.setOnClickListener { finish() }
    }

    fun setText(){
        val bundle = intent.extras?.getBundle("bundle")
        val id = bundle?.getString("movie").toString()

        quoteDialog.text = bundle?.getString("dialog").toString()
        quoteCharacter.text = bundle?.getString("character").toString()

        if(id == "5cd95395de30eff6ebccde5b"){
            quoteMovie.text = "The Two Towers "
        } else if(id == "5cd95395de30eff6ebccde5c"){
            quoteMovie.text = "The Fellowship of the Ring"
        } else if(id == "5cd95395de30eff6ebccde5d"){
            quoteMovie.text ="The Return of the King"
        } else {
            quoteMovie.text = "unknown"
        }
    }

    fun bindViews(){
        btnBack = findViewById(R.id.quote_back)

        quoteCharacter = findViewById(R.id.quote_character)
        quoteDialog = findViewById(R.id.quote_dialog)
        quoteMovie = findViewById(R.id.quote_movie)
    }
}