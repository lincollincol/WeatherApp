package linc.com.weatherapp.domain.entities.weather

import linc.com.weatherapp.data.models.response.weather.TodayWeatherResponse

/*
data class WeatherEntity(
    val timestamp: Long,
    val maxTemperature: Double,
    val minTemperature: Double,
    val currentTemperature: Double,
    val humidity: Int,
    val clouds: Int,
    val windDirection: Int,
    val windSpeed: Double,
    val description: String,
    val icon: String
)*/


open class WeatherEntity(
    open val timestamp: Long,
    open val mainDescription: String,
    open val fullDescription: String,
    open val icon: String
)