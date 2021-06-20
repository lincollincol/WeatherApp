package linc.com.weatherapp.domain.entities


/*
val temp: Double,
            @SerializedName("feels_like")
            val feelsLike: Double,
            @SerializedName("temp_min")
            val tempMin: Double,
            @SerializedName("temp_max")
            val tempMax: Double,
            val pressure: Int,
            @SerializedName("sea_level")
            val seaLevel: Int,
            @SerializedName("grnd_level")
            val grndLevel: Int,
            val humidity: Int,
            @SerializedName("temp_kf")
            val tempKf: Double
 */
data class TodayWeatherEntity(
    override val timestamp: Long,
    override val description: String,
    override val icon: String,
    val maxTemperature: Double,
    val minTemperature: Double,
    val currentTemperature: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val clouds: Int,
    val windDirection: Int,
    val windSpeed: Double,
) : WeatherEntity(timestamp, description, icon)