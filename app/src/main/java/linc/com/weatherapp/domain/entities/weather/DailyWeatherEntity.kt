package linc.com.weatherapp.domain.entities.weather

data class DailyWeatherEntity(
    override val timestamp: Long,
    override val mainDescription: String,
    override val fullDescription: String,
    override val icon: String,
    val maxTemperature: Double,
    val minTemperature: Double,
    val clouds: Int,
) : WeatherEntity(timestamp, mainDescription, fullDescription, icon)