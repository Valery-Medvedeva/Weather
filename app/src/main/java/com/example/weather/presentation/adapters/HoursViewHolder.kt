package com.example.weather.presentation.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ListItemBinding

class HoursViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val binding=ListItemBinding.bind(view)
    val date=binding.tvDateInItem
    val currentTemperature=binding.tvCurrentTemperature
    val condition=binding.tvConditionInItem
    val image=binding.imageViewCondition
}
