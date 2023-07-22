package com.notepad96.apiholiday

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HolidayObject {
    private const val BASE_URL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/"

    private val getRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService: HolidayAPI by lazy { getRetrofit.create(HolidayAPI::class.java) }
}