package com.example.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.presentation.adapters.HoursRVAdapter
import com.example.weather.data.pojo.WeatherResponse
import com.example.weather.domain.LoadWeatherInfoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val loadWeatherInfoUseCase: LoadWeatherInfoUseCase
) : ViewModel() {

    private val _weatherInfo=MutableLiveData<WeatherResponse>()
    val weatherInfo:LiveData<WeatherResponse>
        get() = _weatherInfo

    fun loadWeatherInfo(){
        val loading=viewModelScope.async {
            loadWeatherInfoUseCase.invoke()
        }
       viewModelScope.launch {
           _weatherInfo.value=loading.await()
        }
    }
}