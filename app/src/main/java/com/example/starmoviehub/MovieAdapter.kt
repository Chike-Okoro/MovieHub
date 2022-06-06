package com.example.starmoviehub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starmoviehub.model.response.Result
import kotlinx.android.synthetic.main.movie_list.view.*
import loadImage

class MovieAdapter(private val movieProperties: List<Result>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MovieAdapter.NowShowingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowShowingViewHolder {
        return NowShowingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false))
    }




    override fun onBindViewHolder(holder: NowShowingViewHolder, position: Int) {
        val currentProperties = movieProperties[position]
        holder.itemView.apply {
            movieImage.loadImage("https://image.tmdb.org/t/p/w500/${currentProperties.backdrop_path}", R.drawable.johnwick3_image, context)
//            starRating.setImageResource(currentProperties.starImage)
            movieTitle.text = currentProperties.original_title
            genre.text = currentProperties.release_date
            overview.text = currentProperties.overview
//            timePeriod.text = currentProperties.backdrop_path
//            movieRating.text = currentProperties.

        }

    }

    override fun getItemCount(): Int {
        println("getItemCount" + movieProperties.size)
        return movieProperties.size
    }

    inner class NowShowingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)

        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(movieProperties[position])
            }

        }

    }

    interface OnItemClickListener{
        fun onItemClick(movie: Result)
    }

}