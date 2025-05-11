package com.example.weatherapp.data.models

data class DailyForecast(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val precipitation_sum: List<Double>,
    val wind_speed_10m_max: List<Double>
)