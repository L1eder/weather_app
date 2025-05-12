package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.repositories.CoordinatesRepository
import com.example.weatherapp.data.repositories.WeatherRepository
import com.example.weatherapp.domain.usecases.GetCoordinatesUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import com.example.weatherapp.presentation.ui.screen.CitySelectionScreen
import com.example.weatherapp.presentation.ui.screen.WeatherScreen
import com.example.weatherapp.presentation.viewmodels.CityViewModel
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.presentation.viewmodels.WeatherViewModelFactory
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var cityViewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val coordinatesApi = ApiService.coordinatesApi
        val weatherApi = ApiService.weatherApi
        val coordinatesRepository = CoordinatesRepository(coordinatesApi)
        val weatherRepository = WeatherRepository(weatherApi)
        val getCoordinatesUseCase = GetCoordinatesUseCase(coordinatesRepository)
        val getWeatherUseCase = GetWeatherUseCase(weatherRepository)

        weatherViewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(getWeatherUseCase, getCoordinatesUseCase)
        ).get(WeatherViewModel::class.java)

        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "city_selection") {
                        composable("city_selection") {
                            CitySelectionScreen(
                                cityViewModel,
                                navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        composable("weather/{city}") { backStackEntry ->
                            val city = backStackEntry.arguments?.getString("city")
                            WeatherScreen(weatherViewModel, city)
                        }
                    }
                }
            }
        }
    }
}