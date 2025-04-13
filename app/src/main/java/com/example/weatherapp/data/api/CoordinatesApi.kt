package com.example.weatherapp.data.api

import com.example.weatherapp.data.models.CityCoordinatesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CoordinatesApi {
    @GET("v1/city")
    suspend fun getCityCoordinates(
        @Query("name") cityName: String,
        @Header("X-Api-Key") apiKey: String = "qEagPHPqtBwzgxAFjBsbQw==J54hyJAsg2uvBirj"
    ): List<CityCoordinatesResponse>
}