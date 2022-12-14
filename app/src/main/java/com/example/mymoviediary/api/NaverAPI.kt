package com.example.mymoviediary.api

import com.example.mymoviediary.model.ResultGetNaverMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("v1/search/movie.json")
    fun getSearchMovies(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
    ): Call<ResultGetNaverMovie>
}