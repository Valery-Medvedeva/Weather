package com.example.weather.di

import com.example.weather.BASE_URL
import com.example.weather.data.ApiService
import com.example.weather.data.RepositoryImpl
import com.example.weather.domain.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {
    @AppScope
    @Provides
    fun provideApiService(): ApiService {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        return api
    }

    @Provides
    fun provideRepository(api: ApiService): Repository {
        return RepositoryImpl(api)
    }
}