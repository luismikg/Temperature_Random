package com.luis.hsbctest.ui.temperature.di

import com.luis.hsbctest.ui.temperature.data.network.TemperatureApiService
import com.luis.hsbctest.ui.temperature.data.network.TemperatureApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providerTemperatureApiService(): TemperatureApiService {
        return TemperatureApiServiceImpl()
    }
}