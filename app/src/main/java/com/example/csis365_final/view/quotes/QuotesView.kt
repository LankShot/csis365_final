package com.example.csis365_final.view.quotes



import com.example.csis365_final.dto.Quotes


interface QuotesView {
    fun bindQuotes(quotes: Quotes)
    fun showError(errorMessage: String)
}