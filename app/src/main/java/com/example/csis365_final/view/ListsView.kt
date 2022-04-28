package com.example.csis365_final.view


import com.example.csis365_final.dto.Book
import com.example.csis365_final.dto.BookReturn
import com.example.csis365_final.dto.Characters
import com.example.csis365_final.dto.Quotes
import okhttp3.ResponseBody


interface ListsView {
    fun bindBookReturn(books: BookReturn)
    fun bindCharacters(characters: Characters)
    fun bindQuotes(quotes: Quotes)
    fun showError(errorMessage: String)
}