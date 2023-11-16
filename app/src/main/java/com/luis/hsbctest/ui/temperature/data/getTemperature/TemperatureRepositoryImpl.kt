package com.luis.hsbctest.ui.temperature.data.getTemperature

import com.luis.hsbctest.ui.temperature.data.getTemperature.dataSource.TemperatureDataSource
import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel
import com.luis.hsbctest.ui.temperature.domain.repository.TemperatureRepository
import javax.inject.Inject

class TemperatureRepositoryImpl @Inject constructor(
    private val temperatureDataSource: TemperatureDataSource
) : TemperatureRepository {

    override suspend fun getTemperature(): TemperatureModel? {
        return temperatureDataSource.getData()
    }
}