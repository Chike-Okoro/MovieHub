package com.example.myfirstproject.viewmodel

import androidx.lifecycle.*
import com.example.myfirstproject.utils.SingleLiveEvent
import com.example.myfirstproject.utils.UseCaseResult
import com.qucoon.robertoagency.utils.handleException
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel(), CoroutineScope,LifecycleObserver {
    // Coroutine's background job
    private val job = Job()
    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val showLoading = MutableLiveData<Boolean>()
    val showError = SingleLiveEvent<String>()
    val showSessionTimeOut= SingleLiveEvent<String>()
    override fun onCleared() {
        super.onCleared()
        // Clear our job when the linked activity is destroyed to avoid memory leaks
        job.cancel()
    }
    fun <R:Any,T:Any> apiRequest(request:R, apiCall:suspend (request:R)-> UseCaseResult<T>, observer:SingleLiveEvent<T>, getError:(response:T) -> String){
        showLoading.value = true
        launch {
            val response = withContext(IO){
                apiCall(request)
            }
            showLoading.value = false
            when(response){
                is UseCaseResult.Success -> observer.value = response.data
                is UseCaseResult.FailedAPI -> showError.value = getError(response.data)
                is UseCaseResult.Error -> showError.value = response.exception.handleException()
            }
        }
    }
    fun <R:Any,T:Any> apiRequest(request:R, apiCall:suspend (request:R)-> UseCaseResult<T>, observer:SingleLiveEvent<T>, getError:(response:T) -> String,
                                 onSuccessOperations:(response:T)->Unit){
        showLoading.value = true
        launch {
            val response = withContext(IO){apiCall(request)}
            showLoading.value = false
            when(response){
                is UseCaseResult.Success -> {
                    observer.value = response.data
                    onSuccessOperations(response.data)
                }
                is UseCaseResult.FailedAPI -> showError.value = getError(response.data)
                is UseCaseResult.Error -> showError.value = response.exception.handleException()
            }
        }
    }
}


fun <T> SingleLiveEvent<T>.observeUnit(owner: LifecycleOwner, action:(T?)->Unit){
    this.observe(owner, Observer { action(it) })
}

fun <T> SingleLiveEvent<T>.observeChange(owner: LifecycleOwner,action:(T)->Unit){
    this.observe(owner, Observer { action(it) })
}
fun <T> LiveData<T>.observeChange(owner: LifecycleOwner, action:(T)->Unit){
    this.observe(owner, Observer { action(it) })
}
fun <T> MutableLiveData<T>.observeChange(owner: LifecycleOwner, action:(T)->Unit){
    this.observe(owner, Observer { action(it) })
}