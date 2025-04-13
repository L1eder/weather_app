package com.example.weatherapp.data.repositories

import com.example.weatherapp.data.api.CoordinatesApi
import com.example.weatherapp.data.models.CityCoordinatesResponse

class CoordinatesRepository(private val coordinatesApi: CoordinatesApi) {
    suspend fun getCoordinates(cityName: String): List<CityCoordinatesResponse> {
        return coordinatesApi.getCityCoordinates(cityName)
    }
}