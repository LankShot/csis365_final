package com.example.csis365_final.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    fun getTheOneApi(): TheOneApi {

        val client = OkHttpClient()
        client.interceptors()

        return Retrofit.Builder()
            .baseUrl("https://the-one-api.dev/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheOneApi::class.java)
    }
}
