package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Hour(
    @SerializedName("time")
    val time: String,
    @SerializedName("temp_c")
    val temp: Double,
    @SerializedName("condition")
    val condition: Condition
)
