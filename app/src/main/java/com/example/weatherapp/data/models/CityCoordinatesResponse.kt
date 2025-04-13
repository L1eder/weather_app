package com.example.weatherapp.data.models

data class CityCoordinatesResponse(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val population: Int,
    val is_capital: Boolean
)