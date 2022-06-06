package com.example.myfirstproject.module

//import com.example.myfirstproject.repository.TestRepository
//import com.example.myfirstproject.repository.TestRepositoryImpl
import com.example.starmoviehub.viewmodel.MoviesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { TestViewModel(testRepository = get(), context = get()) }
    viewModel { MoviesViewModel(movieRepository = get()) }
}