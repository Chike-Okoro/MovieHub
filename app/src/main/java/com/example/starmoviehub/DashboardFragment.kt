package com.example.starmoviehub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstproject.database.PaperPrefs
import com.example.myfirstproject.viewmodel.observeChange
import com.example.starmoviehub.model.response.Result
import com.example.starmoviehub.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DashboardFragment : BaseFragment(), MovieAdapter.OnItemClickListener {
    private val movieViewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers(movieViewModel)
        movieViewModel.getPopularMoviesApi()
        movieViewModel.getPopularMoviesResponse.observeChange(this){
            println("api sucess ")
        }
        movieViewModel.getPopularMoviesFromDb().observeChange(viewLifecycleOwner){
            updateRecycler(it)
        }
    }

    fun updateRecycler(listOfMovieProperties: List<Result>){
        println("Count is ${listOfMovieProperties.count()}")
        movieDisplay.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        movieDisplay.adapter = MovieAdapter(listOfMovieProperties, this)
    }

    override fun onItemClick(movie: Result) {
        println("Fragment Pushed!")
        mFragmentNavigation.pushFragment(MovieDetailsFragment().newInstance(movie.title, movie.release_date, movie.overview, movie.backdrop_path))
    }


}