package com.example.weatherapp.presentation.ui.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun CityHeader() {
    Column(
        modifier = Modifier
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            style = TextStyle(
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 1f),
                    blurRadius = 8f
                )
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.app_rule),
            fontSize = 26.sp,
            style = TextStyle(
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 1f),
                    blurRadius = 8f
                )
            ),
            textAlign = TextAlign.Center
        )
    }
}