package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Forecast (
    @SerializedName("forecastday")
    val forecastday:List<OneDay>
)