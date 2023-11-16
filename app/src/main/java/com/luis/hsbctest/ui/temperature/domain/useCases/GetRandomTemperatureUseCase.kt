package com.luis.hsbctest.ui.temperature.domain.useCases

import com.luis.hsbctest.ui.temperature.domain.model.DataModel
import com.luis.hsbctest.ui.temperature.domain.repository.TemperatureRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetRandomTemperatureUseCase @Inject constructor(
    private val temperatureRepository: TemperatureRepository
) {
    suspend operator fun invoke(): DataModel? {
        delay(1000)
        return temperatureRepository.getTemperature()?.dataTemperature?.random()
    }
}