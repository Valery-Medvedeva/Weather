package com.example.weather.domain

import com.example.weather.data.pojo.WeatherResponse

interface Repository {
    suspend fun loadInfo():WeatherResponse
}