package com.example.myfirstproject.utils

sealed class UseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class ActivateProfile<out T : Any>(val data: T) : UseCaseResult<T>()
    class DeviceChange<out T : Any>(val data: T) : UseCaseResult<T>()
    class Error(val exception: Throwable) : UseCaseResult<Nothing>()
    class Failed(val errorMessage:String): UseCaseResult<Nothing>()
    class SessionTimeOut(val errorMessage:String): UseCaseResult<Nothing>()
    class FailedAPI<out T : Any>(val data: T): UseCaseResult<T>()
    class LoginUser(): UseCaseResult<Nothing>()
    class FailedData<out T : Any>(val data: T):UseCaseResult<T>()

}
