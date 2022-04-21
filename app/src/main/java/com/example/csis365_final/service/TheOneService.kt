package com.example.csis365_final.service

import com.example.csis365_final.network.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheOneService {

    val api = RetrofitFactory().getTheOneApi()

    fun getCharacters(
        successCallback: (List<String>) -> Unit,
        failureCallback: (errorMessage: String) -> Unit
    ) {
        api.getCharacters().enqueue(object : Callback<List<String>> {

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No categories returned from service")
                    }
                } else {
                    failureCallback("Error getting categories")
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })
    }
}