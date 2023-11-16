package com.luis.hsbctest.ui.temperature.domain.repository

import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel

interface TemperatureRepository {

    suspend fun getTemperature(): TemperatureModel?
}