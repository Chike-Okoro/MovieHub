//package com.example.myfirstproject.viewmodel
//
//import android.content.Context
//import com.example.myfirstproject.model.request.LoginRequest
//import com.example.myfirstproject.model.response.LoginResponse
//import com.example.myfirstproject.repository.TestRepository
//import com.example.myfirstproject.utils.Constants
//import com.example.myfirstproject.utils.SingleLiveEvent
//import com.example.myfirstproject.utils.Utils
//
//class TestViewModel(private val testRepository: TestRepository, private val context: Context): BaseViewModel() {
//    val loginResponse = SingleLiveEvent<LoginResponse>()
//
//
//    fun login(password: String, username: String){
//        println("LoginViewModel")
//        val request = LoginRequest(username, password )
//        apiRequest(request, testRepository::login, loginResponse, {it.responsemessage})
//    }
//
//
//
//}