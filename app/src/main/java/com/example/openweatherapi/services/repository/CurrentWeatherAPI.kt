package com.example.openweatherapi.services.repository

import com.example.openweatherapi.models.CurrentModel.CurrentWeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherAPI {
    @GET("/data/2.5/weather")
    suspend fun getTodaysWeather(
        @Query("q") q : String,
        @Query("appID") appid: String
    ) : Response<CurrentWeatherModel>
}