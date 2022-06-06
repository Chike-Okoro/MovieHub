package com.example.myfirstproject.repository

import com.example.myfirstproject.model.request.LoginRequest
import com.example.myfirstproject.model.response.LoginResponse
import com.example.myfirstproject.network.MyFirstProjectApi
import com.example.myfirstproject.utils.UseCaseResult

interface TestRepository{
   suspend fun login(loginRequest: LoginRequest): UseCaseResult<LoginResponse>
}

class TestRepositoryImpl(private val myFirstProjectApi: MyFirstProjectApi): BaseRepository(), TestRepository{
    override suspend fun login(loginRequest: LoginRequest): UseCaseResult<LoginResponse> {
       return safeApiCall(loginRequest, myFirstProjectApi::login) { it.responsecode == "00" }
    }

}