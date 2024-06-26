package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    val currentTemp: Double,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("last_updated")
    val lastUpdate: String
)
