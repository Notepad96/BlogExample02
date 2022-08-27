package com.notepad96.apiretrofit

import retrofit2.Call
import retrofit2.http.GET

interface UpbitAPI {
    @GET("v1/market/all")
    fun getCoinAll(
    ): Call<List<Coin>>
}