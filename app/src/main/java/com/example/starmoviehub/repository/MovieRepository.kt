package com.example.starmoviehub.repository


import com.example.myfirstproject.network.MyFirstProjectApi
import com.example.myfirstproject.repository.BaseRepository
import com.example.myfirstproject.utils.UseCaseResult
import com.example.starmoviehub.database.datasource.MoviesDataSource
import com.example.starmoviehub.model.request.GetPopularMoviesRequest
import com.example.starmoviehub.model.response.GetPopularMoviesResponse
import com.example.starmoviehub.model.response.Result
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies(request: GetPopularMoviesRequest): UseCaseResult<GetPopularMoviesResponse>
    fun getAllMovies(): Flow<List<Result>>
}

class MovieRepositoryImpl(private val movieApi: MyFirstProjectApi, private val moviesDataSource: MoviesDataSource): BaseRepository(), MovieRepository{
    override suspend fun getPopularMovies(request: GetPopularMoviesRequest): UseCaseResult<GetPopularMoviesResponse> {
        val apiRequest = movieApi.getPopularMovies(request.apiKey)
        return safeGetApiCall(apiRequest, { it.status_code == null && it.status_message == null }, this::updateMovieList)
    }

    override fun getAllMovies(): Flow<List<Result>> {
      return  moviesDataSource.getAllMovies()
    }

     suspend fun updateMovieList(getPopularMoviesResponse: GetPopularMoviesResponse){
        getPopularMoviesResponse.results?.let {
            moviesDataSource.updateAll(it)
        }
    }
}

