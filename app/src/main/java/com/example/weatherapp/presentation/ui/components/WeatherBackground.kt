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
        0 -> R.drawable.sunny
        1 -> R.drawable.partly_cloudy
        2 -> R.drawable.cloudy
        3 -> R.drawable.rainy
        4 -> R.drawable.snowy
        else -> R.drawable.background2
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