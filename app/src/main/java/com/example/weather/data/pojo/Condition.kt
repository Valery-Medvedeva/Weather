package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("text")
    val conditionText: String,
    @SerializedName("icon")
    val imageUrl: String
)
