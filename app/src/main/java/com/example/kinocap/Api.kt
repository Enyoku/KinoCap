package com.example.kinocap

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330")
    @GET("/api/v2.2/films/premieres")
    fun getPremieres(@Query("year") year: Int, @Query("month") month: String):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.2/films/")
    fun getFilm(@Query("id") id: Int):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330", "Content-Type: application/json")
    @GET("/api/v2.1/films/search-by-keyword")
    fun getFilmByKeyword(@Query("keyword") keyword: String):Call<film_keyword>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330")
    @GET("/api/v2.2/films/top")
    fun getTop250Films(@Query("type") type: String = "TOP_250_BEST_FILMS",
                       @Query("page") page: Int = 4):Call<Film>

    @Headers("X-API-KEY: 0da2b04f-8117-4677-884a-8f2cc8ee1330")
    fun getFilmListByGenre(@Query("genres") genres: Int):Call<Film>
}