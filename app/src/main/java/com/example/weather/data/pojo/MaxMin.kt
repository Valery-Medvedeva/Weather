package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class MaxMin(
    @SerializedName("maxtemp_c")
    val maxTemp: Double,
    @SerializedName("mintemp_c")
    val minTemp: Double
)
