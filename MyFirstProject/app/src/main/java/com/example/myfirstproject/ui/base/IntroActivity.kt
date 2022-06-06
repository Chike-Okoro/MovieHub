package com.example.myfirstproject.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.myfirstproject.R
import com.ncapdevi.fragnav.FragNavController

class IntroActivity : BaseActivity() {
    val baseFragment = lazy {
        listOf<BaseFragment>(SplashScreenFragment())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()



        initFragNavController(this, baseFragment.value, TAG, supportFragmentManager, R.id.content)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }




    companion object {
        val TAG = "Intro Activity"
    }
}