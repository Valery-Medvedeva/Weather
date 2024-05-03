package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("localtime")
    val localtime : String,
    @SerializedName("name")
    val name: String
)
