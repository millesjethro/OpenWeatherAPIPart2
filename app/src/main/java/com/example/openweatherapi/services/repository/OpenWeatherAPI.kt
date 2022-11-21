package com.example.openweatherapi.services.repository

import com.example.openweatherapi.models.MainForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {
    @GET("/data/2.5/forecast")
    suspend fun getFiveDayForecast(
        @Query("lat") lat : Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String,
        @Query("units") units: String) : Response<MainForecastModel>
}