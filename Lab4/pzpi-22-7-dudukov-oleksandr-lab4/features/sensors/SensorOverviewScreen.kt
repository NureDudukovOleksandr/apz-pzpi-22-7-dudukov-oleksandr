package com.example.apz111.features.sensors

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apz111.viewmodel.DashboardViewModel

@Composable
fun SensorOverviewScreen(token: String, viewModel: DashboardViewModel = hiltViewModel()) {
    val data by viewModel.sensorData.collectAsState()

    LaunchedEffect(true) {
        viewModel.loadSensorData(token)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Температура: ${data?.temperature ?: "—"} °C")
        Text("Вологість: ${data?.humidity ?: "—"} %")
        Text("CO₂: ${data?.co2 ?: "—"} ppm")
    }
}