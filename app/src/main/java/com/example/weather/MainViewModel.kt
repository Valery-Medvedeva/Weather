package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val current=MutableLiveData<String>()
    val list=MutableLiveData<List<String>>()
    val picCurrent=MutableLiveData<String>()
}