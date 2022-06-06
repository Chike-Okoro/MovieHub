package com.example.starmoviehub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starmoviehub.utils.argumentNullable
import com.example.starmoviehub.utils.withArguments
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.movie_list.*
import loadImage


class MovieDetailsFragment : BaseFragment() {
    private val movieTitle: String? by argumentNullable(MOVIE_TITLE)
    private val genre: String? by argumentNullable(GENRE)
    private val overview: String? by argumentNullable(OVERVIEW)
    private val movieImage: String? by argumentNullable(MOVIE_IMAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailTitle.text = movieTitle
        movieDesc.text = overview
        imageBackground.loadImage("https://image.tmdb.org/t/p/w500/${movieImage}", R.drawable.johnwick3_image, requireContext())
    }

    companion object{
        private val MOVIE_TITLE = "movie_details"
        private val GENRE = "genre"
        private val OVERVIEW = "overview"
        private val MOVIE_IMAGE = "image"

    }

    fun newInstance(movieTitle: String, genre: String, overview:String, movieImage: String): MovieDetailsFragment{
        return MovieDetailsFragment().withArguments(MOVIE_TITLE to movieTitle, GENRE to genre, OVERVIEW to overview, MOVIE_IMAGE to movieImage)
    }


}