package com.example.myfirstproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movies_now_showing.view.*
import kotlinx.android.synthetic.main.movie_items.view.*

class MoviesNowShowingAdapter(
    private val movieProperties: List<MovieShowingProperties>
) : RecyclerView.Adapter<MoviesNowShowingAdapter.NowShowingViewHolder>() {
    class NowShowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowShowingViewHolder {
        return NowShowingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_items, parent, false))
    }

    override fun onBindViewHolder(holder: NowShowingViewHolder, position: Int) {
        val currentProperties = movieProperties[position]
        holder.itemView.apply {
            movieImage.setImageResource(currentProperties.movieImage)
            starRating.setImageResource(currentProperties.starImage)
            movieTitle.text = currentProperties.movieName
            genre.text = currentProperties.genre
            timePeriod.text = currentProperties.period
            movieRating.text = currentProperties.rating
        }
    }

    override fun getItemCount(): Int {
        println("getItemCount" + movieProperties.size)
        return movieProperties.size
    }

}