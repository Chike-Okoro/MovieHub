package com.example.yharrnlimited

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
        val notificationList = listOf(Notification("30,000", "18th May 2022"),
            Notification("70,000", "25th November 2021 "),
            Notification("80,000", "14th March 2020"),
            Notification("70,000", "25th November 2021 "),
            Notification("80,000", "25th November 2021 "),
            Notification("90,000", "25th November 2021 "),
            Notification("90,000", "25th November 2021 "),
            Notification("90,000", "25th November 2021 ")
        )

        receivedEarnings.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        receivedEarnings.adapter = NotificationsAdapter(notificationList)
    }
}