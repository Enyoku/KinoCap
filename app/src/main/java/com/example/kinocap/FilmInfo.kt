package com.example.kinocap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kinocap.databinding.ActivityFilmInfoBinding

class FilmInfo : AppCompatActivity() {
    lateinit var binding: ActivityFilmInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackButton.setOnClickListener {
            finish()
        }
    }
}