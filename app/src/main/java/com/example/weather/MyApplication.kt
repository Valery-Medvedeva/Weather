package com.example.weather

import android.app.Application
import com.example.weather.di.DaggerMyComponent

class MyApplication:Application() {

  val component by lazy {
      DaggerMyComponent.factory().create(this)
  }
}