package com.example.starmoviehub.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.starmoviehub.converters.ListConverter
import com.example.starmoviehub.database.dao.MoviesDao
import com.example.starmoviehub.model.response.GetPopularMoviesResponse
import com.example.starmoviehub.model.response.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)

abstract class MoviesRoomDatabase: RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}