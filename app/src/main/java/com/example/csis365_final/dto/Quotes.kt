package com.example.csis365_final.dto

data class Quotes(
    val docs: List<Quote>?,
    val total: Int?,
    val limit: Int?,
    val offset: Int?,
    val page: Int?,
    val pages: Int?
)