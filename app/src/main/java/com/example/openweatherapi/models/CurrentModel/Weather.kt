package com.example.openweatherapi.models.CurrentModel

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)