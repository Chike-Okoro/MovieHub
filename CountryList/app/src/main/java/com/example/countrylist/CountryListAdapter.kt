package com.example.countrylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_of_countries.view.*

class CountryListAdapter(
    private val countryList: List<CountryList>
) : RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {

    class CountryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        return CountryListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_of_countries, parent, false))
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val currentList = countryList[position]
        holder.itemView.apply {
            country_text.text = currentList.country
            canada_flag.setImageResource(currentList.image)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

}