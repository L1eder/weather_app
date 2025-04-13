package com.example.weatherapp.data.api

import com.example.weatherapp.data.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String = "temperature_2m,precipitation,wind_speed_10m,weather_code",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min,precipitation_sum,wind_speed_10m_max",
        @Query("timezone") timezone: String = "auto",
        @Query("forecast_days") forecastDays: Int = 16
    ): WeatherResponse
}