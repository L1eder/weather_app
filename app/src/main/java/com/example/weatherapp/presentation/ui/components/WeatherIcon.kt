package com.example.weatherapp.presentation.ui.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R

@Composable
fun getWeatherIcon(weatherCode: Int): Painter {
    Log.d("WeatherCode", "Received weather code: $weatherCode")

    val resourceId = when (weatherCode) {
        0, 1 -> R.drawable.ic_sunny
        2 -> R.drawable.ic_partly_cloudy
        3 -> R.drawable.ic_cloudy
        45, 48 -> R.drawable.ic_fog
        51, 53, 56, 57 -> R.drawable.ic_drizzle
        61, 63, 65, 66, 67, 80, 81, 82 -> R.drawable.ic_rainy
        71, 73, 75, 77, 85, 86 -> R.drawable.ic_snowy
        95, 96, 99 -> R.drawable.ic_thunderstorm
        else -> R.drawable.ic_unknown
    }
    return painterResource(id = resourceId)
}
//Code	Description
//0	Clear sky
//1, 2, 3	Mainly clear, partly cloudy, and overcast
//45, 48	Fog and depositing rime fog
//51, 53, 55	Drizzle: Light, moderate, and dense intensity
//56, 57	Freezing Drizzle: Light and dense intensity
//61, 63, 65	Rain: Slight, moderate and heavy intensity
//66, 67	Freezing Rain: Light and heavy intensity
//71, 73, 75	Snow fall: Slight, moderate, and heavy intensity
//77	Snow grains
//80, 81, 82	Rain showers: Slight, moderate, and violent
//85, 86	Snow showers slight and heavy
//95 *	Thunderstorm: Slight or moderate
//96, 99 *	Thunderstorm with slight and heavy hail