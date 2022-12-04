package com.example.kinocap.ui.home
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinocap.FilmInfo
import com.example.kinocap.FilmTop
import com.example.kinocap.R

class TopFilmsAdapter(val context: Context, val film: FilmTop): RecyclerView.Adapter<TopFilmsAdapter.TopFilmsHolder>() {
    class TopFilmsHolder(item: View): RecyclerView.ViewHolder(item) {
        val card: CardView = item.findViewById(R.id.filmCard)
        val filmImage: ImageView = item.findViewById(R.id.filmImage)
        val filmName: TextView = item.findViewById(R.id.filmName)
        var id : Int = 0

        init {
            this.card.setOnClickListener {
                val intent = Intent(item.context, FilmInfo::class.java)
                intent.putExtra("id", id)
                item.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFilmsHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.film_item,
            parent, false)
        return TopFilmsAdapter.TopFilmsHolder(view)
    }

    override fun onBindViewHolder(holder: TopFilmsHolder, position: Int) {
        Glide.with(context).load(film.films[position].posterUrlPreview).into(holder.filmImage)
        holder.filmName.setText(film.films[position].nameRu)
        holder.id = film.films[position].filmId
    }

    override fun getItemCount(): Int {
        return film.films.size
    }
}