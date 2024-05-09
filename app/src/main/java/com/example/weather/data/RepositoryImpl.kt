package com.example.weather.data

import com.example.weather.data.pojo.WeatherResponse
import com.example.weather.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api:ApiService):Repository {

    override suspend fun loadInfo():WeatherResponse {
        return api.getResponse()
    }
}