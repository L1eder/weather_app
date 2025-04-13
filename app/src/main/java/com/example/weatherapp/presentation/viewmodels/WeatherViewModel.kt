package com.example.weatherapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.models.WeatherResponse
import com.example.weatherapp.data.models.CityCoordinatesResponse // Убедитесь, что это правильный импорт
import com.example.weatherapp.domain.usecases.GetCoordinatesUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getCoordinatesUseCase: GetCoordinatesUseCase
) : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> get() = _weather

    fun fetchWeather(cityName: String, onComplete: () -> Unit) {
        viewModelScope.launch {
            try {
                val coordinates: List<CityCoordinatesResponse> = getCoordinatesUseCase(cityName)
                if (coordinates.isNotEmpty()) {
                    val firstCoordinate = coordinates[0]
                    _weather.value = getWeatherUseCase(firstCoordinate.latitude, firstCoordinate.longitude)
                } else {
                    Log.e("WeatherViewModel", "Координаты не найдены")
                    _weather.value = null
                }
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Ошибка получения погоды", e)
                _weather.value = null
            } finally {
                onComplete()
            }
        }
    }
}