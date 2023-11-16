package com.luis.hsbctest.ui.temperature.data.network.response

import com.luis.hsbctest.ui.temperature.domain.model.DataModel
import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel

data class TemperatureResponse(
    val temperature: Temperature
) {
    fun mapper(): TemperatureModel {
        val dataTemperature: MutableList<DataModel> = mutableListOf()
        temperature.data.map {
            dataTemperature.add(DataModel(it.place, it.unit, it.value))
        }

        return TemperatureModel(dataTemperature)
    }
}