package com.luis.hsbctest.ui.temperature.data.network.response

import com.luis.hsbctest.ui.temperature.data.motherObject.TemperatureMotherObject
import com.luis.hsbctest.ui.temperature.domain.model.TemperatureModel
import io.kotlintest.shouldBe
import org.junit.Test

class TemperatureResponseTest {

    @Test
    fun `mapper should return a correct TemperatureModel`() {
        //Given
        val temperatureResponse =
            TemperatureResponse(
                Temperature(
                    data = listOf<Data>(
                        TemperatureMotherObject.dataResponse,
                        TemperatureMotherObject.dataResponse.copy(
                            place = "Hong Kong",
                            unit = "C",
                            value = 10
                        )
                    ),
                    recordTime = "13:00"
                )
            )

        //When
        val temperatureModel: TemperatureModel = temperatureResponse.mapper()

        //Then
        temperatureModel.dataTemperature[0].place shouldBe temperatureResponse.temperature.data[0].place
        temperatureModel.dataTemperature[0].value shouldBe temperatureResponse.temperature.data[0].value
        temperatureModel.dataTemperature[0].unit shouldBe temperatureResponse.temperature.data[0].unit
        temperatureModel.dataTemperature[1].place shouldBe temperatureResponse.temperature.data[1].place
        temperatureModel.dataTemperature[1].value shouldBe temperatureResponse.temperature.data[1].value
        temperatureModel.dataTemperature[1].unit shouldBe temperatureResponse.temperature.data[1].unit
    }
}