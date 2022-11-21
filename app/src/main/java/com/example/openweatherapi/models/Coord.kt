package com.example.openweatherapi.models

import java.io.Serializable

data class Coord(
    var Location: String,
    var lat: Double,
    var lon: Double
) : Serializable