package linc.com.weatherapp.domain.entities

data class CurrentWeatherEntity(
    override val timestamp: Long,
    override val mainDescription: String,
    override val fullDescription: String,
    override val icon: String,
    val currentTemperature: Double,
    val humidity: Int,
    val clouds: Int,
    val windDirection: Int,
    val windSpeed: Double
) : WeatherEntity(timestamp, mainDescription, fullDescription, icon)