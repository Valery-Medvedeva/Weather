package com.example.weather.data

import com.example.weather.API_KEY
import com.example.weather.data.pojo.WeatherResponse
import retrofit2.http.GET

interface ApiService {

    @GET("forecast.json?key=${API_KEY}&q=Moscow&days=3&aqi=no&alerts=no")
    suspend fun getResponse(): WeatherResponse


}