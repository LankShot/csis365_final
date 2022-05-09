package com.example.csis365_final.network

import com.example.csis365_final.dto.BookReturn
import com.example.csis365_final.dto.Characters
import com.example.csis365_final.dto.Quotes
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheOneApi {

    @GET("/v2/character?limit=50")
    @Headers("Authorization: Bearer hUXOxvlTiaM-67Cjjrk7")
    fun getCharacters(): Call<Characters>

    @GET("/v2/book")
    @Headers("Authorization: Bearer hUXOxvlTiaM-67Cjjrk7")
    fun getBooks(): Call<BookReturn>

    @GET("/v2/quote")
    @Headers("Authorization: Bearer hUXOxvlTiaM-67Cjjrk7")
    fun getQuotes(): Call<Quotes>

}