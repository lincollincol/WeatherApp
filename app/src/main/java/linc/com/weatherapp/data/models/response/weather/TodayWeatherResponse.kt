package linc.com.weatherapp.data.models.response.weather

import com.google.gson.annotations.SerializedName

data class TodayWeatherResponse(
    val cod: String,
    val message: Int,
    val cnt: Long,
    @SerializedName("list")
    val todayForecast: List<Forecast>
) {
    data class Forecast(
        val dt: Long,
        val main: General,
        val weather: List<WeatherDetails>,
        val clouds: Clouds,
        val wind: Wind,
        @SerializedName("dt_txt")
        val dtTxt: String
    ) {
        data class General(
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
        )

        data class Wind(
            val speed: Double,
            val deg: Int
        )

        data class Clouds(
            val all: Int
        )
    }
}