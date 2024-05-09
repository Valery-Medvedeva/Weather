package com.example.weather.di

import android.app.Application
import com.example.weather.MyApplication
import com.example.weather.presentation.fragments.DaysFragment
import com.example.weather.presentation.fragments.HoursFragment
import com.example.weather.presentation.fragments.MainFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface MyComponent {

    fun inject(fragment: MainFragment)
    fun inject(fragment: DaysFragment)
    fun inject(fragment: HoursFragment)
    @Component.Factory
    interface AppFactory {
        fun create(@BindsInstance application: Application): MyComponent
    }
}