package com.example.weather.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.weather.data.pojo.Hour


class HoursDiffCallBack:DiffUtil.ItemCallback<Hour>() {
    override fun areItemsTheSame(oldItem: Hour, newItem: Hour): Boolean {
        return oldItem==newItem
    }
    override fun areContentsTheSame(oldItem: Hour, newItem: Hour): Boolean {
        return oldItem==newItem
    }
}
