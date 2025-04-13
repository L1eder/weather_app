package com.example.weatherapp.data.repositories

import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.models.WeatherResponse

class WeatherRepository(private val weatherApi: WeatherApi) {
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return weatherApi.getWeather(lat, lon)
    }
}