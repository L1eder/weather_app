package com.example.weatherapp.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import com.example.weatherapp.presentation.ui.components.CityBackground
import com.example.weatherapp.presentation.ui.components.CityCard
import com.example.weatherapp.presentation.ui.components.CityHeader
import com.example.weatherapp.presentation.ui.components.CitySearchBar
import com.example.weatherapp.presentation.viewmodels.CityViewModel

@Composable
fun CitySelectionScreen(cityViewModel: CityViewModel, navController: NavHostController, modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCity by remember { mutableStateOf("") }
    val cities = cityViewModel.cities
    val filteredCities = cities.filter { it.contains(searchQuery, ignoreCase = true) }

    CityBackground()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CityHeader()
        Spacer(modifier = Modifier.height(16.dp))
        CitySearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            onAddCity = {
                cityViewModel.addCity(searchQuery)
                searchQuery = ""
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredCities) { city ->
                CityCard(
                    city = city,
                    onClick = {
                        selectedCity = city
                        navController.navigate("weather/$city")
                    }
                )
            }
        }
    }
}