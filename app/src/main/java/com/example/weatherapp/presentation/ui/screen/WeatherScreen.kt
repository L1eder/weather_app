package com.example.weatherapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    var selectedCity by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val cities = listOf("Moscow", "Rome", "Warsaw", "Minsk", "Mexico City", "Berlin", "London", "Paris", "Madrid", "Tokyo")

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherDropdownMenu(cities, selectedCity, expanded, { city ->
            selectedCity = city
            isLoading = true
            viewModel.fetchWeather(city) { isLoading = false }
        }, { isExpanded ->
            expanded = isExpanded
        })

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            Text("Loading...")
        } else {
            viewModel.weather.observeAsState().value?.let { weather ->
                if (weather != null) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text("Weather in $selectedCity for the next 14 days", style = MaterialTheme.typography.h6)

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn(modifier = Modifier.fillMaxWidth()) {
                            items(weather.daily.time.indices.toList()) { i ->
                                WeatherCard(
                                    dateString = weather.daily.time.getOrNull(i),
                                    maxTemp = weather.daily.temperature_2m_max[i],
                                    minTemp = weather.daily.temperature_2m_min[i],
                                    precipitation = weather.daily.precipitation_sum[i],
                                    windSpeed = weather.daily.wind_speed_10m_max[i]
                                )
                            }
                        }
                    }
                } else {
                    Text("Error retrieving weather data.")
                }
            }
        }
    }
}