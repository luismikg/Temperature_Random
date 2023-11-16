package com.luis.hsbctest.ui.temperature.data.getTemperature.dataSource

import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel

interface TemperatureDataSource {
    suspend fun getData(): TemperatureModel?
}