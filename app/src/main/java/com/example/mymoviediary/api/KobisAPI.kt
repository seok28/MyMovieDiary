package com.example.mymoviediary.api

import com.example.mymoviediary.model.ResultGetMovieChart
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KobisAPI {
    @GET("searchDailyBoxOfficeList.json")
    fun getMovieChart(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
    ): Call<ResultGetMovieChart>
}