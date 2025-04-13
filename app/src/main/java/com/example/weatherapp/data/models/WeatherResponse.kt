package com.example.weatherapp.data.models

data class WeatherResponse(
    val daily: DailyForecast,
    val hourly: HourlyForecast
)

data class DailyForecast(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val precipitation_sum: List<Double>,
    val wind_speed_10m_max: List<Double>
)

data class HourlyForecast(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val precipitation: List<Double>,
    val wind_speed_10m: List<Double>,
    val weather_code: List<Int>
)
