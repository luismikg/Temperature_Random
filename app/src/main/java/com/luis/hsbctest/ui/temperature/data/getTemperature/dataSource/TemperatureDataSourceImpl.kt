package com.luis.hsbctest.ui.temperature.data.getTemperature.dataSource

import android.util.Log
import com.luis.hsbctest.ui.temperature.data.network.TemperatureApiService
import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel
import javax.inject.Inject

class TemperatureDataSourceImpl @Inject constructor(
    private val temperatureApiService: TemperatureApiService
) : TemperatureDataSource {

    override suspend fun getData(): TemperatureModel? {
        runCatching { temperatureApiService.getTemperature() }
            .onSuccess { return it.mapper() }
            .onFailure {
                Log.e("Error", "In ${TemperatureDataSourceImpl::class.java.name}: ${it.message}")
            }
        return null
    }
}