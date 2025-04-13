package com.example.weatherapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val COORDINATES_BASE_URL = "https://api.api-ninjas.com/"
    private const val WEATHER_BASE_URL = "https://api.open-meteo.com/v1/"

    private val coordinatesRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(COORDINATES_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(WEATHER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val coordinatesApi: CoordinatesApi = coordinatesRetrofit.create(CoordinatesApi::class.java)
    val weatherApi: WeatherApi = weatherRetrofit.create(WeatherApi::class.java)
}