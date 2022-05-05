package com.example.csis365_final.view.books

import android.content.Context
import com.example.csis365_final.service.TheOneService

class BooksPresenterFactory {

    companion object {
        fun createPresenter(view: BooksView, context: Context): BooksPresenter {
            return BooksPresenter(
                view,
                TheOneService()
            )
        }
    }
}
