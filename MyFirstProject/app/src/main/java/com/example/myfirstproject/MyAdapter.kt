package com.example.myfirstproject

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfirstproject.ui.fragments.ComingSoonFragment
import com.example.myfirstproject.ui.fragments.DashboardFragment
import com.example.myfirstproject.ui.fragments.MoviesNowShowing
import kotlinx.android.synthetic.main.fragment_movies_now_showing.*

class MyAdapter(fragmentManager: FragmentManager, lifecycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                MoviesNowShowing()
            }

            1 -> {
                ComingSoonFragment()
            }

            else -> {
                DashboardFragment()
            }
        }
    }
}
//class MyAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
//    val fragmentList:MutableList<Fragment> = ArrayList<Fragment>() as MutableList<Fragment>
//    val fragmentTitleList:MutableList<String> = ArrayList<String>()
//
//    override fun getItem(position: Int): Fragment {
//        return fragmentList.get(position)
//    }
//
//    override fun getCount(): Int {
//        return fragmentList.size
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return fragmentTitleList.get(position)
//    }
//
//    fun addFragment(fragment: Fragment, title:String){
//        fragmentList.add(fragment)
//        fragmentTitleList.add(title)
//
//    }
//
//
//}