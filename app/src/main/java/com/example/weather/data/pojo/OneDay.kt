package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class OneDay(
    @SerializedName("day")
    val day: Day,
    @SerializedName("hour")
    val hours: List<Hour>,
    @SerializedName("date")
    val date: String
)
