package com.example.csis365_final.view


import com.example.csis365_final.dto.Book
import com.example.csis365_final.dto.BookReturn


interface ListsView {
    fun bindBookReturn(books: BookReturn)
    fun showError(errorMessage: String)
}