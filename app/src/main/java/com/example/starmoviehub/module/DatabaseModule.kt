package com.example.starmoviehub.module

import androidx.room.Room
import com.example.myfirstproject.database.PaperPrefs
import com.example.starmoviehub.database.datasource.MoviesDataSource
import com.example.starmoviehub.database.datasource.MoviesDataSourceImpl
import com.example.starmoviehub.database.room.MoviesRoomDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import org.koin.dsl.single
import kotlin.math.sin

val dbModule = module{
    single { PaperPrefs(androidApplication()) }

    single { Room.databaseBuilder(androidApplication(), MoviesRoomDatabase::class.java, "movies-db").
    fallbackToDestructiveMigration().build() }

    //Dao
    val createAtStart = false
    single(createdAtStart = createAtStart) {get<MoviesRoomDatabase>().moviesDao()}
    single<MoviesDataSource> { MoviesDataSourceImpl(moviesDao = get()) }

}