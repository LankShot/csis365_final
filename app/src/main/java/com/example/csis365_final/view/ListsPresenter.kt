package com.example.csis365_final.view

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.csis365_final.dto.Book
import com.example.csis365_final.service.TheOneService


class ListsPresenter(
    val view: ListsView,
    val theOneService: TheOneService,
    val sharedPreferences: SharedPreferences
) {

    fun start() {

        getBooks()

        //saveValue()
    }


    fun getBooks() {
        theOneService.getBooks(

            successCallback = { books ->
                view.bindBookReturn(books)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

/**
    private fun saveValue() {
        val editor = sharedPreferences.edit()
        editor.putString("unique key", "whatever string")
        editor.commit()

        val recalledString = sharedPreferences.getString("unique key", "default")
    }
    **/
}
