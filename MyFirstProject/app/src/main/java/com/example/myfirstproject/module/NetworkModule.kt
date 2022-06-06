package com.example.myfirstproject.module

import android.app.Application
import androidx.multidex.BuildConfig
import com.example.myfirstproject.database.PaperPrefs
import com.example.myfirstproject.network.MyFirstProjectApi
import com.example.myfirstproject.utils.Utils
import com.example.myfirstproject.utils.getStringPref
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


const val BASEURL = "https://q5oe4x5q66.execute-api.us-east-1.amazonaws.com/v1/dev/"
val networkModule = module {
    single { createWebService<MyFirstProjectApi>(RxJava2CallAdapterFactory.create(), BASEURL,  get()) }
}

inline fun <reified T> createWebService(
    factory: CallAdapter.Factory, baseUrl: String, paperPrefs: PaperPrefs
): T {

    println("Got here")

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient(paperPrefs))
        .build()
    return retrofit.create(T::class.java)
}


fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

}




fun okHttpClient(paperPrefs: PaperPrefs) =
    OkHttpClient.Builder()
        .addInterceptor(headersInterceptor(paperPrefs))
        .addInterceptor(loggingInterceptor())
        .readTimeout(5, TimeUnit.MINUTES)
        .connectTimeout(  5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)
        .build()

fun headersInterceptor(paperPrefs: PaperPrefs) = Interceptor { chain ->
    chain.proceed(chain.request().newBuilder()
        .addHeader("Content-Type", "application/json")
        .addHeader("Authorization",paperPrefs.getStringPref(PaperPrefs.AUTH))
        //.addHeader("Authorization","Bearer ${paperPrefs.getStringPref(PaperPrefs.AUTH)}")
        .build())
}