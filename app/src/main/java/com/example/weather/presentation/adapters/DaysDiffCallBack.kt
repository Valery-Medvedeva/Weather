package com.example.weather.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.weather.data.pojo.OneDay


class DaysDiffCallBack:DiffUtil.ItemCallback<OneDay>() {
    override fun areItemsTheSame(oldItem: OneDay, newItem: OneDay): Boolean {
        return oldItem==newItem
    }
    override fun areContentsTheSame(oldItem: OneDay, newItem: OneDay): Boolean {
        return oldItem==newItem
    }
}
