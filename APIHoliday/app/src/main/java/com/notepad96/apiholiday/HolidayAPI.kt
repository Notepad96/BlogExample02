package com.notepad96.apiholiday

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HolidayAPI {
    @GET("getRestDeInfo?serviceKey=%2FEXw%2F177y%2FAhcdD7c9uH9po9i2MxxgZAgH9ZdFwDeFtLgM%2Bi6wWfqlJLr2y0rt8Ea40bRbfj5No9RbafR6tVjg%3D%3D&solYear=2023")
    fun getHoliday() : Call<List<MyDateItem>>

//    @GET("getRestDeInfo")
//    fun getHoliday(
//        @Query("serviceKey") serviceKey: String = "%2FEXw%2F177y%2FAhcdD7c9uH9po9i2MxxgZAgH9ZdFwDeFtLgM%2Bi6wWfqlJLr2y0rt8Ea40bRbfj5No9RbafR6tVjg%3D%3D",
//        @Query("_type") type: String = "json",
//        @Query("solYear") solYear: String = "2023",
//    ) : Call<List<MyDateItem>>
}