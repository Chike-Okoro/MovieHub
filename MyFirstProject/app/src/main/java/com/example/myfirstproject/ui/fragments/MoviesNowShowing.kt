package com.example.myfirstproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstproject.MovieShowingProperties
import com.example.myfirstproject.MoviesNowShowingAdapter
import com.example.myfirstproject.MyAdapter
import com.example.myfirstproject.R
import com.example.myfirstproject.ui.base.BaseFragment
import com.example.myfirstproject.utils.ViewPagerObject
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ncapdevi.fragnav.FragNavController
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_movies_now_showing.*


class MoviesNowShowing : BaseFragment() {
    var tabTitle = arrayOf("Now Showing", "Coming Soon")
    val listOfMovieProperties = listOf(MovieShowingProperties(R.drawable.johnwick3_image, R.drawable.five_star_rating, "John Wick 3", "Crime", "2hr 10min", "R"),
        MovieShowingProperties(R.drawable.blade_runner, R.drawable.five_star_rating, "Blade Runner 2049", "Sci-fi/Action", "2hr 43m", "R"),
        MovieShowingProperties(R.drawable.alita_image, R.drawable.five_star_rating, "Alita Battle Angel", "Sci-fi/Action", "2hr 2min", "PG-13"),
        MovieShowingProperties(R.drawable.avengers, R.drawable.five_star_rating, "The Avengers", "Adventure/Action", "2hr 23min", "PG-13")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_movies_now_showing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        updateRecycler()
        println("Got here to MoviesNowShowing ")

    }

    private fun updateRecycler(){
        println("Count is ${listOfMovieProperties.count()}")
        movieList.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        movieList.adapter = MoviesNowShowingAdapter(listOfMovieProperties)

    }
}
