package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.repositories.CoordinatesRepository
import com.example.weatherapp.data.repositories.WeatherRepository
import com.example.weatherapp.domain.usecases.GetCoordinatesUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import com.example.weatherapp.presentation.ui.WeatherScreen
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.presentation.viewmodels.WeatherViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Инициализация API через ApiService
        val coordinatesApi = ApiService.coordinatesApi
        val weatherApi = ApiService.weatherApi

        // Инициализация репозиториев и UseCase
        val coordinatesRepository = CoordinatesRepository(coordinatesApi)
        val weatherRepository = WeatherRepository(weatherApi)
        val getCoordinatesUseCase = GetCoordinatesUseCase(coordinatesRepository)
        val getWeatherUseCase = GetWeatherUseCase(weatherRepository)

        // Инициализация ViewModel с зависимостями через фабрику
        viewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(getWeatherUseCase, getCoordinatesUseCase)
        ).get(WeatherViewModel::class.java)

        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}