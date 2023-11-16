package com.luis.hsbctest.ui.temperature.data.network

import com.luis.hsbctest.ui.temperature.data.motherObject.TemperatureMotherObject
import io.kotlintest.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.system.measureTimeMillis

class TemperatureApiServiceImplTest {

    @ExperimentalCoroutinesApi
    @Test
    fun `the getTemperature method should parse the JSON`() = runTest {
        //Given
        val json = TemperatureMotherObject.json
        val anyTemperatureApiService = TemperatureMotherObject.anyTemperatureApiService

        //When
        val totalExecutionTime = measureTimeMillis {
            val temperatureResponse = anyTemperatureApiService.getTemperature(json)

            //Then
            temperatureResponse.temperature.data[0].place shouldBe "Kings Park"
            temperatureResponse.temperature.data[0].value shouldBe 25
            temperatureResponse.temperature.data[0].unit shouldBe "C"
        }
        print("Total Execution Time: $totalExecutionTime")
    }
}