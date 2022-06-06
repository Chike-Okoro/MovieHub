package com.example.myfirstproject.module

import com.example.myfirstproject.repository.TestRepository
import com.example.myfirstproject.repository.TestRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<TestRepository> { TestRepositoryImpl(myFirstProjectApi = get()) }

}