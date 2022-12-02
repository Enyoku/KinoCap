package com.example.kinocap.ui.filmsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.*
import com.example.kinocap.databinding.ActivityListFilmsByGenreBinding
import com.example.kinocap.ui.home.PremierFilmsAdapter
import retrofit2.Call
import retrofit2.Response

class ListFilmsByGenreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsByGenreBinding
//    val adapter = ListFilmsGenreAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFilmsByGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rcFilmsList: RecyclerView = binding.rcListFilmsByGenre
        val genreId = getIntent().extras?.getInt("genreId")

        val films = MyRetrofit().getRetrofit()
        val api_ret = films.create(Api::class.java)
        val films_call: retrofit2.Call<Film> = api_ret.getFilmListByGenre(arrayListOf(genreId!!.toInt()))
        films_call.enqueue(object : retrofit2.Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.isSuccessful){
                    rcFilmsList.adapter =
                        response.body()?.let { ListFilmsGenreAdapter(this@ListFilmsByGenreActivity, it) }
                    Log.d("It","just work")
                }
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                Toast.makeText(this@ListFilmsByGenreActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        binding.apply {
//            rcFilmsList.adapter = ListFilmsGenreAdapter(this@ListFilmsByGenreActivity, Film())
            rcFilmsList.layoutManager = GridLayoutManager(this@ListFilmsByGenreActivity, 3)
        }

        binding.goCategoryBtn.setOnClickListener {
            finish()
        }
    }

}