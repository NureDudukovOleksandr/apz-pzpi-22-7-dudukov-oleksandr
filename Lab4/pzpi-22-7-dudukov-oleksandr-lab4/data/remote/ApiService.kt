package com.example.apz111.data.remote

import com.android.volley.Header
import com.example.apz111.data.model.SensorData
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @GET("sensors/latest")
    suspend fun getLatestSensorData(@Header("Authorization") token: String): SensorData

    @POST("presence/checkin")
    suspend fun markPresence(@Header("Authorization") token: String)
}