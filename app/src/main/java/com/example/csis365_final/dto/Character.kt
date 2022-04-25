package com.example.csis365_final.dto

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("_id")
    val id: String?,
    val height: String?,
    val race: String?,
    val gender: String?,
    val birth: String?,
    val spouse: String?,
    val death: String?,
    val realm: String?,
    val hair: String?,
    val name: String?,
    val wikiUrl: String?
)