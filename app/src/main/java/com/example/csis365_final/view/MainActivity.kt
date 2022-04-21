package com.example.csis365_final.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.csis365_final.R
import com.example.csis365_final.service.TheOneService

class MainActivity : AppCompatActivity() {

    lateinit var textMain : TextView
    lateinit var characters : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textMain = findViewById(R.id.text_main)

        val service = TheOneService()

        service.getCharacters(
            successCallback = { categories ->
                textMain.setText(categories.toString())
            },

            failureCallback = { errorMessage ->
                textMain.setText(errorMessage)
            }
        )
    }
}