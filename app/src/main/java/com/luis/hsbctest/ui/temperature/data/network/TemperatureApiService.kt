package com.luis.hsbctest.ui.temperature.data.network

import com.luis.hsbctest.ui.temperature.data.network.response.TemperatureResponse

interface TemperatureApiService {
    suspend fun getTemperature(
        json: String = "{\n" +
                "  \"temperature\": {\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"place\": \"King's Park\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Hong Kong Observatory\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Wong Chuk Hang\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Ta Kwu Ling\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Lau Fau Shan\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tai Po\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Sha Tin\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tuen Mun\",\n" +
                "        \"value\": 27,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tseung Kwan O\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Sai Kung\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Cheung Chau\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Chek Lap Kok\",\n" +
                "        \"value\": 27,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tsing Yi\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Shek Kong\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tsuen Wan Shing Mun Valley\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Hong Kong Park\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Shau Kei Wan\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Kowloon City\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Happy Valley\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Wong Tai Sin\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Stanley\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Kwun Tong\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Sham Shui Po\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Kai Tak Runway Park\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Yuen Long Park\",\n" +
                "        \"value\": 26,\n" +
                "        \"unit\": \"C\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"place\": \"Tai Mei Tuk\",\n" +
                "        \"value\": 25,\n" +
                "        \"unit\": \"C\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"recordTime\": \"2023-11-09T17:00:00+08:00\"\n" +
                "  }\n" +
                "}"
    ): TemperatureResponse
}