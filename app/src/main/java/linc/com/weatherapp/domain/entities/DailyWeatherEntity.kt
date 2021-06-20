package linc.com.weatherapp.domain.entities

data class DailyWeatherEntity(
    override val timestamp: Long,
    override val description: String,
    override val icon: String,
    val maxTemperature: Double,
    val minTemperature: Double,
    val clouds: Int,
) : WeatherEntity(timestamp, description, icon)