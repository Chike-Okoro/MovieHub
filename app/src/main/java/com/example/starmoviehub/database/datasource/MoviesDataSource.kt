package com.example.starmoviehub.database.datasource

import com.example.starmoviehub.database.dao.MoviesDao
import com.example.starmoviehub.model.response.Result
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface MoviesDataSource {
    fun getAllMovies(): Flow<List<Result>>
    suspend fun updateAll(listOfData:List<Result>)
}

class MoviesDataSourceImpl(private val moviesDao: MoviesDao):MoviesDataSource{
    override fun getAllMovies(): Flow<List<Result>> {
        return moviesDao.getAllMovies()
    }

    override suspend fun updateAll(listOfData: List<Result>) {
        withContext(IO){
            moviesDao.updateMovies(listOfData)
        }

    }

}