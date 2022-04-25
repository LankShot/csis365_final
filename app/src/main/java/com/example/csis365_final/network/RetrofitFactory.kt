package com.example.csis365_final.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {

    fun getTheOneApi(): TheOneApi {

        val client = OkHttpClient.Builder()
        client.addInterceptor(LoggingInterceptor())

        return Retrofit.Builder()
            .baseUrl("https://the-one-api.dev/")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheOneApi::class.java)
    }
}
