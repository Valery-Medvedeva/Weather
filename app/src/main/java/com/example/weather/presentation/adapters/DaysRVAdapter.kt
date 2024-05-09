package com.example.weather.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weather.R
import com.example.weather.data.pojo.Forecast
import com.example.weather.data.pojo.OneDay

class DaysRVAdapter: ListAdapter<OneDay, DaysViewHolder>(DaysDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        val item=getItem(position)
        holder.date.text=item.date
        val maxTemp=item.day.maxTemp.toString()
        val minTemp=item.day.minTemp.toString()
        holder.maxMinTemperature.text=String.format("%s%s/%s%s",minTemp,"°",maxTemp,"°")
        holder.condition.text=item.hours[position].condition.conditionText
        Glide.with(holder.itemView).load("https:"+item.hours[position].condition.imageUrl)
            .into(holder.image)
    }
}