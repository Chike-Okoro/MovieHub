package com.example.myfirstproject.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstproject.MyAdapter
import com.example.myfirstproject.R
import com.example.myfirstproject.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_movies_now_showing.*



class DashboardFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
    }





    @SuppressLint("ResourceAsColor")
    fun setViewPager(){

        star.setOnClickListener {
            mFragmentNavigation.pushFragment(ImageFragment())
        }
//        tabLayout.addTab(tabLayout.newTab().setText("Now showing"))
//        tabLayout.addTab(tabLayout.newTab().setText("Coming Soon"))
//        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
//
//        val pagerAdapter = MyAdapter(childFragmentManager)
//        pagerAdapter.addFragment(MoviesNowShowing(), "Now Showing")
//        pagerAdapter.addFragment(ComingSoonFragment(), "Coming Soon")
//        viewPager.apply {
//            adapter = pagerAdapter
//            setBackgroundColor(R.color.movieBgColor)
//        }
//
//        tabLayout.setupWithViewPager(viewPager)

        val pagerAdapter = MyAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager){tab, position ->

            when(position){
                0 -> {
                    tab.text = "Now Showing"
                    println("Showing Tab 1")
                }

                1 -> {
                    tab.text = "Coming Soon"
                    println("Showing Tab 2")


                }
            }

        }.attach()

}
}