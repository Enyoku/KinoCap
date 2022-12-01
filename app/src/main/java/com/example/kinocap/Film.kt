package com.example.kinocap

data class Film(val total: Int, val data: ArrayList<film_info>)
data class data_film(val film_id: Int, val film_name: String, val image_url: String)


data class film_info(val film_id: Int, val film_name_ru: String,
                     val film_name_en: String, val year: Int, val image_url: String,
                     val image_url_preview: String, val country: ArrayList<country>,
                     val genres: ArrayList<genres_req>, val duration: Int,
                     val premiereRU: String)

data class country(val country_name: String)
data class genres_req(val genre_name: String)
