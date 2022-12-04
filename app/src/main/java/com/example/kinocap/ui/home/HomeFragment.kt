package com.example.kinocap.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinocap.*
import com.example.kinocap.data.api.Api
import com.example.kinocap.data.api.MyRetrofit
import com.example.kinocap.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rcViewPremier: RecyclerView = root.findViewById(R.id.rcViewPremiere)
        val rcViewTop250Films: RecyclerView = root.findViewById(R.id.rcViewTop250Films)
        val imFilmDay: ImageView = root.findViewById(R.id.imFilmOfTheDay)

        // Запрос на получение premier films
        val films = MyRetrofit().getRetrofit()
        val api_ret = films.create(Api::class.java)
        val films_call_premiere: retrofit2.Call<Film> = api_ret.getPremieres(2022,"OCTOBER")
        films_call_premiere.enqueue(object : retrofit2.Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.isSuccessful){
                    rcViewPremier.adapter =
                        response.body()?.let {PremierFilmsAdapter(requireContext(), it)}
                    Log.d("It",response.body().toString())
                }
            }
            override fun onFailure(call: Call<Film>, t: Throwable) {
                Toast.makeText(this@HomeFragment.context, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        //Запрос на получения топ-250 фильмов
        val top_films = MyRetrofit().getRetrofit()
        val api_top = top_films.create(Api::class.java)
        val films_call_top: retrofit2.Call<FilmTop> = api_top.getTop250Films()
        films_call_top.enqueue(object : retrofit2.Callback<FilmTop>{
            override fun onResponse(call: Call<FilmTop>, response: Response<FilmTop>) {
                if (response.isSuccessful){
                    rcViewTop250Films.adapter =
                        response.body()?.let {TopFilmsAdapter(requireContext(), it)}
            }
        }
            override fun onFailure(call: Call<FilmTop>, t: Throwable) {
                Toast.makeText(this@HomeFragment.context, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        val film_day = MyRetrofit().getRetrofit()
        val api_retr = film_day.create(Api::class.java)
        val film_call_day: retrofit2.Call<film_day_info> = api_retr.getFilmById(456)
        film_call_day.enqueue(object : retrofit2.Callback<film_day_info>{
            override fun onResponse(call: Call<film_day_info>, response: Response<film_day_info>) {
                if (response.isSuccessful){
                    Log.d("D", response.body().toString())
                    response.body()?.let {
                        Glide.with(this@HomeFragment).load(it.posterUrlPreview).into(imFilmDay)
                        binding.filmOfTheDayName.text = it.nameRu
                        binding.filmOfTheDayScore.text = it.ratingKinopoisk.toString()
                        binding.filmOfTheDayDescription.text = it.description
                        var strGenres : String = ""
                        for (i in it.genres) {
                            strGenres += i.genre + ", "
                        }
                        binding.filmOfTheDayGenres.text = strGenres
                    }
                }
            }
            override fun onFailure(call: Call<film_day_info>, t: Throwable) {
                Toast.makeText(this@HomeFragment.context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
        binding.apply {
            rcViewPremiere.layoutManager = LinearLayoutManager(this@HomeFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rcViewTop250Films.layoutManager = LinearLayoutManager(this@HomeFragment.context,
            LinearLayoutManager.HORIZONTAL,
            false)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}