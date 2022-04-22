package com.example.csis365_final.dto

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("_id")
    val id: String?,
    val name: String?
)