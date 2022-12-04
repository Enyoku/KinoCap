package com.example.kinocap

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/premieres")
    fun getPremieres(@Query("year") year: Int, @Query("month") month: String):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/top")
    fun getTop250Films(@Query("page") page: Int = 4):Call<FilmTop>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films")
    fun getFilmListByGenre(@Query("genres") genres: ArrayList<Int>, @Query("page") page: Int = 4):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/{id}")
    fun getFilmById(@Path("id") id: Int):Call<film_day_info>
}