package com.example.myfirstproject.repository

import com.example.myfirstproject.utils.UseCaseResult
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import retrofit2.HttpException
import timber.log.Timber

open class BaseRepository {

    suspend inline fun <reified T:Any> safeGetApiCall( mResponse:Deferred<T>, checkIfSuccessful:(T)->Boolean, onSuccessOperations: suspend (response:T)->Unit): UseCaseResult<T> {
        return try {
            val response = mResponse.await()
            if(checkIfSuccessful(response)){
                try {
                    onSuccessOperations(response)
                }catch (ex:Exception){
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            }else{
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex:Exception){
            when(ex){
                is HttpException -> {
                    try {
                        Timber.e(ex)
                        val body = ex.response()?.errorBody()
                        val errorJson = Gson().fromJson(body?.string() ?: "", T::class.java)
                        UseCaseResult.FailedAPI(errorJson)
                    }catch (ex:java.lang.Exception){
                        Timber.e(ex)
                        UseCaseResult.Error(ex)
                    }
                }
                else -> {
                    Timber.e(ex)
                    UseCaseResult.Error(ex)
                }
            }

        }
    }



    suspend fun <R:Any,T:Any> safePostApiCall(request: R,apiCall: (request:R) ->Deferred<T>, checkIfSuccessful:(T)->Boolean, onSuccessOperations:suspend (response:T)->Unit): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if(checkIfSuccessful(response)){
                try {
                    onSuccessOperations(response)
                }catch (ex:Exception){
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            }else{
                UseCaseResult.FailedAPI(response)
            }
        }catch (ex:Exception){
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }
}