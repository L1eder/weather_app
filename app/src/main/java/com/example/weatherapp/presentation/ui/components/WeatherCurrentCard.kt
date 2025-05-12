package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.models.WeatherResponse

@Composable
fun WeatherCurrentCard(city: String?, weather: WeatherResponse) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text("Current Weather in $city", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))

            val currentTemperature = weather.hourly.temperature_2m.firstOrNull() ?: 0.0
            val currentPrecipitation = weather.hourly.precipitation.firstOrNull() ?: 0.0
            val currentWindSpeed = weather.hourly.wind_speed_10m.firstOrNull() ?: 0.0

            Text("Temperature: ${currentTemperature}°C")
            Text("Precipitation: ${currentPrecipitation} mm")
            Text("Wind Speed: ${currentWindSpeed} m/s")
        }
    }
}