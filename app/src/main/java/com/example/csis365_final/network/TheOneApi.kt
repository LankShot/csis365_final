package com.example.csis365_final.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheOneApi {

    @GET("/character")
    @Headers("Authorization: Bearer hUXOxvlTiaM-67Cjjrk7")
    fun getCharacters(): Call<List<String>>

}