package com.example.yharrnlimited

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.earnings_received.view.*

class NotificationsAdapter (
    private val notifications: List<Notification>
) : RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>() {

    class NotificationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        return NotificationsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.earnings_received, parent, false))
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
        val curnotes = notifications[position]
        holder.itemView.apply {
            date_received.text = curnotes.date
            amount_received.text = curnotes.amount.toString()
        }
    }

    override fun getItemCount(): Int {
       return notifications.size
    }
}