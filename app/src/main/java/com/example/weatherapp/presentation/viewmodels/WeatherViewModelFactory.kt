package com.example.weatherapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.domain.usecases.GetCoordinatesUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase

class WeatherViewModelFactory(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getCoordinatesUseCase: GetCoordinatesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(getWeatherUseCase, getCoordinatesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}