package com.example.kinocap.ui.filmsList

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
import com.example.kinocap.Film
import com.example.kinocap.FilmInfo
import com.example.kinocap.R

class ListFilmsGenreAdapter(val context: Context, val films: Film): RecyclerView.Adapter<ListFilmsGenreAdapter.VH>() {
    class VH(item: View): RecyclerView.ViewHolder(item) {
        val card: CardView = item.findViewById(R.id.filmCard)
        val image: ImageView = item.findViewById(R.id.filmImage)
        val textView: TextView = item.findViewById(R.id.filmName)

        init {
            this.card.setOnClickListener {
                val intent = Intent(item.context, FilmInfo::class.java)
//                intent.putExtra("id", ) id фильма
                item.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =  LayoutInflater.from(context).inflate(R.layout.film_item,
            parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(context).load(films.data[position].image_url).into(holder.image)
        holder.textView.setText(films.data[position].film_name_ru)
    }

    override fun getItemCount(): Int {
        return films.data.size
    }
}