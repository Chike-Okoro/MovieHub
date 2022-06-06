package com.example.starmoviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstproject.viewmodel.observeChange
import com.example.starmoviehub.model.response.Result
import com.example.starmoviehub.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
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
