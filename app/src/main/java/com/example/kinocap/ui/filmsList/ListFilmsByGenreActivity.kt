package com.example.kinocap.ui.filmsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Film
import com.example.kinocap.R
import com.example.kinocap.databinding.ActivityListFilmsByGenreBinding

class ListFilmsByGenreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsByGenreBinding
//    val adapter = ListFilmsGenreAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFilmsByGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rcFilmsList: RecyclerView = binding.rcListFilmsByGenre

        binding.apply {
//            rcFilmsList.adapter = ListFilmsGenreAdapter(this@ListFilmsByGenreActivity, Film())
            rcFilmsList.layoutManager = GridLayoutManager(this@ListFilmsByGenreActivity, 3)
        }

        binding.goCategoryBtn.setOnClickListener {
            finish()
        }
    }

}