package com.example.weatherapp.domain.usecases

import com.example.weatherapp.data.models.WeatherResponse
import com.example.weatherapp.data.repositories.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(lat: Double, lon: Double): WeatherResponse {
        return weatherRepository.getWeather(lat, lon)
    }
}