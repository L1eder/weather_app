package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherCard(dateString: String?, maxTemp: Double, minTemp: Double, precipitation: Double, windSpeed: Double, weatherCode: Int) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Date: ${dateString ?: "Unknown"}", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Temperature: ${maxTemp}°C / ${minTemp}°C")
                Text("Precipitation Sum: ${precipitation} mm")
                Text("Maximum Wind Speed: ${windSpeed} m/s")
            }
            Icon(
                painter = getWeatherIcon(weatherCode),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(88.dp),
                tint = Color.Unspecified
            )
        }
    }
}