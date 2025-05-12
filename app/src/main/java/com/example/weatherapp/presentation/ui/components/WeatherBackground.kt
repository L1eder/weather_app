package com.example.weatherapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel

@Composable
fun WeatherBackground(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    val weatherState = viewModel.weather.observeAsState().value

    val backgroundImageId = when (weatherState?.hourly?.weather_code?.firstOrNull()) {
        0, 1 -> R.drawable.sunny
        2 -> R.drawable.partly_cloudy
        3 -> R.drawable.cloudy
        45, 48 -> R.drawable.fog
        51, 53, 56, 57 -> R.drawable.drizzle
        61, 63, 65, 66, 67, 80, 81, 82 -> R.drawable.rainy
        71, 73, 75, 77, 85, 86 -> R.drawable.snowy
        95, 96, 99 -> R.drawable.thunderstorm
        else -> R.drawable.unknown
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = backgroundImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}