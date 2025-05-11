package com.example.weatherapp.data.models

data class WeatherResponse(
    val daily: DailyForecast,
    val hourly: HourlyForecast
)