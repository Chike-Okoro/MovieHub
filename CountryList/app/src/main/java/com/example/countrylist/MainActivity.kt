package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateRecycler()
    }

    private fun updateRecycler() {
        val listOfCountries = listOf(CountryList(R.drawable.canadianflag, "Canada"),
            CountryList(R.drawable.nigeria, "Nigeria"),
            CountryList(R.drawable.ghana, "Ghana"),
            CountryList(R.drawable.rwanda, "Rwanda"),)

        countriesAvailable.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        countriesAvailable.adapter = CountryListAdapter(listOfCountries)


    }
}