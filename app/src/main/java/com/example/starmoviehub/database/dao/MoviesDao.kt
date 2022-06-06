package com.example.starmoviehub.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.starmoviehub.base.BaseDao
import com.example.starmoviehub.model.response.Result
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao: BaseDao<Result> {
    @Query("Select * from result")
    fun getAllMovies():Flow<List<Result>>



    @Query("DELETE FROM result")
    fun deleteAllMovie()


    @Transaction
     fun updateMovies(movie: List<Result>){
        deleteAllMovie()
        insertAll(movie)
    }

}

