package com.example.kinocap

data class Genre(val id: Int, val title: String, val image_id: Int)
class Genres{
    val list = arrayListOf(Genre(1, "${R.string.anime}", R.drawable.anime_genre),
        Genre(2, "${R.string.action}", R.drawable.action_genre),
        Genre(3, "${R.string.war}", R.drawable.war_genre),
        Genre(4, "${R.string.detective}", R.drawable.detective_genre),
        Genre(5, "${R.string.drama}", R.drawable.drama_genre),
        Genre(6, "${R.string.history}", R.drawable.history_genre),
        Genre(7, "${R.string.comedy}", R.drawable.comedy_genre),
        Genre(8, "${R.string.short_film}", R.drawable.short_genre),
        Genre(9, "${R.string.cartoon}", R.drawable.cartoon_genre),
        Genre(10,"${R.string.thriller}", R.drawable.thriller_genre),
        Genre(11,"${R.string.horror}", R.drawable.horror_genre),
        Genre(12,"${R.string.fiction}", R.drawable.fiction_genre))
}
