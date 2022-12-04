package com.example.kinocap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kinocap.data.api.Api
import com.example.kinocap.data.api.MyRetrofit
import com.example.kinocap.databinding.ActivityFilmInfoBinding
import retrofit2.Call
import retrofit2.Response

class FilmInfo : AppCompatActivity() {
    lateinit var binding: ActivityFilmInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val film_id = getIntent().extras?.getInt("id")
        val filmImg: ImageView = findViewById(R.id.filmImg)

        val film = MyRetrofit().getRetrofit()
        val api_retr = film.create(Api::class.java)
        val film_call_info: retrofit2.Call<film_day_info> = api_retr.getFilmById(film_id!!.toInt())
        film_call_info.enqueue(object : retrofit2.Callback<film_day_info>{
            override fun onResponse(call: Call<film_day_info>, response: Response<film_day_info>) {
                if (response.isSuccessful){
                    Log.d("D", response.body().toString())
                    response.body()?.let {
                        Glide.with(this@FilmInfo).load(it.posterUrlPreview).into(filmImg)
                        binding.filmTitleRu.text = it.nameRu
                        binding.filmTitleEn.text = it.nameEn
                        binding.filmRating.text = it.ratingKinopoisk.toString()
                        binding.filmsDescription.text = it.description
                        var strGenres : String = ""
                        var strCountries: String = ""
                        for (i in it.genres) {
                            if(it.genres.last() == i){
                                strGenres += i.genre + ""
                            }
                            else
                                strGenres += i.genre + ", "
                        }
                        for (i in it.countries) {
                            if(it.countries.last() == i){
                                strCountries += i.country + ""
                            }
                            else
                                strCountries += i.country + ", "
                        }
                        binding.filmGenreInfo.text = strGenres
                        binding.filmCountry.text = strCountries
                    }
                }
            }
            override fun onFailure(call: Call<film_day_info>, t: Throwable) {
                Toast.makeText(this@FilmInfo, t.message, Toast.LENGTH_SHORT).show()
            }
        })
        binding.goBackButton.setOnClickListener {
            finish()
        }
    }
}