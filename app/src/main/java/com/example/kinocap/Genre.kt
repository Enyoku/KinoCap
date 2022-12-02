package com.example.kinocap

import android.view.View

data class Genre(val id: Int, val title: String, val image_id: Int, val genreId: Int)
class Genres_category(val root : View)  {
    val list = arrayListOf(Genre(1, "${root.context.getString(R.string.anime)}", R.drawable.anime_genre, 24),
        Genre(2, "${root.context.getString(R.string.action)}", R.drawable.action_genre, 11),
        Genre(3, "${root.context.getString(R.string.war)}", R.drawable.war_genre, 14),
        Genre(4, "${root.context.getString(R.string.detective)}", R.drawable.detective_genre, 5),
        Genre(5, "${root.context.getString(R.string.drama)}", R.drawable.drama_genre, 2),
        Genre(6, "${root.context.getString(R.string.history)}", R.drawable.history_genre, 15),
        Genre(7, "${root.context.getString(R.string.comedy)}", R.drawable.comedy_genre, 13),
        Genre(8, "${root.context.getString(R.string.short_film)}", R.drawable.short_genre, 23),
        Genre(9, "${root.context.getString(R.string.cartoon)}", R.drawable.cartoon_genre, 18),
        Genre(10,"${root.context.getString(R.string.thriller)}", R.drawable.thriller_genre, 1),
        Genre(11,"${root.context.getString(R.string.horror)}", R.drawable.horror_genre, 17),
        Genre(12,"${root.context.getString(R.string.fiction)}", R.drawable.fiction_genre, 6))
}
