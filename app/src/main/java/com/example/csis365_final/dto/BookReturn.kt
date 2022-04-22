package com.example.csis365_final.dto

data class BookReturn(
    val docs: List<Book>?,
    val total: Int?,
    val limit: Int?,
    val offset: Int?,
    val page: Int?,
    val pages: Int?
)