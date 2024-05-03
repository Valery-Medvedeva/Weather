package com.example.weather.data

import com.example.weather.data.pojo.WeatherResponse
import retrofit2.http.GET

interface ApiService {

    @GET("current.json?key=24cc3ad99cc14ab2ab254556240305&q=Moscow&aqi=no")
    suspend fun getResponse(): WeatherResponse
}