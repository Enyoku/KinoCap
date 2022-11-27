package com.example.kinocap.ui.category
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Film
import com.example.kinocap.Genre
import com.example.kinocap.R
import com.example.kinocap.databinding.GenreItemBinding

class GenreAdapter: RecyclerView.Adapter<GenreAdapter.VH>() {
    val genreList = ArrayList<Genre>()
    class VH(item: View): RecyclerView.ViewHolder(item)  {
        val binding = GenreItemBinding.bind(item)
        fun bind(genre: Genre){
            binding.genreImage.setImageResource(R.id.genreImage)
            binding.genreText.text = genre.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.genre_item,
            parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(genreList[position])
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    fun addGenre(genre: Genre){
        genreList.add(genre)
        notifyDataSetChanged()
    }
}