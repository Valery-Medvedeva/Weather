package com.example.weather.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weather.R
import com.example.weather.data.pojo.Hour

class HoursRVAdapter:ListAdapter<Hour, HoursViewHolder>(HoursDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return HoursViewHolder(view)
    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        val item=getItem(position)
        holder.date.text=item.time
        holder.condition.text=item.condition.conditionText
        holder.currentTemperature.text=String.format("%s%s",item.temp.toString(),"°")
        Glide.with(holder.itemView).load("https:"+item.condition.imageUrl)
            .into(holder.image)
    }
}