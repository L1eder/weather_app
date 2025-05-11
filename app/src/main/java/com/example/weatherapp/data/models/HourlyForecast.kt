package com.example.weatherapp.data.models

data class HourlyForecast(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val precipitation: List<Double>,
    val wind_speed_10m: List<Double>,
    val weather_code: List<Int>
)
