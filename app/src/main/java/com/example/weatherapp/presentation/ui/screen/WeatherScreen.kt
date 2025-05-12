package com.example.weatherapp.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.ui.components.WeatherCurrentCard
import com.example.weatherapp.presentation.ui.components.WeatherBackground
import com.example.weatherapp.presentation.ui.components.WeatherCard
import com.example.weatherapp.presentation.ui.components.WeatherHeader
import com.example.weatherapp.presentation.ui.components.WeatherIsLoading
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, city: String?) {
    var isLoading by remember { mutableStateOf(false) }
    val weatherState = viewModel.weather.observeAsState().value

    LaunchedEffect(city) {
        if (city != null) {
            isLoading = true
            viewModel.fetchWeather(city) { isLoading = false }
        }
    }

    WeatherBackground(viewModel, modifier = Modifier)

    if (isLoading) {
       WeatherIsLoading()
    } else {
        weatherState?.let { weather ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(16.dp))

                WeatherHeader(city)

                WeatherCurrentCard(city, weather)
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(weather.daily.time.size) { i ->
                        val maxTemp = weather.daily.temperature_2m_max.getOrNull(i)
                        val minTemp = weather.daily.temperature_2m_min.getOrNull(i)
                        val precipitation = weather.daily.precipitation_sum.getOrNull(i)
                        val windSpeed = weather.daily.wind_speed_10m_max.getOrNull(i)
                        val weatherCode = weather.hourly.weather_code.getOrNull(i) ?: -1

                        if (maxTemp != null && minTemp != null && precipitation != null && windSpeed != null && weatherCode != -1) {
                            WeatherCard(
                                dateString = weather.daily.time.getOrNull(i),
                                maxTemp = maxTemp,
                                minTemp = minTemp,
                                precipitation = precipitation,
                                windSpeed = windSpeed,
                                weatherCode = weatherCode
                            )
                        }
                    }
                }
            }
        }
    }
}