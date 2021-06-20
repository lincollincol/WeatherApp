package linc.com.weatherapp.data.models.response.weather

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Long,
    val current: Current,
    val daily: List<Daily>
) {

    data class Current(
        val dt: Long,
        val sunrise: Long,
        val sunset: Long,
        val temp: Double,
        @SerializedName("feels_like")
        val feelsLike: Double,
        val pressure: Int,
        val humidity: Int,
        val clouds: Int,
        val visibility: Int,
        @SerializedName("wind_speed")
        val windSpeed: Double,
        @SerializedName("wind_deg")
        val windDeg: Int,
        val weather: List<WeatherDetails>
    )

    data class Daily(
        val dt: Long,
        val sunrise: Long,
        val sunset: Long,
        val temp: MainTemperature,
        @SerializedName("feels_like")
        val feelsLike: FeelsLikeTemperature,
        val pressure: Int,
        val humidity: Int,
        @SerializedName("wind_speed")
        val windSpeed: Double,
        @SerializedName("wind_deg")
        val windDeg: Int,
        val weather: List<WeatherDetails>,
        val clouds: Int,
        val rain: Double,
    ) {
        data class MainTemperature(
            val day: Double,
            val min: Double,
            val max: Double,
            val night: Double,
            val eve: Double,
            val morn: Double
        )

        data class FeelsLikeTemperature(
            val day: Double,
            val night: Double,
            val eve: Double,
            val morn: Double
        )
    }
}