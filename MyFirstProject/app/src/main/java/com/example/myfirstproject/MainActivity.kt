package com.example.myfirstproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.example.myfirstproject.ui.base.BaseActivity
import com.example.myfirstproject.ui.base.BaseFragment
import com.example.myfirstproject.ui.base.SplashScreenFragment
import com.example.myfirstproject.ui.fragments.DashboardFragment
import com.example.myfirstproject.ui.fragments.LoginFragment
import com.example.myfirstproject.ui.fragments.MoviesNowShowing
import com.example.myfirstproject.viewmodel.TestViewModel
import com.google.android.material.tabs.TabLayoutMediator
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavLogger
import com.ncapdevi.fragnav.FragNavTransactionOptions
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movies_now_showing.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : BaseActivity() {
    var tabTitle = arrayOf("Now Showing", "Coming Soon")
    lateinit var rootFragments:List<BaseFragment>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        intFragNav()


    }





    private fun intFragNav() {
        rootFragments = listOf(
        DashboardFragment()
        )
        initFragNavController(this,rootFragments,"MAIN ACTIVITY",supportFragmentManager,R.id.content)
    }





}