package com.abdullojon.memorygame.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdullojon.memorygame.R

class InfoAdapter(private val list: List<String>) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    inner class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_info_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false)
        return InfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item

        if (position % 2 == 0) {
            holder.textView.setTypeface(null, Typeface.BOLD)
            holder.textView.textSize = 22f
        } else {
            holder.textView.setTypeface(null, Typeface.NORMAL)
            holder.textView.textSize = 17f
        }
    }

    override fun getItemCount(): Int = list.size
}