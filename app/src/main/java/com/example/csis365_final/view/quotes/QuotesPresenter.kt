package com.example.csis365_final.view.quotes


import com.example.csis365_final.service.TheOneService


class QuotesPresenter(
    val view: QuotesView,
    val theOneService: TheOneService
) {

    fun start() {

        getQuotes()
    }


    fun getQuotes() {
        theOneService.getQuotes(

            successCallback = { quotes ->
                view.bindQuotes(quotes)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

}
