package com.luis.hsbctest.ui.temperature.domain.useCases

import com.luis.hsbctest.ui.temperature.data.motherObject.TemperatureMotherObject
import com.luis.hsbctest.ui.temperature.domain.repository.TemperatureRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.system.measureTimeMillis

class GetRandomTemperatureUseCaseTest {

    @MockK
    lateinit var temperatureRepository: TemperatureRepository

    private lateinit var getRandomTemperatureUseCase: GetRandomTemperatureUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `the invoke method should return a DataModel object from TemperatureModel list`() =
        runTest {
            //Given
            getRandomTemperatureUseCase = GetRandomTemperatureUseCase(temperatureRepository)

            //When
            val totalExecutionTime = measureTimeMillis {
                coEvery { temperatureRepository.getTemperature() } returns TemperatureMotherObject.temperatureModel
                val dataModel = getRandomTemperatureUseCase.invoke()

                assert(TemperatureMotherObject.temperatureModel.dataTemperature.contains(dataModel))
            }
            print("Total Execution Time: $totalExecutionTime")
        }
}