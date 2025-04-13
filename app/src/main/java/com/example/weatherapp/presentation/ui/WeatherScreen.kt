package com.example.weatherapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import androidx.compose.ui.Modifier // Импорт для Modifier
import androidx.compose.ui.unit.dp // Импорт для dp

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    var city by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(value = city, onValueChange = { city = it }, label = { Text("Введите город") })
        Button(onClick = {
            isLoading = true
            viewModel.fetchWeather(city) {
                isLoading = false
            }
        }) {
            Text("Получить погоду")
        }

        if (isLoading) {
            Text("Загрузка...")
        } else {
            viewModel.weather.observeAsState().value?.let { weather ->
                if (weather != null) {
                    Text("Температура: ${weather.hourly.temperature_2m.firstOrNull() ?: "Нет данных"}")
                } else {
                    Text("Ошибка получения данных о погоде.")
                }
            }
        }
    }
}
