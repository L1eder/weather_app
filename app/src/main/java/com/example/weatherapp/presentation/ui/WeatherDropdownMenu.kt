package com.example.weatherapp.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherDropdownMenu(
    cities: List<String>,
    selectedCity: String,
    expanded: Boolean,
    onCitySelected: (String) -> Unit,
    onExpandChange: (Boolean) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onExpandChange(!expanded) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Select City: $selectedCity")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandChange(false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            cities.forEach { city ->
                DropdownMenuItem(onClick = {
                    onCitySelected(city)
                    onExpandChange(false)
                }) {
                    Text(text = city)
                }
            }
        }
    }
}