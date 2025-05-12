package com.example.weatherapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {
    private val _cities = mutableStateOf(
        listOf(
            "Moscow",
            "Rome",
            "Warsaw",
            "Minsk",
            "Mexico City",
            "Berlin",
            "London",
            "Paris",
            "Madrid",
            "Tokyo"
        )
    )

    val cities get() = _cities.value

    fun addCity(city: String) {
        if (city.isNotEmpty() && !_cities.value.contains(city)) {
            _cities.value = _cities.value + city
        }
    }
}