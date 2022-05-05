package com.example.csis365_final.service

import com.example.csis365_final.dto.BookReturn
import com.example.csis365_final.dto.Characters
import com.example.csis365_final.dto.Quotes
import com.example.csis365_final.network.RetrofitFactory
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheOneService {

    val api = RetrofitFactory().getTheOneApi()

    fun getCharacters(
        successCallback: (Characters) -> Unit,
        failureCallback: (errorMessage: String) -> Unit
    ) {
        api.getCharacters().enqueue(object : Callback<Characters> {

            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No Characters returned from service")
                    }
                } else {
                    failureCallback("Error getting jokes")
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }

    fun getBooks(
        successCallback: (BookReturn) -> Unit,
        failureCallback: (errorMessage: String) -> Unit
    ) {
        api.getBooks().enqueue(object : Callback<BookReturn> {

            override fun onResponse(call: Call<BookReturn>, response: Response<BookReturn>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No Books returned from service")
                    }
                } else {
                    failureCallback("Error getting jokes")
                }
            }

            override fun onFailure(call: Call<BookReturn>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }

    fun getQuotes(
        successCallback: (Quotes) -> Unit,
        failureCallback: (errorMessage: String) -> Unit
    ) {
        api.getQuotes().enqueue(object : Callback<Quotes> {

            override fun onResponse(call: Call<Quotes>, response: Response<Quotes>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No quotes returned from service")
                    }
                } else {
                    failureCallback("Error getting jokes")
                }
            }

            override fun onFailure(call: Call<Quotes>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }

}
