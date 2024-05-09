package com.example.weather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.presentation.adapters.HoursRVAdapter
import com.example.weather.data.pojo.WeatherResponse

class MainViewModel: ViewModel() {


    private val hoursRVAdapter= HoursRVAdapter()

    val current=MutableLiveData<WeatherResponse>()
    val list=MutableLiveData<List<WeatherResponse>>()
}