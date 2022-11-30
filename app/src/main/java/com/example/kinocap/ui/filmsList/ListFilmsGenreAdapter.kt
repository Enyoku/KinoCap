package com.example.kinocap.ui.filmsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.Film
import com.example.kinocap.R

class ListFilmsGenreAdapter: RecyclerView.Adapter<ListFilmsGenreAdapter.VH>() {
    val list = ArrayList<Film>()
    class VH(item: View): RecyclerView.ViewHolder(item) {
        val image: ImageView = item.findViewById(R.id.filmImage)
        val textView: TextView = item.findViewById(R.id.filmName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.film_item,
            parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.image.setImageResource(list[position].image_id)
        holder.textView.setText(list[position].film_name)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addFilm(film: Film){
        list.add(film)
        notifyDataSetChanged()
    }
}