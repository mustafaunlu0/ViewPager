package com.mustafaunlu.viewpager

import android.view.LayoutInflater
import android.widget.RatingBar
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        private var imagePoster: RoundedImageView=view.findViewById(R.id.posterImage)
        private var textName:TextView=view.findViewById(R.id.textName)
        private var textCategory:TextView= view.findViewById(R.id.textCategory)
        private var textReleaseDate:TextView = view.findViewById(R.id.textReleaseDate)
        private var ratingBar: RatingBar = view.findViewById(R.id.ratingBar)

        fun setMovie(movie : Movie){
            imagePoster.setImageResource(movie.poster)
            textName.text=movie.name
            textCategory.text=movie.category
            textReleaseDate.text = movie.releaseDate
            ratingBar.rating=movie.rating
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_container_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setMovie(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}