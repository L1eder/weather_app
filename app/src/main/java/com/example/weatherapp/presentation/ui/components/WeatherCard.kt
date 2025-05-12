package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherCard(dateString: String?, maxTemp: Double, minTemp: Double, precipitation: Double, windSpeed: Double) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Date: ${dateString ?: "Unknown"}", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Temperature: ${maxTemp}°C / ${minTemp}°C")
            Text("Precipitation Sum: ${precipitation} mm")
            Text("Maximum Wind Speed: ${windSpeed} m/s")
        }
    }
}