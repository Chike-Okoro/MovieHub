package com.example.myfirstproject.model.request


data class LoginRequest(
    val email: String,
    val password: String,val source:String = "MOBILE"
)