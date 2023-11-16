package com.luis.hsbctest.ui.temperature.data.motherObject

import com.luis.hsbctest.ui.temperature.data.network.TemperatureApiService
import com.luis.hsbctest.ui.temperature.data.network.TemperatureApiServiceImpl
import com.luis.hsbctest.ui.temperature.data.network.response.Data
import com.luis.hsbctest.ui.temperature.domain.model.DataModel
import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel

object TemperatureMotherObject {


    val dataResponse = Data(
        place = "England",
        unit = "F",
        value = 30
    )

    private val dataModel = DataModel(
        place = "England",
        unit = "F",
        value = 30
    )

    val anyTemperatureApiService: TemperatureApiService = TemperatureApiServiceImpl()
    val temperatureModel = TemperatureModel(
        listOf(
            dataModel, dataModel.copy(
                place = "Hong Kong",
                unit = "C",
                value = 10
            )
        )
    )


    val json = "{\n" +
            "  \"temperature\": {\n" +
            "    \"data\": [\n" +
            "      {\n" +
            "        \"place\": \"Kings Park\",\n" +
            "        \"value\": 25,\n" +
            "        \"unit\": \"C\"\n" +
            "      }],\n" +
            "    \"recordTime\": \"2023-11-09T17:00:00+08:00\"\n" +
            "  }\n" +
            "}"
}