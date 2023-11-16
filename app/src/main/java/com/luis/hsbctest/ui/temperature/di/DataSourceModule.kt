package com.luis.hsbctest.ui.temperature.di

import com.luis.hsbctest.ui.temperature.data.getTemperature.TemperatureRepositoryImpl
import com.luis.hsbctest.ui.temperature.data.getTemperature.dataSource.TemperatureDataSource
import com.luis.hsbctest.ui.temperature.data.getTemperature.dataSource.TemperatureDataSourceImpl
import com.luis.hsbctest.ui.temperature.domain.repository.TemperatureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindTemperatureDataSourceImpl(
        temperatureDataSourceImpl: TemperatureDataSourceImpl
    ): TemperatureDataSource

    @Binds
    abstract fun bindTemperatureRepositoryImpl(
        temperatureRepositoryImpl: TemperatureRepositoryImpl
    ): TemperatureRepository
}