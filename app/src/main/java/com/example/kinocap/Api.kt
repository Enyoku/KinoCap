package com.example.kinocap

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/premieres")
    fun getPremieres(@Query("year") year: Int, @Query("month") month: String):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/")
    fun getFilm():Call<film_info>
}