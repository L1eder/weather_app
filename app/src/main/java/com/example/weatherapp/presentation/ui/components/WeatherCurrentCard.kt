package com.example.weatherapp.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.models.WeatherResponse

@Composable
fun WeatherCurrentCard(city: String?, weather: WeatherResponse) {
    val weatherCode = weather.hourly.weather_code.firstOrNull() ?: -1
    Log.d("WeatherCode", "Received weather code: $weatherCode")
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
            Column{
                Text("Current Weather in $city", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))

                val currentTemperature = weather.hourly.temperature_2m.firstOrNull() ?: 0.0
                val currentPrecipitation = weather.hourly.precipitation.firstOrNull() ?: 0.0
                val currentWindSpeed = weather.hourly.wind_speed_10m.firstOrNull() ?: 0.0

                Text("Temperature: ${currentTemperature}°C")
                Text("Precipitation: ${currentPrecipitation} mm")
                Text("Wind Speed: ${currentWindSpeed} m/s")
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