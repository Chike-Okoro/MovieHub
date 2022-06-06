package com.example.myfirstproject.ui.base

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstproject.MainActivity
import com.example.myfirstproject.R
import com.example.myfirstproject.ui.fragments.MoviesNowShowing


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            val intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)

        }, 3000)

    }


}