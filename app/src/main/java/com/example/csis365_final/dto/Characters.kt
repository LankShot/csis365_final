package com.example.csis365_final.dto

data class Characters(
    val docs: List<Character>?,
    val total: Int?,
    val limit: Int?,
    val offset: Int?,
    val page: Int?,
    val pages: Int?
)