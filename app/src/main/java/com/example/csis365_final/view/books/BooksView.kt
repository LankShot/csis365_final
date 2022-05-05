package com.example.csis365_final.view.books

import com.example.csis365_final.dto.BookReturn

interface BooksView {
    fun bindBookReturn(books: BookReturn)
    fun showError(errorMessage: String)
}