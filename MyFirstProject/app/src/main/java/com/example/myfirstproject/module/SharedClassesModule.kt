package com.example.myfirstproject.module

import com.amazonaws.auth.BasicAWSCredentials
import com.example.myfirstproject.database.PaperPrefs
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val sharedclassmodule = module {

    single { PaperPrefs(androidApplication()) }

}
