package com.example.openweatherapi.models

import java.io.Serializable

data class MainForecastModel(
    var cnt: Int,
    var cod: String,
    var message: Int,
    var list : List<ForecastModel>,
    var city : CityModel
) : Serializable