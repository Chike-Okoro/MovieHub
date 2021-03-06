package com.example.myfirstproject.module

import android.app.Application
//import com.example.myfirstproject.database.PaperPrefs
import com.example.myfirstproject.network.MyFirstProjectApi
import com.example.myfirstproject.utils.Utils
import com.example.starmoviehub.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val MOVIESAPIBASEURL = "https://api.themoviedb.org/3/movie/"

val networkModule = module {
    single { createWebService<MyFirstProjectApi>(RxJava2CallAdapterFactory.create(), MOVIESAPIBASEURL) }
}
/* function to build our Retrofit service */
inline fun <reified T> createWebService(
    factory: CallAdapter.Factory, baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient())
        .build()
    return retrofit.create(T::class.java)
}

fun okHttpClient() = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor())
    .readTimeout(5, TimeUnit.MINUTES)
    .connectTimeout(  5, TimeUnit.MINUTES)
    .writeTimeout(5, TimeUnit.MINUTES)
    .build()

fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
}

fun headersInterceptor() = Interceptor { chain ->
    chain.proceed(chain.request().newBuilder()
        .addHeader("Content-Type", "application/json")
        .build())
}