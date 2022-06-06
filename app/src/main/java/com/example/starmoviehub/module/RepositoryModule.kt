package com.example.myfirstproject.module

//import com.example.myfirstproject.repository.TestRepository
//import com.example.myfirstproject.repository.TestRepositoryImpl
import com.example.starmoviehub.repository.MovieRepository
import com.example.starmoviehub.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
//    single<TestRepository> { TestRepositoryImpl(myFirstProjectApi = get()) }
    single<MovieRepository> {MovieRepositoryImpl(movieApi = get(), moviesDataSource = get())  }

}