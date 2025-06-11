package com.example.apz111.data.repository

import com.example.apz111.data.model.SensorData
import com.example.apz111.data.remote.ApiService
import javax.inject.Inject

class OfficeRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getLatestSensorData(token: String): SensorData =
        api.getLatestSensorData("Bearer $token")

    suspend fun markPresence(token: String) {
        api.markPresence("Bearer $token")
    }
}
