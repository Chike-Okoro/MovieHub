package com.example.myfirstproject.network

import com.example.myfirstproject.model.request.LoginRequest
import com.example.myfirstproject.model.response.LoginResponse
import com.example.starmoviehub.model.response.GetPopularMoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyFirstProjectApi {
    @POST("login")
    fun login(@Body params: LoginRequest): Deferred<LoginResponse>

    @GET("popular")
    fun getPopularMovies(@Query("api_key") api_key: String): Deferred<GetPopularMoviesResponse>
}