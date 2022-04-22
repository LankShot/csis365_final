package com.example.csis365_final.network

import com.example.csis365_final.dto.BookReturn
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheOneApi {

    @GET("/quote")
    @Headers("Authorization: Bearer hUXOxvlTiaM-67Cjjrk7")
    fun getCharacters(): Call<ResponseBody>

    @GET("/book")
    fun getBooks(): Call<BookReturn>



}