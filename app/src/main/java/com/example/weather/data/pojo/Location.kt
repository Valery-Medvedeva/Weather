package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("localtime")
    val time : String,
    @SerializedName("name")
    val city: String
)
