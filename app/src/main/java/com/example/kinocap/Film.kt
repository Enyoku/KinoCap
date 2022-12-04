package com.example.kinocap

import com.google.gson.annotations.SerializedName

data class Film(val total: Int, val items: ArrayList<film_info>)

data class film_info(@SerializedName("kinopoiskId") val kinopoiskId: Int,
                     @SerializedName("nameRu")val nameRu: String,
                     @SerializedName("nameEn")val nameEn: String,
                     @SerializedName("year")val year: Int,
                     @SerializedName("posterUrl")val posterUrl: String,
                     @SerializedName("posterUrlPreview")val posterUrlPreview: String,
                     @SerializedName("countries")val countries: ArrayList<countries>,
                     @SerializedName("genres")val genres: ArrayList<genres>,
                     @SerializedName("duration")val duration: Int,
                     @SerializedName("premiereRu")val premiereRU: String)

data class countries(@SerializedName("country")val country: String)
data class genres(@SerializedName("genre")val genre: String)

data class FilmTop(@SerializedName("pagesCount")val pagesCount: Int,
                   @SerializedName("films") val films: ArrayList<top_films>
)
data class top_films(@SerializedName("filmId") val filmId: Int,
                     @SerializedName("nameRu") val nameRu: String,
                     @SerializedName("nameEn") val nameEn: String,
                     @SerializedName("posterUrlPreview") val posterUrlPreview: String)

data class film_day_info(@SerializedName("kinopoiskId") val kinopoiskId: Int,
                         @SerializedName("nameRu") val nameRu: String,
                         @SerializedName("nameEn") val nameEn: String,
                         @SerializedName("type") val type: String,
                         @SerializedName("year") val year: Int,
                         @SerializedName("description") val description : String,
                         @SerializedName("filmLength") val filmLength: Int,
                         @SerializedName("countries") val countries: ArrayList<countries>,
                         @SerializedName("genres") val genres: ArrayList<genres>,
                         @SerializedName("ratingKinopoisk") val ratingKinopoisk: Float,
                         @SerializedName("reviewsCount") val reviewsCount: Int,
                         @SerializedName("posterUrl") val posterUrl: String,
                         @SerializedName("posterUrlPreview") val posterUrlPreview: String)