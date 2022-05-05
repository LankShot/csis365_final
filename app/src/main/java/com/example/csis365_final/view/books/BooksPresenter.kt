package com.example.csis365_final.view.books

import android.content.SharedPreferences
import com.example.csis365_final.service.TheOneService


class BooksPresenter(
    val view: BooksView,
    val theOneService: TheOneService
) {

    fun start() {

        getBooks()
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

}
