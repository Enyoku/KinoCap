package com.example.kinocap.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinocap.Film
import com.example.kinocap.R
import com.example.kinocap.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapterPremierFilms = PremierFilmsAdapter()
    private val adapterTopFilms = TopFilmsAdapter()

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

        binding.apply {
            rcViewPremiere.layoutManager = LinearLayoutManager(this@HomeFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rcViewPremiere.adapter = adapterPremierFilms

            rcViewTop250Films.layoutManager = LinearLayoutManager(this@HomeFragment.context,
            LinearLayoutManager.HORIZONTAL,
            false)
            rcViewTop250Films.adapter = adapterPremierFilms
        }

        val premFilm = Film(3, "Film", R.drawable.anime_genre)
        for (i in 1..5){
            adapterPremierFilms.addFilm(premFilm)
            adapterTopFilms.addFilm(premFilm)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}