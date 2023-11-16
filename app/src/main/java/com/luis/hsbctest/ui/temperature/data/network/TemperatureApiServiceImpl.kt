package com.luis.hsbctest.ui.temperature.data.network

import com.google.gson.Gson
import com.luis.hsbctest.ui.temperature.data.network.response.TemperatureResponse

class TemperatureApiServiceImpl : TemperatureApiService {

    override suspend fun getTemperature(json: String): TemperatureResponse {
        return Gson().fromJson(json, TemperatureResponse::class.java)
    }
}