package com.example.kinocap.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Genres_category
import com.example.kinocap.R
import com.example.kinocap.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rcViewGenres: RecyclerView = root.findViewById(R.id.rcViewGenres)

        binding.apply {
            rcViewGenres.adapter = GenreAdapter(requireContext(), Genres_category(root).list)
            rcViewGenres.layoutManager = GridLayoutManager(this@CategoryFragment.context, 3)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}