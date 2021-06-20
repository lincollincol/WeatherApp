package linc.com.weatherapp.domain.entities

data class CurrentWeatherEntity(
    override val timestamp: Long,
    override val description: String,
    override val icon: String,
    val currentTemperature: Double,
    val humidity: Int,
    val clouds: Int,
    val windDirection: Int,
    val windSpeed: Double
) : WeatherEntity(timestamp, description, icon)