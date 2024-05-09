package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.adapters.HoursRVAdapter
import com.example.weather.data.pojo.WeatherResponse

class MainViewModel: ViewModel() {


    private val hoursRVAdapter=HoursRVAdapter()

    val current=MutableLiveData<WeatherResponse>()
    val list=MutableLiveData<List<WeatherResponse>>()
}