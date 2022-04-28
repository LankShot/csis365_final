package com.example.csis365_final.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.csis365_final.R
import com.example.csis365_final.dto.BookReturn
import com.example.csis365_final.dto.Characters
import com.example.csis365_final.dto.Quotes
import com.example.csis365_final.service.TheOneService
import com.google.gson.JsonElement
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity() {
    lateinit var textMain : TextView
    lateinit var bookReturn: BookReturn
    lateinit var charactersRet: Characters
    lateinit var quotesRet: Quotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textMain = findViewById(R.id.text_main)

        val service = TheOneService()


        service.getCharacters(
            successCallback = { characters ->
                charactersRet = characters
            },

            failureCallback = { errorMessage ->
                textMain.setText(errorMessage.toString())
            }
        )

        service.getBooks(
            successCallback = { books ->
                bookReturn = books
            },

            failureCallback = { errorMessage ->
                textMain.setText(errorMessage.toString())
            }
        )

        service.getQuotes(
            successCallback = { quotes ->
                quotesRet = quotes
            },

            failureCallback = { errorMessage ->
                textMain.setText(errorMessage.toString())
            }
        )
    }
}