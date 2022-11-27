package com.example.kinocap.ui.home
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Film
import com.example.kinocap.R
import com.example.kinocap.databinding.FilmItemBinding

class TopFilmsAdapter: RecyclerView.Adapter<TopFilmsAdapter.TopFilmsHolder>() {
    val filmList = ArrayList<Film>()
    class TopFilmsHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FilmItemBinding.bind(item)
        fun bind(film: Film){
            binding.filmImage.setImageResource(film.image_id)
            binding.filmName.text = film.film_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFilmsHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.film_item,
            parent, false)
        return TopFilmsAdapter.TopFilmsHolder(view)
    }

    override fun onBindViewHolder(holder: TopFilmsHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun addFilm(film: Film){
        filmList.add(film)
        notifyDataSetChanged()
    }
}