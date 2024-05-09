package com.example.weather.domain

import com.example.weather.data.pojo.WeatherResponse
import javax.inject.Inject

class LoadWeatherInfoUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(): WeatherResponse{
        return repository.loadInfo()
    }
}