package com.example.kinocap

import android.view.View

data class Genre(val id: Int, val title: String, val image_id: Int)
class Genres_category(val root : View)  {
    val list = arrayListOf(Genre(1, "${root.context.getString(R.string.anime)}", R.drawable.anime_genre),
        Genre(2, "${root.context.getString(R.string.action)}", R.drawable.action_genre),
        Genre(3, "${root.context.getString(R.string.war)}", R.drawable.war_genre),
        Genre(4, "${root.context.getString(R.string.detective)}", R.drawable.detective_genre),
        Genre(5, "${root.context.getString(R.string.drama)}", R.drawable.drama_genre),
        Genre(6, "${root.context.getString(R.string.history)}", R.drawable.history_genre),
        Genre(7, "${root.context.getString(R.string.comedy)}", R.drawable.comedy_genre),
        Genre(8, "${root.context.getString(R.string.short_film)}", R.drawable.short_genre),
        Genre(9, "${root.context.getString(R.string.cartoon)}", R.drawable.cartoon_genre),
        Genre(10,"${root.context.getString(R.string.thriller)}", R.drawable.thriller_genre),
        Genre(11,"${root.context.getString(R.string.horror)}", R.drawable.horror_genre),
        Genre(12,"${root.context.getString(R.string.fiction)}", R.drawable.fiction_genre))
}
