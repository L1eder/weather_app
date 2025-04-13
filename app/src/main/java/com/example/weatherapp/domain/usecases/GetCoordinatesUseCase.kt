package com.example.weatherapp.domain.usecases

import com.example.weatherapp.data.models.CityCoordinatesResponse
import com.example.weatherapp.data.repositories.CoordinatesRepository

class GetCoordinatesUseCase(private val coordinatesRepository: CoordinatesRepository) {
    suspend operator fun invoke(cityName: String): List<CityCoordinatesResponse> {
        return coordinatesRepository.getCoordinates(cityName)
    }
}