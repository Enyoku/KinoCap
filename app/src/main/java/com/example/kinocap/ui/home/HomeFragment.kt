package com.example.kinocap.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Api
import com.example.kinocap.Film
import com.example.kinocap.MyRetrofit
import com.example.kinocap.R
import com.example.kinocap.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
//    private val adapterTopFilms = TopFilmsAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rcViewPremier: RecyclerView = root.findViewById(R.id.rcViewPremiere)
        val rcViewTop250Films: RecyclerView = root.findViewById(R.id.rcViewTop250Films)

        val films = MyRetrofit().getRetrofit()
        val api_ret = films.create(Api::class.java)
        val films_call_premiere: retrofit2.Call<Film> = api_ret.getPremieres(2022,"OCTOBER")
        films_call_premiere.enqueue(object : retrofit2.Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.isSuccessful){
                    rcViewPremier.adapter =
                        response.body()?.let {PremierFilmsAdapter(requireContext(), it)}
                    Log.d("It","just work")
                }
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                Toast.makeText(this@HomeFragment.context, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        val films_call_top: retrofit2.Call<Film> = api_ret.getTop250Films()
        films_call_top.enqueue(object : retrofit2.Callback<Film>{
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.isSuccessful){
                    rcViewTop250Films.adapter =
                        response.body()?.let {TopFilmsAdapter(requireContext(), it)}
                    Log.d("It","just work")
            }
        }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                Toast.makeText(this@HomeFragment.context, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        binding.apply {
            rcViewPremiere.layoutManager = LinearLayoutManager(this@HomeFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
//            rcViewPremiere.adapter = PremierFilmsAdapter(requireContext(), )

            rcViewTop250Films.layoutManager = LinearLayoutManager(this@HomeFragment.context,
            LinearLayoutManager.HORIZONTAL,
            false)
//            rcViewTop250Films.adapter = adapterTopFilms
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}