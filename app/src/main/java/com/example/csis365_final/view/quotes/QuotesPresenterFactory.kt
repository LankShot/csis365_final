package com.example.csis365_final.view.quotes

import android.content.Context
import com.example.csis365_final.service.TheOneService

class QuotesPresenterFactory {

    companion object {
        fun createPresenter(view: QuotesView, context: Context): QuotesPresenter {
            return QuotesPresenter(
                view,
                TheOneService())
        }
    }
}
