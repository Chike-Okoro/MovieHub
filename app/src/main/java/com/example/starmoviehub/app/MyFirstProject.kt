package com.example.myfirstproject.app


import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.example.myfirstproject.module.networkModule
import com.example.myfirstproject.module.repoModule
import com.example.myfirstproject.module.sharedclassmodule
import com.example.myfirstproject.module.viewModelModule
import com.example.starmoviehub.module.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyFirstProject: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            androidContext(this@MyFirstProject)
            modules(listOf(networkModule, repoModule, viewModelModule, dbModule))
        }

    }

     private fun initTimber() {
         if(BuildConfig.DEBUG){
             Timber.plant(Timber.DebugTree())
         }
     }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}