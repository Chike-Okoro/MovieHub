package com.example.starmoviehub.viewmodel

import android.content.Context
import androidx.lifecycle.asLiveData
import com.example.myfirstproject.utils.SingleLiveEvent
import com.example.myfirstproject.viewmodel.BaseViewModel
import com.example.starmoviehub.model.request.GetPopularMoviesRequest
import com.example.starmoviehub.model.response.GetPopularMoviesResponse
import com.example.starmoviehub.repository.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository): BaseViewModel() {
    val getPopularMoviesResponse = SingleLiveEvent<GetPopularMoviesResponse>()

    fun getPopularMoviesApi(){
        val request = GetPopularMoviesRequest("45e13e0e00163bcdf33d85f81e9f55fc")
        apiRequest(request, movieRepository::getPopularMovies, getPopularMoviesResponse, {it.status_message ?: ""})
    }

    fun getPopularMoviesFromDb() = movieRepository.getAllMovies().asLiveData()
}