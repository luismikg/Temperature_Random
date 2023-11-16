package com.luis.hsbctest.ui.temperature.data.network.response

data class Temperature(
    val `data`: List<Data>,
    val recordTime: String
)