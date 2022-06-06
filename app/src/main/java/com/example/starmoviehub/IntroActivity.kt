package com.example.starmoviehub

import android.content.Intent
import android.os.Bundle

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