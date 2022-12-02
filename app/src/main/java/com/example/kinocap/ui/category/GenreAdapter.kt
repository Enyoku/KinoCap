package com.example.kinocap.ui.category

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kinocap.FilmInfo
import com.example.kinocap.Genre
import com.example.kinocap.R
import com.example.kinocap.ui.filmsList.ListFilmsByGenreActivity

class GenreAdapter(val context: Context, val list: ArrayList<Genre>): RecyclerView.Adapter<GenreAdapter.VH>() {
    class VH(item: View): RecyclerView.ViewHolder(item)  {
        val card: CardView = item.findViewById(R.id.genreCard)
        val image: ImageView = item.findViewById(R.id.genreImage)
        val textView: TextView = item.findViewById(R.id.genreText)
        var genreId: Int = 0

        init {
            this.card.setOnClickListener {
                val intent = Intent(item.context, ListFilmsByGenreActivity::class.java)
                intent.putExtra("genreId", genreId)
                item.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =  LayoutInflater.from(context).inflate(R.layout.genre_item,
            parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.image.setImageResource(list[position].image_id)
        holder.textView.setText(list[position].title)
        holder.genreId = list[position].genreId
    }

    override fun getItemCount(): Int {
        return list.size
    }
}