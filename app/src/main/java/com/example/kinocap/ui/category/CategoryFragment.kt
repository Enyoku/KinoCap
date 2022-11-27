package com.example.kinocap.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinocap.Film
import com.example.kinocap.Genre
import com.example.kinocap.R
import com.example.kinocap.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    val adapterGenre = GenreAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(CategoryViewModel::class.java)

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            rcViewGenres.adapter = adapterGenre
            rcViewGenres.layoutManager = GridLayoutManager(this@CategoryFragment.context, 3)
        }

        val genre = Genre(3, "Film", R.drawable.capybara_icon)
        for (i in 1..5){
            adapterGenre.addGenre(genre)
            adapterGenre.addGenre(genre)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}