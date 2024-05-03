package com.example.weather.data.pojo

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    val temp_c: Int,
    @SerializedName("condition")
    val condition: Condition
)
